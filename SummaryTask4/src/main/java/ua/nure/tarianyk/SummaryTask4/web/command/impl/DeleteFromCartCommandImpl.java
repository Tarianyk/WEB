package ua.nure.tarianyk.SummaryTask4.web.command.impl;

import java.sql.SQLException;
import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import ua.nure.tarianyk.SummaryTask4.service.ShoppingCartService;
import ua.nure.tarianyk.SummaryTask4.util.consts.RedirectConst;
import ua.nure.tarianyk.SummaryTask4.web.command.Command;

/**
 * Used for deleting specified products from cart.
 * 
 * @author Anton
 * @version 1.0
 *
 */
public class DeleteFromCartCommandImpl implements Command {

	/**
	 * Logger.
	 */
	private final static Logger LOG = Logger.getLogger(DeleteFromCartCommandImpl.class);

	/**
	 * Service for processing shopping actions.
	 */
	private ShoppingCartService shoppingCartService = null;

	public DeleteFromCartCommandImpl(ShoppingCartService shoppingCartService) {
		this.shoppingCartService = shoppingCartService;
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
			shoppingCartService.deleteFromCart(request, response);
		} catch (SQLException | ParseException e) {
			LOG.log(Level.TRACE, "Exception has occurred in execute method.", e);
		}

		LOG.log(Level.DEBUG, "Command finished.");
		return RedirectConst.REFERER;
	}

}
