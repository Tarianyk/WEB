package ua.nure.tarianyk.SummaryTask4.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import ua.nure.tarianyk.SummaryTask4.util.consts.SessionConst;

/**
 * Used for returning appropriate text from code of error.
 * 
 * @author Anton
 * @version 1.0
 * 
 */
public final class ErrorCheck {

	/** 
	 * Logger.
	 */
	public final static Logger LOG = Logger.getLogger(ErrorCheck.class);

	private ErrorCheck() {
		LOG.log(Level.ERROR, "Attempt to create an instance of ErrorCheck class!");

		throw new UnsupportedOperationException("Non instance ErrorCheck."); 
	}

	/**
	 * Returns appropriate text from code of error.
	 * And adds to session appropriate text.
	 * 
	 * @param error
	 * 			code of error
	 * @param request
	 * 				input http request
	 * @return
	 * 		code of error
	 */
	public static int errorCheck(String error, HttpServletRequest request) {

		HttpSession session = request.getSession(false);

		switch (error) {
		case ErrorConst.BANNED:  
			session.setAttribute(SessionConst.ERROR, ErrorConst.BANNED_TEXT);
			return 1; 
		case ErrorConst.EMAIL_EXIST:
			session.setAttribute(SessionConst.ERROR, ErrorConst.EXIST_TEXT);
			return 1;
		case ErrorConst.EMPTY: 
			session.setAttribute(SessionConst.ERROR, ErrorConst.EMPTY_TEXT);
			return 1;
		case ErrorConst.EMAIL:
			session.setAttribute(SessionConst.ERROR, ErrorConst.EMAIL_TEXT);
			return 1;
		case ErrorConst.NOT_EQUAL:
			session.setAttribute(SessionConst.ERROR, ErrorConst.NOTEQUAL_TEXT);
			return 1;
		case ErrorConst.INTERVAL:
			session.setAttribute(SessionConst.ERROR, ErrorConst.INTERVAL_TEXT);
			return 1;
		case ErrorConst.CAPTCHA:
			session.setAttribute(SessionConst.ERROR, ErrorConst.CAPTCHA_TEXT);
			return 1;
		case ErrorConst.VALIDE:
			session.setAttribute(SessionConst.ERROR, ErrorConst.VALIDE_TEXT);
			return 0;
		default:
			session.setAttribute(SessionConst.ERROR, null);
			break;

		}
		return 0;
	}

	/**
	 * Checks users on ban.
	 * 
	 * @param error
	 * 			code of error
	 * @param request
	 * 				input http request
	 * @return
	 * 		code of appropriate text from code of error
	 */
	public static int checkBan(String error, HttpServletRequest request) {

		HttpSession session = request.getSession(false);

		switch (error) { 
		case ErrorConst.BANNED:
			LOG.log(Level.INFO, "User is banned.");			
			session.setAttribute(SessionConst.ERROR, ErrorConst.BANNED_TEXT);
			return 1;
		default:
			session.setAttribute(SessionConst.ERROR, null);
			break;

		}

		return 0;
	}
}
