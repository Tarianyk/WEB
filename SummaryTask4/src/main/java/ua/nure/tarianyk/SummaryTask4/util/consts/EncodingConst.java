package ua.nure.tarianyk.SummaryTask4.util.consts;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * Contains constants for encoding.
 * 
 * @author Anton
 * @version 1.0
 *
 */
public final class EncodingConst {
	 
	/**
	 * Logger.
	 */
	private final static Logger LOG = Logger.getLogger(EncodingConst.class);
	
	private EncodingConst() {
		LOG.log(Level.ERROR, "Attempt to create an instance of ConnectionConst class!");
		
		throw new UnsupportedOperationException("Non instance EncodingConst.");
	}
	
	/**
	 * Holds UTF-8 encoding.
	 */
	public final static String ENCODING_UTF8 = "UTF-8";
	
	/**
	 * Holds CP-1251 encoding. 
	 */
	public final static String ENCODING_CP1251 = "CP1251";
	
	/**
	 * Holds UTF-16 encoding.
	 */
	public final static String ENCODING_UTF16 = "UTF-16";
	
	/**
	 * Holds ISO_8859_1 encoding.
	 */
	public final static String ENCODING_ISO_8859_1 = "ISO_8859_1";
	
}
