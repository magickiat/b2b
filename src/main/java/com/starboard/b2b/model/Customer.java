package com.starboard.b2b.model;

import java.util.Set;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer extends BaseModel {
	@Column(length = 255, nullable = false)
	private String name;

	@Column(length = 20, nullable = false)
	private String code;

	@Column(length = 100, nullable = false)
	private String country;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<User> users = new TreeSet<>();

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Brand> brands = new TreeSet<>();

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Address> addresses = new TreeSet<>();

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Contact> contacts = new TreeSet<>();

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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Set<Brand> getBrands() {
		return brands;
	}

	public void setBrands(Set<Brand> brands) {
		this.brands = brands;
	}

	public Set<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}

	public Set<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(Set<Contact> contacts) {
		this.contacts = contacts;
	}

}
