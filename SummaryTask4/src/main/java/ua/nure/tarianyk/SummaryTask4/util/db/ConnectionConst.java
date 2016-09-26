package ua.nure.tarianyk.SummaryTask4.util.db;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * ConnectionConst class used for store variable-constants.
 * 
 * @author Anton
 * @version 1.0
 */
public final class ConnectionConst {

	private final static Logger LOG = Logger.getLogger(ConnectionConst.class);

	private ConnectionConst() {
		LOG.log(Level.ERROR, "Attempt to create an instance of ConnectionConst class!");

		throw new UnsupportedOperationException("Non instance ConnectionConst");
	} 

	/**
	 * Holds the name of connection in resource file.
	 */
	public static String DRIVERMYSQL = "drivermysql";

	/**
	 * Holds the name of JDBC in resource file.
	 */
	public static String JDBC_UCP = "JDBC_UCP";

	/**
	 * Holds the name of URL in resource file.
	 */
	public static String URL = "url";

	/**
	 * Holds the name of USER in resource file.
	 */
	public static String USER = "user";

	/**
	 * Holds the name of PASSWORD in resource file.
	 */
	public static String PASSWORD = "password";

}
