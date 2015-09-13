
package com.starboard.b2b.dto;

import com.starboard.b2b.model.Role;

public class RoleDTO {
	private String roleId;

	public RoleDTO() {
	}

	public RoleDTO(Role role) {
		this.roleId = role.getRoleId();
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
}
