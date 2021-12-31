package com.filters;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.controllers.servlet.LoginController;

/**
 * This Java filter demonstrates how to intercept the request and transform the
 * response to implement authentication feature. for the website's back-end.
 *
 * 
 */
@WebFilter("/app/*")
public class LoginFilter implements Filter {
	static {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy");
		System.setProperty("current.date.time", dateFormat.format(new Date()));

	}
	final static Logger logger = Logger.getLogger(LoginFilter.class);

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		// ////////////System.out.println("Entered the filter");
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession(false);
		// ////////////System.out.println(httpRequest.getContextPath());
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		if ((session != null && session.getAttribute("username") != null)
				|| httpRequest.getRequestURI().equals("/Login")) {
			// continues the filter chain
			// allows the request to reach the destination

			// ////////////System.out.println("Inside the session ");
			httpResponse.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
			httpResponse.addHeader("Cache-Control", "post-check=0, pre-check=0");
			httpResponse.setHeader("Pragma", "no-cache");
			httpResponse.setDateHeader("Expires", 0);

			logger.info("username- " + session.getAttribute("username"));
			/*
			 * ////////////System.out.println(httpRequest.getScheme() + "://" + // "http" + "://
			 * httpRequest.getServerName() + // "myhost" ":" + // ":"
			 * httpRequest.getServerPort() + // "8080" httpRequest.getRequestURI() + //
			 * "/people" "?" + // "?" httpRequest.getQueryString());
			 */
			chain.doFilter(request, response);

		} else {
			// the admin is not logged in, so authentication is required
			// forwards to the Login page

			// ////////////System.out.println("Inside the other session ");
//			RequestDispatcher dispatcher = request.getRequestDispatcher("/Login");
			httpResponse.sendRedirect("/WeatherApi/Login.jsp");

//			dispatcher.forward(request, response);

		}

	}

	public void destroy() {
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
