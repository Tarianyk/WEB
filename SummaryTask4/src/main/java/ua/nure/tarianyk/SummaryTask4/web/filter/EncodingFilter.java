package ua.nure.tarianyk.SummaryTask4.web.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Level;

import ua.nure.tarianyk.SummaryTask4.database.DAO.UsersDAO;
import ua.nure.tarianyk.SummaryTask4.database.DAO.impl.UsersDAOimpl;
import ua.nure.tarianyk.SummaryTask4.support.CookieCustom;
import ua.nure.tarianyk.SummaryTask4.util.consts.EncodingConst;
import ua.nure.tarianyk.SummaryTask4.util.consts.SessionConst;
import ua.nure.tarianyk.SummaryTask4.web.model.entity.UserBean;

public class EncodingFilter implements Filter {

	private String encoding = EncodingConst.ENCODING_UTF8;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		String encodingParam = filterConfig.getInitParameter("encoding");
		if (encodingParam != null) {
			encoding = encodingParam;
		}
	}

	public void destroy() {
		// nothing todo
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		EncodingWrapper encodingWrapper = new EncodingWrapper(request);
		encodingWrapper.filter();
		
		filterChain.doFilter(request, response);
	}

	private class EncodingWrapper {

		//////////////
		// Http data//
		/////////////
		private ServletRequest request = null;

		public EncodingWrapper(ServletRequest request) {
			this.request = request;
		}

		/**
		 * Do filter.
		 * 
		 * @return if data valide return <tt>true</tt>
		 * @throws UnsupportedEncodingException
		 * @throws SQLException
		 */
		public void filter() throws UnsupportedEncodingException {
			request.setCharacterEncoding(encoding);
		}
	}
}
