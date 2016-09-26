package ua.nure.tarianyk.SummaryTask4.web.command.impl;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import ua.nure.tarianyk.SummaryTask4.service.ContactService;
import ua.nure.tarianyk.SummaryTask4.util.consts.SessionConst;
import ua.nure.tarianyk.SummaryTask4.web.command.Command;
import ua.nure.tarianyk.SummaryTask4.web.model.extractor.Extractor_Generic_OneParameter;
import ua.nure.tarianyk.SummaryTask4.web.model.transfer.ContactTransferBean;

/**
 * The class needs for contact with administration.
 * 
 * @author Anton
 * @version 1.0
 *
 */
public class ContactCommandImpl implements Command {

	/**
	 * Logger.
	 */
	private final static Logger LOG = Logger.getLogger(ContactCommandImpl.class);

	/**
	 * Service for processing contact actions.
	 */
	private ContactService contactService = null;

	/**
	 * Used for extracting ContactTransferBean from request data.
	 */
	private Extractor_Generic_OneParameter<ContactTransferBean, HttpServletRequest> cExtractorReq = null;

	public ContactCommandImpl(ContactService contactService,
			Extractor_Generic_OneParameter<ContactTransferBean, HttpServletRequest> cExtractorReq) {
		this.contactService = contactService;
		this.cExtractorReq = cExtractorReq;
	}
 
	/*
	 * Execution method for command.
	 * 
	 * @see
	 * ua.nure.tarianyk.SummaryTask4.web.command.Command#execute(javax.servlet.
	 * http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		LOG.log(Level.DEBUG, "Command starts.");

		ContactTransferBean contactTransferBean = cExtractorReq.extract(request);
		try {
			contactService.send(request, contactTransferBean);
		} catch (MessagingException | IOException e) {
			LOG.log(Level.TRACE, "Problem has occured in execute method: ", e);
		}

		LOG.log(Level.DEBUG, "Command finished.");
		return SessionConst.CONTACT;
	}

}
