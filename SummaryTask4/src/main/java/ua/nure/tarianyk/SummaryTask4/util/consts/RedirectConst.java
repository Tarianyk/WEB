package ua.nure.tarianyk.SummaryTask4.util.consts;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class RedirectConst {

	/**
	 * Logger.
	 */
	private final static Logger LOG = Logger.getLogger(RedirectConst.class);

	private RedirectConst() {
		LOG.log(Level.ERROR, "Attempt to create an instance of RedirectConst class!");

		throw new UnsupportedOperationException("Non instance RedirectConst");
	}

	///////////////////////////
	/////// Parameters/////////
	//////////////////////////
	public final static String REFERER = "Referer";
	public final static String CPU = "cpu";
	public final static String SOUND = "sound";
	public final static String DRIVE = "drive";
	public final static String CAMERA = "camera";
	public final static String FLASH = "flash";
	public final static String DETAIL = "detail";
	public final static String FORWARD = "forward";
	public final static String ADMIN = "admin";
	public final static String CATALOG = "catalog";
	public final static String PERSONAL_AREA = "personalarea";
	public final static String MAIN_PAGE = "/";
	public final static String CONTACT_PAGE = "contact";
	public final static String REGISTER_PAGE = "registration";
	public final static String CART_PAGE = "cart";
	public final static String CATALOG_PAGE = "catalog";

	////////////////////////////
	/////// Path to pages///////
	///////////////////////////
//	public final static String CPU_PATH = "/WEB-INF/views/public/catalog.jsp";
//	public final static String SOUND_PATH = "/WEB-INF/views/public/catalog.jsp";
//	public final static String DRIVE_PATH = "/WEB-INF/views/public/catalog.jsp";
//	public final static String CAMERA_PATH = "/WEB-INF/views/public/catalog.jsp";
//	public final static String FLASH_PATH = "/WEB-INF/views/public/catalog.jsp";
	public final static String DETAIL_PATH = "/WEB-INF/views/public/detail.jsp";
	public final static String ADMIN_PATH = "/SummaryTask4/views/private/adminarea.jsp";
	public final static String PERSONAL_AREA_PATH = "/SummaryTask4/views/private/personalarea.jsp";
	public final static String MAIN_PAGE_PATH = "/SummaryTask4/";
	public final static String CONTACT_PAGE_PATH = "/SummaryTask4/views/public/contact.jsp";
	public final static String REGISTER_PAGE_PATH = "/SummaryTask4/views/public/registration.jsp";
	public final static String CART_PAGE_PATH = "/SummaryTask4/views/public/shoppingcart.jsp";
	public final static String ADMIN_PAGE_PATH = "/SummaryTask4/views/private/adminarea.jsp";
	public final static String CATALOG_PAGE_PATH = "/WEB-INF/views/public/catalog.jsp";

	/**
	 * Get appropriate kind.
	 * 
	 * @param kind
	 *            input parameter
	 * @return appropriate object input String
	 */
	public static String getKind(String kind) {
		switch (kind) {
		case CPU:
			return CPU.toUpperCase();
		case SOUND:
			return SOUND.toUpperCase();
		case DRIVE:
			return DRIVE.toUpperCase();
		case CAMERA:
			return CAMERA.toUpperCase();
		case FLASH:
			return FLASH.toUpperCase();

		default:
			throw new IllegalArgumentException("non Action");
		}

	}

}
