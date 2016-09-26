package ua.nure.tarianyk.SummaryTask4.service.impl;

import java.sql.SQLException;
import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import ua.nure.tarianyk.SummaryTask4.database.DAO.CatalogDAO;
import ua.nure.tarianyk.SummaryTask4.database.DAO.impl.CatalogDAOimpl;
import ua.nure.tarianyk.SummaryTask4.service.EditCatalogService;

/**
 * Used for processing with catalog table through DAO-layer.
 * 
 * @author Anton
 * @version 1.0
 *
 */
public class EditCatalogServiceImpl implements EditCatalogService {

	/**
	 * Logger.
	 */
	private final static Logger LOG = Logger.getLogger(EditCatalogServiceImpl.class);

	/**
	 * DAO layer for access to catalog table.
	 */
	private CatalogDAO catalogDAO = null;

	/**
	 * Default constructor witout parameters.
	 */
	public EditCatalogServiceImpl() {
		this.catalogDAO = new CatalogDAOimpl();
	}

	/*
	 * Adds product into table.
	 * 
	 * @see
	 * ua.nure.tarianyk.SummaryTask4.service.EditCatalogService#addThing(javax.
	 * servlet.http.HttpServletRequest)
	 */
	@Override
	public void addThing(HttpServletRequest request) throws Exception {
		LOG.log(Level.DEBUG, "Method addThing starts.");
		catalogDAO.addThing(request);
		LOG.log(Level.DEBUG, "Method addThing finished.");
	}

	/*
	 * Remove specific product from database.
	 * 
	 * @see
	 * ua.nure.tarianyk.SummaryTask4.service.EditCatalogService#removeThing(java
	 * .lang.String)
	 */
	@Override
	public void removeThing(String article) throws SQLException, ParseException {
		LOG.log(Level.DEBUG, "Method removeThing starts.");
		catalogDAO.removeThing(article);
		LOG.log(Level.DEBUG, "Method removeThing finished.");
	}

}
