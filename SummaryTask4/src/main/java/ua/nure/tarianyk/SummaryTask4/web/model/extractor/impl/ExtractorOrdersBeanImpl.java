package ua.nure.tarianyk.SummaryTask4.web.model.extractor.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import ua.nure.tarianyk.SummaryTask4.util.tablesconst.OrdersTableConst;
import ua.nure.tarianyk.SummaryTask4.web.model.entity.LanguageBean;
import ua.nure.tarianyk.SummaryTask4.web.model.entity.OrdersBean;
import ua.nure.tarianyk.SummaryTask4.web.model.extractor.Extractor_Generic_OneParameter;

/**
 * Used for extracting from <tt>ResultSet</tt> for  <tt>OrdersBean</tt>.
 * 
 * @author Anton
 * @version 1.0
 * 
 */
public class ExtractorOrdersBeanImpl implements Extractor_Generic_OneParameter<OrdersBean, ResultSet> {

	/**
	 * Logger.
	 */
	public final static Logger LOG = Logger.getLogger(ExtractorOrdersBeanImpl.class);

	/*
	 * Extract data.
	 * 
	 * @see
	 * ua.nure.tarianyk.SummaryTask4.web.model.extractor.ExtractorOrdersBean#
	 * extract(java.sql.ResultSet)
	 */
	@Override
	public OrdersBean extract(ResultSet resultSet) {
		OrdersBean ordersBean = new OrdersBean(); 
		try {
			ordersBean.setId(Integer.valueOf(resultSet.getString(OrdersTableConst.ID)));
			ordersBean.setArticle(resultSet.getString(OrdersTableConst.ARTICLE));
			ordersBean.setEmail(resultSet.getString(OrdersTableConst.EMAIL));
			ordersBean.setTotalAmount(Integer.valueOf(resultSet.getString(OrdersTableConst.TOTAL_AMOUNT)));
			ordersBean.setPrice(Double.valueOf(resultSet.getString(OrdersTableConst.PRICE)));
			ordersBean.setTotalPrice(Double.valueOf(resultSet.getString(OrdersTableConst.TOTAL_PRICE)));
			ordersBean.setStatus(resultSet.getString(OrdersTableConst.STATUS));

			LanguageBean languageBean = new LanguageBean();
			languageBean.setId(Integer.valueOf(resultSet.getString(OrdersTableConst.LANG_ID)));
			ordersBean.setLanguageBean(languageBean);
		} catch (NumberFormatException | SQLException e) {
			LOG.log(Level.TRACE, "Exception has occured in extract method.", e);
		}

		return ordersBean;
	}

}
