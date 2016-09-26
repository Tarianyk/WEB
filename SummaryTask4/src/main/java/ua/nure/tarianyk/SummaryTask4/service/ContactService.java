package ua.nure.tarianyk.SummaryTask4.service;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.http.HttpServletRequest;

import ua.nure.tarianyk.SummaryTask4.web.model.transfer.ContactTransferBean;

/**
 * Used for sending email to administration.
 * 
 * @author Anton
 * @version 1.0
 *
 */
public interface ContactService {

	/**
	 * Sends email.
	 * 
	 * @param contactTransferBean
	 *            object with data from contact page
	 * @throws AddressException
	 *             does not exists email/not valide
	 * @throws MessagingException
	 *             incorrect parameters inside object of message
	 * @throws IOException
	 *             incorrect parameters into SQL-query
	 */
	public void send(HttpServletRequest request, ContactTransferBean contactTransferBean)
			throws AddressException, MessagingException, IOException;
}
