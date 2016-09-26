package ua.nure.tarianyk.SummaryTask4.web.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import ua.nure.tarianyk.SummaryTask4.util.consts.SessionConst;
import ua.nure.tarianyk.SummaryTask4.web.model.entity.UserBean;

/**
 * Filtering request data for check access to page.
 * 
 * @author Anton
 * @version 1.0
 *
 */
public class AccessFilter implements Filter { 

	/**
	 * Logger.
	 */
	public final static Logger LOG = Logger.getLogger(AccessFilter.class);

	private FilterConfig filterConfig = null;

	private final static String PATH = "/SummaryTask4";
	/**
	 * Holds an urls on which mapped filter for security.
	 */
	private static Map<String, String> url = new HashMap<>();

	static {
		url.put(PATH + "/exit", SessionConst.PARAM);
		url.put(PATH + "/login", SessionConst.PARAM);
		url.put(PATH + "/registration", SessionConst.PARAM);
		url.put(PATH + "/catalog", SessionConst.PARAM);
		url.put(PATH + "/detail", SessionConst.ARTICLE);
		url.put(PATH + "/addshopcart", SessionConst.ARTICLE);
		url.put(PATH + "/delete", SessionConst.ARTICLE);
		url.put(PATH + "/buything", SessionConst.PARAM);
		url.put(PATH + "/sort", SessionConst.DIRECT);
		url.put(PATH + "/language", null);
	}

	/*
	 * Called by the web container to indicate to a filter that it is being
	 * placed into service.
	 * 
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		LOG.log(Level.DEBUG, "Filter initialization starts.");
		this.filterConfig = filterConfig;
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

		AccessWrapper accessWrapper = new AccessWrapper(request, response);

		if (accessWrapper.filter()) {
			LOG.log(Level.DEBUG, "Filter finished with access.");
			next.doFilter(request, response);
		}

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
	private class AccessWrapper {

		///////////////
		// Http data///
		//////////////
		private HttpServletRequest request = null;
		private HttpServletResponse response = null;

		public AccessWrapper(HttpServletRequest request, HttpServletResponse response) {
			this.request = request;
			this.response = response;
		}

		private boolean restrict(String eq, String param) throws IOException {
			boolean flag = false;

			if (request.getRequestURI().equals(eq) & !request.getRequestURI().equals("/SummaryTask4/language")) {
				if (null == request.getParameter(param)) {
					flag = false;
					response.sendError(404, "Access error");
				} else {
					flag = true;
				}

				return flag;
			} else if (request.getRequestURI().equals("/SummaryTask4/language")) {
				if (null == request.getSession(false).getAttribute(SessionConst.USER)) {
					flag = false;
					response.sendError(404, "Access error");
				} else {
					flag = true;
				}

				return flag;

			}

			return flag;
		}

		/**
		 * Do filter.
		 * 
		 * @return if data valide return <tt>true</tt>
		 */
		public boolean filter() throws IOException {
			HttpSession session = request.getSession(false);

			boolean flag = false;

			for (Map.Entry<String, String> i : url.entrySet()) {
				if (i.getKey().equals(request.getRequestURI())) {
					return restrict(i.getKey(), i.getValue());
				} 
			} 
 
			if (null == session) { 
				flag = false;
				response.sendError(401, "Unauthorized");
			} else {
				UserBean userBean = (UserBean) session.getAttribute(SessionConst.USER);
				if (null == userBean) {
					flag = false;
					response.sendError(401, "Unauthorized");
				} else { 
					String role = userBean.getRole();    
					String list = filterConfig.getInitParameter(role);  
					if (null == list) {  
						flag = false; 
						response.sendError(404, "Access error");
					} else {
						
						if (!list.contains(request.getRequestURI().substring(13, request.getRequestURI().length()).trim())) {
							flag = false;
							response.sendError(404, "Access error");
						} else {
							flag = true;
						}
					}

				}
			}
			return flag;
		}
	}

}
