package com.starboard.b2b.dto;

import java.util.Set;
import java.util.TreeSet;

import com.starboard.b2b.model.Customer;

public class CustomerDTO extends BaseDTO {
	private Long custId;
	private String name;
	private String code;
	private Set<BrandDTO> brands = new TreeSet<>();
	private Set<AddressDTO> addresses = new TreeSet<>();
	private Set<ContactDTO> contacts = new TreeSet<>();

	public CustomerDTO() {
	}

	public CustomerDTO(Customer cust) {
		super(cust);
		this.custId = cust.getCustId();
		this.name = cust.getName();
		this.code = cust.getCode();
	}

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

	public Set<BrandDTO> getBrands() {
		return brands;
	}

	public void setBrands(Set<BrandDTO> brands) {
		this.brands = brands;
	}

	public Set<AddressDTO> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<AddressDTO> addresses) {
		this.addresses = addresses;
	}

	public Set<ContactDTO> getContacts() {
		return contacts;
	}

	public void setContacts(Set<ContactDTO> contacts) {
		this.contacts = contacts;
	}

	public Long getCustId() {
		return custId;
	}

	public void setCustId(Long custId) {
		this.custId = custId;
	}

}
