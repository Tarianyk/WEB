package ua.nure.tarianyk.SummaryTask4.util.consts;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * Contains constants for creating PDF-document.
 * 
 * @author Anton
 * @version 1.0
 *
 */
public class PDFconst {

	/**
	 * Logger.
	 */
	private final static Logger LOG = Logger.getLogger(PDFconst.class);

	private PDFconst() {
		LOG.log(Level.ERROR, "Attempt to create an instance of PDFconst class!");

		throw new UnsupportedOperationException("Non instance PDFconst.");
	}

	/////////////////////////////////////////////////////////////////////
	/// Below are variables that contains constants for localization. ///
	/////////////////////////////////////////////////////////////////////
	public static final String REPORT = "java.report";
	public static final String TABLE = "java.table";
	public static final String NUMBER = "java.number";
	public static final String ARTICLE = "java.article";
	public static final String AMOUNT = "java.amount";
	public static final String PRICE = "java.price";
	public static final String TOTAL_PRICE = "java.total_price";
	public static final String IN_TOTAL = "java.intotal";
	public static final String MESSAGE = "java.message";
	public static final String REGISTERED = "java.registered";
	public static final String HEADER_ORDER = "java.header_order";
	public static final String HEADER_REG = "java.header_reg";
	

}
