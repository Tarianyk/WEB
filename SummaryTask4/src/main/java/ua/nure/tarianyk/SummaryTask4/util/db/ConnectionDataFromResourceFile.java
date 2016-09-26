package ua.nure.tarianyk.SummaryTask4.util.db;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * Class used for access to connection data from resource file.
 * 
 * @author Anton
 * @version 1.0
 *
 */
public class ConnectionDataFromResourceFile {
	
	/**
	 * 
	 */
	private static ResourceBundle rb = null;

	/**
	 * Contains data from resource file.
	 */ 
	private static StringBuilder st = null;

	/**
	 * Maps used for store data from resource file. 
	 */
	private static Map<String, String> settings = null;

	/**
	 * Four data.
	 */
	private final static int SIZE = 4;

	/**
	 * Inner enum-class that contains list of parameters that used in resource file. 
	 * 
	 * @author Anton
	 *
	 */
	private enum TEST {
		DRIVERMYSQL, URL, USER, PASSWORD
	};

	/**
	 * Getter for searching needed parameter from resource file.
	 * 
	 * @return
	 * 		map that contains <tt>parameter</tt> from resource file
	 */
	public static Map<String, String> gerResources() {
		settings = new HashMap<>(); 
		st = new StringBuilder();
		rb = ResourceBundle.getBundle("resources");

		for (int i = 0; i < SIZE; i++) {
			String temp = TEST.values()[i].toString().toLowerCase();

			st.append(rb.getString(temp));

			settings.put(temp, st.toString());

			st.setLength(0);
		}

		return settings;

	}

}
