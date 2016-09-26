package ua.nure.tarianyk.SummaryTask4.web.model.extractor.impl;

import javax.servlet.http.HttpServletRequest;

import ua.nure.tarianyk.SummaryTask4.util.consts.SessionConst;
import ua.nure.tarianyk.SummaryTask4.web.model.extractor.Extractor_Generic_OneParameter;
import ua.nure.tarianyk.SummaryTask4.web.model.transfer.BacketTransferBean;

/**
 * Used for extracting from <tt>HttpServletRequest</tt>.
 * 
 * @author Anton
 * @version 1.0
 *
 */
public class ExtractorReqBacketTransferImpl
		implements Extractor_Generic_OneParameter<BacketTransferBean, HttpServletRequest> {

	/*
	 * Extract data.
	 * 
	 * @see
	 * ua.nure.tarianyk.SummaryTask4.web.model.extractor.ExtractorReq#extract(
	 * javax.servlet.http.HttpServletRequest)
	 */
	@Override
	public BacketTransferBean extract(HttpServletRequest request) {
		BacketTransferBean backetTransferBean = new BacketTransferBean(); 

		backetTransferBean.setPath(request.getParameter(SessionConst.PATH));
		backetTransferBean.setArticle(request.getParameter(SessionConst.ARTICLE));
		backetTransferBean.setPrice(Double.valueOf(request.getParameter(SessionConst.PRICE)));
 
		return backetTransferBean; 
	}

}
