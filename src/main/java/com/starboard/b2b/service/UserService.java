package com.starboard.b2b.service;

import java.util.List;

import com.starboard.b2b.common.Page;
import com.starboard.b2b.model.User;
import com.starboard.b2b.web.form.user.UserRegisterForm;

public interface UserService {

	List<User> list(Page page);

	User findUserById(String id);

	User findByUsername(String username);

	void add(UserRegisterForm user);
}