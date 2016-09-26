package ua.nure.tarianyk.SummaryTask4.service;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ua.nure.tarianyk.SummaryTask4.web.model.entity.UserBean;

/**
 * Used for processing an action in shopping cart through DAO-layer.
 * 
 * @author Anton
 * @version 1.0
 *
 */
public interface ShoppingCartService {

	/**
	 * Adds to cart current product.
	 * 
	 * @param request
	 *            input http request
	 * @param response
	 *            input http response
	 * @throws SQLException
	 *             incorrect parameters into SQL-query
	 * @throws ParseException
	 *             reached while parsing.
	 * @throws IOException
	 *             input/output problem
	 * @throws MessagingException
	 */
	public void addToCart(HttpServletRequest request, HttpServletResponse response)
			throws Exception;

	/**
	 * Deletes from shopping cart.
	 * 
	 * @param request
	 *            input http request
	 * @param response
	 *            input http response
	 * @throws SQLException
	 *             incorrect parameters into SQL-query
	 * @throws ParseException
	 *             reached while parsing.
	 */
	public void deleteFromCart(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ParseException;

	/**
	 * Buy product.
	 * 
	 * @param request
	 *            input http request
	 * @param response
	 *            input http response
	 * @return user that bought product
	 * @throws SQLException
	 *             incorrect parameters into SQL-query
	 * @throws ParseException
	 *             reached while parsing.
	 */
	public UserBean buyThing(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ParseException;

}
