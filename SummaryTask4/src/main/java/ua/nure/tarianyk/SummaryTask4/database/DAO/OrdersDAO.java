package ua.nure.tarianyk.SummaryTask4.database.DAO;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import ua.nure.tarianyk.SummaryTask4.web.model.entity.OrdersBean;
import ua.nure.tarianyk.SummaryTask4.web.model.entity.UserBean;
import ua.nure.tarianyk.SummaryTask4.web.model.transfer.BacketTransferBean;
import ua.nure.tarianyk.SummaryTask4.web.model.transfer.TaskTransfer;

/**
 * DAO layer is used for access to processing SQL-query.
 * 
 * @author Anton
 * @version 1.0
 *
 */
public interface OrdersDAO {

	/**
	 * Used for buying product from shopping cart.
	 * 
	 * @param backet
	 *            list that contains current cart (java bean)
	 * @param userBean
	 *            current user (java bean)
	 * @param language
	 *            current language
	 * @throws SQLException
	 *             incorrect parameters into SQL-query
	 * @throws ParseException
	 *             reached while parsing.
	 */
	public void buyThing(List<BacketTransferBean> backet, UserBean userBean, String language)
			throws SQLException, ParseException;

	/**
	 * Gets list of orders.
	 * 
	 * @param email
	 *            email of user
	 * @param lang
	 *            current language
	 * @return list of products
	 * @throws SQLException
	 *             incorrect parameters into SQL-query
	 * @throws ParseException
	 *             reached while parsing.
	 */
	public List<OrdersBean> getOrders(String email, Integer lang) throws SQLException, ParseException;

	/**
	 * Changes status of specified product.
	 * 
	 * @param article
	 *            article of product
	 * @param email
	 *            email of user
	 * @param status
	 *            status that will be changed
	 * @throws SQLException
	 *             incorrect parameters into SQL-query
	 * @throws ParseException
	 *             reached while parsing.
	 */
	public void changeStatus(String article, String email, String status, String language)
			throws SQLException, ParseException;
	
	public List<TaskTransfer> getTask() throws SQLException;
}
