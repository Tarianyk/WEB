package ua.nure.tarianyk.SummaryTask4.web.command.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nure.tarianyk.SummaryTask4.service.CloseSessionService;
import ua.nure.tarianyk.SummaryTask4.util.consts.RedirectConst;
import ua.nure.tarianyk.SummaryTask4.web.command.Command;

/**
 * Used for closing session current user.
 * 
 * @author Anton
 * @version 1.0
 *
 */
public class CloseSessionCommandImpl implements Command {

	/**
	 * Service for closing session.
	 */
	private CloseSessionService closeSessionService = null;

	public CloseSessionCommandImpl(CloseSessionService closeSessionService) {
		this.closeSessionService = closeSessionService;
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
		closeSessionService.interruptSession(request, response);

		return RedirectConst.MAIN_PAGE;
	}

}
