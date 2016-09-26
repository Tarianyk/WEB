package ua.nure.tarianyk.SummaryTask4.util.tablesconst;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * Contains constants for orders table.
 * 
 * @author Anton
 * @version 1.0
 *
 */
public final class OrdersTableConst {

	/**
	 * Logger. 
	 */
	private final static Logger LOG = Logger.getLogger(OrdersTableConst.class); 
	
	private OrdersTableConst() {
		LOG.log(Level.ERROR, "Attempt to create an instance of OrdersTableConst class!");

		throw new UnsupportedOperationException("Non instance OrdersTableConst");
	}

	///////////////////////////////////////////////////////////
	/// Below are variables that contains names of columns. ///
	//////////////////////////////////////////////////////////

	public final static String ID = "Id";
	public final static String ARTICLE = "Article";
	public final static String EMAIL = "Email";
	public final static String TOTAL_AMOUNT = "TotalAmount";
	public final static String PRICE = "Price";
	public final static String TOTAL_PRICE = "TotalPrice";
	public final static String STATUS = "status";
	public final static String LANG_ID = "LangId";

}
