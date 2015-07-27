package com.starboard.b2b.service;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.starboard.b2b.dao.UserDao;
import com.starboard.b2b.model.User;
import com.starboard.b2b.web.form.user.UserRegisterForm;

@Service
public class UserServiceImpl implements UserService {

	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

	private UserDao userDao;

	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Transactional(readOnly = true)
	public User findUserById(String id) {
		return userDao.findById(id);
	}

	@Transactional(readOnly = true)
	public User findByUsername(String username) {
		return userDao.findByUsername(username);
	}

	@Transactional
	public void add(UserRegisterForm form) {
		if (findByUsername(form.getUsername()) == null) {
			User user = new User();
			try {
				BeanUtils.copyProperties(user, form);
				userDao.add(user);
			} catch (IllegalAccessException | InvocationTargetException e) {
				log.error("Couldn't copy property to bean", e);
			}

		}
	}

}
