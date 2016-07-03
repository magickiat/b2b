package com.starboard.b2b.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Service;

/**
 * Created by User: Thanakit Jumparuang (jthanakit.dev@gmail.com) Date: 12/29/2015 12:10 AM
 */
@Service
public class AuthenSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    private static final Logger LOG = LoggerFactory.getLogger(AuthenSuccessHandler.class);

    private int sessionTimeout;

    public AuthenSuccessHandler() {
    }

    public AuthenSuccessHandler(int sessionTimeout){
        this.sessionTimeout = sessionTimeout;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        super.onAuthenticationSuccess(request, response, authentication);
        LOG.info("=== Starting session for "+sessionTimeout+" minutes..");
        request.getSession().setMaxInactiveInterval(sessionTimeout * 60);
        super.onAuthenticationSuccess(request, response, authentication);
    }
}
