package com.starboard.b2b.web.controller.frontend;

import org.apache.bval.constraints.NotEmpty;
import org.apache.commons.lang.builder.ToStringBuilder;

public class LoginForm {
	@NotEmpty
	private String username;
	@NotEmpty
	private String password;
	private boolean rememberMe;

	public LoginForm() {
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isRememberMe() {
		return rememberMe;
	}

	public void setRememberMe(boolean rememberMe) {
		this.rememberMe = rememberMe;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
