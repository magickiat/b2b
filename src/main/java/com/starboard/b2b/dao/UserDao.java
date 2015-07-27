package com.starboard.b2b.dao;

import java.util.List;

import com.starboard.b2b.model.User;

public interface UserDao {
	User findById(String id);

	User findByUsername(String username);

	List<User> list();
	
	void add(User user);
}
