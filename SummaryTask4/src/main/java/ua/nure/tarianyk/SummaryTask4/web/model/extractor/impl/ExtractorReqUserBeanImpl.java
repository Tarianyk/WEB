package ua.nure.tarianyk.SummaryTask4.web.model.extractor.impl;

import javax.servlet.http.HttpServletRequest;

import ua.nure.tarianyk.SummaryTask4.util.consts.SessionConst;
import ua.nure.tarianyk.SummaryTask4.web.model.entity.LanguageBean;
import ua.nure.tarianyk.SummaryTask4.web.model.entity.UserBean;
import ua.nure.tarianyk.SummaryTask4.web.model.entity.UserbanBean;
import ua.nure.tarianyk.SummaryTask4.web.model.extractor.Extractor_Generic_OneParameter;

/**
 * Used for extracting from <tt>HttpServletRequest</tt>.
 * 
 * @author Anton
 * @version 1.0
 *
 */
public class ExtractorReqUserBeanImpl implements Extractor_Generic_OneParameter<UserBean, HttpServletRequest> {

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

		userBean.setFirstName(request.getParameter(SessionConst.FIRST_NAME));
		userBean.setLastName(request.getParameter(SessionConst.LAST_NAME));
		userBean.setEmail(request.getParameter(SessionConst.EMAIL));
		userBean.setFpassword(request.getParameter(SessionConst.FIRST_PASSWORD));
		userBean.setLpassword(request.getParameter(SessionConst.LAST_PASSWORD));
		userBean.setRole(SessionConst.ROLE_USER);

		LanguageBean language = new LanguageBean(); 
		language.setId(Integer.valueOf(request.getParameter(SessionConst.LANG)));
		userBean.setLanguage(language);

		UserbanBean userbanBean = new UserbanBean();
		userbanBean.setId(2);
		userBean.setUserBanBean(userbanBean);

		return userBean;
	}

}
