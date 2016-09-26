package ua.nure.tarianyk.SummaryTask4.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import ua.nure.tarianyk.SummaryTask4.web.model.entity.CatalogBean;

/**
 * Util class is used for sorting data on page.
 * 
 * @author Anton
 * @version 1.0
 *
 */ 
public class Sorter { 

	private static final Comparator<CatalogBean> SORT_BY_NAME_ZA = new Comparator<CatalogBean>() {
		@Override
		public int compare(CatalogBean objOne, CatalogBean objTwo) {
			return objOne.getTitle().compareTo(objTwo.getTitle()) * (-1);
		}
	};
	
	private static final Comparator<CatalogBean> SORT_BY_NAME_AZ = new Comparator<CatalogBean>() {
		@Override
		public int compare(CatalogBean objOne, CatalogBean objTwo) {
			return objOne.getTitle().compareTo(objTwo.getTitle());
		}
	};
	
	private static final Comparator<CatalogBean> SORT_BY_PRICE_AZ = new Comparator<CatalogBean>() {
		@Override
		public int compare(CatalogBean objOne, CatalogBean objTwo) {
			return objOne.getPrice().compareTo(objTwo.getPrice());
		}
	};
	
	private static final Comparator<CatalogBean> SORT_BY_PRICE_ZA = new Comparator<CatalogBean>() {
		@Override
		public int compare(CatalogBean objOne, CatalogBean objTwo) {
			return objOne.getPrice().compareTo(objTwo.getPrice()) * (-1);
		}
	};
	
	private static final Comparator<CatalogBean> SORT_BY_NOVELTY = new Comparator<CatalogBean>() {
		@Override
		public int compare(CatalogBean objOne, CatalogBean objTwo) {
			return objOne.getDate().compareTo(objTwo.getDate());
		}
	};
	
	private static final Comparator<CatalogBean> SORT_BY_PRICE_INTERVAL = new Comparator<CatalogBean>() {
		@Override
		public int compare(CatalogBean objOne, CatalogBean objTwo) {
			return objOne.getPrice().compareTo(objTwo.getPrice());
		}
	};

	/**
	 * Sort by name (Z-->A).
	 * 
	 * @param things
	 * 			not sorted data
	 * @return
	 * 		sorted data
	 */
	public static final List<CatalogBean> sortByNameZA(List<CatalogBean> things) {
		List<CatalogBean> temp = things;
		
		Collections.sort(temp, SORT_BY_NAME_ZA); 
		
		return temp;
	}
	
	/**
	 * Sort by name (A-->Z).
	 * 
	 * @param things
	 * 			not sorted data
	 * @return
	 * 		sorted data
	 */
	public static final List<CatalogBean> sortByNameAZ(List<CatalogBean> things) {
		List<CatalogBean> temp = things;
		
		Collections.sort(temp, SORT_BY_NAME_AZ);
		
		return temp;
	}
	
	/**
	 * Sort by price (A-->Z).
	 * 
	 * @param things
	 * 			not sorted data
	 * @return
	 * 		sorted data
	 */
	public static final List<CatalogBean> sortByPriceAZ(List<CatalogBean> things) {
		List<CatalogBean> temp = things;
		
		Collections.sort(temp, SORT_BY_PRICE_AZ);
		
		return temp;
	}
	
	/**
	 * Sort by price (Z-->A).
	 * 
	 * @param things
	 * 			not sorted data
	 * @return
	 * 		sorted data
	 */
	public static final List<CatalogBean> sortByPriceZA(List<CatalogBean> things) {
		List<CatalogBean> temp = things;
		
		Collections.sort(temp, SORT_BY_PRICE_ZA);
		
		return temp;
	}
	
	/**
	 * Sort by novelty.
	 * 
	 * @param things
	 * 			not sorted data
	 * @return
	 * 		sorted data
	 */
	public static final List<CatalogBean> sortByNovelty(List<CatalogBean> things) {
		List<CatalogBean> temp = things;
		
		Collections.sort(temp, SORT_BY_NOVELTY);
		
		return temp;
	}
	
	/**
	 * Sort by price in interval.
	 * 
	 * @param things
	 * 			not sorted data
	 * @return
	 * 		sorted data
	 */
	public static final List<CatalogBean> sortByPriceInterval(List<CatalogBean> things, String from, String to) {
		List<CatalogBean> new_temp = new ArrayList<>();
		List<CatalogBean> temp = things;
		
		double from_temp = Double.valueOf(from);
		double to_temp = Double.valueOf(to);
		
		Collections.sort(temp, SORT_BY_PRICE_INTERVAL);
		
		for (int i = 0; i < temp.size(); i++) {
			if(temp.get(i).getPrice() >= from_temp && temp.get(i).getPrice() <= to_temp) {
				new_temp.add(temp.get(i));    
			}   
		} 
		
		return new_temp;
	}
	
}
