package ua.nure.tarianyk.SummaryTask4.util.tablesconst;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * Contains constants for language table.
 * 
 * @author Anton
 * @version 1.0
 *
 */
public class LanguageTableConst {

	/**
	 * Logger.
	 */
	private final static Logger LOG = Logger.getLogger(LanguageTableConst.class);

	private LanguageTableConst() {
		LOG.log(Level.ERROR, "Attempt to create an instance of LanguageTableConst class!");

		throw new UnsupportedOperationException("Non instance LanguageTableConst");
	}

	///////////////////////////////////////////////////////////
	/// Below are variables that contains names of columns. ///
	//////////////////////////////////////////////////////////

	public final static String ID = "Id";
	public final static String NAME = "Name";

}
