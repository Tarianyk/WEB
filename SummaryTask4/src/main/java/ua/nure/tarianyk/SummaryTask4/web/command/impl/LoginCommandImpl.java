package ua.nure.tarianyk.SummaryTask4.web.command.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import ua.nure.tarianyk.SummaryTask4.service.AuthenticationUserService;
import ua.nure.tarianyk.SummaryTask4.support.CookieCustom;
import ua.nure.tarianyk.SummaryTask4.support.daemonthread.CheckUserBan;
import ua.nure.tarianyk.SummaryTask4.util.ErrorCheck;
import ua.nure.tarianyk.SummaryTask4.util.ErrorConst;
import ua.nure.tarianyk.SummaryTask4.util.consts.RedirectConst;
import ua.nure.tarianyk.SummaryTask4.util.consts.SessionConst;
import ua.nure.tarianyk.SummaryTask4.web.command.Command;
import ua.nure.tarianyk.SummaryTask4.web.model.entity.UserBean;

/**
 * Login user.
 * 
 * @author Anton
 * @version 1.0
 *
 */
public class LoginCommandImpl implements Command {

	/**
	 * Logger.
	 */
	private final static Logger LOG = Logger.getLogger(LoginCommandImpl.class);

	/**
	 * Service for processing authentication for users.
	 */
	private AuthenticationUserService authenticationUserService = null;

	public LoginCommandImpl(AuthenticationUserService authenticationUserService) {
		this.authenticationUserService = authenticationUserService;
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

		UserBean temp = null;
		try {
			temp = authenticationUserService.loginUser(request);

			if (temp != null) {
				if (ErrorCheck.checkBan(temp.getUserBanBean().getBan(), request) != 1) {
					HttpSession session = request.getSession(true);

					session.setAttribute(SessionConst.USER, temp);
					session.setAttribute(SessionConst.LANGUAGE_PAGE, temp.getLanguage().getName());

					startCheckBan(request, response, session, temp);

					CookieCustom.addToCookieUser(temp, response);
					LOG.log(Level.INFO, "User was logged. Created session with id: " + session.getId());
				}

			} else if (null == temp) {
				request.getSession(false).setAttribute(SessionConst.ERROR, ErrorConst.LOGIN_TEXT);
			}

		} catch (SQLException e) {
			LOG.log(Level.TRACE, "Problem has occured in LoginCommandImpl#execute() method: ", e);
		}

		LOG.log(Level.DEBUG, "Command finished.");
		return RedirectConst.REFERER;
	}

	@SuppressWarnings("unchecked")
	private void startCheckBan(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			UserBean temp) {
		CheckUserBan ban = new CheckUserBan(request, response);
		ban.setName(temp.getEmail());
//		ban.setDaemon(true);// here may be a problem
		ban.start();

		List<String> threads = null;
		if (null == session.getAttribute(SessionConst.THREAD_COLLECTION)) {
			threads = new ArrayList<>();
			threads.add(ban.getName());

			session.setAttribute(SessionConst.THREAD_COLLECTION, threads);
			LOG.log(Level.TRACE, "Set the request attribute " + SessionConst.THREAD_COLLECTION + "---->" + threads);
		} else {
			threads = (ArrayList<String>) session.getAttribute(SessionConst.THREAD_COLLECTION);
			threads.add(ban.getName());
			session.setAttribute(SessionConst.THREAD_COLLECTION, threads);
			LOG.log(Level.TRACE, "Set the request attribute " + SessionConst.THREAD_COLLECTION + "---->" + threads);
		}
	}
}
