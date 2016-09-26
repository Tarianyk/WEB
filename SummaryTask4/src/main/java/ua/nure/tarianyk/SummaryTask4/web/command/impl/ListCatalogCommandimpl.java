package ua.nure.tarianyk.SummaryTask4.web.command.impl;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import ua.nure.tarianyk.SummaryTask4.service.ListThingsService;
import ua.nure.tarianyk.SummaryTask4.util.consts.RedirectConst;
import ua.nure.tarianyk.SummaryTask4.util.consts.SessionConst;
import ua.nure.tarianyk.SummaryTask4.web.command.Command;
import ua.nure.tarianyk.SummaryTask4.web.model.entity.CatalogBean;

/**
 * Lists catalog.
 * 
 * @author Anton
 * @version 1.0
 *
 */
public class ListCatalogCommandimpl implements Command {

	/**
	 * Logger.
	 */
	private final static Logger LOG = Logger.getLogger(ListCatalogCommandimpl.class);

	/**
	 * Container contains list of products from catalog table from database.
	 */
	private List<CatalogBean> catalog = null;

	/**
	 * Service for processing product actions.
	 */
	private ListThingsService listThingsService = null;

	public ListCatalogCommandimpl(ListThingsService listThingsService) {
		this.listThingsService = listThingsService;
	}

	/*
	 * Execution method for command.
	 * 
	 * @see
	 * ua.nure.tarianyk.SummaryTask4.web.command.Command#execute(javax.servlet.
	 * http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		LOG.log(Level.DEBUG, "Command starts.");

		HttpSession session = request.getSession(false);

		String parameter = request.getParameter(SessionConst.PARAM);
		
		session.setAttribute(SessionConst.FORWARD, parameter); 
		LOG.log(Level.TRACE, "Set the request attribute " + SessionConst.FORWARD + "---->" + parameter);

		String kind = null;
		try {
			catalog = listThingsService.getList(parameter.trim(), setLanguage(request));  
			LOG.log(Level.TRACE, "Found in DB: list of product ----> " + parameter);

			kind = RedirectConst.getKind(request.getParameter(SessionConst.PARAM).trim()); 
		} catch (SQLException | ParseException e) {
			LOG.log(Level.TRACE, "Problem has occured in ListCommandimpl#execute() method.", e);
		}

		session.setAttribute(kind, catalog); 
		// for sort
		session.setAttribute(SessionConst.KIND, kind);
		LOG.log(Level.TRACE, "Set the request attribute " + kind + "---->" + kind);
		LOG.log(Level.TRACE, "Set the request attribute " + SessionConst.KIND + "---->" + kind);
		LOG.log(Level.DEBUG, "Command finished.");
		return RedirectConst.CATALOG_PAGE;
	}

	/**
	 * Sets language.
	 * 
	 * @param session
	 *            current session
	 * @return tuned language
	 */
	private String setLanguage(HttpServletRequest request) {
		String language_session = (String) request.getSession(false).getAttribute(SessionConst.LANGUAGE_PAGE);
		String language = null;

		if (null == language_session) {
			language = "ru";
		} else {
			language = language_session;
		}

		return language;
	}

}
