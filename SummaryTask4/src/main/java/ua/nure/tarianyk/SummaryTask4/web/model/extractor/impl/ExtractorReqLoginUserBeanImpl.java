package ua.nure.tarianyk.SummaryTask4.web.model.extractor.impl;

import javax.servlet.http.HttpServletRequest;

import ua.nure.tarianyk.SummaryTask4.util.consts.SessionConst;
import ua.nure.tarianyk.SummaryTask4.web.model.entity.UserBean;
import ua.nure.tarianyk.SummaryTask4.web.model.extractor.Extractor_Generic_OneParameter;

/**
 * Used for extracting from <tt>HttpServletRequest</tt>.
 * 
 * @author Anton
 * @version 1.0
 *
 */
public class ExtractorReqLoginUserBeanImpl implements Extractor_Generic_OneParameter<UserBean, HttpServletRequest> {

	/*
	 * Extract data.
	 * 
	 * @see
	 * ua.nure.tarianyk.SummaryTask4.web.model.extractor.ExtractorReq#extract(
	 * javax.servlet.http.HttpServletRequest)
	 */
	@Override
	public UserBean extract(HttpServletRequest request) {
		UserBean userBean = new UserBean();  

		userBean.setEmail(request.getParameter(SessionConst.LOGIN));
		userBean.setFpassword(request.getParameter(SessionConst.PASSWORD));

		return userBean;
	}

}
