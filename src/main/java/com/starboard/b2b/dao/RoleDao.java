package com.starboard.b2b.dao;

import com.starboard.b2b.model.Role;

public interface RoleDao {

	void addRole(Role role);
	
	Role getRole(String id);

}