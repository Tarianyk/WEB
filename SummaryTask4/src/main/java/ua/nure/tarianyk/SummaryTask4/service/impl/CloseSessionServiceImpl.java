package ua.nure.tarianyk.SummaryTask4.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import ua.nure.tarianyk.SummaryTask4.service.CloseSessionService;
import ua.nure.tarianyk.SummaryTask4.support.CookieCustom;
import ua.nure.tarianyk.SummaryTask4.util.consts.SessionConst;
import ua.nure.tarianyk.SummaryTask4.web.model.entity.UserBean;

/**
 * Used for closing session current user.
 * 
 * @author Anton
 * @version 1.0
 *
 */
public class CloseSessionServiceImpl implements CloseSessionService {

	/**
	 * Logger.
	 */
	private final static Logger LOG = Logger.getLogger(CloseSessionServiceImpl.class); 

	/*
	 * Interrupting session.
	 * 
	 * @param request (as specified by {@link
	 * CloseSessionService#interruptSession()})
	 * 
	 * @see ua.nure.tarianyk.SummaryTask4.service.CloseSessionService#
	 * interruptSession(javax.servlet.http.HttpServletRequest)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public synchronized void interruptSession(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("HERE");
		LOG.log(Level.DEBUG, "Method interruptSession starts.");

		HttpSession session = request.getSession(false);

		List<String> threads = (ArrayList<String>) session.getAttribute(SessionConst.THREAD_COLLECTION);
		UserBean userBean = (UserBean) session.getAttribute(SessionConst.USER);

		for (String i : threads) { 
			if (i.trim().equalsIgnoreCase(userBean.getEmail().trim())) {
				interruptThread(userBean.getEmail().trim());
			}
		}

		if (session != null) {
			session.setAttribute(SessionConst.USER, null);
			LOG.log(Level.TRACE, "Set the request attribute " + SessionConst.USER + "---->" + null);

			System.out.println("close");
			session.invalidate();
			LOG.log(Level.TRACE, "Session interrupted.");
		}

		CookieCustom.deleteCookie(request, response);

		LOG.log(Level.DEBUG, "Method interruptSession ends.");
	}

	/**
	 * Interrupts specific thread.
	 * 
	 * @param id
	 *            number of thread
	 */
	private synchronized void interruptThread(String name) {
		LOG.log(Level.DEBUG, "Method interruptThread starts.");

		Set<Thread> setOfThread = Thread.getAllStackTraces().keySet();

		for (Thread thread : setOfThread) {
			if (thread.getName().trim().equalsIgnoreCase(name)) {
				thread.stop(); 
				LOG.log(Level.TRACE, "Thread number " + thread.getId() + " interrupted.");
			}
		}
		LOG.log(Level.DEBUG, "Method interruptThread ends.");
	}

}
