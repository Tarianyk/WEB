package ua.nure.tarianyk.SummaryTask4.service.impl;

import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import ua.nure.tarianyk.SummaryTask4.service.SortService;
import ua.nure.tarianyk.SummaryTask4.util.Sorter;
import ua.nure.tarianyk.SummaryTask4.web.filter.ValidateFieldsContactFormFilter;
import ua.nure.tarianyk.SummaryTask4.web.model.entity.CatalogBean;

/**
 * Used for sorting products on page.
 * 
 * @author Anton
 * @version 1.0
 *
 */
public class SortServiceImpl implements SortService {

	/**
	 * Logger.
	 */
	public final static Logger LOG = Logger.getLogger(SortServiceImpl.class);

	/*
	 * Sorts by name (Z-->A).
	 * 
	 * @see
	 * ua.nure.tarianyk.SummaryTask4.service.SortService#sortByNameZA(java.util.
	 * List)
	 */
	@Override
	public List<CatalogBean> sortByNameZA(List<CatalogBean> things) {
		LOG.log(Level.DEBUG, "sortByNameZA finished");
		return Sorter.sortByNameZA(things);
	}

	/*
	 * Sorts by name (A-->Z).
	 * 
	 * @see
	 * ua.nure.tarianyk.SummaryTask4.service.SortService#sortByNameAZ(java.util.
	 * List)
	 */
	@Override
	public List<CatalogBean> sortByNameAZ(List<CatalogBean> things) {
		LOG.log(Level.DEBUG, "sortByNameAZ finished");
		return Sorter.sortByNameAZ(things);
	}

	/*
	 * Sorts by price (A-->Z).
	 * 
	 * @see
	 * ua.nure.tarianyk.SummaryTask4.service.SortService#sortByPriceAZ(java.util
	 * .List)
	 */
	@Override
	public List<CatalogBean> sortByPriceAZ(List<CatalogBean> things) {
		LOG.log(Level.DEBUG, "sortByPriceAZ finished");
		return Sorter.sortByPriceAZ(things);
	}

	/*
	 * Sorts by price (Z-->A).
	 * 
	 * @see
	 * ua.nure.tarianyk.SummaryTask4.service.SortService#sortByPriceZA(java.util
	 * .List)
	 */
	@Override
	public List<CatalogBean> sortByPriceZA(List<CatalogBean> things) {
		LOG.log(Level.DEBUG, "sortByPriceZA finished");
		return Sorter.sortByPriceZA(things);
	}

	/*
	 * Sorts by interval.
	 * 
	 * @see
	 * ua.nure.tarianyk.SummaryTask4.service.SortService#sortByNovelty(java.util
	 * .List)
	 */
	@Override
	public List<CatalogBean> sortByNovelty(List<CatalogBean> things) {
		LOG.log(Level.DEBUG, "sortByNovelty finished");
		return Sorter.sortByNovelty(things);
	}

	/*
	 * Sorts by novelty.
	 * 
	 * @see
	 * ua.nure.tarianyk.SummaryTask4.service.SortService#sortByPriceInterval(
	 * java.util.List, java.lang.String, java.lang.String)
	 */
	@Override
	public List<CatalogBean> sortByPriceInterval(List<CatalogBean> things, String from, String to) {
		LOG.log(Level.DEBUG, "sortByPriceInterval finished");
		return Sorter.sortByPriceInterval(things, from, to); 
	}

}
