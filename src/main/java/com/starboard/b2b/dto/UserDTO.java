
package com.starboard.b2b.dto;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.beans.BeanUtils;

import com.starboard.b2b.model.Role;
import com.starboard.b2b.model.User;

public class UserDTO extends BaseDTO {
	private String name;
	private String username;
	private String password;
	private String email;
	private boolean enabled;
	private boolean accountNonExpired;
	private boolean accountNonLocked;
	private boolean credentialsNonExpired;
	private CustDTO customer;
	private Set<RoleDTO> role = new HashSet<>();

	public UserDTO() {
	}

	public UserDTO(User user) {
		super(user);
		this.name = user.getName();
		this.username = user.getUsername();
		this.password = user.getPassword();
		this.email = user.getEmail();
		this.enabled = user.isEnabled();
		this.accountNonExpired = user.isAccountNonExpired();
		this.accountNonLocked = user.isAccountNonLocked();
		this.customer = new CustDTO();
		BeanUtils.copyProperties(user.getCustomer(), this.customer);

		TreeSet<RoleDTO> roleList = new TreeSet<>();
		Iterator<Role> iterator = user.getRole().iterator();
		while (iterator.hasNext()) {
			Role role = (Role) iterator.next();
			roleList.add(new RoleDTO(role));
		}
		this.role = roleList;

	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<RoleDTO> getRole() {
		return role;
	}

	public void setRole(Set<RoleDTO> role) {
		this.role = role;
	}

	public CustDTO getCustomer() {
		return customer;
	}

	public void setCustomer(CustDTO customer) {
		this.customer = customer;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

}
