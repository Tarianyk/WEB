package ua.nure.tarianyk.SummaryTask4.support.order;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * New thread for sending email.
 * 
 * @author Anton
 * @version 1.0
 *
 */
public class Sender extends Thread {

	/**
	 * Logger.
	 */
	private final static Logger LOG = Logger.getLogger(Sender.class);

	String login = null;
	String password = null;
	String to = null;
	String header = null;
	String message = null;
	String path = null;
	boolean attachment = false;

	/**
	 * Constructor with parameters.
	 * 
	 * @param request
	 *            input http request
	 * @param to
	 *            last point where message will come
	 * @param header
	 *            header of message
	 * @param message
	 *            body of message
	 * @param path
	 * @param attachment
	 */
	public Sender(HttpServletRequest request, String to, String header, String message, String path,
			boolean attachment) {
		login = request.getSession(false).getServletContext().getInitParameter("login");
		password = request.getSession(false).getServletContext().getInitParameter("password");

		this.to = to;
		this.header = header;
		this.message = message;
		this.path = path;
		this.attachment = attachment;
	}

	@Override 
	public void run() {
		LOG.log(Level.DEBUG, "run method starts.");

		try {
			MailHelper.setLogin(login);
			MailHelper.setPassword(password);
			MailHelper.sendMail(to, header, message, path, attachment);
		} catch (MessagingException | IOException e) {
			LOG.log(Level.TRACE, "Exception has occurred in run method.", e);
		}

		LOG.log(Level.DEBUG, "run method finished.");
	}

}
