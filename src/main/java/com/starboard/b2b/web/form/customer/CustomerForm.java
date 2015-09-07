package com.starboard.b2b.web.form.customer;

import java.util.Set;
import java.util.TreeSet;

import com.starboard.b2b.model.Address;
import com.starboard.b2b.web.form.brand.BrandForm;
import com.starboard.b2b.web.form.contact.ContactForm;
import com.starboard.b2b.web.form.country.CountryForm;
import com.starboard.b2b.web.form.user.UserRegisterForm;

public class CustomerForm {
	//TODO register customer form
	//private List<KeyValueBean> countries = new ArrayList<>();
	private int id;
	private String name;
	private String code;
	private CountryForm country;
	private Set<UserRegisterForm> user = new TreeSet<>();
	private Set<BrandForm> brand = new TreeSet<>();
	private Set<Address> addresses = new TreeSet<>();
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
	public Set<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
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
	
}
