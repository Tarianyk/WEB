package ua.nure.tarianyk.SummaryTask4.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import ua.nure.tarianyk.SummaryTask4.util.ErrorCheck;
import ua.nure.tarianyk.SummaryTask4.util.consts.RedirectConst;
import ua.nure.tarianyk.SummaryTask4.web.model.entity.UserBean;
import ua.nure.tarianyk.SummaryTask4.web.model.extractor.Extractor_Generic_OneParameter;
import ua.nure.tarianyk.SummaryTask4.web.model.extractor.impl.ExtractorReqLoginUserBeanImpl;
import ua.nure.tarianyk.SummaryTask4.web.validator.impl.ValidateLoginFormImpl;

/**
 * Filtering request data for validate login form.
 * 
 * @author Anton
 * @version 1.0
 *
 */
public class ValidateFieldsLoginFormFilter implements Filter {

	/**
	 * Logger.
	 */
	public final static Logger LOG = Logger.getLogger(ValidateFieldsLoginFormFilter.class);

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
		LOG.log(Level.DEBUG, "Filter starts");

		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;

		ValideateWrapper valideateWrapper = new ValideateWrapper(request);

		if (valideateWrapper.filter() == 0) {
			LOG.log(Level.DEBUG, "Filter finished with valide login form.");

			next.doFilter(request, response);
		} else {
			LOG.log(Level.DEBUG, "Filter finished with not valide login form.");

			response.sendRedirect(RedirectConst.MAIN_PAGE_PATH);
		}

	}

	/*
	 * Called by the web container to indicate to a filter that it is being
	 * placed into service.
	 * 
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		LOG.log(Level.DEBUG, "Filter initialization starts.");
		LOG.log(Level.DEBUG, "Filter initialization finished.");
	}

	/**
	 * Inner wrapper for validating.
	 * 
	 * @author Anton
	 * @version 1.0
	 *
	 */
	private class ValideateWrapper {

		/**
		 * Object for validating login form.
		 */
		private ValidateLoginFormImpl validateLoginForm = null;

		/**
		 * Used for extracting UserBean from request data.
		 */
		private Extractor_Generic_OneParameter<UserBean, HttpServletRequest> extractor = null;

		/**
		 * Http request.
		 */
		private HttpServletRequest request = null;

		public ValideateWrapper(HttpServletRequest request) {
			this.request = request;
			extractor = new ExtractorReqLoginUserBeanImpl();
			validateLoginForm = new ValidateLoginFormImpl();
		}

		/**
		 * Do filter. 
		 * 
		 * @return if data valide return <tt>true</tt>
		 */
		public int filter() {
			UserBean userBean = extractor.extract(request);

			String error = null; 
			try {
				error = validateLoginForm.validateInputData(userBean, request);
			} catch (IOException e) {
				LOG.log(Level.TRACE, "Exception has occured in filter method.", e);
			}
			int flag = ErrorCheck.errorCheck(error, request); 

			return flag; 
		}
	}
}
