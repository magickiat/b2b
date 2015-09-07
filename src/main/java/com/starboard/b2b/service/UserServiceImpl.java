package com.starboard.b2b.service;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.starboard.b2b.common.Page;
import com.starboard.b2b.dao.UserDao;
import com.starboard.b2b.model.Customer;
import com.starboard.b2b.model.Role;
import com.starboard.b2b.model.User;
import com.starboard.b2b.web.form.user.UserRegisterForm;

@Service
public class UserServiceImpl implements UserService {

	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserDao userDao;

//	@Autowired
//	private RoleDao roleDao;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Transactional(readOnly = true)
	public User findUserById(String id) {
		return userDao.findById(id);
	}

	@Transactional(readOnly = true)
	public List<User> findUserByCusId(int cusId) {
		User user = new User();
		Customer cus = new Customer();
		cus.setId(cusId);
		user.setCustomer(cus);
		return userDao.findByCusId(user);
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
				user.setPassword(encoder.encode(form.getPassword()));
				user.setEnabled(true);
				user.setAccountNonExpired(true);
				user.setAccountNonLocked(true);
				user.setCredentialsNonExpired(true);
				user.setCreatedDate(new Date());

				Set<Role> roles = new HashSet<>();
				for (String id : form.getRoles()) {
					roles.add(new Role(id));
				}
				user.setRole(roles);

				if(form.getCusId()!=null){
					Customer customer = new Customer();
					customer.setId(Integer.valueOf(form.getCusId()));
					user.setCustomer(customer);
				}
				userDao.add(user);
			} catch (IllegalAccessException | InvocationTargetException e) {
				log.error("Couldn't copy property to bean", e);
			}

		}
	}

	@Override
	@Transactional
	public List<User> list(Page page) {
		return userDao.list(page);
	}

}
