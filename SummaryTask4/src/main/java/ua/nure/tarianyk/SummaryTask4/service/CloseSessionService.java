package ua.nure.tarianyk.SummaryTask4.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Used for closing session current user.
 * 
 * @author Anton
 * @version 1.0
 *
 */
public interface CloseSessionService {

	/**
	 * Interrupting session.
	 * 
	 * @param request
	 *            input http request
	 */
	public void interruptSession(HttpServletRequest request, HttpServletResponse response);
}
