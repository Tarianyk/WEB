package ua.nure.tarianyk.SummaryTask4.web.listener;

import java.sql.SQLException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import ua.nure.tarianyk.SummaryTask4.database.connection.ConnectionPool;

/**
 * Listener class for activating connection pool in WEB-application.
 * 
 * @author Anton
 * @version 1.0
 *
 */
public class ActivateConnectionPoolListener implements ServletContextListener {

	/**
	 * Logger
	 */
	private final static Logger LOG = Logger.getLogger(ActivateConnectionPoolListener.class);

	/**
	 * Holds connection pool.
	 * 
	 * @see ua.nure.tarianyk.SummaryTask4.database.connectiondb.CreateConnectionPool
	 */
	private ConnectionPool pool = null; 

	/*
	 * Receives notification that the web application initialization process is
	 * starting.
	 * 
	 * @param sce (as specified by {@link
	 * ServletContextListener#contextInitialized})
	 * 
	 * @see
	 * javax.servlet.ServletContextListener#contextInitialized(javax.servlet.
	 * ServletContextEvent)
	 */
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		LOG.log(Level.INFO, "ActivateConnectionPoolListener context initialization starts");

		try {
			pool = new ConnectionPool();
			pool.createConnection();

			LOG.log(Level.INFO, "Connection pool was created.");
		} catch (SQLException e) {
			LOG.log(Level.TRACE, "SQLException has occured in contextInitialized method.", e);
		}

	} 

	/*
	 * Receives notification that the ServletContext is about to be shut down.
	 * 
	 * @param sce (as specified by {@link
	 * ServletContextListener#contextDestroyed})
	 * 
	 * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.
	 * ServletContextEvent)
	 */
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		LOG.log(Level.INFO, "ActivateConnectionPoolListener context initialization ends");

		if (pool != null) {
			try {
				pool.closeConnection();
			} catch (SQLException e) {
				LOG.log(Level.TRACE, "SQLException has occured in contextDestroyed method.", e);
			}

			LOG.log(Level.INFO, "Connection pool was closed.");
		}
	}

}
