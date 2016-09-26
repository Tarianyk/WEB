package ua.nure.tarianyk.SummaryTask4.web.model.extractor.impl;

import javax.servlet.http.HttpServletRequest;

import ua.nure.tarianyk.SummaryTask4.util.consts.SessionConst;
import ua.nure.tarianyk.SummaryTask4.web.model.extractor.Extractor_Generic_OneParameter;
import ua.nure.tarianyk.SummaryTask4.web.model.transfer.ContactTransferBean;

/**
 * Used for extracting from <tt>HttpServletRequest</tt>.
 * 
 * @author Anton
 * @version 1.0
 *
 */
public class ExtractorReqContactTransferImpl
		implements Extractor_Generic_OneParameter<ContactTransferBean, HttpServletRequest> {

	/*
	 * Extract data.
	 * 
	 * @see
	 * ua.nure.tarianyk.SummaryTask4.web.model.extractor.ExtractorReq#extract(
	 * javax.servlet.http.HttpServletRequest)
	 */
	@Override
	public ContactTransferBean extract(HttpServletRequest request) {
		ContactTransferBean contactTransferBean = new ContactTransferBean();

		contactTransferBean.setName(request.getParameter(SessionConst.NAME));
		contactTransferBean.setEmail(request.getParameter(SessionConst.EMAIL));
		contactTransferBean.setSubject(request.getParameter(SessionConst.SUBJECT));
		contactTransferBean.setMessage(request.getParameter(SessionConst.MESSAGE));

		return contactTransferBean;
	}

}
