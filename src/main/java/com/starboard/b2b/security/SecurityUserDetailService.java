package com.starboard.b2b.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.starboard.b2b.dao.UserDao;
import com.starboard.b2b.model.User;
import com.starboard.b2b.util.DateTimeUtil;

@Component("userDetailsService")
public class SecurityUserDetailService implements UserDetailsService {

	private static final Logger log = LoggerFactory.getLogger(SecurityUserDetailService.class);

	@Autowired
	private UserDao userDao;

	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.info("loadUserByUsername: " + username);
		User user = userDao.login(username);
		if (user == null) {
			log.info("Not found user: " + username);
			throw new UsernameNotFoundException(username);
		}
		
		if(!user.isEnabled()){
			 throw new DisabledException("This account has inactive");
		}
		
		user.setLastActive(DateTimeUtil.getCurrentDate());
		return user;
	}

}
