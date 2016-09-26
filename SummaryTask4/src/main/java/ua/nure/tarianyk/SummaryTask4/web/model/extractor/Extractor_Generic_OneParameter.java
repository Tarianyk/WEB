package ua.nure.tarianyk.SummaryTask4.web.model.extractor;

/**
 * Used for extracting from <tt>HttpServletRequest</tt>.
 * 
 * @author Anton
 * @version 1.0
 *
 * @param <T>
 * 			input generic class
 */
public interface Extractor_Generic_OneParameter<T,E> extends Extractor {
	
	/**
	 * Extract data.
	 * 
	 * @param preparedStatement
	 * 						input PreparedStatement data
	 * @return
	 * 		extracted data
	 */
	public T extract(E e); /*PreparedStatement preparedStatement*/
}
