package com.starboard.b2b.web.form.user;

import java.util.ArrayList;
import java.util.List;

public class UserForm {
	private String id;
	private String username;
	private String password;
	private String confirmPassword;
	private String email;
	private List<AddressForm> addresses = new ArrayList<AddressForm>();

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

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<AddressForm> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<AddressForm> addresses) {
		this.addresses = addresses;
	}

}
