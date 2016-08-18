package com.starboard.b2b.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tmp_ord_address")
public class TmpOrdAddress {

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

	public TmpOrdAddress() {
	}

	public TmpOrdAddress(long orderAddressId, long orderId, String orderFname, String orderLname, String orderAddr, String subdistrict,
			String district, String orderCountryId, String orderProvince, String orderZipcode, String orderTel, String orderMobile, String fax,
			String email, String description, Long type, String userCreate, String userUpdate, Date timeCreate, Date timeUpdate) {
		this.orderAddressId = orderAddressId;
		this.orderId = orderId;
		this.orderFname = orderFname;
		this.orderLname = orderLname;
		this.orderAddr = orderAddr;
		this.subdistrict = subdistrict;
		this.district = district;
		this.orderCountryId = orderCountryId;
		this.orderProvince = orderProvince;
		this.orderZipcode = orderZipcode;
		this.orderTel = orderTel;
		this.orderMobile = orderMobile;
		this.fax = fax;
		this.email = email;
		this.description = description;
		this.type = type;
		this.userCreate = userCreate;
		this.userUpdate = userUpdate;
		this.timeCreate = timeCreate;
		this.timeUpdate = timeUpdate;
	}

	@Column(name = "order_fname", length = 100)
	public String getOrderFname() {
		return this.orderFname;
	}

	public void setOrderFname(String orderFname) {
		this.orderFname = orderFname;
	}

	@Column(name = "order_lname", length = 100)
	public String getOrderLname() {
		return this.orderLname;
	}

	public void setOrderLname(String orderLname) {
		this.orderLname = orderLname;
	}

	@Column(name = "order_addr", length = 100)
	public String getOrderAddr() {
		return this.orderAddr;
	}

	public void setOrderAddr(String orderAddr) {
		this.orderAddr = orderAddr;
	}

	@Column(name = "subdistrict", length = 50)
	public String getSubdistrict() {
		return this.subdistrict;
	}

	public void setSubdistrict(String subdistrict) {
		this.subdistrict = subdistrict;
	}

	@Column(name = "district", length = 50)
	public String getDistrict() {
		return this.district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	@Column(name = "order_country_id", length = 16)
	public String getOrderCountryId() {
		return this.orderCountryId;
	}

	public void setOrderCountryId(String orderCountryId) {
		this.orderCountryId = orderCountryId;
	}

	@Column(name = "order_province", length = 100)
	public String getOrderProvince() {
		return this.orderProvince;
	}

	public void setOrderProvince(String orderProvince) {
		this.orderProvince = orderProvince;
	}

	@Column(name = "order_zipcode", length = 32)
	public String getOrderZipcode() {
		return this.orderZipcode;
	}

	public void setOrderZipcode(String orderZipcode) {
		this.orderZipcode = orderZipcode;
	}

	@Column(name = "order_tel", length = 100)
	public String getOrderTel() {
		return this.orderTel;
	}

	public void setOrderTel(String orderTel) {
		this.orderTel = orderTel;
	}

	@Column(name = "order_mobile", length = 100)
	public String getOrderMobile() {
		return this.orderMobile;
	}

	public void setOrderMobile(String orderMobile) {
		this.orderMobile = orderMobile;
	}

	@Column(name = "fax", length = 32)
	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	@Column(name = "email", length = 64)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "description", length = 100)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "type")
	public Long getType() {
		return this.type;
	}

	public void setType(Long type) {
		this.type = type;
	}

	@Column(name = "user_create", length = 32)
	public String getUserCreate() {
		return this.userCreate;
	}

	public void setUserCreate(String userCreate) {
		this.userCreate = userCreate;
	}

	@Column(name = "user_update", length = 32)
	public String getUserUpdate() {
		return this.userUpdate;
	}

	public void setUserUpdate(String userUpdate) {
		this.userUpdate = userUpdate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "time_create", length = 19)
	public Date getTimeCreate() {
		return this.timeCreate;
	}

	public void setTimeCreate(Date timeCreate) {
		this.timeCreate = timeCreate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "time_update", length = 19)
	public Date getTimeUpdate() {
		return this.timeUpdate;
	}

	public void setTimeUpdate(Date timeUpdate) {
		this.timeUpdate = timeUpdate;
	}

	@Id
	@Column(name = "order_address_id", nullable = false)
	public long getOrderAddressId() {
		return orderAddressId;
	}

	public void setOrderAddressId(long orderAddressId) {
		this.orderAddressId = orderAddressId;
	}

	@Column(name = "order_id", nullable = false)
	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

}
