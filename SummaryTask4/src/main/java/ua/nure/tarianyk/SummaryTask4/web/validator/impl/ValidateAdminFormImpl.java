package ua.nure.tarianyk.SummaryTask4.web.validator.impl;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import ua.nure.tarianyk.SummaryTask4.support.captcha.ReCaptcha;
import ua.nure.tarianyk.SummaryTask4.util.ErrorConst;
import ua.nure.tarianyk.SummaryTask4.util.consts.PatternConst;
import ua.nure.tarianyk.SummaryTask4.util.consts.SessionConst;

/**
 * Used for validating login form.
 * 
 * @author Anton
 * @version 1.0
 */
public class ValidateAdminFormImpl {

	/**
	 * Logger.
	 */
	private final static Logger LOG = Logger.getLogger(ValidateAdminFormImpl.class);

	/////////////////////
	// Regex variables.//
	////////////////////
	private Pattern pattern = null;
	private Matcher matcher = null;

	/**
	 * Validating input data.
	 * 
	 * @param userBean
	 *            bean class with user's input data
	 * @param request
	 *            input http request
	 * @return code of error
	 * @throws IOException
	 * @see {@link ReCaptcha#verify(String, HttpServletRequest)}
	 */
	public String validateAddInputData(HttpServletRequest request) throws IOException {
		String title = request.getParameter(SessionConst.TITLE);
		String article = request.getParameter(SessionConst.ARTICLE);
		String desc1 = request.getParameter(SessionConst.DESC_1);
		String price = request.getParameter(SessionConst.PRICE);
		String path = request.getParameter(SessionConst.PATH);
		String amount = request.getParameter(SessionConst.AMOUNT);
 
		if ((null == title) || (null == article) || (null == desc1) || (null == price) || (null == path)
				|| (null == amount)) {
			LOG.log(Level.INFO, "Inputted data is empty.");
			return ErrorConst.EMPTY;
		}
		
		if ((title.equals("")) || (article.equals("")) || (desc1.equals("")) || (price.equals("")) || (path.equals(""))
				|| (amount.equals(""))) {
			LOG.log(Level.INFO, "Inputted data is empty.");
			return ErrorConst.EMPTY;
		}

		return ErrorConst.VALIDE;
	}

	/**
	 * Validating input data.
	 * 
	 * @param userBean
	 *            bean class with user's input data
	 * @param request
	 *            input http request
	 * @return code of error
	 * @throws IOException
	 * @see {@link ReCaptcha#verify(String, HttpServletRequest)}
	 */
	public String validateBanInputData(HttpServletRequest request) throws IOException {
		String email = request.getParameter(SessionConst.EMAIL);

		if ((email.equals("")) || (null == email)) { 
			LOG.log(Level.INFO, "Inputted email is empty.");
			return ErrorConst.EMPTY;
		}
		
		if (!validateEmail(email)) {
			LOG.log(Level.INFO, "Inputted email is not valide.");
			return ErrorConst.EMAIL;
		}

		return ErrorConst.VALIDE;
	}

	/**
	 * Validating input data.
	 * 
	 * @param userBean
	 *            bean class with user's input data
	 * @param request
	 *            input http request
	 * @return code of error
	 * @throws IOException
	 * @see {@link ReCaptcha#verify(String, HttpServletRequest)}
	 */
	public String validateRemoveInputData(HttpServletRequest request) throws IOException {
		String article = request.getParameter(SessionConst.ARTICLE);

		if ((article.equals("")) || (null == article)) {
			LOG.log(Level.INFO, "Inputted article is empty.");
			return ErrorConst.EMPTY;
		}

		return ErrorConst.VALIDE;
	}

	/**
	 * Validating input data.
	 * 
	 * @param userBean
	 *            bean class with user's input data
	 * @param request
	 *            input http request
	 * @return code of error
	 * @throws IOException
	 * @see {@link ReCaptcha#verify(String, HttpServletRequest)}
	 */
	public String validateStatusInputData(HttpServletRequest request) throws IOException {
		String article = request.getParameter(SessionConst.ARTICLE);
		String email = request.getParameter(SessionConst.EMAIL);

		if ((null == article) || (null == email)) {
			LOG.log(Level.INFO, "Inputted email is empty.");
			return ErrorConst.EMPTY;
		}
		
		if ((article.equals("")) || (email.equals(""))) {
			LOG.log(Level.INFO, "Inputted email is empty.");
			return ErrorConst.EMPTY;
		}
		
		if (!validateEmail(email)) {
			LOG.log(Level.INFO, "Inputted email is not valide.");
			return ErrorConst.EMAIL;
		}

		return ErrorConst.VALIDE;
	}

	/**
	 * Used for validating email.
	 * 
	 * @param email
	 *            email of user
	 * @return <tt>true</tt> of <tt>false</tt>
	 */
	public boolean validateEmail(String email) {
		pattern = Pattern.compile(PatternConst.EMAIL_PATTERN);
		matcher = pattern.matcher(email);

		return matcher.matches();
	}

}
