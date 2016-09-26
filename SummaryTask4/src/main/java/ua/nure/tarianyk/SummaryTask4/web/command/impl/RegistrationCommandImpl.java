package ua.nure.tarianyk.SummaryTask4.web.command.impl;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import ua.nure.tarianyk.SummaryTask4.service.AuthenticationUserService;
import ua.nure.tarianyk.SummaryTask4.support.order.Sender;
import ua.nure.tarianyk.SummaryTask4.util.consts.PDFconst;
import ua.nure.tarianyk.SummaryTask4.util.consts.RedirectConst;
import ua.nure.tarianyk.SummaryTask4.util.consts.SessionConst;
import ua.nure.tarianyk.SummaryTask4.web.command.Command;
import ua.nure.tarianyk.SummaryTask4.web.model.entity.UserBean;
import ua.nure.tarianyk.SummaryTask4.web.model.extractor.Extractor_Generic_OneParameter;

/**
 * Used for registration users.
 * 
 * @author Anton
 * @version 1.0
 *
 */
public class RegistrationCommandImpl implements Command {

	/**
	 * Logger.
	 */
	private final static Logger LOG = Logger.getLogger(RegistrationCommandImpl.class);

	/**
	 * Path to files of localization path.
	 */
	private final static String LOCALIZATION = "ua.nure.tarianyk.SummaryTask4.localization.text";

	/**
	 * Used for extracting data from request.
	 */
	private Extractor_Generic_OneParameter<UserBean, HttpServletRequest> extractor = null;

	/**
	 * Service for processing authentication for users.
	 */
	private AuthenticationUserService authenticationUserService = null;

	////////////////////////////////
	// Variables for localization.//
	///////////////////////////////
	private ResourceBundle rb = null;
	private Locale locale = null; 

	public RegistrationCommandImpl(AuthenticationUserService authenticationUserService,
			Extractor_Generic_OneParameter<UserBean, HttpServletRequest> extractor) {
		this.extractor = extractor;
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

		UserBean userBean = extractor.extract(request);  
		try {
			authenticationUserService.registrationUser(userBean); 

			locale = new Locale(userBean.getLanguage().getName().trim());
			rb = ResourceBundle.getBundle(LOCALIZATION, locale);

			Sender send = new Sender(request, userBean.getEmail(), rb.getString(PDFconst.HEADER_ORDER), rb.getString("java.registered"),
					null, false);
			send.setDaemon(true);
			send.start();
			request.getSession(false).setAttribute(SessionConst.ERROR, SessionConst.REGIST);
		} catch (Exception e) {
			LOG.trace("Problem has occured in RegistrationUserCommandimpl#execute() method: " + e);
		}

		LOG.log(Level.DEBUG, "Command finished.");
		return RedirectConst.REFERER;
	}

}
