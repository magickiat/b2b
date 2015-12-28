package com.starboard.b2b.security;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.csrf.MissingCsrfTokenException;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by User: Thanakit Jumparuang (jthanakit.dev@gmail.com) Date: 12/28/2015 11:44 PM
 */
public class CustomAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
        if(e instanceof MissingCsrfTokenException){
             httpServletResponse.sendRedirect("/login");
        }else{
            httpServletResponse.sendRedirect("/error");
        }
    }
}
