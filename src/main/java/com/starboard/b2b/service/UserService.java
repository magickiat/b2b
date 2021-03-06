package com.starboard.b2b.service;

import java.util.List;

import com.starboard.b2b.common.Page;
import com.starboard.b2b.common.Pagination;
import com.starboard.b2b.dto.UserDTO;
import com.starboard.b2b.model.User;
import com.starboard.b2b.web.form.user.UserForm;
import com.starboard.b2b.web.form.user.UserRegisterForm;
import com.starboard.b2b.web.form.user.UserSearchForm;

public interface UserService {

	List<User> list(Pagination page);

	User findUserById(Integer id);
	
	List<User> findUserByCustId(Long cusId);
	
	User findByUsername(String username);

	void add(UserRegisterForm user);
	
	boolean update(UserForm userForm);

	boolean isExistUsername(String username);

	Page<UserDTO> search(UserSearchForm userSearchForm);
	
	boolean delete(UserForm userForm);
}