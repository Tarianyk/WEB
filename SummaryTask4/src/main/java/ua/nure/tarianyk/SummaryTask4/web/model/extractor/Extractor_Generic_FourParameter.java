package ua.nure.tarianyk.SummaryTask4.web.model.extractor;

import java.sql.SQLException;

/**
 * Used for extracting from <tt>HttpServletRequest</tt>.
 * 
 * @author Anton
 * @version 1.0
 *
 * @param <T>
 * 			input generic class
 */
public interface Extractor_Generic_FourParameter<T, E, V, U> extends Extractor {
	
	/**
	 * Extract data.
	 * 
	 * @param preparedStatement
	 * 						input PreparedStatement data
	 * @param backetTransferBean
	 * 						input BacketTransferBean data
	 * @param userBean
	 * 				input UserBean data
	 * @return
	 * 		extracted data
	 * @throws SQLException
	 * 					problem in SQL query
	 */
	public T extract(T t, E e , V v, U u) throws SQLException; 
}
