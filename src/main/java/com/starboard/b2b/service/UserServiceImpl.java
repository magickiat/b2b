package com.starboard.b2b.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.starboard.b2b.common.Page;
import com.starboard.b2b.dao.UserDao;
import com.starboard.b2b.model.Customer;
import com.starboard.b2b.model.Role;
import com.starboard.b2b.model.User;
import com.starboard.b2b.security.MD5;
import com.starboard.b2b.util.DateTimeUtil;
import com.starboard.b2b.util.UserUtil;
import com.starboard.b2b.web.form.user.UserForm;
import com.starboard.b2b.web.form.user.UserRegisterForm;

@Service
public class UserServiceImpl implements UserService {

	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserDao userDao;

	@Autowired
	private PasswordEncoder encoder;

	@Transactional(readOnly = true)
	public User findUserById(String id) {
		return userDao.findById(id);
	}

	@Transactional(readOnly = true)
	public List<User> findUserByCustId(Integer custId) {
		return userDao.findByCustId(custId);
	}

	@Transactional(readOnly = true)
	public User findByUsername(String username) {
		return userDao.findByUsername(username);
	}

	@Transactional
	public void add(UserRegisterForm form) {
		User user = new User();
		user.setName(form.getName());
		user.setUsername(form.getUsername());
		user.setPassword(encoder.encode(form.getPassword()));
		user.setEnabled(true);
		user.setAccountNonExpired(true);
		user.setAccountNonLocked(true);
		user.setCredentialsNonExpired(true);
		user.setCreatedBy(UserUtil.getCurrentUsername());
		user.setCreatedDate(DateTimeUtil.getCurrentDate());

		Set<Role> roles = new HashSet<>();
		for (String id : form.getRoles()) {
			roles.add(new Role(id));
		}
		user.setRole(roles);

		if (form.getCusId() != null) {
			Customer customer = new Customer();
			customer.setId(Integer.valueOf(form.getCusId()));
			user.setCustomer(customer);
		}
		userDao.add(user);
	}

	@Override
	@Transactional
	public List<User> list(Page page) {
		return userDao.list(page);
	}

	@Override
	@Transactional
	public void update(UserForm userForm) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		user.setPassword(new MD5().encode(userForm.getPassword()));
		user.setEmail(userForm.getEmail());
		userDao.update(user);
	}

	@Override
	@Transactional(readOnly = true)
	public boolean isExistUsername(String username) {
		return userDao.exist("username", username);
	}

}
