package ua.nure.tarianyk.SummaryTask4.web.command.impl;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import ua.nure.tarianyk.SummaryTask4.service.OrdersService;
import ua.nure.tarianyk.SummaryTask4.util.consts.RedirectConst;
import ua.nure.tarianyk.SummaryTask4.util.consts.SessionConst;
import ua.nure.tarianyk.SummaryTask4.web.command.Command;
import ua.nure.tarianyk.SummaryTask4.web.model.entity.OrdersBean;
import ua.nure.tarianyk.SummaryTask4.web.model.entity.UserBean;
import ua.nure.tarianyk.SummaryTask4.web.model.transfer.TaskTransfer;

/**
 * Used for controlling personal area.
 * 
 * @author Anton
 * @version 1.0
 *
 */
public class PersonalAreaCommandImpl implements Command {

	/**
	 * Logger.
	 */
	private final static Logger LOG = Logger.getLogger(PersonalAreaCommandImpl.class);

	/**
	 * Service for processing order actions.
	 */
	private OrdersService ordersService = null;

	public PersonalAreaCommandImpl(OrdersService ordersService) {
		this.ordersService = ordersService;
	}

	/*
	 * Execution method for command.
	 * 
	 * @see
	 * ua.nure.tarianyk.SummaryTask4.web.command.Command#execute(javax.servlet.
	 * http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		LOG.log(Level.DEBUG, "Command starts.");

		HttpSession session = request.getSession(false);
		UserBean userBean = (UserBean) session.getAttribute(SessionConst.USER);

		List<OrdersBean> ordersBeans = null;
		try {
			ordersBeans = ordersService.getOrders(userBean.getEmail(), userBean.getLanguage().getId());
			LOG.log(Level.TRACE, "Found in DB: list of orders ----> " + ordersBeans);
		} catch (SQLException | ParseException e) {
			LOG.log(Level.TRACE, "Problem has occured in execute method.", e);
		}

		session.setAttribute(SessionConst.ORDER, ordersBeans);
		LOG.log(Level.TRACE, "Set the request attribute " + SessionConst.ORDER + "---->" + ordersBeans);
		LOG.log(Level.DEBUG, "Command finished.");

		List<TaskTransfer> list_task = null;
		try {
			list_task = ordersService.getTask();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		session.setAttribute("task", list_task);

		System.out.println(list_task);
		return RedirectConst.PERSONAL_AREA;
	}

}
