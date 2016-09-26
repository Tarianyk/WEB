package ua.nure.tarianyk.SummaryTask4.service.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.mail.MessagingException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import ua.nure.tarianyk.SummaryTask4.database.DAO.OrdersDAO;
import ua.nure.tarianyk.SummaryTask4.database.DAO.impl.OrdersDAOimpl;
import ua.nure.tarianyk.SummaryTask4.service.ShoppingCartService;
import ua.nure.tarianyk.SummaryTask4.support.CookieCustom;
import ua.nure.tarianyk.SummaryTask4.support.Serilizable;
import ua.nure.tarianyk.SummaryTask4.util.consts.SessionConst;
import ua.nure.tarianyk.SummaryTask4.web.model.entity.UserBean;
import ua.nure.tarianyk.SummaryTask4.web.model.extractor.Extractor_Generic_OneParameter;
import ua.nure.tarianyk.SummaryTask4.web.model.extractor.impl.ExtractorReqBacketTransferImpl;
import ua.nure.tarianyk.SummaryTask4.web.model.transfer.BacketTransferBean;

/**
 * Used for processing an action in shopping cart through DAO-layer.
 * 
 * @author Anton
 * @version 1.0
 *
 */
public class ShoppingCartServiceImpl implements ShoppingCartService {

	/**
	 * Logger.
	 */
	private final static Logger LOG = Logger.getLogger(ShoppingCartServiceImpl.class);

	/**
	 * DAO layer for access to orders table.
	 */
	private OrdersDAO ordersDAO = null;

	/**
	 * Used for extracting BacketTransferBean from request data.
	 */
	private Extractor_Generic_OneParameter<BacketTransferBean, HttpServletRequest> extractorBacketTransfer = null;

	/**
	 * Max age cookie.
	 */
	private final static Integer MAX_AGE_COOKIE = 60 * 60 * 600;

	/**
	 * Default constructor witout parameters.
	 */
	public ShoppingCartServiceImpl() {
		ordersDAO = new OrdersDAOimpl();
		extractorBacketTransfer = new ExtractorReqBacketTransferImpl();
	}

	/*
	 * Adds to cart current product.
	 *
	 * @see
	 *
	 * ua.nure.tarianyk.SummaryTask4.service.ShoppingCartService#addToCart(javax
	 * .servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void addToCart(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ParseException, IOException, MessagingException {
		LOG.log(Level.DEBUG, "addToCart method starts.");

		HttpSession session = request.getSession(false);
		boolean newItem = true;

		BacketTransferBean backetTransferBean = extractorBacketTransfer.extract(request);

		List<BacketTransferBean> backet = null;

		List<BacketTransferBean> backet_cookie = CookieCustom.searchNeededCookie(request, SessionConst.BACKET_COOKIE);

		if (null == backet_cookie) {
			if (null == session.getAttribute(SessionConst.BACKET)) {
				backet = new ArrayList<>();
				backetTransferBean.setCountAdd();
				backet.add(backetTransferBean);

				CookieCustom.addToCookieBacket(backet, response);

				session.setAttribute(SessionConst.BACKET, backet);
				LOG.log(Level.TRACE, "Set the request attribute " + SessionConst.BACKET + "---->" + backet);
			} else {
				backet = (ArrayList<BacketTransferBean>) session.getAttribute(SessionConst.BACKET);

				for (BacketTransferBean i : backet) {
					if (i.getArticle().equals(backetTransferBean.getArticle())) {
						newItem = false;
						i.setCountAdd();
					}
				}

				if (newItem) {
					backetTransferBean.setCountAdd();
					backet.add(backetTransferBean);
				}

			}
		} else {
			backet = backet_cookie;

			for (BacketTransferBean i : backet) {
				if (i.getArticle().equals(backetTransferBean.getArticle())) {
					newItem = false;
					i.setCountAdd();
				}
			}

			if (newItem) {
				backetTransferBean.setCountAdd();
				backet.add(backetTransferBean);
			}
		}

		CookieCustom.addToCookieBacket(backet, response);

		session.setAttribute(SessionConst.BACKET, backet);
		LOG.log(Level.TRACE, "Set the request attribute " + SessionConst.BACKET + "---->" + backet);
		LOG.log(Level.DEBUG, "addToCart method finished.");
	}

	/*
	 * Deletes from shopping cart.
	 * 
	 * @see
	 * ua.nure.tarianyk.SummaryTask4.service.ShoppingCartService#deleteFromCart(
	 * javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void deleteFromCart(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ParseException {
		LOG.log(Level.DEBUG, "deleteFromCart method starts.");

		HttpSession session = request.getSession(false);

		List<BacketTransferBean> backet = (List<BacketTransferBean>) session.getAttribute(SessionConst.BACKET);

		List<BacketTransferBean> backet_cookie = CookieCustom.searchNeededCookie(request, SessionConst.BACKET_COOKIE);
		for (int i = 0; i < backet.size(); i++) {
			if (backet.get(i).getArticle().trim().equalsIgnoreCase(request.getParameter(SessionConst.ARTICLE).trim())) {
				if (backet.get(i).getCount() == 1) {
					backet.remove(i);
					backet_cookie.remove(i);
				} else {
					backet.get(i).setCountDel();
					backet_cookie.get(i).setCountDel();
				}
				break;
			}
		}

		CookieCustom.addToCookieBacket(backet_cookie, response);

		session.setAttribute(SessionConst.BACKET, backet);
		LOG.log(Level.TRACE, "Set the request attribute " + SessionConst.BACKET + "---->" + backet);
		LOG.log(Level.DEBUG, "deleteFromCart method finished.");

	}

	/*
	 * Buy product.
	 * 
	 * @see
	 * ua.nure.tarianyk.SummaryTask4.service.ShoppingCartService#buyThing(javax.
	 * servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public synchronized UserBean buyThing(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ParseException {
		LOG.log(Level.DEBUG, "buyThing method starts.");

		HttpSession session = request.getSession(false);

		List<BacketTransferBean> backet = (List<BacketTransferBean>) session.getAttribute(SessionConst.BACKET);
		UserBean userBean = (UserBean) session.getAttribute(SessionConst.USER);

		ordersDAO.buyThing(backet, userBean, setLanguage(session));

		CookieCustom.deleteCookie(request, response, SessionConst.BACKET_COOKIE);

		session.setAttribute(SessionConst.BACKET, null);
		LOG.log(Level.TRACE, "Set the request attribute " + SessionConst.BACKET + "---->" + null);
		LOG.log(Level.DEBUG, "buyThing method dinished.");

		return userBean;
	}

	/**
	 * Sets language.
	 * 
	 * @param session
	 *            current session
	 * @return tuned language
	 */
	private String setLanguage(HttpSession session) {
		String language_session = (String) session.getAttribute(SessionConst.LANGUAGE);
		String language = null;

		if (null == language_session) {
			language = "ru";
		} else {
			language = language_session;
		}

		return language;
	}

	////////////////////

}
