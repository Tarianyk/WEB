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
import ua.nure.tarianyk.SummaryTask4.web.model.entity.UserBean;

/**
 * Used for validating login form.
 * 
 * @author Anton
 * @version 1.0
 */
public class ValidateLoginFormImpl {

	/**
	 * Logger.
	 */
	private final static Logger LOG = Logger.getLogger(ValidateLoginFormImpl.class);
	
	////////////////////
	//Regex variables.//
	///////////////////
	private Pattern pattern = null; 
	private Matcher matcher = null;

	/**
	 * Validating input data.
	 * 
	 * @param userBean
	 * 				bean class with user's input data
	 * @param request
	 * 				input http request
	 * @return
	 * 		code of error
	 * @throws IOException
	 * 					@see {@link ReCaptcha#verify(String, HttpServletRequest)}
	 */
	public String validateInputData(UserBean userBean, HttpServletRequest request) throws IOException {
		String login = userBean.getEmail().trim();
		String password = userBean.getFpassword(); 

		if ((login.equals("")) || (password.equals(""))) {
			LOG.log(Level.INFO, "Inputted name or password is empty.");			
			return ErrorConst.EMPTY;  
		}

		if (!validateEmail(login)) {   
			LOG.log(Level.INFO, "Inputted email is not valide.");			
			return ErrorConst.EMAIL;
		}

		if(!ReCaptcha.verify(request.getParameter("g-recaptcha-response"), request)) {
			LOG.log(Level.INFO, "reCaptcha is not valide.");			
			return ErrorConst.CAPTCHA;   
		}

		return ErrorConst.VALIDE; 
	}

	/**
	 * Used for validating email.
	 * 
	 * @param email
	 * 			email of user
	 * @return
	 * 		<tt>true</tt> of <tt>false</tt>
	 */
	public boolean validateEmail(String email) {
		pattern = Pattern.compile(PatternConst.EMAIL_PATTERN);
		matcher = pattern.matcher(email);

		return matcher.matches();
	}

}
