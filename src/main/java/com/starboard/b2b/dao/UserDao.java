package com.starboard.b2b.dao;

import java.util.List;

import com.starboard.b2b.common.Pagination;
import com.starboard.b2b.model.User;

public interface UserDao extends BaseDao {
	User findById(Integer id);
	
	List<User> findByCustId(Long id);

	User findByUsername(String username);

	List<User> list();
	
	List<User> list(Pagination page);
	
	void add(User user);
	
	void update(User user);
	
	void delete(User user);
}
