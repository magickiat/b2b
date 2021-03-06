package com.starboard.b2b.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tmp_addr_from_ax")
public class TmpAddrFromAx {
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

	public TmpAddrFromAx() {
	}

	public TmpAddrFromAx(long addrId, long custId) {
		this.addrId = addrId;
		this.custId = custId;
	}

	public TmpAddrFromAx(long addrId, long custId, String custCode, Long contactId, String address, Long subDistrict, Long district, Long province,
			String regionCountryId, String postCode, String tel1, String tel2, String fax, String email, Long transType, String transTel, String type,
			String userCreate, String userUpdate, Date timeCreate, Date timeUpdate) {
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

	@Id
	@Column(name = "addr_id", unique = true, nullable = false)
	public long getAddrId() {
		return this.addrId;
	}

	public void setAddrId(long addrId) {
		this.addrId = addrId;
	}

	@Column(name = "cust_id", nullable = false)
	public long getCustId() {
		return this.custId;
	}

	public void setCustId(long custId) {
		this.custId = custId;
	}

	@Column(name = "cust_code", length = 32)
	public String getCustCode() {
		return this.custCode;
	}

	public void setCustCode(String custCode) {
		this.custCode = custCode;
	}

	@Column(name = "contact_id")
	public Long getContactId() {
		return this.contactId;
	}

	public void setContactId(Long contactId) {
		this.contactId = contactId;
	}

	@Column(name = "address", length = 65535)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "sub_district")
	public Long getSubDistrict() {
		return this.subDistrict;
	}

	public void setSubDistrict(Long subDistrict) {
		this.subDistrict = subDistrict;
	}

	@Column(name = "district")
	public Long getDistrict() {
		return this.district;
	}

	public void setDistrict(Long district) {
		this.district = district;
	}

	@Column(name = "province")
	public Long getProvince() {
		return this.province;
	}

	public void setProvince(Long province) {
		this.province = province;
	}

	@Column(name = "region_country_id", length = 32)
	public String getRegionCountryId() {
		return this.regionCountryId;
	}

	public void setRegionCountryId(String regionCountryId) {
		this.regionCountryId = regionCountryId;
	}

	@Column(name = "post_code", length = 5)
	public String getPostCode() {
		return this.postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	@Column(name = "tel_1", length = 20)
	public String getTel1() {
		return this.tel1;
	}

	public void setTel1(String tel1) {
		this.tel1 = tel1;
	}

	@Column(name = "tel_2", length = 20)
	public String getTel2() {
		return this.tel2;
	}

	public void setTel2(String tel2) {
		this.tel2 = tel2;
	}

	@Column(name = "fax", length = 20)
	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	@Column(name = "email")
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "trans_type")
	public Long getTransType() {
		return this.transType;
	}

	public void setTransType(Long transType) {
		this.transType = transType;
	}

	@Column(name = "trans_tel", length = 50)
	public String getTransTel() {
		return this.transTel;
	}

	public void setTransTel(String transTel) {
		this.transTel = transTel;
	}

	@Column(name = "type", length = 1)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "user_create", length = 30)
	public String getUserCreate() {
		return this.userCreate;
	}

	public void setUserCreate(String userCreate) {
		this.userCreate = userCreate;
	}

	@Column(name = "user_update", length = 30)
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
}
