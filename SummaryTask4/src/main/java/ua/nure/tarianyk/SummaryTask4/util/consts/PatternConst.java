package ua.nure.tarianyk.SummaryTask4.util.consts;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * Contains constants for pattern.
 * 
 * @author Anton
 * @version 1.0
 *
 */
public final class PatternConst { 

	/**
	 * Logger.
	 */
	private final static Logger LOG = Logger.getLogger(PatternConst.class);

	private PatternConst() { 
		LOG.log(Level.ERROR, "Attempt to create an instance of PatternConst class!");

		throw new UnsupportedOperationException("Non instance PatternConst.");
	}

	/**
	 * Email pattern for searching valide email. 
	 */
	public static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	/**
	 * Number pattern for searching numbers.
	 */
	public static final String NUMBER_PATTERN = "\\d+(\\.\\d+)?";

}
