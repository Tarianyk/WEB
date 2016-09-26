package ua.nure.tarianyk.SummaryTask4.support.captcha;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.google.gson.Gson;

import ua.nure.tarianyk.SummaryTask4.support.daemonthread.CheckUserBan;

/**
 * Used for verifying reCaptcha.
 * 
 * @author Anton
 * @version 1.0
 *
 */
public class ReCaptcha { 

	/**
	 * Logger.
	 */
	private final static Logger LOG = Logger.getLogger(ReCaptcha.class);

	/**
	 * Holds secret code for reCaptcha.
	 */
	private static final String SECRET_KEY = "6LdlBSgTAAAAAKc7zYReZaGa59hT9cCOUx4J8ztz";

	/**
	 * Checks reCpatcha data.
	 * 
	 * @param gRecaptchaResponse
	 *            input captcha code
	 * @param request
	 *            input http request
	 * @return if captcha was passed return <tt>true</tt>
	 * @throws IOException
	 *             input/output problem
	 */
	public static boolean verify(String gRecaptchaResponse, HttpServletRequest request) throws IOException {
		LOG.log(Level.DEBUG, "verify method starts.");
		
		if (gRecaptchaResponse == null || gRecaptchaResponse.length() == 0) {
			return false;
		}

		URL url = new URL("https://www.google.com/recaptcha/api/siteverify?secret=" + SECRET_KEY + "&response="
				+ gRecaptchaResponse + "&remoteip=" + request.getRemoteAddr());
		
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		
		String line, outputString = "";
		BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

		while ((line = reader.readLine()) != null) {
			outputString += line;
		}

		CaptchaResponse capRes = new Gson().fromJson(outputString, CaptchaResponse.class);

		LOG.log(Level.DEBUG, "verify method finished.");		
		if (capRes.isSuccess()) {  
			LOG.log(Level.INFO, "reCaptcha was passed.");
			return true; 
		} else {
			LOG.log(Level.INFO, "reCaptcha was not passed.");
			return false;
		}
	}

}
