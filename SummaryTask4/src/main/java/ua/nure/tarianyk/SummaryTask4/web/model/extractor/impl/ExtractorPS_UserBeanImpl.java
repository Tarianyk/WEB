package ua.nure.tarianyk.SummaryTask4.web.model.extractor.impl;

import java.io.UnsupportedEncodingException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import ua.nure.tarianyk.SummaryTask4.util.HashPass;
import ua.nure.tarianyk.SummaryTask4.util.consts.EncodingConst;
import ua.nure.tarianyk.SummaryTask4.web.model.entity.UserBean;
import ua.nure.tarianyk.SummaryTask4.web.model.extractor.Extractor_Generic_TwoParameter;

/**
 * Used for extracting from <tt>UserBean</tt> for <tt>PreparedStatement</tt>.
 * 
 * @author Anton
 * @version 1.0
 *
 */
public class ExtractorPS_UserBeanImpl implements Extractor_Generic_TwoParameter<PreparedStatement, UserBean> {

	/**
	 * Logger.
	 */
	public final static Logger LOG = Logger.getLogger(ExtractorPS_UserBeanImpl.class);
	
	/* 
	 * Extract data.
	 * 
	 * @see ua.nure.tarianyk.SummaryTask4.web.model.extractor.ExtractorPS_UserBean#extract(java.sql.PreparedStatement, ua.nure.tarianyk.SummaryTask4.web.model.entity.UserBean)
	 */
	@Override
	public PreparedStatement extract(PreparedStatement preparedStatement, UserBean userBean) throws SQLException {
		try { 
			preparedStatement.setString(1, encodingRequest(userBean.getFirstName()));
			preparedStatement.setString(2, encodingRequest(userBean.getLastName()));
			preparedStatement.setString(3, encodingRequest(userBean.getEmail()));
			preparedStatement.setString(4, HashPass.hash(userBean.getFpassword(), HashPass.CIPHER_NAME).trim());
			preparedStatement.setString(5, userBean.getRole()); 
			preparedStatement.setInt(6, Integer.valueOf(userBean.getLanguage().getId()));
			preparedStatement.setInt(7, userBean.getUserBanBean().getId());
		} catch (UnsupportedEncodingException e) {
			LOG.log(Level.TRACE, "Exception has occured in extract method.", e);
		}
		 

		return preparedStatement; 
	}
	
	/**
	 * Encrypts input data from request to UTF-8.
	 * 
	 * @param name
	 *            input request 
	 * @return encoded data
	 * @throws UnsupportedEncodingException
	 *             if does not exist specified encoding
	 */
	private String encodingRequest(String name) throws UnsupportedEncodingException {
		return new String(name.getBytes(EncodingConst.ENCODING_ISO_8859_1), EncodingConst.ENCODING_UTF8);
	}
 
}
 