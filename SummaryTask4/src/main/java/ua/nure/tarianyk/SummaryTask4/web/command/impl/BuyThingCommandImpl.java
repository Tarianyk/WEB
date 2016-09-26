package ua.nure.tarianyk.SummaryTask4.web.command.impl;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.itextpdf.text.DocumentException;

import ua.nure.tarianyk.SummaryTask4.service.OrdersService;
import ua.nure.tarianyk.SummaryTask4.service.ShoppingCartService;
import ua.nure.tarianyk.SummaryTask4.support.order.GeneratePDF;
import ua.nure.tarianyk.SummaryTask4.support.order.Sender;
import ua.nure.tarianyk.SummaryTask4.util.consts.PDFconst;
import ua.nure.tarianyk.SummaryTask4.util.consts.RedirectConst;
import ua.nure.tarianyk.SummaryTask4.web.command.Command;
import ua.nure.tarianyk.SummaryTask4.web.model.entity.OrdersBean;
import ua.nure.tarianyk.SummaryTask4.web.model.entity.UserBean;

/**
 * Used for buying specified products.
 * 
 * @author Anton
 * @version 1.0
 *
 */
public class BuyThingCommandImpl implements Command {

	/** 
	 * Logger. 
	 */
	private final static Logger LOG = Logger.getLogger(BuyThingCommandImpl.class);

	/**
	 * Path to files with localization.
	 */
	private final static String LOCALIZATION = "ua.nure.tarianyk.SummaryTask4.localization.text";

	/**
	 * Path to style for text.
	 */
	private final static String STYLE = "c:\\Windows\\Fonts\\tahoma.ttf";

	/**
	 * Service for processing shopping actions.
	 */
	private ShoppingCartService shoppingCartService = null;

	/**
	 * Service for processing order actions.
	 */
	private OrdersService ordersService = null;

	////////////////////////////////
	// Variables for localization.//
	///////////////////////////////
	private ResourceBundle rb = null;
	private Locale locale = null;

	public BuyThingCommandImpl(ShoppingCartService shoppingCartService, OrdersService ordersService) {
		this.shoppingCartService = shoppingCartService;
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

		UserBean userBean = null;
		List<OrdersBean> ordersBeans = null;
		try { 
			userBean = shoppingCartService.buyThing(request, response);
			 
			LOG.log(Level.TRACE, "Found in DB: email of user that did order ----> " + userBean.getEmail());
   
			locale = new Locale(userBean.getLanguage().getName().trim());
			rb = ResourceBundle.getBundle(LOCALIZATION, locale);
			if (null != userBean) {
				ordersBeans = ordersService.getOrders(userBean.getEmail(), userBean.getLanguage().getId());
				LOG.log(Level.TRACE, "Found in DB: list of ordered products ----> " + ordersBeans);

				GeneratePDF generatePDF = new GeneratePDF(userBean.getEmail(), STYLE,
						userBean.getLanguage().getName().trim()); 
				String path = generatePDF.generateBodyDocument(generatePDF.createDocument(), ordersBeans);

				Sender send = new Sender(request, userBean.getEmail(), rb.getString(PDFconst.HEADER_ORDER), rb.getString(PDFconst.MESSAGE), path,
						true);  
				send.setDaemon(true);
				send.start();
			}

		} catch (SQLException | ParseException | DocumentException | IOException e) {
			LOG.log(Level.TRACE, "Exception has occurred in execute method.", e);
		}

		LOG.log(Level.DEBUG, "Command finished.");
		return RedirectConst.CART_PAGE;
	}

}
