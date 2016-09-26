package ua.nure.tarianyk.SummaryTask4.service;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import ua.nure.tarianyk.SummaryTask4.web.model.entity.CatalogBean;

/**
 * Used to display products through DAO-layer.
 * 
 * @author Anton
 * @version 1.0
 *
 */
public interface ListThingsService {

	/**
	 * Get list of products.
	 * 
	 * @param kind
	 *            kind of product
	 * @param language
	 *            current language
	 * @return array that contains products
	 * @throws SQLException
	 *             incorrect parameters into SQL-query
	 * @throws ParseException
	 *             reached while parsing.
	 */
	public List<CatalogBean> getList(String kind, String language) throws SQLException, ParseException;

	/**
	 * Get product by article.
	 * 
	 * @param article
	 *            article of product
	 * @param language
	 *            current language
	 * @return product
	 * @throws SQLException
	 *             incorrect parameters into SQL-query
	 * @throws ParseException
	 *             reached while parsing.
	 */
	public CatalogBean getThing(String article, String language) throws SQLException, ParseException;
}
