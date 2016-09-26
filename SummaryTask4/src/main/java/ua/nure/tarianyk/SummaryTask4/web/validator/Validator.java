package ua.nure.tarianyk.SummaryTask4.web.validator;

/**
 * Used for validating input data.
 * 
 * @author Anton
 * @version 1.0
 *
 * @param <T>
 *            generic input parameter
 */
public interface Validator<T> {

	/**
	 * Validating input data.
	 * 
	 * @param t
	 *            generic object that will be validate
	 * @return key for redirect
	 */
	public String validateInputData(T t);
}
