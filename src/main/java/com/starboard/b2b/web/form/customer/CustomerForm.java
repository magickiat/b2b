package com.starboard.b2b.web.form.customer;

import java.util.Set;
import java.util.TreeSet;

import com.starboard.b2b.web.form.address.AddressForm;
import com.starboard.b2b.web.form.brand.BrandForm;
import com.starboard.b2b.web.form.contact.ContactForm;
import com.starboard.b2b.web.form.country.CountryForm;
import com.starboard.b2b.web.form.user.UserRegisterForm;

public class CustomerForm {
	private int id;
	private String name;
	private String code;
	private CountryForm country;
	private Set<UserRegisterForm> user = new TreeSet<>();
	private Set<BrandForm> brand = new TreeSet<>();
	private Set<AddressForm> addresses = new TreeSet<>();
	private Set<ContactForm> contacts = new TreeSet<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public CountryForm getCountry() {
		return country;
	}

	public void setCountry(CountryForm country) {
		this.country = country;
	}

	public Set<UserRegisterForm> getUser() {
		return user;
	}

	public void setUser(Set<UserRegisterForm> user) {
		this.user = user;
	}

	public Set<BrandForm> getBrand() {
		return brand;
	}

	public void setBrand(Set<BrandForm> brand) {
		this.brand = brand;
	}

	public Set<ContactForm> getContacts() {
		return contacts;
	}

	public void setContacts(Set<ContactForm> contacts) {
		this.contacts = contacts;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Set<AddressForm> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<AddressForm> addresses) {
		this.addresses = addresses;
	}

}
