package ua.nure.tarianyk.SummaryTask4.util.consts;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class URLConst {

	/**
	 * Logger.
	 */
	private final static Logger LOG = Logger.getLogger(URLConst.class);

	private URLConst() {
		LOG.log(Level.ERROR, "Attempt to create an instance of URLConst class!");

		throw new UnsupportedOperationException("Non instance URLConst");
	}

	///////////////////////////
	/////// Parameters/////////
	//////////////////////////
	public final static String LANGUAGE = "language";
	public final static String LOGIN = "login";
	public final static String CATALOG = "catalog";
	public final static String REGISTRATION = "registration";
	public final static String DETAIL = "detail";
	public final static String ADD_SHOP_CART = "addshopcart";
	public final static String DELETE = "delete";
	public final static String BUY_THING = "buything";
	public final static String ADMIN = "admin";
	public final static String PERSONAL_AREA = "personalarea";
	public final static String SORT = "sort";
	public final static String EXIT = "exit";
	public final static String CONTACT = "contact";
}
