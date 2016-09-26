package ua.nure.tarianyk.SummaryTask4.web.validator.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import ua.nure.tarianyk.SummaryTask4.util.ErrorConst;
import ua.nure.tarianyk.SummaryTask4.util.consts.PatternConst;
import ua.nure.tarianyk.SummaryTask4.util.consts.SessionConst;
import ua.nure.tarianyk.SummaryTask4.web.validator.Validator;

/**
 * Used for validating input data.
 * 
 * @author Anton
 * @version 1.0
 *
 */
public class ValidateSortIntervalFormImpl implements Validator<HttpServletRequest> {

	////////////////////////////////
	//// Variables for pattern.////
	///////////////////////////////
	private Pattern pattern = null;
	private Matcher matcher = null;

	/**
	 * Validating input data.
	 * 
	 * @param request
	 *            generic object that will be validate
	 * @return key for redirect
	 */
	@Override
	public String validateInputData(HttpServletRequest request) {
		String from = request.getParameter(SessionConst.FROM);
		String to = request.getParameter(SessionConst.TO);

//		if (((null == from) & (null == to)) || ((null == from) | (null == to))) {
//			return ErrorConst.INTERVAL;
//		}
		
		if((null == from) || (null == to)) {
			from = "0";
			to = "0";
		}
		
		if (((from.equals("")) & (to.equals(""))) || ((from.equals("")) | (to.equals("")))) {
			return ErrorConst.INTERVAL;
		} 
		
		if ((!valideNumber(from) & !valideNumber(to)) || (!valideNumber(from) | !valideNumber(to))) {
			return ErrorConst.INTERVAL; 
		}

		return ErrorConst.VALIDE;
	}

	/**
	 * Used for validating number.
	 * 
	 * @param number
	 *            number from field
	 * @return <tt>true</tt> or <tt>false</tt>
	 */
	private boolean valideNumber(String number) {
		pattern = Pattern.compile(PatternConst.NUMBER_PATTERN);
		matcher = pattern.matcher(number);

		return matcher.matches();
	}
}
