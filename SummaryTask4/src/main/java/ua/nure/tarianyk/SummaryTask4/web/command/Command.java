package ua.nure.tarianyk.SummaryTask4.web.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Main interface for the Command pattern implementation.
 * 
 * @author Anton
 * @version 1.0
 *
 */
public interface Command {
	
	/**
	 * Execution method for command.
	 * 
	 * @param request
	 * 				input request parameter
	 * @param response
	 * 				input response parameter
	 * @return
	 * 		Address to go once the command is executed.
	 */
	public String execute(HttpServletRequest request, HttpServletResponse response);
}
