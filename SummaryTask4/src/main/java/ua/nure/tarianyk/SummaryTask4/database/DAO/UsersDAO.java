package ua.nure.tarianyk.SummaryTask4.database.DAO;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import ua.nure.tarianyk.SummaryTask4.web.model.entity.UserBean;

/**
 * DAO layer is used for access to processing SQL-query.
 * 
 * @author Anton
 * @version 1.0
 *
 */
public interface UsersDAO {

	/**
	 * Inserts an user into table.
	 * 
	 * @param userBean
	 *            current user (java bean) that will be added
	 * @throws SQLException
	 *             incorrect parameters into SQL-query
	 */
	public void insertUser(UserBean userBean) throws Exception;

	/**
	 * Checks email inside database. If this email exists then returns not-null
	 * object.
	 * 
	 * @param email
	 *            email of current user
	 * @return <tt>true</tt> or <tt>false</tt>
	 * @throws SQLException
	 *             incorrect parameters into SQL-query
	 */
	public String checkEmail(String email) throws SQLException;

	/**
	 * Login user.
	 * 
	 * @param request
	 *            input request
	 * @return current user
	 * @throws SQLException
	 *             incorrect parameters into SQL-query
	 */
	public UserBean loginUser(HttpServletRequest request) throws SQLException;

	/**
	 * Gives ban.
	 * 
	 * @param ban
	 *            parameter of ban
	 * @param email
	 *            email of current that will be banned
	 * @throws SQLException
	 *             incorrect parameters into SQL-query
	 */
	public void giveBan(String ban, String email) throws SQLException;

	/**
	 * Checks ban.
	 * 
	 * @param email
	 *            email of user
	 * @return
	 * 		<tt>1</tt> or <tt>2</tt> in dependency of user is banned or not
	 * 
	 * @throws SQLException
	 *             incorrect parameters into SQL-query
	 */
	public Integer checkBan(String email) throws SQLException;

	/**
	 * Changes language.
	 * 
	 * @param userBean
	 *            current user
	 * @param language
	 *            current language
	 * @throws SQLException
	 *             incorrect parameters into SQL-query
	 */
	public void changeLanguage(UserBean userBean, String language) throws SQLException;
}
