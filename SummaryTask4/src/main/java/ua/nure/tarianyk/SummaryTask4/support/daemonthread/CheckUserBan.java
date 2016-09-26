package ua.nure.tarianyk.SummaryTask4.support.daemonthread;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import ua.nure.tarianyk.SummaryTask4.database.DAO.UsersDAO;
import ua.nure.tarianyk.SummaryTask4.database.DAO.impl.UsersDAOimpl;
import ua.nure.tarianyk.SummaryTask4.support.CookieCustom;
import ua.nure.tarianyk.SummaryTask4.util.consts.SessionConst;
import ua.nure.tarianyk.SummaryTask4.web.model.entity.UserBean;

/**
 * The daemon thread that checks every one minute user's ban. If user was banned
 * thread will interrupt session of current user.
 * 
 * @author Anton
 * @version 1.0
 *
 */
public class CheckUserBan extends Thread {

	/**
	 * Logger.
	 */
	private static final Logger LOG = Logger.getLogger(CheckUserBan.class);

	/**
	 * Delay on work a thread.
	 */
	private Integer sleep_time = 5000;
	// private final static Integer SLEEP_TIME = 1000;

	/**
	 * DAO layer for processing commands that depend with user-table from
	 * database.
	 * 
	 */
	private UsersDAO usersDAO = null; 

	///////////////////////
	//// Http variables.///
	//////////////////////
	private HttpServletRequest request = null;
	private HttpServletResponse response = null;
	boolean flag = true;
//	HttpSession session;

	/**
	 * Constructor with parameters.
	 * 
	 * @param request
	 *            input http request
	 * @param response
	 *            input http response
	 */
	public CheckUserBan(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		
		usersDAO = new UsersDAOimpl();

	}

	@Override
	public void run() { 
		LOG.log(Level.DEBUG, "run method starts.");
		
		while (flag) { 
			HttpSession session = request.getSession(false);
			UserBean userBean = null;
			if(session != null) {
				userBean = (UserBean) session.getAttribute(SessionConst.USER);	
			} 
			
			try {
				if (null != userBean) { 
					if(usersDAO.checkBan(userBean.getEmail()).equals(1)) {
						if (session != null) {
							if(null != session.getAttribute(SessionConst.USER)) {
								session.setAttribute(SessionConst.USER, null);
								LOG.log(Level.TRACE, "Set the request attribute " + SessionConst.USER + "---->" + null);

								for (int i = 0; i < 10; i++) {
									CookieCustom.deleteCookie(request, response);
								}
								flag = false;
								this.stop();
								
								session.invalidate();
								LOG.log(Level.TRACE, "Session interrupted.");
							}
						}

						for (int i = 0; i < 10; i++) {
							CookieCustom.deleteCookie(request, response);
						}
						flag = false;
						this.stop();
						break;	
					}
				}
			} catch (SQLException e) {
				LOG.trace("Problem has occured in run method: " + e);
			}
			
			try {
				Thread.sleep(sleep_time);
			} catch (InterruptedException e) {
				LOG.trace("Problem has occured in run method: " + e);
			}
		}

		LOG.log(Level.DEBUG, "run method finished.");
	}

	public void setSleep_time(Integer sleep_time) {
		this.sleep_time = sleep_time;
	}

}
