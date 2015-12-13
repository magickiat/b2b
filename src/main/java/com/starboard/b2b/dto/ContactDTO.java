package com.starboard.b2b.dto;

import java.util.Date;

public class ContactDTO {

	private long id;
	private long contact_id;
	private String address;
	private Date birth_date;
	private long cust_id;
	private String email;
	private String facebook;
	private String fax;
	private String img_path;
	private double mark_up;
	private String mobile;
	private String mobile_id;
	private String name_en;
	private String name_nick;
	private String name_th;
	private String name_title;
	private String position;
	private String sales_id;
	private String signature_path;
	private String skype;
	private String tel;
	private String twitter;
	private String userCreate;
	private String userUpdate;
	private Date timeCreate;
	private Date timeUpdate;

	public ContactDTO(long id, long contact_id, String address, Date birth_date, long cust_id, String email, String facebook, String fax,
			String img_path, double mark_up, String mobile, String mobile_id, String name_en, String name_nick, String name_th, String name_title,
			String position, String sales_id, String signature_path, String skype, String tel, String twitter, String userCreate, String userUpdate,
			Date timeCreate, Date timeUpdate) {
		this.id = id;
		this.timeCreate = timeCreate;
		this.timeUpdate = timeUpdate;
		this.userCreate = userCreate;
		this.userUpdate = userUpdate;
		this.contact_id = contact_id;
		this.address = address;
		this.birth_date = birth_date;
		this.cust_id = cust_id;
		this.email = email;
		this.facebook = facebook;
		this.fax = fax;
		this.img_path = img_path;
		this.mark_up = mark_up;
		this.mobile = mobile;
		this.mobile_id = mobile_id;
		this.name_en = name_en;
		this.name_nick = name_nick;
		this.name_th = name_th;
		this.name_title = name_title;
		this.position = position;
		this.sales_id = sales_id;
		this.signature_path = signature_path;
		this.skype = skype;
		this.tel = tel;
		this.twitter = twitter;
	}

	public String getTwitter() {
		return twitter;
	}

	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}

	public String getTel() {
		return tel;
	}

	public void getTel(String tel) {
		this.tel = tel;
	}

	public String getSkype() {
		return skype;
	}

	public void setSkype(String skype) {
		this.skype = skype;
	}

	public String getSignaturePath() {
		return signature_path;
	}

	public void setSignaturePath(String signature_path) {
		this.signature_path = signature_path;
	}

	public String getSalesId() {
		return sales_id;
	}

	public void setSalesId(String sales_id) {
		this.sales_id = sales_id;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getNameTitle() {
		return name_title;
	}

	public void setNameTitle(String name_title) {
		this.name_title = name_title;
	}

	public String getNameTh() {
		return name_th;
	}

	public void setNameTh(String name_th) {
		this.name_th = name_th;
	}

	public String getNameNick() {
		return name_nick;
	}

	public void setNameNick(String name_nick) {
		this.name_nick = name_nick;
	}

	public String getNameEn() {
		return name_en;
	}

	public void setNameEn(String name_en) {
		this.name_en = name_en;
	}

	public String getMobileId() {
		return mobile_id;
	}

	public void setMobileId(String mobile_id) {
		this.mobile_id = mobile_id;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public double getMarkup() {
		return mark_up;
	}

	public void setMark_up(double mark_up) {
		this.mark_up = mark_up;
	}

	public String getImgPath() {
		return img_path;
	}

	public void setImgPath(String img_path) {
		this.img_path = img_path;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getCustId() {
		return cust_id;
	}

	public void setCustId(long cust_id) {
		this.cust_id = cust_id;
	}

	public Date getBirthDate() {
		return birth_date;
	}

	public void setBirthDate(Date birth_date) {
		this.birth_date = birth_date;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getContactId() {
		return contact_id;
	}

	public void setContactId(long contact_id) {
		this.contact_id = contact_id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
