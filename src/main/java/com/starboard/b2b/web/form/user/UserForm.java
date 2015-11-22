package com.starboard.b2b.web.form.user;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.starboard.b2b.model.Addr;

public class UserForm {
	private String id;
	private String username;
	private String password;
	private String confirmPassword;
	private String email;
	private String address;
	private String country;
	private String postCode;
	private String emailOfAddr;
	private String telephone;
	private String fax;
	private String addressType;
	private List<Addr> addresses = new ArrayList<>();

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getEmailOfAddr() {
		return emailOfAddr;
	}

	public void setEmailOfAddr(String emailOfAddr) {
		this.emailOfAddr = emailOfAddr;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getAddressType() {
		return addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	public List<Addr> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Addr> addresses) {
		this.addresses = addresses;
	}

}
