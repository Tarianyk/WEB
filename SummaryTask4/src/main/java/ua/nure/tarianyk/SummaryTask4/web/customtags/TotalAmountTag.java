package ua.nure.tarianyk.SummaryTask4.web.customtags;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import ua.nure.tarianyk.SummaryTask4.util.consts.SessionConst;
import ua.nure.tarianyk.SummaryTask4.web.model.transfer.BacketTransferBean;

/**
 * TotalAmountTag class implements an application that calculates and displays
 * total amount by purchases.
 * 
 * @author Anton
 * @version 1.0
 *
 */
public class TotalAmountTag extends SimpleTagSupport {

	/**
	 * Holds the total amount by purchases.
	 */
	private Double totalAmount = .0;

	/*
	 * Default processing of the tag does nothing.
	 * 
	 * @throws (as specified by {@link SimpleTagSupport#doTag})
	 * 
	 * @see TotalAmountTag#doTag()
	 */
	@Override
	@SuppressWarnings("unchecked")
	public void doTag() throws JspException, IOException {

		PageContext pageContext = (PageContext) getJspContext();
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();

		List<BacketTransferBean> backet = (List<BacketTransferBean>) request.getSession(false)
				.getAttribute(SessionConst.BACKET);
		if (null != backet) {
			for (BacketTransferBean i : backet) {
				totalAmount += i.getTotalAmount();
			}
			totalAmount = Math.rint(100.0 * totalAmount) / 100.0;

			JspWriter oWriter = getJspContext().getOut();
			oWriter.println(totalAmount);
		}

	}

}
