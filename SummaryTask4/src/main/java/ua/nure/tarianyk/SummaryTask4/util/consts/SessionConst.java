package ua.nure.tarianyk.SummaryTask4.util.consts;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class SessionConst {
	
	private SessionConst() {
		LOG.log(Level.ERROR, "Attempt to create an instance of SessionConst class!");
		
		throw new UnsupportedOperationException("Non instance SessionConst");
	}
	
	/**
	 * Logger.
	 */
	private final static Logger LOG = Logger.getLogger(SessionConst.class);
	
	public final static String FIRST_NAME = "fname";
	public final static String LAST_NAME = "lname";
	public final static String EMAIL = "email";
	public final static String FIRST_PASSWORD = "fpass";
	public final static String LAST_PASSWORD = "lpass";
	public final static String LANG = "lang";
	public final static String LOGIN = "login";
	public final static String PASSWORD = "password";
	public final static String ARTICLE = "article";
	public final static String PATH = "path";
	public final static String PRICE = "price";
	public final static String NAME = "name";
	public final static String SUBJECT = "subject";
	public final static String MESSAGE = "message";
	public final static String ERROR = "error";
	public final static String USER = "user";
	public final static String THREAD_COLLECTION = "thread_collection";
	public final static String LANGUAGE = "language";
	public final static String PARAM = "param";
	public final static String FORWARD = "forward";
	public final static String KIND = "kind";
	public final static String BACKET = "backet";
	public final static String BACKET_COOKIE = "backet_cookie";
	public final static String USER_COOKIE = "user_cookie";
	public final static String DETAIL_PRODUCT = "detail_product";
	public final static String ROLE_USER = "USER";
	public final static String BAN = "ban";
	public final static String ADD = "add";
	public final static String REMOVE = "remove";
	public final static String STATUS = "status";
	public final static String ID = "id";
	public final static String ORDER = "order";
	public final static String LANGUAGE_PAGE = "language_page";
	public final static String CONTACT = "contact";
	public final static String TITLE = "title";
	public final static String DESC_1 = "desc1";
	public final static String DESC_2 = "desc2";
	public final static String AMOUNT = "amount";
	public final static String FROM = "from";
	public final static String TO = "to";
	public final static String DIRECT = "direct";	
	public final static String AZ = "az";
	public final static String ZA = "za";
	public final static String NOVELTY = "novelty";
	public final static String INTERVAL = "interval";
	public final static String REGIST = "You are successfully registered.";
		
}

