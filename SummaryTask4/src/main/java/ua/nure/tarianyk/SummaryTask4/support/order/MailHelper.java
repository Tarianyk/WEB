package ua.nure.tarianyk.SummaryTask4.support.order;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * The class used for sending email to clients.
 * 
 * @author Anton
 * @version 1.0
 *
 */
public class MailHelper {

	/**
	 * Logger.
	 */
	private final static Logger LOG = Logger.getLogger(MailHelper.class);

	/**
	 * Contains email.
	 */
	public static String login = "summarytaskepam@gmail.com";

	/**
	 * Contains email password.
	 */
	public static String password = "summarytaskepamsummarytaskepam";

	public static String email = null;

	/**
	 * Name of order file.
	 */
	private final static String ORDER_LIST = "Order_list.pdf";

	static {

	}

	/**
	 * Sends email to clients.
	 * 
	 * @param mail
	 *            input email
	 * @param subject
	 *            subject of mail
	 * @param message
	 *            message
	 * @param attachment
	 *            if need attach document select <tt>true</tt>
	 * @throws AddressException
	 *             email address does not exists
	 * @throws MessagingException
	 *             message has a problem
	 * @throws IOException
	 *             input/output problem
	 */
	public synchronized static void sendMail(String mail, String subject, String message, String path,
			boolean attachment) throws AddressException, MessagingException, IOException {
		LOG.log(Level.DEBUG, "sendMail method starts.");
		
		email = mail;

		MimeMessage msg = new MimeMessage(getSession());
		msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mail));
		msg.setSubject(subject);
		msg.setText(message);
		msg.setSentDate(new Date());

		BodyPart messageBodyPart = new MimeBodyPart();
		messageBodyPart.setText(message);

		// if need attach files
		if (attachment) {

			// Create a multipar message
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart); 

			// Part two is attachment
			messageBodyPart = new MimeBodyPart();

			DataSource source = new FileDataSource(path);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName(ORDER_LIST);
			multipart.addBodyPart(messageBodyPart);

			// Send the complete message parts
			msg.setContent(multipart);

		}

		Transport.send(msg);
		LOG.log(Level.INFO, "Message sent to " + mail);
		LOG.log(Level.DEBUG, "sendMail method finished.");
	}

	/**
	 * Get session.
	 * 
	 * @return needed session
	 */
	private synchronized static Session getSession() {
		Session session = Session.getDefaultInstance(getProperties(), new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(login, password);
			}
		});
		return session;
	}

	/**
	 * Get properties.
	 * 
	 * @return properties
	 */
	private synchronized static Properties getProperties() {
		Properties properties = new Properties();
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.socketFactory.port", "465");
		properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.port", "465");
		return properties;
	}

	public static void setLogin(String login) {
		MailHelper.login = login;
	}

	public static void setPassword(String password) {
		MailHelper.password = password;
	}

}
