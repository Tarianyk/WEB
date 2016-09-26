package ua.nure.tarianyk.SummaryTask4.service;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import ua.nure.tarianyk.SummaryTask4.web.model.entity.OrdersBean;
import ua.nure.tarianyk.SummaryTask4.web.model.transfer.TaskTransfer;

/**
 * Used for processing an action in orders cart through DAO-layer.
 * 
 * @author Anton
 * @version 1.0
 *
 */
public interface OrdersService {

	/**
	 * Get list of ordered products.
	 * 
	 * @param email
	 *            user's email that did order
	 * @param lang
	 *            current language of user
	 * @return ordered product
	 * @throws SQLException
	 *             incorrect parameters into SQL-query
	 * @throws ParseException
	 *             reached while parsing.
	 */
	public List<OrdersBean> getOrders(String email, Integer lang) throws SQLException, ParseException;

	/**
	 * Changes status of order.
	 * 
	 * @param article
	 *            article of product
	 * @param email
	 *            email of user
	 * @param status
	 *            status
	 * @throws SQLException
	 *             incorrect parameters into SQL-query
	 * @throws ParseException
	 *             reached while parsing.
	 */
	public void changeStatus(String article, String email, String status, String language)
			throws SQLException, ParseException;

	public List<TaskTransfer> getTask() throws SQLException;
}
