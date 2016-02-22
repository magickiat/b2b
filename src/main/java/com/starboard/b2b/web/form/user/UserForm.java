package com.starboard.b2b.web.form.user;

import java.util.ArrayList;
import java.util.List;
import com.starboard.b2b.web.form.address.AddressForm;

public class UserForm {
	private String id;
	private String username;
	private String password;
	private String confirmPassword;
	private String email;
	private long custId;
	private String name;
	private boolean enable;

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

	public long getCustId() {
		return custId;
	}

	public void setCustId(long custId) {
		this.custId = custId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}
}
