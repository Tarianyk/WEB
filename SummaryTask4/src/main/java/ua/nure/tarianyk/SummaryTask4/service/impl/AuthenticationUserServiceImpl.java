package ua.nure.tarianyk.SummaryTask4.service.impl;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import ua.nure.tarianyk.SummaryTask4.database.DAO.UsersDAO;
import ua.nure.tarianyk.SummaryTask4.database.DAO.impl.UsersDAOimpl;
import ua.nure.tarianyk.SummaryTask4.service.AuthenticationUserService;
import ua.nure.tarianyk.SummaryTask4.web.model.entity.UserBean;

/**
 * Used for processing on authentication through DAO-layer.
 * 
 * @author Anton
 * @version 1.0
 *
 */
public class AuthenticationUserServiceImpl implements AuthenticationUserService {

	/**
	 * Logger.
	 */
	private final static Logger LOG = Logger.getLogger(AuthenticationUserServiceImpl.class);

	/**
	 * DAO layer for access to catalog table.
	 */
	private UsersDAO usersDAO = null;

	/**
	 * Default constructor witout parameters.
	 */
	public AuthenticationUserServiceImpl() {
		usersDAO = new UsersDAOimpl();
	}

	/*
	 * Registration user.
	 * 
	 * @see ua.nure.tarianyk.SummaryTask4.service.AuthenticationUserService#
	 * registrationUser(ua.nure.tarianyk.SummaryTask4.web.model.entity.UserBean)
	 */
	@Override
	public void registrationUser(UserBean userBean) throws Exception {
		LOG.log(Level.DEBUG, "Method registrationUser starts.");
		usersDAO.insertUser(userBean);
		LOG.log(Level.INFO, "User was regitered.");
		LOG.log(Level.DEBUG, "Method registrationUser ends.");
	}

	/*
	 * Login user.
	 * 
	 * @see
	 * ua.nure.tarianyk.SummaryTask4.service.AuthenticationUserService#loginUser
	 * (javax.servlet.http.HttpServletRequest)
	 */
	@Override
	public UserBean loginUser(HttpServletRequest request) throws SQLException {
		LOG.log(Level.DEBUG, "Method loginUser starts.");
		return usersDAO.loginUser(request);
	}

}
