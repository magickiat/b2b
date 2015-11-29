package com.starboard.b2b.dto;

import java.util.Date;

public class OrdAddressDTO {
	private long orderAddressId;
	private long orderId;
	private String orderFname;
	private String orderLname;
	private String orderAddr;
	private String subdistrict;
	private String district;
	private String orderCountryId;
	private String orderProvince;
	private String orderZipcode;
	private String orderTel;
	private String orderMobile;
	private String fax;
	private String email;
	private String description;
	private Long type;
	private String userCreate;
	private String userUpdate;
	private Date timeCreate;
	private Date timeUpdate;
	
	public OrdAddressDTO() {
	}
	
	public long getOrderAddressId() {
		return orderAddressId;
	}
	public void setOrderAddressId(long orderAddressId) {
		this.orderAddressId = orderAddressId;
	}
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public String getOrderFname() {
		return orderFname;
	}
	public void setOrderFname(String orderFname) {
		this.orderFname = orderFname;
	}
	public String getOrderLname() {
		return orderLname;
	}
	public void setOrderLname(String orderLname) {
		this.orderLname = orderLname;
	}
	public String getOrderAddr() {
		return orderAddr;
	}
	public void setOrderAddr(String orderAddr) {
		this.orderAddr = orderAddr;
	}
	public String getSubdistrict() {
		return subdistrict;
	}
	public void setSubdistrict(String subdistrict) {
		this.subdistrict = subdistrict;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getOrderCountryId() {
		return orderCountryId;
	}
	public void setOrderCountryId(String orderCountryId) {
		this.orderCountryId = orderCountryId;
	}
	public String getOrderProvince() {
		return orderProvince;
	}
	public void setOrderProvince(String orderProvince) {
		this.orderProvince = orderProvince;
	}
	public String getOrderZipcode() {
		return orderZipcode;
	}
	public void setOrderZipcode(String orderZipcode) {
		this.orderZipcode = orderZipcode;
	}
	public String getOrderTel() {
		return orderTel;
	}
	public void setOrderTel(String orderTel) {
		this.orderTel = orderTel;
	}
	public String getOrderMobile() {
		return orderMobile;
	}
	public void setOrderMobile(String orderMobile) {
		this.orderMobile = orderMobile;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getType() {
		return type;
	}
	public void setType(Long type) {
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

	@Override
	public String toString() {
		return "OrdAddressDTO{" +
				"orderAddressId=" + orderAddressId +
				", orderId=" + orderId +
				", orderFname='" + orderFname + '\'' +
				", orderLname='" + orderLname + '\'' +
				", orderAddr='" + orderAddr + '\'' +
				", subdistrict='" + subdistrict + '\'' +
				", district='" + district + '\'' +
				", orderCountryId='" + orderCountryId + '\'' +
				", orderProvince='" + orderProvince + '\'' +
				", orderZipcode='" + orderZipcode + '\'' +
				", orderTel='" + orderTel + '\'' +
				", orderMobile='" + orderMobile + '\'' +
				", fax='" + fax + '\'' +
				", email='" + email + '\'' +
				", description='" + description + '\'' +
				", type=" + type +
				", userCreate='" + userCreate + '\'' +
				", userUpdate='" + userUpdate + '\'' +
				", timeCreate=" + timeCreate +
				", timeUpdate=" + timeUpdate +
				'}';
	}
}
