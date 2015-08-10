package com.starboard.b2b.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.starboard.b2b.dao.RoleDao;
import com.starboard.b2b.model.Role;

@Service
public class SecurityServiceImpl implements SecurityService {
	@Autowired
	private RoleDao roleDao;

	@Override
	@Transactional
	public void addRole(String roleId) {
		roleDao.addRole(new Role(roleId));
	}

	@Override
	@Transactional(readOnly = true)
	public List<String> listRole() {
		List<Role> list = roleDao.list();
		
		ArrayList<String> roles = new ArrayList<>(list.size());
		for (Role role : list) {
			roles.add(role.getRoleId());
		}

		return roles;
	}
}
