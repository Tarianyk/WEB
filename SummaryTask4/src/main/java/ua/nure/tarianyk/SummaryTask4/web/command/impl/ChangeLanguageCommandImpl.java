package ua.nure.tarianyk.SummaryTask4.web.command.impl;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import ua.nure.tarianyk.SummaryTask4.service.ProcessUserService;
import ua.nure.tarianyk.SummaryTask4.support.CookieCustom;
import ua.nure.tarianyk.SummaryTask4.util.consts.RedirectConst;
import ua.nure.tarianyk.SummaryTask4.util.consts.SessionConst;
import ua.nure.tarianyk.SummaryTask4.web.command.Command;
import ua.nure.tarianyk.SummaryTask4.web.model.entity.UserBean;

/**
 * used for changing language for users.
 * 
 * @author Anton
 * @version 1.0
 *
 */
public class ChangeLanguageCommandImpl implements Command {

	/**
	 * Logger.
	 */
	private static final Logger LOG = Logger.getLogger(ChangeLanguageCommandImpl.class);

	/** 
	 * Service for processing users actions.
	 */
	private ProcessUserService processUserService = null;

	public ChangeLanguageCommandImpl(ProcessUserService processUserService) {
		this.processUserService = processUserService;
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
		String language = request.getParameter(SessionConst.LANG);

		try {
			UserBean userBean = (UserBean) session.getAttribute(SessionConst.USER);
			LOG.log(Level.TRACE, "Found in SESSION: current user ----> " + userBean);

			processUserService.change(userBean, language); 
			userBean.getLanguage().setName(language);  

			session.setAttribute(SessionConst.LANGUAGE_PAGE, language);
			session.setAttribute(SessionConst.USER, userBean);
			LOG.log(Level.TRACE, "Set the request attribute " + SessionConst.LANGUAGE_PAGE + "---->" + language);
			LOG.log(Level.TRACE, "Set the request attribute " + SessionConst.USER + "---->" + userBean);

			CookieCustom.setLanguageInCookie(request, response, language);
		} catch (SQLException | IOException e) {
			LOG.log(Level.TRACE, "Problem has occured in execute method.", e);
		}

		LOG.log(Level.DEBUG, "Command finished.");
		return RedirectConst.PERSONAL_AREA;
	}

}
