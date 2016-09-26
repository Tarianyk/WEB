package ua.nure.tarianyk.SummaryTask4.web.model.extractor.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import ua.nure.tarianyk.SummaryTask4.web.model.entity.UserBean;
import ua.nure.tarianyk.SummaryTask4.web.model.extractor.Extractor_Generic_FourParameter;
import ua.nure.tarianyk.SummaryTask4.web.model.transfer.BacketTransferBean;

/**
 * Used for extracting from <tt>BacketTransferBean and UserBean</tt> for <tt>PreparedStatement</tt>.
 * 
 * @author Anton
 * @version 1.0
 *
 */
public class ExtractorPS_UserBean_BacketTransferImpl
		implements Extractor_Generic_FourParameter<PreparedStatement, BacketTransferBean, UserBean, String> {

	/*
	 * Extract data.
	 * 
	 * @see ua.nure.tarianyk.SummaryTask4.web.model.extractor.
	 * ExtractorPS_UserBean_BacketTransfer#extract(java.sql.PreparedStatement,
	 * ua.nure.tarianyk.SummaryTask4.web.model.transfer.BacketTransferBean,
	 * ua.nure.tarianyk.SummaryTask4.web.model.entity.UserBean)
	 */
	@Override
	public PreparedStatement extract(PreparedStatement preparedStatement, BacketTransferBean i, UserBean userBean,
			String language) throws SQLException {

		preparedStatement.setString(1, i.getArticle()); 
		preparedStatement.setString(2, userBean.getEmail());
		preparedStatement.setInt(3, i.getCount());
		preparedStatement.setDouble(4, i.getPrice());
		preparedStatement.setDouble(5, i.getTotalAmount()); 

		if (language.equals("ru")) {
			preparedStatement.setString(6, "Зарегистрировано");
			preparedStatement.setInt(7, 2);
		} else if (language.equals("en")) {
			preparedStatement.setString(6, "Joined"); 
			preparedStatement.setInt(7, 1);
		}

		return preparedStatement;
	}

}
