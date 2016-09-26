package ua.nure.tarianyk.SummaryTask4.util.tablesconst;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * Contains constants for users table.
 * 
 * @author Anton
 * @version 1.0
 *
 */
public class UsersTableConst {

	/**
	 * Logger.
	 */
	private final static Logger LOG = Logger.getLogger(UsersTableConst.class);

	private UsersTableConst() {
		LOG.log(Level.ERROR, "Attempt to create an instance of UsersTableConst class!");

		throw new UnsupportedOperationException("Non instance UsersTableConst");
	}

	///////////////////////////////////////////////////////////
	/// Below are variables that contains names of columns. ///
	//////////////////////////////////////////////////////////

	public static final String USERS_ID = "UsersID";
	public static final String FIRST_NAME = "FirstName";
	public static final String LAST_NAME = "LastName";
	public static final String EMAIL = "Email";
	public static final String PASSWORD = "Password";
	public static final String ROLE = "Role";
	public static final String LANGUAGE_ID = "LanguageID";
	public static final String ID = "id";

}
