package ua.nure.tarianyk.SummaryTask4.service.impl;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import ua.nure.tarianyk.SummaryTask4.database.DAO.OrdersDAO;
import ua.nure.tarianyk.SummaryTask4.database.DAO.impl.OrdersDAOimpl;
import ua.nure.tarianyk.SummaryTask4.service.OrdersService;
import ua.nure.tarianyk.SummaryTask4.web.model.entity.OrdersBean;
import ua.nure.tarianyk.SummaryTask4.web.model.transfer.TaskTransfer;

/**
 * Used for processing an action in orders cart through DAO-layer.
 * 
 * @author Anton
 * @version 1.0
 *
 */
public class OrdersServiceImpl implements OrdersService {

	/**
	 * Logger.
	 */
	private final static Logger LOG = Logger.getLogger(OrdersServiceImpl.class);

	/**
	 * DAO layer for access to orders table.
	 */
	private OrdersDAO ordersDAO = null;

	/**
	 * Default constructor witout parameters.
	 */
	public OrdersServiceImpl() {
		this.ordersDAO = new OrdersDAOimpl();
	}

	/*
	 * Get list of ordered products.
	 * 
	 * @see
	 * ua.nure.tarianyk.SummaryTask4.service.OrdersService#getOrders(java.lang.
	 * String, java.lang.Integer)
	 */
	@Override
	public List<OrdersBean> getOrders(String email, Integer lang) throws SQLException, ParseException {
		LOG.log(Level.DEBUG, "getOrders method starts.");
		LOG.log(Level.DEBUG, "getOrders method finished.");
		return ordersDAO.getOrders(email, lang);
	}

	/*
	 * Changes status of order.
	 * 
	 * @see
	 * ua.nure.tarianyk.SummaryTask4.service.OrdersService#changeStatus(java.
	 * lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void changeStatus(String article, String email, String status, String language)
			throws SQLException, ParseException {
		LOG.log(Level.DEBUG, "changeStatus method starts.");
		ordersDAO.changeStatus(article, email, status, language);
		LOG.log(Level.DEBUG, "changeStatus method finished.");

	}

	@Override
	public List<TaskTransfer> getTask() throws SQLException {
		return ordersDAO.getTask();		
	}

}
