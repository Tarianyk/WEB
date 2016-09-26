package ua.nure.tarianyk.SummaryTask4.web.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
public class LoginFilter implements Filter {

	/**
	 * Logger.
	 */
	public final static Logger LOG = Logger.getLogger(LoginFilter.class);

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

		LoginFilterWrapper loginFilterWrapper = new LoginFilterWrapper(request, response);
		loginFilterWrapper.filter();
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
	private class LoginFilterWrapper {

		//////////////
		// Http data//
		/////////////
		private HttpServletRequest request = null;
		private HttpServletResponse response = null;
		private HttpSession session = null;

		public LoginFilterWrapper(HttpServletRequest request, HttpServletResponse response) {
			this.request = request;
			this.response = response;
			session = request.getSession(true);
		}

		/**
		 * Do filter.
		 * 
		 * @return if data valide return <tt>true</tt>
		 */
		public void filter() throws IOException {
			if (flag) { 
				if (null == session.getAttribute(SessionConst.USER)) {
					Cookie[] cookie = request.getCookies();

					if (null != cookie) {
						for (Cookie obj : cookie) {
							if (obj.getName().equals(SessionConst.USER_COOKIE)) {
								UserBean userBean = null;
								try {
									userBean = (UserBean) Serilizable.deserialization(obj.getValue());
								} catch (ClassNotFoundException e) {
									LOG.log(Level.TRACE, "Exception has occured in filter method.", e);
								}

								session.setAttribute(SessionConst.USER, userBean);
								session.setAttribute(SessionConst.LANGUAGE_PAGE, userBean.getLanguage().getName());
								LOG.log(Level.TRACE,
										"Set the request attribute " + SessionConst.USER + "---->" + userBean);

								startCheckBan(request, response, session, userBean);
								CheckUserBan ban = new CheckUserBan(request, response);
								ban.setName(userBean.getEmail());
								ban.start();

								break;
							}
						}
					}
				}

				flag = false;
			}
		}

		@SuppressWarnings("unchecked")
		private void startCheckBan(HttpServletRequest request, HttpServletResponse response, HttpSession session,
				UserBean temp) {
			CheckUserBan ban = new CheckUserBan(request, response);
			ban.setName(temp.getEmail());
//			ban.setDaemon(true);// here
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
}
