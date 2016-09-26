package ua.nure.tarianyk.SummaryTask4.database.DAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import ua.nure.tarianyk.SummaryTask4.database.DAO.OrdersDAO;
import ua.nure.tarianyk.SummaryTask4.database.connection.ConnectionPool;
import ua.nure.tarianyk.SummaryTask4.web.model.entity.OrdersBean;
import ua.nure.tarianyk.SummaryTask4.web.model.entity.UserBean;
import ua.nure.tarianyk.SummaryTask4.web.model.extractor.Extractor_Generic_FourParameter;
import ua.nure.tarianyk.SummaryTask4.web.model.extractor.Extractor_Generic_OneParameter;
import ua.nure.tarianyk.SummaryTask4.web.model.extractor.impl.ExtractorPS_UserBean_BacketTransferImpl;
import ua.nure.tarianyk.SummaryTask4.web.model.transfer.BacketTransferBean;
import ua.nure.tarianyk.SummaryTask4.web.model.transfer.TaskTransfer;
import ua.nure.tarianyk.SummaryTask4.web.model.extractor.impl.ExtractorOrdersBeanImpl;

/**
 * DAO layer is used for access to processing SQL-query.
 * 
 * @author Anton
 * @version 1.0
 *
 */
public class OrdersDAOimpl implements OrdersDAO {

	/**
	 * Logger.
	 */
	private final static Logger LOG = Logger.getLogger(OrdersDAOimpl.class);

	/**
	 * Used for extracting data for PreparedStatement.
	 */
	private Extractor_Generic_FourParameter<PreparedStatement, BacketTransferBean, UserBean, String> exTransfer = null;

	/**
	 * Used for extracting data for OrdersBean.
	 */
	private Extractor_Generic_OneParameter<OrdersBean, ResultSet> extractorOrdersBean = null;

	private String[] lan = new String[2];

	/**
	 * Default constructor without parameters.
	 */
	public OrdersDAOimpl() {
		exTransfer = new ExtractorPS_UserBean_BacketTransferImpl();
		extractorOrdersBean = new ExtractorOrdersBeanImpl();
		lan[0] = "ru";
		lan[1] = "en";
	}

	/*
	 * Buys product.
	 * 
	 * @see
	 * ua.nure.tarianyk.SummaryTask4.database.DAO.OrdersDAO#buyThing(java.util.
	 * List, ua.nure.tarianyk.SummaryTask4.web.model.entity.UserBean,
	 * java.lang.String)
	 */
	@Override
	public void buyThing(List<BacketTransferBean> backet, UserBean userBean, String language)
			throws SQLException, ParseException {
		LOG.log(Level.DEBUG, "buyThing method starts.");

		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String sql = "insert into orders (Article, Email, TotalAmount, Price, TotalPrice, status, LangId) values (?, ?, ?, ?, ?, ?, ?);";
		try {
			dbConnection = ConnectionPool.getConnection();
			dbConnection.setAutoCommit(false);
			preparedStatement = dbConnection.prepareStatement(sql);

			for (int i = 0; i < lan.length; i++) {
				for (BacketTransferBean j : backet) {
					preparedStatement = exTransfer.extract(preparedStatement, j, userBean, lan[i]);
					preparedStatement.addBatch();
				}
			}

			preparedStatement.executeBatch();
			dbConnection.commit();

		} catch (SQLException e) {
			LOG.log(Level.TRACE, "Exception has occured in buyThing method.", e);
		} finally {

			if (preparedStatement != null) {
				preparedStatement.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}

		}

		LOG.log(Level.DEBUG, "buyThing method finished.");
	}

	/*
	 * Gets list of orders.
	 * 
	 * @see
	 * ua.nure.tarianyk.SummaryTask4.database.DAO.OrdersDAO#getOrders(java.lang.
	 * String, java.lang.Integer)
	 */
	@Override
	public List<OrdersBean> getOrders(String email, Integer lang) throws SQLException, ParseException {
		LOG.log(Level.DEBUG, "getOrders method starts.");

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		ArrayList<OrdersBean> catalog = new ArrayList<OrdersBean>();

		String sql = "select * from orders where Email = ? and LangId = ?;";
		try {
			connection = ConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, email);
			preparedStatement.setInt(2, lang);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				OrdersBean ordersBean = extractorOrdersBean.extract(resultSet);
				catalog.add(ordersBean);
			}

		} catch (SQLException e) {
			LOG.log(Level.TRACE, "Exception has occured in getOrders method.", e);
		} finally {
			if (preparedStatement != null) {
				preparedStatement.close();
			}

			if (connection != null) {
				connection.close();
			}
		}

		LOG.log(Level.DEBUG, "getOrders method finished.");
		return catalog;
	}

	/*
	 * Changes status of specified product.
	 * 
	 * @see
	 * ua.nure.tarianyk.SummaryTask4.database.DAO.OrdersDAO#changeStatus(java.
	 * lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void changeStatus(String article, String email, String status, String language)
			throws SQLException, ParseException {
		LOG.log(Level.DEBUG, "changeStatus method starts.");

		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String sql = "UPDATE orders SET status = ? WHERE Email = ? AND Article = ? AND LangId = ?;";
		try {
			dbConnection = ConnectionPool.getConnection();
			preparedStatement = dbConnection.prepareStatement(sql);

			if (status.equals("paid")) {
				preparedStatement.setString(1, "Paid");
				preparedStatement.setString(2, email);
				preparedStatement.setString(3, article);
				preparedStatement.setInt(4, 1);
				preparedStatement.addBatch();

				preparedStatement.setString(1, "Оплачено");
				preparedStatement.setString(2, email);
				preparedStatement.setString(3, article);
				preparedStatement.setInt(4, 2);
				preparedStatement.addBatch();

				preparedStatement.executeBatch();
			} else if (status.equals("cancelled")) {
				preparedStatement.setString(1, "Cancelled");
				preparedStatement.setString(2, email);
				preparedStatement.setString(3, article);
				preparedStatement.setInt(4, 1);
				preparedStatement.addBatch();

				preparedStatement.setString(1, "Отменено");
				preparedStatement.setString(2, email);
				preparedStatement.setString(3, article);
				preparedStatement.setInt(4, 2);
				preparedStatement.addBatch();

				preparedStatement.executeBatch();
			}

		} catch (SQLException e) {
			LOG.log(Level.TRACE, "Exception has occured in changeStatus method.", e);
		} finally {

			if (preparedStatement != null) {
				preparedStatement.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}

		}

		LOG.log(Level.DEBUG, "changeStatus method finished.");
	}

	@Override
	public List<TaskTransfer> getTask() throws SQLException {
		LOG.log(Level.DEBUG, "getOrders method starts.");
		Connection dbConnection = null;
		Statement statement = null;
		List<TaskTransfer> catalog = null;

		String sql = "select orders.Id, catalog.title, language.name from orders, catalog, language where orders.Article = catalog.articul and language.name = 'en' and LangId = 2 and LanguageID = (select language.Id from language where Name = 'en');";
//		String sql = "select orders.Id, catalog.title from catalog join orders ON orders.Article = catalog.articul where orders.LangId = 1 and LanguageID = 1";

		try {
			dbConnection = ConnectionPool.getConnection();
			statement = dbConnection.createStatement();

			// execute select SQL stetement
			ResultSet rs = statement.executeQuery(sql);

			catalog = new ArrayList<TaskTransfer>();
			while (rs.next()) {
				TaskTransfer taskTransfer = new TaskTransfer();
				taskTransfer.setOrdersID(rs.getString("Id"));
				taskTransfer.setCatalogTitle(rs.getString("title"));
				taskTransfer.setLanguage(rs.getString("name"));
				catalog.add(taskTransfer);


			}

		} catch (SQLException e) {
			LOG.log(Level.TRACE, "Exception has occured in getOrders method.", e);

		} finally {

			if (statement != null) {
				statement.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}

		}
		return catalog;
	}

}
