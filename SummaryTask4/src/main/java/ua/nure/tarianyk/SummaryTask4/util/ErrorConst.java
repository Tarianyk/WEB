package ua.nure.tarianyk.SummaryTask4.util;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * Contains codes of errors and appropriate text to them. 
 * 
 * @author Anton
 * @version 1.0
 */
public final class ErrorConst {

	/**
	 * Logger.
	 */
	private final static Logger LOG = Logger.getLogger(ErrorConst.class);
	
	private ErrorConst() {
		LOG.log(Level.ERROR, "Attempt to create an instance of ErrorConst class!");
		
		throw new UnsupportedOperationException("Non instance ErrorConst");
	}

	///////////////////////////////
	/////// Codes of errors.///////
	//////////////////////////////
	public static final String BANNED = "banned";
	public static final String EMAIL_EXIST = "email exist";
	public static final String EMPTY = "empty";
	public static final String EMAIL = "email";
	public static final String NOT_EQUAL = "notequal";
	public static final String INTERVAL = "interval";
	public static final String VALIDE = "valide";
	public static final String CAPTCHA = "not_valide";

	////////////////////////////////////
	/// Appropriate text error codes.///
	///////////////////////////////////
	public static final String EXIST_TEXT = "User already exist.";
	public static final String EMPTY_TEXT = "Fill all fields.";
	public static final String EMAIL_TEXT = "Email is not valide.";
	public static final String NOTEQUAL_TEXT = "Passwords are not equals.";
	public static final String BANNED_TEXT = "The user is banned.";
	public static final String INTERVAL_TEXT = "Not valid any one from input data.";
	public static final String VALIDE_TEXT = null;
	public static final String CAPTCHA_TEXT = "ReCaptcha is not valide.";
	public static final String LOGIN_TEXT = "This user does not exists.";

}
