package ua.nure.tarianyk.SummaryTask4.service.impl;

import java.sql.SQLException;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import ua.nure.tarianyk.SummaryTask4.database.DAO.UsersDAO;
import ua.nure.tarianyk.SummaryTask4.database.DAO.impl.UsersDAOimpl;
import ua.nure.tarianyk.SummaryTask4.service.ProcessUserService;
import ua.nure.tarianyk.SummaryTask4.web.model.entity.UserBean;

/**
 * Used for processing different actions with users through DAO-layer.
 * 
 * @author Anton
 * @version 1.0
 *
 */
public class ProcessUserServiceImpl implements ProcessUserService {

	/**
	 * Logger.
	 */
	private final static Logger LOG = Logger.getLogger(ProcessUserServiceImpl.class);

	/**
	 * DAO layer for access to catalog table.
	 */
	private UsersDAO usersDAO = null;

	/**
	 * Default constructor witout parameters.
	 */
	public ProcessUserServiceImpl() {
		usersDAO = new UsersDAOimpl();
	}

	/*
	 * Gives ban/unban.
	 * 
	 * @see
	 * ua.nure.tarianyk.SummaryTask4.service.ProcessUserService#giveBan(java.
	 * lang.String, java.lang.String)
	 */
	@Override
	public void giveBan(String ban, String email) throws SQLException {
		LOG.log(Level.DEBUG, "Method giveBan starts.");
		usersDAO.giveBan(ban, email);
		LOG.log(Level.DEBUG, "Method giveBan finished.");
	}

	/*
	 * Changes status.
	 * 
	 * @see
	 * ua.nure.tarianyk.SummaryTask4.service.ProcessUserService#change(ua.nure.
	 * tarianyk.SummaryTask4.web.model.entity.UserBean, java.lang.String)
	 */
	@Override
	public void change(UserBean userBean, String language) throws SQLException {
		LOG.log(Level.DEBUG, "Method change starts.");
		usersDAO.changeLanguage(userBean, language);
		LOG.log(Level.DEBUG, "Method change finished.");
	}

}
