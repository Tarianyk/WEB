package ua.nure.tarianyk.SummaryTask4.web.model.extractor.impl;

import java.io.UnsupportedEncodingException;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import ua.nure.tarianyk.SummaryTask4.util.consts.EncodingConst;
import ua.nure.tarianyk.SummaryTask4.util.consts.SessionConst;
import ua.nure.tarianyk.SummaryTask4.web.model.extractor.Extractor_Generic_TwoParameter;

/**
 * Used for extracting data from <tt>HttpServletRequest</tt> for
 * <tt>PreparedStatement</tt>.
 * 
 * @author Anton
 * @version 1.0
 * 
 */
public class ExtractorPS_REQImpl implements Extractor_Generic_TwoParameter<PreparedStatement, HttpServletRequest> {

	/*
	 * Extract data.
	 * 
	 * @see ua.nure.tarianyk.SummaryTask4.web.model.extractor.
	 * Extractor_Generic_TwoParameter#extract(java.lang.Object,
	 * java.lang.Object)
	 */
	@Override
	public PreparedStatement extract(PreparedStatement preparedStatement, HttpServletRequest request) throws Exception {
		preparedStatement.setString(1, encodingRequest(request.getParameter(SessionConst.TITLE)));
		preparedStatement.setString(2, encodingRequest(request.getParameter(SessionConst.ARTICLE)));
		preparedStatement.setString(3, encodingRequest(request.getParameter(SessionConst.DESC_1)));
		preparedStatement.setString(4, encodingRequest(request.getParameter(SessionConst.DESC_2)));
		preparedStatement.setString(5, request.getParameter(SessionConst.PRICE));
		preparedStatement.setString(6, request.getParameter(SessionConst.LANG));
		preparedStatement.setString(7, String.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(new Date())));
		preparedStatement.setString(8, "/SummaryTask4/resources/images/db/" + request.getParameter(SessionConst.PATH));
		preparedStatement.setString(9, request.getParameter(SessionConst.AMOUNT));

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
