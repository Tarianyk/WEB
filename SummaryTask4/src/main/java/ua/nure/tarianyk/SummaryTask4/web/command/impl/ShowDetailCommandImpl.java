package ua.nure.tarianyk.SummaryTask4.web.command.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import ua.nure.tarianyk.SummaryTask4.util.consts.RedirectConst;
import ua.nure.tarianyk.SummaryTask4.util.consts.SessionConst;
import ua.nure.tarianyk.SummaryTask4.web.command.Command;
import ua.nure.tarianyk.SummaryTask4.web.model.entity.CatalogBean;

/**
 * Used for showing detailed information about products.
 * 
 * @author Anton
 * @version 1.0
 *
 */
public class ShowDetailCommandImpl implements Command {

	/** 
	 * Logger.
	 */
	private final static Logger LOG = Logger.getLogger(ShowDetailCommandImpl.class);

	/*
	 * Execution method for command.
	 * 
	 * @see
	 * ua.nure.tarianyk.SummaryTask4.web.command.Command#execute(javax.servlet.
	 * http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		LOG.log(Level.DEBUG, "Command starts.");

		HttpSession session = request.getSession(false);

		String article = request.getParameter(SessionConst.ARTICLE);
		List<CatalogBean> catalogBean = (List<CatalogBean>) session
				.getAttribute(request.getParameter(SessionConst.PARAM)); 
		for (CatalogBean i : catalogBean) {
			if (i.getArticle().equals(article)) {
				session.setAttribute(SessionConst.DETAIL_PRODUCT, i);
				break; 
			}
		}

		LOG.log(Level.DEBUG, "Command finished.");
		return RedirectConst.DETAIL;
	}

}
