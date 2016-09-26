package ua.nure.tarianyk.SummaryTask4.web.model.extractor.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import ua.nure.tarianyk.SummaryTask4.util.tablesconst.LanguageTableConst;
import ua.nure.tarianyk.SummaryTask4.util.tablesconst.UsersTableConst;
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
public class ExtractorRSUserBeanImpl implements Extractor_Generic_OneParameter<UserBean, ResultSet> {

	private final static Logger LOG = Logger.getLogger(ExtractorRSUserBeanImpl.class);

	/*
	 * Extract data.
	 * 
	 * @see
	 * ua.nure.tarianyk.SummaryTask4.web.model.extractor.ExtractorRS#extract(
	 * java.sql.ResultSet)
	 */
	@Override
	public UserBean extract(ResultSet resultSet) {
		UserBean userBean = new UserBean();

		try {
			userBean.setFirstName(resultSet.getString(UsersTableConst.FIRST_NAME));
			userBean.setLastName(resultSet.getString(UsersTableConst.LAST_NAME));
			userBean.setEmail(resultSet.getString(UsersTableConst.EMAIL));
			userBean.setFpassword(resultSet.getString(UsersTableConst.PASSWORD));
			userBean.setLpassword(resultSet.getString(UsersTableConst.PASSWORD));
			userBean.setRole(resultSet.getString(UsersTableConst.ROLE));

			LanguageBean language = new LanguageBean();
			language.setName(resultSet.getString(LanguageTableConst.NAME));
			userBean.setLanguage(language);

			UserbanBean userbanBean = new UserbanBean();
			userbanBean.setId(Integer.valueOf(resultSet.getString(LanguageTableConst.ID)));
			userBean.setUserBanBean(userbanBean);
		} catch (SQLException e) {
			LOG.log(Level.TRACE, "Exception has occured in extract method.", e);
		}

		return userBean;
	}

}
