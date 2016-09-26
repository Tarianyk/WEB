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
import ua.nure.tarianyk.SummaryTask4.util.consts.SessionConst;
import ua.nure.tarianyk.SummaryTask4.web.model.transfer.BacketTransferBean;

/**
 * Used for getting products from cookie.
 * 
 * @author Anton
 * @version 1.0
 *
 */
public class BacketDeserializeFilter implements Filter {

	/**
	 * Logger.
	 */
	public final static Logger LOG = Logger.getLogger(BacketDeserializeFilter.class);

	/*
	 * Called by the web container to indicate to a filter that it is being
	 * placed into service.
	 * 
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		LOG.log(Level.DEBUG, "Filter initialization starts.");
		LOG.log(Level.DEBUG, "Filter initialization finished.");
	}

	/*
	 * Called by the web container to indicate to a filter that it is being
	 * taken out of service.
	 * 
	 * @see javax.servlet.Filter#destroy()
	 */
	public void destroy() {
		LOG.log(Level.DEBUG, "Filter destruction starts");
		LOG.log(Level.DEBUG, "Filter destruction finished");
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
	@SuppressWarnings("unchecked")
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain next)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		HttpSession session = request.getSession(false);

		BacketDeserializeWrapper backetDeserializeWrapper = new BacketDeserializeWrapper(request);
		backetDeserializeWrapper.filter();

		next.doFilter(request, response);
	}

	private class BacketDeserializeWrapper {

		HttpSession session = null;

		/**
		 * Http request.
		 */
		private HttpServletRequest request = null;

		public BacketDeserializeWrapper(HttpServletRequest request) {
			this.request = request;
			session = request.getSession(false);
		}

		/**
		 * Do filter.
		 * 
		 * @return if data valide return <tt>true</tt>
		 * @throws IOException
		 */
		@SuppressWarnings("unchecked")
		public void filter() throws IOException {
			if (null == (List<BacketTransferBean>) session.getAttribute(SessionConst.BACKET)) {

				Cookie[] cookie = request.getCookies();

				if (null != cookie) { 
					for (Cookie obj : cookie) {
						if (obj.getName().equals(SessionConst.BACKET_COOKIE)) {
							ArrayList<BacketTransferBean> back = null;

							try { 
								back = (ArrayList<BacketTransferBean>) Serilizable.deserialization(obj.getValue());
							} catch (ClassNotFoundException e) {
								LOG.log(Level.TRACE, "Exception has occured in filter method.", e);
							}

							session.setAttribute(SessionConst.BACKET, back);
							break;
						}
					}
				}
			}
		}
	}
}
