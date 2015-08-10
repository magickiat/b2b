package com.starboard.b2b.dao;

import java.util.List;

import com.starboard.b2b.model.Role;

public interface RoleDao {

	void addRole(Role role);
	
	Role getRole(String id);
	
	List<Role> list();

}