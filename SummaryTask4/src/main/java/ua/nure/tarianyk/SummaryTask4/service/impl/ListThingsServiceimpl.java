package ua.nure.tarianyk.SummaryTask4.service.impl;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import ua.nure.tarianyk.SummaryTask4.database.DAO.CatalogDAO;
import ua.nure.tarianyk.SummaryTask4.database.DAO.impl.CatalogDAOimpl;
import ua.nure.tarianyk.SummaryTask4.service.ListThingsService;
import ua.nure.tarianyk.SummaryTask4.web.model.entity.CatalogBean;

/**
 * Used to display products through DAO-layer.
 * 
 * @author Anton
 * @version 1.0
 *
 */
public class ListThingsServiceimpl implements ListThingsService {

	/**
	 * Logger.
	 */
	private final static Logger LOG = Logger.getLogger(ListThingsServiceimpl.class);

	/**
	 * DAO layer for access to catalog table.
	 */
	private CatalogDAO catalogDAO = null;

	/**
	 * Default constructor witout parameters.
	 */
	public ListThingsServiceimpl() {
		catalogDAO = new CatalogDAOimpl();
	}

	/*
	 * Get list of products.
	 * 
	 * @see
	 * ua.nure.tarianyk.SummaryTask4.service.ListThingsService#getList(java.lang
	 * .String, java.lang.String)
	 */
	@Override
	public List<CatalogBean> getList(String kind, String language) throws SQLException, ParseException {
		LOG.log(Level.TRACE, "getList method starts.");
		LOG.log(Level.TRACE, "getList method finished.");
		return catalogDAO.getList(kind, language);
	}

	/*
	 * Get product by article.
	 * 
	 * @see
	 * ua.nure.tarianyk.SummaryTask4.service.ListThingsService#getThing(java.
	 * lang.String, java.lang.String)
	 */
	@Override
	public CatalogBean getThing(String article, String language) throws SQLException, ParseException {
		LOG.log(Level.TRACE, "getThings method starts.");
		LOG.log(Level.TRACE, "getThings method finished.");
		return catalogDAO.getThing(article, language);
	}

}
