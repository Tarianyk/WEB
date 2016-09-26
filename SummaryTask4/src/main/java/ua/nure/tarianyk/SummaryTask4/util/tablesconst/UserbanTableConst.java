package ua.nure.tarianyk.SummaryTask4.util.tablesconst;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * Contains constants for userban table.
 * 
 * @author Anton
 * @version 1.0
 *
 */
public class UserbanTableConst {

	/**
	 * Logger.
	 */
	private final static Logger LOG = Logger.getLogger(UserbanTableConst.class);

	private UserbanTableConst() {
		LOG.log(Level.ERROR, "Attempt to create an instance of UserbanTableConst class!");

		throw new UnsupportedOperationException("Non instance UserbanTableConst");
	}

	///////////////////////////////////////////////////////////
	/// Below are variables that contains names of columns. ///
	//////////////////////////////////////////////////////////

	public static final String ID = "Id";
	public static final String BAN = "ban";
}
