package com.starboard.b2b.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.starboard.b2b.model.User;

public class UserUtil {

    private static final Logger log = LoggerFactory.getLogger(UserUtil.class);

    public static User getCurrentUser() {
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    public static String getCurrentUsername() {
        Authentication user = SecurityContextHolder.getContext().getAuthentication();
        if (user instanceof AnonymousAuthenticationToken) {
            return "";
        } else {
            return ((User) user.getPrincipal()).getUsername();
        }
    }

}
