package ua.nure.tarianyk.SummaryTask4.util.tablesconst;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * Contains constants for catalog table.
 * 
 * @author Anton
 * @version 1.0
 *
 */
public class CatalogTableConst {

	/**
	 * Logger.
	 */
	private final static Logger LOG = Logger.getLogger(CatalogTableConst.class);

	private CatalogTableConst() {
		LOG.log(Level.ERROR, "Attempt to create an instance of CatalogTableConst class!");

		throw new UnsupportedOperationException("Non instance CatalogTableConst.");
	}

	///////////////////////////////////////////////////////////
	/// Below are variables that contains names of columns. ///
	//////////////////////////////////////////////////////////

	public final static String ID = "Id";
	public final static String TITLE = "title";
	public final static String ARTICLE = "articul";
	public final static String DESC_1 = "desc1";
	public final static String DESC_2 = "desc2";
	public final static String PRICE = "price";
	public final static String LANGUAGE_ID = "LanguageID";
	public final static String DATE = "Date";
	public final static String PATH = "path";
	public final static String AMOUNT = "amount";

}
