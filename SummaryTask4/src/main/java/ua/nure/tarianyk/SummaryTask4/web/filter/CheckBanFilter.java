package ua.nure.tarianyk.SummaryTask4.web.filter;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import ua.nure.tarianyk.SummaryTask4.database.DAO.UsersDAO;
import ua.nure.tarianyk.SummaryTask4.database.DAO.impl.UsersDAOimpl;
import ua.nure.tarianyk.SummaryTask4.support.CookieCustom;
import ua.nure.tarianyk.SummaryTask4.support.Serilizable;
import ua.nure.tarianyk.SummaryTask4.support.daemonthread.CheckUserBan;
import ua.nure.tarianyk.SummaryTask4.util.consts.SessionConst;
import ua.nure.tarianyk.SummaryTask4.web.model.entity.UserBean;

/**
 * Filtering request data for check user in cookie.
 * 
 * @author Anton
 * @version 1.0
 *
 */
public class CheckBanFilter implements Filter {

	/**
	 * Logger.
	 */
	public final static Logger LOG = Logger.getLogger(CheckBanFilter.class);

	private boolean flag = true;

	/*
	 * Called by the web container to indicate to a filter that it is being
	 * placed into service.
	 * 
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		LOG.log(Level.DEBUG, "Filter initialization starts.");
		LOG.log(Level.DEBUG, "Filter initialization finished.");
	}

	/*
	 * The <code>doFilter</code> method of the Filter is called by the container
	 * each time a request/response pair is passed through the chain due to a
	 * client request for a resource at the end of the chain. The FilterChain
	 * passed in to this method allows the Filter to pass on the request and
	 * response to the next entity in the chain.
	 * 
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest,
	 * javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain next)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;

		BanFilterWrapper loginFilterWrapper = new BanFilterWrapper(request, response);
		try {
			loginFilterWrapper.filter();
		} catch (SQLException e) {
			LOG.trace("Problem has occured in doFilter method: " + e);
		}
		flag = true;

		next.doFilter(request, response);
	}

	/*
	 * Called by the web container to indicate to a filter that it is being
	 * taken out of service.
	 * 
	 * @see javax.servlet.Filter#destroy()
	 */
	@Override
	public void destroy() {
		LOG.log(Level.DEBUG, "Filter destruction starts");
		LOG.log(Level.DEBUG, "Filter destruction finished");
	}

	/**
	 * Inner wrapper for checking access.
	 * 
	 * @author Anton
	 * @version 1.0
	 *
	 */
	private class BanFilterWrapper {

		//////////////
		// Http data//
		/////////////
		private HttpServletRequest request = null;
		private HttpServletResponse response = null;
		private HttpSession session = null;

		public BanFilterWrapper(HttpServletRequest request, HttpServletResponse response) {
			this.request = request;
			this.response = response;
			session = request.getSession(true);
		}

		/**
		 * Do filter.
		 * 
		 * @return if data valide return <tt>true</tt>
		 * @throws SQLException
		 */
		public void filter() throws IOException, SQLException {
			UsersDAO usersDAO = new UsersDAOimpl();

			UserBean userBean = (UserBean) session.getAttribute(SessionConst.USER);

			if (null != userBean) {
				if (usersDAO.checkBan(userBean.getEmail().trim()).equals(1)) {
					LOG.log(Level.DEBUG, "Method interruptSession starts.");

					HttpSession session = request.getSession(false);

					List<String> threads = (ArrayList<String>) session.getAttribute(SessionConst.THREAD_COLLECTION);

					for (String i : threads) {
						if (i.trim().equalsIgnoreCase(userBean.getEmail().trim())) {
							interruptThread(userBean.getEmail().trim());
						}
					}

					if (session != null) {
						session.setAttribute(SessionConst.USER, null);
						LOG.log(Level.TRACE, "Set the request attribute " + SessionConst.USER + "---->" + null);

						for (int i = 0; i < 10; i++) {
							CookieCustom.deleteCookie(request, response);
						}
						session.invalidate();
						LOG.log(Level.TRACE, "Session interrupted.");
					}

					for (int i = 0; i < 10; i++) {
						CookieCustom.deleteCookie(request, response);
					}

					LOG.log(Level.DEBUG, "Method interruptSession ends.");
				}
			}

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
}
