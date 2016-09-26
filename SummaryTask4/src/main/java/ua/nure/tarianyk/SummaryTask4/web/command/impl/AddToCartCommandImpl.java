package ua.nure.tarianyk.SummaryTask4.web.command.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import ua.nure.tarianyk.SummaryTask4.service.ShoppingCartService;
import ua.nure.tarianyk.SummaryTask4.util.consts.RedirectConst;
import ua.nure.tarianyk.SummaryTask4.web.command.Command;

/**
 * Used for adding to cart specified products.
 * 
 * @author Anton
 * @version 1.0
 *
 */
public class AddToCartCommandImpl implements Command {

	/**
	 * Logger.
	 */
	private final static Logger LOG = Logger.getLogger(AddToCartCommandImpl.class);

	/**
	 * Service for processing shopping actions.
	 */
	private ShoppingCartService shoppingCartService = null;

	/**
	 * Constructor with parameter.
	 * 
	 * @param shoppingCartService
	 *            java-bean transfer class
	 */
	public AddToCartCommandImpl(ShoppingCartService shoppingCartService) {
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
			shoppingCartService.addToCart(request, response);
		} catch (Exception e) {
			LOG.log(Level.TRACE, "Exception has occurred in execute method.", e);
		}

		LOG.log(Level.DEBUG, "Command finished.");
		return RedirectConst.REFERER;
	}

}
