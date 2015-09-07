package com.starboard.b2b.dao;

import java.util.List;

import com.starboard.b2b.common.Page;
import com.starboard.b2b.model.User;

public interface UserDao {
	User findById(String id);
	
	List<User> findByCusId(User user);

	User findByUsername(String username);

	List<User> list();
	
	List<User> list(Page page);
	
	void add(User user);
	
	void update(User user);
}
