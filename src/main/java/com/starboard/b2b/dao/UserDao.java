package com.starboard.b2b.dao;

import java.util.List;

import com.starboard.b2b.model.User;

public interface UserDao {
	User findByUsername(String username);
	List<User> list();
}
