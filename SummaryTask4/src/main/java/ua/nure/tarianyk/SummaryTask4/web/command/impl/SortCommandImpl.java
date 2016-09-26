package ua.nure.tarianyk.SummaryTask4.web.command.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import ua.nure.tarianyk.SummaryTask4.service.SortService;
import ua.nure.tarianyk.SummaryTask4.util.ErrorCheck;
import ua.nure.tarianyk.SummaryTask4.util.consts.RedirectConst;
import ua.nure.tarianyk.SummaryTask4.util.consts.SessionConst;
import ua.nure.tarianyk.SummaryTask4.web.command.Command;
import ua.nure.tarianyk.SummaryTask4.web.model.entity.CatalogBean;
import ua.nure.tarianyk.SummaryTask4.web.validator.impl.ValidateSortIntervalFormImpl;

/**
 * used for sorting products.
 * 
 * @author Anton
 * @version 1.0
 *
 */
public class SortCommandImpl implements Command {

	/**
	 * Logger.
	 */
	private final static Logger LOG = Logger.getLogger(SortCommandImpl.class);

	/**
	 * Service for sorting products.
	 */
	private SortService sortService = null;

	private ValidateSortIntervalFormImpl validateSortIntervalForm = null;

	private static String from_temp = null;
	private static String to_temp = null;

	private static String from = null;
	private static String to = null;

	public SortCommandImpl(SortService sortService, ValidateSortIntervalFormImpl validateSortIntervalForm) {
		this.sortService = sortService;
		this.validateSortIntervalForm = validateSortIntervalForm;
	}

	/*
	 * Execution method for command.
	 * 
	 * @see
	 * ua.nure.tarianyk.SummaryTask4.web.command.Command#execute(javax.servlet.
	 * http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		LOG.log(Level.DEBUG, "execute method starts.");
		
		HttpSession session = request.getSession(false);
		String kind = request.getParameter(SessionConst.KIND);

		List<CatalogBean> things = (List<CatalogBean>) session.getAttribute(kind.trim());
		List<CatalogBean> ready_things = null; 

		switch (request.getParameter(SessionConst.DIRECT)) {
		case SessionConst.AZ:
			ready_things = sortService.sortByNameAZ(things); 
			break;
		case SessionConst.ZA:
			ready_things = sortService.sortByNameZA(things); 
			break; 
		case SessionConst.FROM:
			ready_things = sortService.sortByPriceZA(things);  
			break;
		case SessionConst.TO:
			ready_things = sortService.sortByPriceAZ(things);
			break;
		case SessionConst.NOVELTY:
			ready_things = sortService.sortByNovelty(things);
			break;
		case SessionConst.INTERVAL:

			String error = validateSortIntervalForm.validateInputData(request);
			int flag = ErrorCheck.errorCheck(error, request); 
  
			if (flag == 1) { 
				ready_things = things;
			} else {
				if ((null != request.getParameter(SessionConst.TO)) && (null != request.getParameter(SessionConst.FROM))) {
					from_temp = request.getParameter(SessionConst.FROM);
					to_temp = request.getParameter(SessionConst.TO); 

					ready_things = sortService.sortByPriceInterval(things, from_temp, to_temp);
				} else {
					from = from_temp;
					to = to_temp; 

					ready_things = sortService.sortByPriceInterval(things, from_temp, to_temp);
				}
			}
			
			break;

		default:
			break;
		}

		session.setAttribute(kind.trim(), ready_things);

		LOG.log(Level.DEBUG, "execute method finished.");
		
		return RedirectConst.CATALOG_PAGE;
	}

}
