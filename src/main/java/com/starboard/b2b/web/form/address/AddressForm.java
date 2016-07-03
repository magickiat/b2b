package com.starboard.b2b.web.form.address;

import org.hibernate.validator.constraints.NotEmpty;


public class AddressForm {
	private long addrId;
	private Long custId;
	@NotEmpty(message = "Address is required")
	private String address;
	private String regionCountryId;
	@NotEmpty(message = "Telephone is required")
	private String tel1;
	@NotEmpty(message = "PostCode is required")
	private String postCode;
	@NotEmpty(message = "Fax is required")
	private String fax;
	@NotEmpty(message = "Email is required")
	private String email;
	private String type;
	public long getAddrId() {
		return addrId;
	}
	public void setAddrId(long addrId) {
		this.addrId = addrId;
	}
	public Long getCustId() {
		return custId;
	}
	public void setCustId(Long custId) {
		this.custId = custId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRegionCountryId() {
		return regionCountryId;
	}
	public void setRegionCountryId(String regionCountryId) {
		this.regionCountryId = regionCountryId;
	}
	public String getTel1() {
		return tel1;
	}
	public void setTel1(String tel1) {
		this.tel1 = tel1;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
}
