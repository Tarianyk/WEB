package ua.nure.tarianyk.SummaryTask4.service;

import java.sql.SQLException;
import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;

/**
 * Used for processing with catalog table through DAO-layer.
 * 
 * @author Anton
 * @version 1.0
 *
 */
public interface EditCatalogService {

	/**
	 * Adds product into table.
	 * 
	 * @param request
	 *            input http request
	 * @throws SQLException
	 *             incorrect parameters into SQL-query
	 * @throws ParseException
	 *             reached while parsing.
	 */
	public void addThing(HttpServletRequest request) throws Exception;

	/**
	 * Remove specific product from database.
	 * 
	 * @param article
	 *            article of product
	 * @throws SQLException
	 *             incorrect parameters into SQL-query
	 * @throws ParseException
	 *             reached while parsing.
	 */
	public void removeThing(String article) throws SQLException, ParseException;

}
