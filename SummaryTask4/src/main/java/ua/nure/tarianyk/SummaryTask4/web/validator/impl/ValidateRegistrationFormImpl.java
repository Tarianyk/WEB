package ua.nure.tarianyk.SummaryTask4.web.validator.impl;

import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import ua.nure.tarianyk.SummaryTask4.database.DAO.UsersDAO;
import ua.nure.tarianyk.SummaryTask4.database.DAO.impl.UsersDAOimpl;
import ua.nure.tarianyk.SummaryTask4.util.ErrorConst;
import ua.nure.tarianyk.SummaryTask4.util.consts.PatternConst;
import ua.nure.tarianyk.SummaryTask4.web.model.entity.UserBean;
import ua.nure.tarianyk.SummaryTask4.web.validator.Validator;

/**
 * Used for validating input data.
 * 
 * @author Anton
 * @version 1.0
 *
 */
public class ValidateRegistrationFormImpl implements Validator<UserBean> {

	/**
	 * Logger.
	 */
	private final static Logger LOG = Logger.getLogger(ValidateRegistrationFormImpl.class);

	/**
	 * DAO layer for access to catalog table.
	 */
	private UsersDAO usersDAO = null;

	////////////////////////////////
	//// Variables for pattern.////
	///////////////////////////////
	private Pattern pattern = null;
	private Matcher matcher = null;

	public ValidateRegistrationFormImpl() {
		usersDAO = new UsersDAOimpl();
	}

	/**
	 * Validating input data.
	 * 
	 * @param userBean
	 *            generic object that will be validate
	 * @return key for redirect
	 */
	@Override
	public String validateInputData(UserBean userBean) {
		String fname = userBean.getFirstName();
		String lname = userBean.getLastName();
		String email = userBean.getEmail();
		String fpass = userBean.getFpassword();
		String lpass = userBean.getLpassword();

		String email_temp = null;

		try {
			email_temp = usersDAO.checkEmail(email);
		} catch (SQLException e) {
			LOG.log(Level.TRACE, "Problem has occured in validateInputData method: ", e);
		}

		if ((null == fname) || (null == lname) || (null == email) || (null == fpass) || (null == lpass)) {
			return ErrorConst.EMPTY;
		}

		if (null != email_temp) {
			return ErrorConst.EMAIL_EXIST;
		}

		if (fpass == null || lpass == null) {
			return ErrorConst.EMPTY;
		}

		if ((fname.equals("")) || (lname.equals("")) || (email.equals("")) || (fpass.equals(""))
				|| (lpass.equals(""))) {
			return ErrorConst.EMPTY;
		}

		if (!validateEmail(email)) {
			return ErrorConst.EMAIL;
		}

		if (!fpass.trim().equals(lpass.trim())) {
			return ErrorConst.NOT_EQUAL;
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
