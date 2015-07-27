package com.starboard.b2b.service;

import com.starboard.b2b.model.User;
import com.starboard.b2b.web.form.user.UserRegisterForm;

public interface UserService {
	User findUserById(String id);

	User findByUsername(String username);
	
	void add(UserRegisterForm user);
}