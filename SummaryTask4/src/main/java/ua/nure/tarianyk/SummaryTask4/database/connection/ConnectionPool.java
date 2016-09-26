package ua.nure.tarianyk.SummaryTask4.database.connection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import oracle.ucp.jdbc.PoolDataSource;
import oracle.ucp.jdbc.PoolDataSourceFactory;
import ua.nure.tarianyk.SummaryTask4.util.db.ConnectionConst;
import ua.nure.tarianyk.SummaryTask4.util.db.ConnectionDataFromResourceFile;

/**
 * Used for creating connection pool.
 * 
 * @author Anton
 * @version 1.0
 *
 */
public class ConnectionPool { 

	/**
	 * Logger. 
	 */
	private final static Logger LOG = Logger.getLogger(ConnectionPool.class);

	/**
	 * The object used for getting connection.
	 */
	private static PoolDataSource pds = null;

	/**
	 * Stores settings for database.
	 */
	private static Map<String, String> settings = null;

	static {
		settings = ConnectionDataFromResourceFile.gerResources();
	} 

	/**
	 * Creates connection pool.
	 * 
	 * @throws SQLException
	 *             if one from parameters is <tt>null</tt>
	 * 
	 */
	public void createConnection() throws SQLException {
		LOG.log(Level.DEBUG, "Method createConnection starts.");
		
		pds = PoolDataSourceFactory.getPoolDataSource(); 

		pds.setConnectionFactoryClassName(settings.get(ConnectionConst.DRIVERMYSQL));
		pds.setConnectionPoolName(ConnectionConst.JDBC_UCP);
		pds.setURL(settings.get(ConnectionConst.URL));
		pds.setUser(settings.get(ConnectionConst.USER));
		pds.setPassword(settings.get(ConnectionConst.PASSWORD));

		pds.setInitialPoolSize(15);

		LOG.log(Level.INFO, "Connection pool was created.");
		LOG.log(Level.DEBUG, "Method createConnection finished."); 
	}

	/**
	 * Get connection.
	 * 
	 * @return connection from pool
	 * 
	 * @throws SQLException
	 *             if PoolDataSource is null
	 */
	public static Connection getConnection() throws SQLException {
		LOG.log(Level.DEBUG, "Method getConnection starts.");
  
		if (pds == null) {   
			LOG.log(Level.TRACE, "PoolDataSource class is empty.");
			throw new IllegalArgumentException();
		}
		  
		LOG.log(Level.DEBUG, "Method getConnection finished.");
		return pds.getConnection();
	}

	/**
	 * Closes connection pool if PoolDataSource is not null.
	 * @throws SQLException 
	 */
	public void closeConnection() throws SQLException {
		LOG.log(Level.DEBUG, "Method closeConnection starts."); 
		
		if (pds != null) { 
			pds = null;
		}
		LOG.log(Level.DEBUG, "Method getConnection finished.");
	}

}
