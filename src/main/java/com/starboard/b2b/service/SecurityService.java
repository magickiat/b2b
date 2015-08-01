package com.starboard.b2b.service;

import org.springframework.transaction.annotation.Transactional;

public interface SecurityService {

	void addRole(String roleId);

}