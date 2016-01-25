package com.starboard.b2b.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandlerImpl;
import org.springframework.security.web.csrf.InvalidCsrfTokenException;
import org.springframework.security.web.csrf.MissingCsrfTokenException;

/**
 * Created by User: Thanakit Jumparuang (jthanakit.dev@gmail.com) Date:
 * 12/28/2015 11:44 PM
 */
public class CustomAccessDeniedHandler extends AccessDeniedHandlerImpl {
	private static final Logger log = LoggerFactory.getLogger(CustomAccessDeniedHandler.class);

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e) throws IOException, ServletException {
		log.warn(e.getMessage());

		String errorPage = "";
		if (e instanceof MissingCsrfTokenException || e instanceof InvalidCsrfTokenException) {
			errorPage = "/error-page/csrf.jsp";
		} else {
			errorPage = "/error-page/403.jsp";
		}

		request.getRequestDispatcher(errorPage).forward(request, response);
	}
	
}
