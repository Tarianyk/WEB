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
import ua.nure.tarianyk.SummaryTask4.web.model.extractor.Extractor_Generic_OneParameter;
import ua.nure.tarianyk.SummaryTask4.web.model.extractor.impl.ExtractorReqContactTransferImpl;
import ua.nure.tarianyk.SummaryTask4.web.model.transfer.ContactTransferBean;
import ua.nure.tarianyk.SummaryTask4.web.validator.Validator;
import ua.nure.tarianyk.SummaryTask4.web.validator.impl.ValideContactFormImpl;

/**
 * Filtering request data for validate contact form.
 * 
 * @author Anton
 * @version 1.0
 *
 */
public class ValidateFieldsContactFormFilter implements Filter {

	/**
	 * Logger.
	 */
	public final static Logger LOG = Logger.getLogger(ValidateFieldsContactFormFilter.class);

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
			LOG.log(Level.DEBUG, "Filter finished with valide contact form.");
			next.doFilter(request, response);
		}

		LOG.log(Level.DEBUG, "Filter finished");
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
		 * Object for validating contact form.
		 */
		private Validator<ContactTransferBean> validator = null;

		/**
		 * Used for extracting ContactTransferBean from request data.
		 */
		private Extractor_Generic_OneParameter<ContactTransferBean, HttpServletRequest> cExtractorReq = null;

		/**
		 * Http request.
		 */
		private HttpServletRequest request = null;

		public ValideateWrapper(HttpServletRequest request) {
			this.request = request;
			cExtractorReq = new ExtractorReqContactTransferImpl();
			validator = new ValideContactFormImpl();
		}

		/**
		 * Do filter.
		 * 
		 * @return if data valide return <tt>true</tt> 
		 */
		public int filter() { 
			ContactTransferBean contactTransferBean = cExtractorReq.extract(request);

			String error = validator.validateInputData(contactTransferBean);
			int flag = ErrorCheck.errorCheck(error, request); 

			return flag; 
		}
	}
}
