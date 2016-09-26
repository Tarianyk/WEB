package ua.nure.tarianyk.SummaryTask4.web.command.impl;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import ua.nure.tarianyk.SummaryTask4.service.EditCatalogService;
import ua.nure.tarianyk.SummaryTask4.service.OrdersService;
import ua.nure.tarianyk.SummaryTask4.service.ProcessUserService;
import ua.nure.tarianyk.SummaryTask4.util.consts.EncodingConst;
import ua.nure.tarianyk.SummaryTask4.util.consts.RedirectConst;
import ua.nure.tarianyk.SummaryTask4.util.consts.SessionConst;
import ua.nure.tarianyk.SummaryTask4.web.command.Command;

/**
 * The class used for processing different actions by admin.
 * 
 * @author Anton
 * @version 1.0
 *
 */
public class AdminAreaCommandImpl implements Command {

	/**
	 * Logger. 
	 */
	private final static Logger LOG = Logger.getLogger(AdminAreaCommandImpl.class);

	/**
	 * Service for processing users actions.
	 */
	private ProcessUserService processUserService = null;

	/**
	 * Service for processing catalog actions.
	 */
	private EditCatalogService editCatalogService = null;

	/**
	 * Service for processing order actions.
	 */
	private OrdersService ordersService = null;

	public AdminAreaCommandImpl(ProcessUserService processUserService, EditCatalogService editCatalogService,
			OrdersService ordersService) {
		this.processUserService = processUserService;
		this.editCatalogService = editCatalogService;
		this.ordersService = ordersService;
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

		try {
			switch (request.getParameter(SessionConst.PARAM).trim()) {
			case SessionConst.BAN:
				processUserService.giveBan(request.getParameter(SessionConst.BAN),
						request.getParameter(SessionConst.EMAIL));
				LOG.log(Level.DEBUG, SessionConst.BAN + " case finished.");
				break;
			case SessionConst.ADD:
				editCatalogService.addThing(request);
				LOG.log(Level.DEBUG, SessionConst.ADD + " case finished.");
				break;
			case SessionConst.REMOVE:
				editCatalogService.removeThing(encodingRequest(request.getParameter(SessionConst.ARTICLE)));
				LOG.log(Level.DEBUG, SessionConst.REMOVE + " case finished.");
				break;
			case SessionConst.STATUS:
				ordersService.changeStatus(request.getParameter(SessionConst.ARTICLE),
						request.getParameter(SessionConst.EMAIL), request.getParameter(SessionConst.STATUS),
						request.getParameter(SessionConst.LANGUAGE_PAGE));
				LOG.log(Level.DEBUG, SessionConst.STATUS + " case finished."); 
				break;
			case RedirectConst.FORWARD:
				LOG.log(Level.DEBUG, SessionConst.FORWARD + " case finished.");
				return RedirectConst.ADMIN;
			default:
				break;
			}
		} catch (Exception e) {
			LOG.log(Level.TRACE, "Problem has occured in execute method: ", e);
		}

		LOG.log(Level.DEBUG, "Command finished.");
		return RedirectConst.ADMIN;
	}
	
	private String encodingRequest(String input) throws UnsupportedEncodingException {
		return new String(input.getBytes(EncodingConst.ENCODING_ISO_8859_1), EncodingConst.ENCODING_UTF8);
	}

}
