package ua.nure.tarianyk.SummaryTask4.support;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import ua.nure.tarianyk.SummaryTask4.util.consts.SessionConst;
import ua.nure.tarianyk.SummaryTask4.web.model.entity.UserBean;
import ua.nure.tarianyk.SummaryTask4.web.model.transfer.BacketTransferBean;

public class CookieCustom {

	/** 
	 * Logger.
	 */
	private static final Logger LOG = Logger.getLogger(CookieCustom.class);

	/**
	 * Max age cookie.
	 */
	private final static Integer MAX_AGE_COOKIE = 60 * 60 * 600; 

	/**
	 * Adds to cookie container.
	 * 
	 * @param backet
	 *            input container
	 * @param response
	 *            input http response
	 */
	public static void addToCookieUser(UserBean userBean, HttpServletResponse response) {
		Cookie cookie = new Cookie(SessionConst.USER_COOKIE/*userBean.getEmail().trim()*/, Serilizable.serializationUser(userBean));
//		cookie.setPath("/");
		cookie.setMaxAge(MAX_AGE_COOKIE); // 1 hour
		response.addCookie(cookie);
	}

	/**
	 * Adds to cookie container.
	 * 
	 * @param backet
	 *            input container
	 * @param response
	 *            input http response
	 */
	public static void addToCookieBacket(List<BacketTransferBean> backet, HttpServletResponse response) {
		Cookie cookie = new Cookie(SessionConst.BACKET_COOKIE, Serilizable.serializationBacket(backet));
		cookie.setPath("/");
		cookie.setMaxAge(MAX_AGE_COOKIE); // 1 hour
		response.addCookie(cookie);

		LOG.log(Level.TRACE, "Set the cookie attribute " + SessionConst.BACKET_COOKIE + "---->" + backet);
	}

	/**
	 * Sets language inside cookie.
	 * 
	 * @param request
	 *            input http request
	 * @param response
	 *            input http response
	 * @param language
	 *            language that will be changed
	 * @throws IOException
	 *             input\output problem
	 */
	public static void setLanguageInCookie(HttpServletRequest request, HttpServletResponse response, String language)
			throws IOException {
		HttpSession session = request.getSession(false);

		Cookie[] cookie = request.getCookies(); 

		if (null != cookie) {   
			for (Cookie obj : cookie) {
				if (obj.getName().equals(SessionConst.USER_COOKIE)) { 
					UserBean userBean = null;
					try { 
						userBean = (UserBean) Serilizable.deserialization(obj.getValue());
						userBean.getLanguage().setName(language);

						CookieCustom.addToCookieUser(userBean, response);
						LOG.log(Level.TRACE,
								"Set the cookie attribute " + SessionConst.USER_COOKIE + "---->" + userBean);
					} catch (ClassNotFoundException e) {
						LOG.log(Level.TRACE, "Exception has occured in filter method.", e);
					}
					break;
				}
			}
		}
	}

	/**
	 * Deletes all the cookie.
	 * 
	 * @param request
	 *            input http request
	 * @param response
	 *            input http responses
	 */
	public static synchronized void deleteCookie(HttpServletRequest request, HttpServletResponse response,
			String name) {
		
		Cookie[] cookies = request.getCookies();

		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				Cookie cookie = cookies[i];
				if (cookie.getName().equals(name)) {
					cookie.setPath("/");
					cookie.setValue(null);
					cookie.setMaxAge(0);
					response.addCookie(cookie);
				}
			}
		}
	}

	/**
	 * Deletes all the cookie.
	 * 
	 * @param request
	 *            input http request
	 * @param response
	 *            input http responses
	 */
	public static synchronized void deleteCookie(HttpServletRequest request, HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();

		if (cookies != null) { 
			for (int i = 0; i < cookies.length; i++) {
				Cookie cookie = cookies[i];
//				cookie.setPath("/");
				cookie.setValue(null);
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			}
		}
	}

	/**
	 * Searches needed cookie.
	 * 
	 * @param request
	 *            input http request
	 * @return found list
	 */
	@SuppressWarnings("unchecked")
	public static List<BacketTransferBean> searchNeededCookie(HttpServletRequest request, String name) {
		List<BacketTransferBean> backet_cookie = null;

		Cookie[] cookie = request.getCookies();
		for (Cookie obj : cookie) { 
			if (obj.getName().equals(name)) { 
				try {
					backet_cookie = (List<BacketTransferBean>) Serilizable.deserialization(obj.getValue());
				} catch (ClassNotFoundException | IOException e) {
					LOG.log(Level.TRACE, "Exception has occured in searchNeededCookie method.", e);
				}
				break; 
			}
		}

		return backet_cookie;
	}
}
