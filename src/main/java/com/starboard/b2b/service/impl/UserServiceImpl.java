package com.starboard.b2b.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.starboard.b2b.common.Page;
import com.starboard.b2b.common.Pagination;
import com.starboard.b2b.dao.CustDao;
import com.starboard.b2b.dao.UserDao;
import com.starboard.b2b.dto.UserDTO;
import com.starboard.b2b.dto.search.SearchRequest;
import com.starboard.b2b.dto.search.SearchResult;
import com.starboard.b2b.model.Cust;
import com.starboard.b2b.model.Role;
import com.starboard.b2b.model.User;
import com.starboard.b2b.security.MD5;
import com.starboard.b2b.service.UserService;
import com.starboard.b2b.util.ApplicationConfig;
import com.starboard.b2b.util.DateTimeUtil;
import com.starboard.b2b.util.UserUtil;
import com.starboard.b2b.web.form.user.UserForm;
import com.starboard.b2b.web.form.user.UserRegisterForm;
import com.starboard.b2b.web.form.user.UserSearchForm;

@Service("userService")
public class UserServiceImpl implements UserService {

	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private ApplicationConfig applicationConfig;

	@Autowired
	private UserDao userDao;

	@Autowired
	private CustDao custDao;

	@Autowired
	private PasswordEncoder encoder;

	@Transactional(readOnly = true)
	public User findUserById(Integer id) {
		return userDao.findById(id);
	}

	@Transactional(readOnly = true)
	public List<User> findUserByCustId(Long custId) {
		return userDao.findByCustId(custId);
	}

	@Transactional(readOnly = true)
	public User findByUsername(String username) {
		return userDao.findByUsername(username);
	}

	@Transactional(rollbackFor = Exception.class)
	public void add(UserRegisterForm form) {
		User user = new User();
		user.setName(form.getName());
		user.setUsername(form.getUsername());
		user.setPassword(encoder.encode(form.getPassword()));
		user.setEmail(form.getEmail());
		user.setEnabled(true);
		user.setAccountNonExpired(true);
		user.setAccountNonLocked(true);
		user.setCredentialsNonExpired(true);
		user.setUserCreate(UserUtil.getCurrentUsername());
		user.setTimeCreate(DateTimeUtil.getCurrentDate());

		Set<Role> roles = new HashSet<>();
		for (String id : form.getRoles()) {
			roles.add(new Role(id));
		}
		user.setRole(roles);

		if (form.getCusId() != null) {
			Cust customer = custDao.findById(form.getCusId());
			log.info("customer id = " + form.getCusId());
			user.setCustomer(customer);
		}
		userDao.add(user);
	}

	@Override
	@Transactional(readOnly = true)
	public List<User> list(Pagination page) {
		return userDao.list(page);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean update(UserForm userForm) {

		User user = userDao.findById(Integer.parseInt(userForm.getId()));
		user.setName(userForm.getName());
		user.setUsername(userForm.getUsername());
		user.setEmail(userForm.getEmail());
		user.setEnabled(userForm.isEnable());
		if (StringUtils.isNotEmpty(userForm.getPassword())) {
			user.setPassword(new MD5().encode(userForm.getPassword()));
		}

		return true;
	}

	@Override
	@Transactional(readOnly = true)
	public boolean isExistUsername(String username) {
		return userDao.exist("username", username);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<UserDTO> search(UserSearchForm form) {
		SearchRequest<UserSearchForm> req = new SearchRequest<>(form.getPage(), applicationConfig.getPageSize());
		req.setCondition(form);
		SearchResult<UserDTO> result = userDao.search(req);

		// ----- prepare result page -----
		Page<UserDTO> page = new Page<>();
		page.setCurrent(req.getPage());
		page.setResult(result.getResult());
		page.setPageSize(req.getPageSize());
		page.setTotal(result.getTotal());
		
		log.info("total = " + result.getTotal() + "\tPage size: " + req.getPageSize());

		return page;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean delete(UserForm userForm) {
		boolean isSuccess = false;
		User user = userDao.findById(Integer.parseInt(userForm.getId()));
		try {
			userDao.delete(user);
			isSuccess = true;
		} catch (Exception e) {
			isSuccess = false;
		}
		return isSuccess;
	}

}
