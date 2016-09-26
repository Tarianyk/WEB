package ua.nure.tarianyk.SummaryTask4.database.DAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import ua.nure.tarianyk.SummaryTask4.database.DAO.CatalogDAO;
import ua.nure.tarianyk.SummaryTask4.database.connection.ConnectionPool;
import ua.nure.tarianyk.SummaryTask4.web.model.entity.CatalogBean;
import ua.nure.tarianyk.SummaryTask4.web.model.entity.UserBean;
import ua.nure.tarianyk.SummaryTask4.web.model.extractor.Extractor_Generic_TwoParameter;
import ua.nure.tarianyk.SummaryTask4.web.model.extractor.Extractor_Generic_OneParameter;
import ua.nure.tarianyk.SummaryTask4.web.model.extractor.impl.ExtractorPS_REQImpl;
import ua.nure.tarianyk.SummaryTask4.web.model.extractor.impl.ExtractorRSCatalogBeanImpl;

/**
 * DAO layer is used for access to processing SQL-query.
 * 
 * @author Anton
 * @version 1.0
 *
 */
public class CatalogDAOimpl implements CatalogDAO {

	/**
	 * Logger.
	 */
	private final static Logger LOG = Logger.getLogger(CatalogDAOimpl.class);

	/**
	 * Used for extracting data for ResulSet.
	 */
	private Extractor_Generic_OneParameter<CatalogBean, ResultSet> catalog = null; 

	/**
	 * Used for extracting data for PreparedStatement.
	 */
	private Extractor_Generic_TwoParameter<PreparedStatement, HttpServletRequest> addExtract = null;

	/**
	 * Default constructor without parameters.
	 */
	public CatalogDAOimpl() {
		catalog = new ExtractorRSCatalogBeanImpl();
		addExtract = new ExtractorPS_REQImpl();
	}

	/*
	 * Gets list of products from database.
	 * 
	 * @see
	 * ua.nure.tarianyk.SummaryTask4.database.DAO.CatalogDAO#getList(java.lang.
	 * String, java.lang.String)
	 */
	@Override
	public List<CatalogBean> getList(String kind, String language) throws SQLException, ParseException {
		LOG.log(Level.DEBUG, "getList method starts."); 

		Connection connection = null; 
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;   

		List<CatalogBean> catalog_list = new ArrayList<CatalogBean>(); 

		String sql = "select * from catalog where desc2 = ? and LanguageID = (select language.Id from language where Name = ?);";
		try {
			connection = ConnectionPool.getConnection();  
			

			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, kind.toUpperCase().trim());
			preparedStatement.setString(2, language);

			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				CatalogBean catalogBean = catalog.extract(resultSet);
				catalog_list.add(catalogBean);
			}
 
		} catch (SQLException e) {
			LOG.log(Level.TRACE, "Exception has occured in getList method.", e);
		} finally {
			if (preparedStatement != null) {
				preparedStatement.close();
			}

			if (connection != null) {
				connection.close();
			}
		}

		LOG.log(Level.DEBUG, "getList method finished.");
		return catalog_list;
	}

	/*
	 * Adds product into a table.
	 * 
	 * @see
	 * ua.nure.tarianyk.SummaryTask4.database.DAO.CatalogDAO#addThing(javax.
	 * servlet.http.HttpServletRequest)
	 */
	@Override
	public void addThing(HttpServletRequest request) throws Exception {
		LOG.log(Level.DEBUG, "addThing method starts.");

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String sql = "insert into catalog (title, articul, desc1, desc2, price, LanguageID, Date, path, amount) values (?, ?, ?, ?, ?, ?, ?, ?, ?);";
		try {  
			connection = ConnectionPool.getConnection();  
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement = addExtract.extract(preparedStatement, request);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			LOG.log(Level.TRACE, "Exception has occured in addThing method.", e);
		} finally {

			if (preparedStatement != null) {
				preparedStatement.close();
			}

			if (connection != null) {
				connection.close();
			}

		}

		LOG.log(Level.DEBUG, "addThing method finished.");
	}

	/*
	 * Removes product from a table.
	 * 
	 * @see
	 * ua.nure.tarianyk.SummaryTask4.database.DAO.CatalogDAO#removeThing(java.
	 * lang.String)
	 */
	@Override
	public void removeThing(String article) throws SQLException, ParseException {
		LOG.log(Level.DEBUG, "removeThing method starts.");

		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String sql = "delete from catalog where articul = ?;";
		try {
			dbConnection = ConnectionPool.getConnection(); 
			preparedStatement = dbConnection.prepareStatement(sql);
			preparedStatement.setString(1, article);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			LOG.log(Level.TRACE, "Exception has occured in removeThing method.", e);
		} finally {

			if (preparedStatement != null) {
				preparedStatement.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}

		}

		LOG.log(Level.DEBUG, "removeThing method finished.");
	}

	/*
	 * Gets a specified product.
	 * 
	 * @see
	 * ua.nure.tarianyk.SummaryTask4.database.DAO.CatalogDAO#getThing(java.lang.
	 * String, java.lang.String)
	 */
	@Override 
	public CatalogBean getThing(String article, String language) throws SQLException, ParseException {
		LOG.log(Level.DEBUG, "getThing method starts.");

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		CatalogBean catalogBean = null;

		String sql = "select * from catalog where article = ? and LanguageID = (select language.Id from language where Name = ?);";
		try {
			connection = ConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, article);
			preparedStatement.setString(2, language);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				catalogBean = catalog.extract(resultSet);
			}

		} catch (SQLException e) {
			LOG.log(Level.TRACE, "Exception has occured in getThing method.", e);
		} finally {
			if (preparedStatement != null) {
				preparedStatement.close();
			}

			if (connection != null) {
				connection.close();
			}
		}

		LOG.log(Level.DEBUG, "getThing method finished.");
		return catalogBean;
	}

}
