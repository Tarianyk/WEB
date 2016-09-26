package ua.nure.tarianyk.SummaryTask4.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import ua.nure.tarianyk.SummaryTask4.util.consts.EncodingConst;

/**
 * Used for hashing passwords.
 * 
 * @author Anton
 *
 */
public final class HashPass {

	/**
	 * Logger.
	 */
	public final static Logger LOG = Logger.getLogger(HashPass.class);

	/**
	 * Holds name of cipher.
	 */
	public final static String CIPHER_NAME = "SHA-256";

	private HashPass() {  
		LOG.log(Level.ERROR, "Attempt to create an instance of HashPass class!");

		throw new UnsupportedOperationException("Non instance HashPass."); 
	}

	/**
	 * Method used for hashing passwords.
	 * 
	 * @param input
	 * 			input password
	 * @param alghoritm
	 * 				name of algorithm
	 * @return
	 * 		hashed password
	 */
	public static String hash(String input, String alghoritm) {
		MessageDigest digest = null;
		StringBuilder builder = new StringBuilder();
		try {
			digest = MessageDigest.getInstance(alghoritm);
			digest.update(input.getBytes(EncodingConst.ENCODING_UTF8));
			byte[] hash = digest.digest(); 
 
			for (int i = 0; i < hash.length; i++) {
				String tmp = Integer.toHexString(hash[i]);
				if (tmp.length() > 2) {
					tmp = tmp.substring(tmp.length() - 2, tmp.length());
				}

				builder.append(tmp).append(" ");
			} 
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			LOG.log(Level.TRACE, "Exception in HshPass#hash method.!", e);
		}

		return builder.toString();
	}

}
