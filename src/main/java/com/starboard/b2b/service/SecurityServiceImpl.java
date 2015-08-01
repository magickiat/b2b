package com.starboard.b2b.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.starboard.b2b.dao.RoleDao;
import com.starboard.b2b.model.Role;

@Service
public class SecurityServiceImpl implements SecurityService {
	@Autowired
	private RoleDao roleDAO;

	@Override
	@Transactional
	public void addRole(String roleId) {
		roleDAO.addRole(new Role(roleId));
	}
}
