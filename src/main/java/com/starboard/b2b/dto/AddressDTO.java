package com.starboard.b2b.dto;

import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;

public class AddressDTO {
	private long addrId;
	private long custId;
	private String custCode;
	private Long contactId;
	private String address;
	private Long subDistrict;
	private Long district;
	private Long province;
	private String regionCountryId;
	private String postCode;
	private String tel1;
	private String tel2;
	private String fax;
	private String email;
	private Long transType;
	private String transTel;
	private String type;
	private String userCreate;
	private String userUpdate;
	private Date timeCreate;
	private Date timeUpdate;

	public AddressDTO() {
	}

	public AddressDTO(long addrId, long custId, String custCode, Long contactId, String address, Long subDistrict,
			Long district, Long province, String regionCountryId, String postCode, String tel1, String tel2, String fax,
			String email, Long transType, String transTel, String type, String userCreate, String userUpdate,
			Date timeCreate, Date timeUpdate) {
		this.addrId = addrId;
		this.custId = custId;
		this.custCode = custCode;
		this.contactId = contactId;
		this.address = address;
		this.subDistrict = subDistrict;
		this.district = district;
		this.province = province;
		this.regionCountryId = regionCountryId;
		this.postCode = postCode;
		this.tel1 = tel1;
		this.tel2 = tel2;
		this.fax = fax;
		this.email = email;
		this.transType = transType;
		this.transTel = transTel;
		this.type = type;
		this.userCreate = userCreate;
		this.userUpdate = userUpdate;
		this.timeCreate = timeCreate;
		this.timeUpdate = timeUpdate;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
	public long getAddrId() {
		return addrId;
	}

	public void setAddrId(long addrId) {
		this.addrId = addrId;
	}

	public long getCustId() {
		return custId;
	}

	public void setCustId(long custId) {
		this.custId = custId;
	}

	public String getCustCode() {
		return custCode;
	}

	public void setCustCode(String custCode) {
		this.custCode = custCode;
	}

	public Long getContactId() {
		return contactId;
	}

	public void setContactId(Long contactId) {
		this.contactId = contactId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getSubDistrict() {
		return subDistrict;
	}

	public void setSubDistrict(Long subDistrict) {
		this.subDistrict = subDistrict;
	}

	public Long getDistrict() {
		return district;
	}

	public void setDistrict(Long district) {
		this.district = district;
	}

	public Long getProvince() {
		return province;
	}

	public void setProvince(Long province) {
		this.province = province;
	}

	public String getRegionCountryId() {
		return regionCountryId;
	}

	public void setRegionCountryId(String regionCountryId) {
		this.regionCountryId = regionCountryId;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getTel1() {
		return tel1;
	}

	public void setTel1(String tel1) {
		this.tel1 = tel1;
	}

	public String getTel2() {
		return tel2;
	}

	public void setTel2(String tel2) {
		this.tel2 = tel2;
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

	public Long getTransType() {
		return transType;
	}

	public void setTransType(Long transType) {
		this.transType = transType;
	}

	public String getTransTel() {
		return transTel;
	}

	public void setTransTel(String transTel) {
		this.transTel = transTel;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUserCreate() {
		return userCreate;
	}

	public void setUserCreate(String userCreate) {
		this.userCreate = userCreate;
	}

	public String getUserUpdate() {
		return userUpdate;
	}

	public void setUserUpdate(String userUpdate) {
		this.userUpdate = userUpdate;
	}

	public Date getTimeCreate() {
		return timeCreate;
	}

	public void setTimeCreate(Date timeCreate) {
		this.timeCreate = timeCreate;
	}

	public Date getTimeUpdate() {
		return timeUpdate;
	}

	public void setTimeUpdate(Date timeUpdate) {
		this.timeUpdate = timeUpdate;
	}
}
