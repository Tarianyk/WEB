package ua.nure.tarianyk.SummaryTask4.database.DAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import ua.nure.tarianyk.SummaryTask4.database.DAO.UsersDAO;
import ua.nure.tarianyk.SummaryTask4.database.connection.ConnectionPool;
import ua.nure.tarianyk.SummaryTask4.util.HashPass;
import ua.nure.tarianyk.SummaryTask4.util.consts.SessionConst;
import ua.nure.tarianyk.SummaryTask4.web.model.entity.UserBean;
import ua.nure.tarianyk.SummaryTask4.web.model.extractor.Extractor_Generic_OneParameter;
import ua.nure.tarianyk.SummaryTask4.web.model.extractor.Extractor_Generic_TwoParameter;
import ua.nure.tarianyk.SummaryTask4.web.model.extractor.impl.ExtractorPS_UserBeanImpl;
import ua.nure.tarianyk.SummaryTask4.web.model.extractor.impl.ExtractorRSUserBeanImpl;

/**
 * DAO layer is used for access to processing SQL-query.
 * 
 * @author Anton
 * @version 1.0
 *
 */
public class UsersDAOimpl implements UsersDAO {

	/**
	 * Logger. 
	 */
	private static final Logger LOG = Logger.getLogger(UsersDAOimpl.class);

	/*
	 * Inserts user into table.
	 * 
	 * @see
	 * ua.nure.tarianyk.SummaryTask4.database.DAO.UsersDAO#insertUser(ua.nure.
	 * tarianyk.SummaryTask4.web.model.entity.UserBean)
	 */
	@Override
	public void insertUser(UserBean userBean) throws Exception {  
		LOG.log(Level.DEBUG, "insertUser method starts."); 

		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		Extractor_Generic_TwoParameter<PreparedStatement, UserBean> extractorPS = new ExtractorPS_UserBeanImpl();

		String sql = "insert into users (FirstName, LastName, Email, Password, Role, LanguageID, id) values (?, ?, ?, ?, ?, ?, ?);";
		try {
			dbConnection = ConnectionPool.getConnection(); 
			preparedStatement = dbConnection.prepareStatement(sql);
			preparedStatement = extractorPS.extract(preparedStatement, userBean);
			preparedStatement.executeUpdate(); 

		} catch (SQLException e) {
			LOG.log(Level.TRACE, "Exception has occured in insertUser method.", e);
		} finally { 

			if (preparedStatement != null) {
				preparedStatement.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}

		}

		LOG.info("User " + userBean.getEmail() + " was registred");
		LOG.log(Level.DEBUG, "insertUser method finished.");
	}

	/*
	 * Checks email.
	 * 
	 * @see
	 * ua.nure.tarianyk.SummaryTask4.database.DAO.UsersDAO#checkEmail(java.lang.
	 * String)
	 */
	@Override
	public String checkEmail(String email) throws SQLException {
		LOG.log(Level.DEBUG, "checkEmail method starts.");

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		String email_temp = null;

		String sql = "select * from users where Email = ?";
		try {
			connection = ConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, email.trim());

			resultSet = preparedStatement.executeQuery();
			resultSet.next();

			email_temp = resultSet.getString("Email");
		} catch (SQLException e) {
			LOG.log(Level.TRACE, "Exception has occured in checkEmail method.", e);
		} finally {
			if (preparedStatement != null) {
				preparedStatement.close();
			}

			if (connection != null) {
				connection.close();
			}
		}

		LOG.log(Level.DEBUG, "checkEmail method finished.");
		return email_temp;
	}

	/*
	 * Login user.
	 * 
	 * @see ua.nure.tarianyk.SummaryTask4.database.DAO.UsersDAO#loginUser(javax.
	 * servlet.http.HttpServletRequest)
	 */
	@Override
	public UserBean loginUser(HttpServletRequest request) throws SQLException {
		LOG.log(Level.DEBUG, "loginUser method starts.");

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		Extractor_Generic_OneParameter<UserBean, ResultSet> extractor = null;

		String sql = "select FirstName, LastName, Email, Password, Role, Name, userban.Id  from users, language, userban where Email = ? and Password = ? and language.Id = LanguageID and users.id = userban.Id;";

		UserBean temp = null;
		try {
			connection = ConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, request.getParameter(SessionConst.LOGIN));
			preparedStatement.setString(2, 
					HashPass.hash(request.getParameter(SessionConst.PASSWORD), HashPass.CIPHER_NAME).trim());

			resultSet = preparedStatement.executeQuery();

			extractor = new ExtractorRSUserBeanImpl();
			if (resultSet.next()) {
				temp = extractor.extract(resultSet);
			}

		} catch (SQLException e) {
			LOG.log(Level.TRACE, "Exception has occured in loginUser method.", e);
		} finally {
			if (preparedStatement != null) {
				preparedStatement.close();
			}

			if (connection != null) {
				connection.close();
			}
		}

		LOG.log(Level.DEBUG, "loginUser method finished.");
		return temp;
	}

	/*
	 * Gives ban.
	 * 
	 * @see
	 * ua.nure.tarianyk.SummaryTask4.database.DAO.UsersDAO#giveBan(java.lang.
	 * String, java.lang.String)
	 */
	@Override
	public void giveBan(String ban, String email) throws SQLException {
		LOG.log(Level.DEBUG, "giveBan method starts.");

		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String sql = "UPDATE users SET Id = ? WHERE Email = ?;";
		try {
			dbConnection = ConnectionPool.getConnection();
			preparedStatement = dbConnection.prepareStatement(sql);

			preparedStatement.setString(1, ban);
			preparedStatement.setString(2, email);

			preparedStatement.executeUpdate(); 

		} catch (SQLException e) { 
			LOG.log(Level.TRACE, "Exception has occured in giveBan method.", e);
		} finally {

			if (preparedStatement != null) {
				preparedStatement.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}

		}

		LOG.log(Level.DEBUG, "giveBan method finished.");
	}

	/*
	 * Checks ban.
	 * 
	 * @see
	 * ua.nure.tarianyk.SummaryTask4.database.DAO.UsersDAO#checkBan(java.lang.
	 * String)
	 */
	@Override
	public Integer checkBan(String email) throws SQLException {
		LOG.log(Level.DEBUG, "checkBan method starts.");

		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String ans = null;

		String sql = "select users.id from users where Email = ?;";
		try { 
			dbConnection = ConnectionPool.getConnection();
			preparedStatement = dbConnection.prepareStatement(sql);
			preparedStatement.setString(1, email);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {  
				ans = resultSet.getString("id"); 
			} 
 
			return Integer.valueOf(ans); 

		} catch (SQLException e) {
			LOG.log(Level.TRACE, "Exception has occured in checkBan method.", e);
		} finally {

			if (preparedStatement != null) { 
				preparedStatement.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}

		}

		LOG.log(Level.DEBUG, "checkBan method finished.");
		return null;
	}

	/*
	 * Changes language.
	 * 
	 * @see
	 * ua.nure.tarianyk.SummaryTask4.database.DAO.UsersDAO#changeLanguage(ua.
	 * nure.tarianyk.SummaryTask4.web.model.entity.UserBean, java.lang.String)
	 */
	@Override
	public void changeLanguage(UserBean userBean, String language) throws SQLException {
		LOG.log(Level.DEBUG, "changeLanguage method starts.");
		
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String sql = "update users inner join language on users.LanguageID = language.Id set LanguageID = (select language.Id from language where Name = ?) where Email = ? and Password = ? ;";
		try {
			dbConnection = ConnectionPool.getConnection();
			preparedStatement = dbConnection.prepareStatement(sql);
			preparedStatement.setString(1, language);
			preparedStatement.setString(2, userBean.getEmail()/* "anton@gmail.com" */);
			preparedStatement.setString(3, userBean
					.getFpassword());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			LOG.log(Level.TRACE, "Exception has occured in changeLanguage method.", e);
		} finally {

			if (preparedStatement != null) {
				preparedStatement.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}

		}

		LOG.log(Level.DEBUG, "changeLanguage method finished.");
	}

}
