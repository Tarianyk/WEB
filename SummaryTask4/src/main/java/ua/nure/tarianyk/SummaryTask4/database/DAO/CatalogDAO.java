package ua.nure.tarianyk.SummaryTask4.database.DAO;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ua.nure.tarianyk.SummaryTask4.web.model.entity.CatalogBean;

/**
 * DAO layer is used for access to processing SQL-query.
 * 
 * @author Anton
 * @version 1.0
 *
 */
public interface CatalogDAO {

	/**
	 * Gets list of specified product.
	 * 
	 * @param kind
	 *            kind of product
	 * @param language
	 *            current language
	 * @return list of specified products
	 * @throws SQLException
	 *             incorrect parameters into SQL-query
	 * @throws ParseException
	 *             reached while parsing.
	 */
	public List<CatalogBean> getList(String kind, String language) throws SQLException, ParseException;

	/**
	 * Gets a specified product.
	 * 
	 * @param article
	 *            article of product
	 * @param language
	 *            current language
	 * @return specified product
	 * @throws SQLException
	 *             incorrect parameters into SQL-query
	 * @throws ParseException
	 *             reached while parsing
	 */
	public CatalogBean getThing(String article, String language) throws SQLException, ParseException;

	/**
	 * Adds product into a database (<tt>catalog</tt> table).
	 * 
	 * @param request
	 *            input http request
	 * @throws Exception
	 *             incorrect parameters at processing
	 */
	public void addThing(HttpServletRequest request) throws Exception;

	/**
	 * Removes product from a table.
	 * 
	 * @param article
	 *            article of product
	 * @throws SQLException
	 *             incorrect parameters into SQL-query
	 * @throws ParseException
	 *             reached while parsing
	 */
	public void removeThing(String article) throws SQLException, ParseException;

}
