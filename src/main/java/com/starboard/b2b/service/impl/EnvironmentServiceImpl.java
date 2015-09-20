package com.starboard.b2b.service.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.starboard.b2b.dao.UserDao;
import com.starboard.b2b.service.EnvironmentService;

@Service
public class EnvironmentServiceImpl implements EnvironmentService {

	private static final Logger log = LoggerFactory.getLogger(EnvironmentServiceImpl.class);
	
	private Environment env;
	private UserDao userDao;

	@Transactional(readOnly = true)
	public Map<String, Object> getEnvironment() {
		HashMap<String, Object> data = new HashMap<>();
		data.put("spring.profiles.active", Arrays.asList(env.getActiveProfiles()));
		data.put("users", userDao.list());
		return data;
	}

	@Autowired
	public void setEnv(Environment env) {
		this.env = env;
	}

	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
