package ua.nure.tarianyk.SummaryTask4.web.model.extractor.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import ua.nure.tarianyk.SummaryTask4.util.tablesconst.CatalogTableConst;
import ua.nure.tarianyk.SummaryTask4.web.model.entity.CatalogBean;
import ua.nure.tarianyk.SummaryTask4.web.model.entity.LanguageBean;
import ua.nure.tarianyk.SummaryTask4.web.model.extractor.Extractor_Generic_OneParameter;

/**
 * Used for extracting from <tt>HttpServletRequest</tt>.
 * 
 * @author Anton
 * @version 1.0
 *
 */
public class ExtractorRSCatalogBeanImpl implements Extractor_Generic_OneParameter<CatalogBean, ResultSet> {

	private final static Logger LOG = Logger.getLogger(ExtractorRSCatalogBeanImpl.class);

	/*
	 * Extract data.
	 * 
	 * @see
	 * ua.nure.tarianyk.SummaryTask4.web.model.extractor.ExtractorRS#extract(
	 * java.sql.ResultSet)
	 */
	@Override
	public CatalogBean extract(ResultSet resultSet) {
		CatalogBean catalogBean = new CatalogBean();

		try {
			catalogBean.setTitle(resultSet.getString(CatalogTableConst.TITLE));
			catalogBean.setArticle(resultSet.getString(CatalogTableConst.ARTICLE));
			catalogBean.setDesc_1(resultSet.getString(CatalogTableConst.DESC_1));
			catalogBean.setDesc_2(resultSet.getString(CatalogTableConst.DESC_2));
			catalogBean.setPrice(Double.valueOf(resultSet.getString(CatalogTableConst.PRICE)));

			LanguageBean language = new LanguageBean();
			language.setId(Integer.valueOf(resultSet.getString(CatalogTableConst.LANGUAGE_ID)));
			catalogBean.setLangId(language);

			catalogBean.setDate(resultSet.getString(CatalogTableConst.DATE));
			catalogBean.setPath(resultSet.getString(CatalogTableConst.PATH));
			catalogBean.setAmount(Integer.valueOf(resultSet.getString(CatalogTableConst.AMOUNT)));
		} catch (SQLException e) {
			LOG.log(Level.TRACE, "Exception has occured in extract method.", e);
		}

		return catalogBean;
	}

}
