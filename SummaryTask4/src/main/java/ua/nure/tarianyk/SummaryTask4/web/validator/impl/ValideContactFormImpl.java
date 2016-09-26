package ua.nure.tarianyk.SummaryTask4.web.validator.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ua.nure.tarianyk.SummaryTask4.util.ErrorConst;
import ua.nure.tarianyk.SummaryTask4.util.consts.PatternConst;
import ua.nure.tarianyk.SummaryTask4.web.model.transfer.ContactTransferBean;
import ua.nure.tarianyk.SummaryTask4.web.validator.Validator;

/**
 * Used for validating input data.
 * 
 * @author Anton
 * @version 1.0
 *
 */
public class ValideContactFormImpl implements Validator<ContactTransferBean> {

	////////////////////////////////
	//// Variables for pattern.////
	///////////////////////////////
	private Pattern pattern = null;
	private Matcher matcher = null;

	/**
	 * Validating input data.
	 * 
	 * @param contactTransferBean
	 *            generic object that will be validate
	 * @return key for redirect
	 */
	@Override
	public String validateInputData(ContactTransferBean contactTransferBean) {
		String name = contactTransferBean.getName();
		String email = contactTransferBean.getEmail();
		String subject = contactTransferBean.getSubject();
		String message = contactTransferBean.getMessage();

		if ((name.equals("")) || (email.equals("")) || (subject.equals("")) || (message.equals(""))) {
			return ErrorConst.EMPTY;
		}

		if ((name.equals("")) && (email.equals("")) && (subject.equals("")) && (message.equals(""))) {
			return ErrorConst.EMPTY;
		} 

		if (!validateEmail(email)) {
			return ErrorConst.EMPTY;
		}

		return ErrorConst.VALIDE;
	}

	/**
	 * Used for validating email.
	 * 
	 * @param email
	 *            email of user
	 * @return <tt>true</tt> or <tt>false</tt>
	 */
	public boolean validateEmail(String email) {
		pattern = Pattern.compile(PatternConst.EMAIL_PATTERN);
		matcher = pattern.matcher(email);
		return matcher.matches();
	}

}
