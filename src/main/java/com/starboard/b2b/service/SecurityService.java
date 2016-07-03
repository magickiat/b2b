package com.starboard.b2b.service;

import java.util.List;

public interface SecurityService {

	void addRole(String roleId);
	List<String> listRole();

}