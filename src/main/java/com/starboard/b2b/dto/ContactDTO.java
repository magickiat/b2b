package com.starboard.b2b.dto;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;

public class ContactDTO {
	private Long contactId;
	private Long custId;
	private String nameTh;
	private String nameTitle;
	private String nameEn;
	private String nameNick;
	private String position;
	private Date birthDate;
	private String address;
	private String email;
	private String tel;
	private String mobile;
	private String fax;
	private String skype;
	private String facebook;
	private String twitter;
	private BigDecimal markUp;
	private String salesId;
	private String mobileId;
	private String imgPath;
	private String userCreate;
	private String userUpdate;
	private Date timeCreate;
	private Date timeUpdate;
	private String signaturePath;
	
	public ContactDTO() {
		
	}
	public ContactDTO(Long contactId, Long custId, String nameTh, String nameTitle, String nameEn, String nameNick, String position, Date birthDate, String address, String email,
			 String tel, String mobile, String fax, String skype, String facebook, String twitter, BigDecimal markUp, String salesId, String mobileId, String imgPath, String userCreate, 
			 String userUpdate, Date timeCreate, Date timeUpdate, String signaturePath) {
		this.contactId = contactId;
		this.custId = custId;
		this.nameTh = nameTh;
		this.nameTitle = nameTitle;
		this.nameEn = nameEn;
		this.nameNick = nameNick;
		this.position = position;
		this.birthDate = birthDate;
		this.address = address;
		this.email = email;
		this.tel = tel;
		this.mobile = mobile;
		this.fax = fax;
		this.skype = skype;
		this.facebook = facebook;
		this.twitter = twitter;
		this.markUp = markUp;
		this.salesId = salesId;
		this.mobileId = mobileId;
		this.imgPath = imgPath;
		this.userCreate = userCreate;
		this.userUpdate = userUpdate;
		this.timeCreate = timeCreate;
		this.timeUpdate = timeUpdate;
		this.signaturePath = signaturePath;
	}
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	public Long getContactId() {
		return contactId;
	}
	public void setContactId(Long contactId) {
		this.contactId = contactId;
	}
	public Long getCustId() {
		return custId;
	}
	public void setCustId(Long custId) {
		this.custId = custId;
	}
	public void setCustId(long custId) {
		this.custId = custId;
	}
	public String getNameTh() {
		return nameTh;
	}
	public void setNameTh(String nameTh) {
		this.nameTh = nameTh;
	}
	public String getNameTitle() {
		return nameTitle;
	}
	public void setNameTitle(String nameTitle) {
		this.nameTitle = nameTitle;
	}
	public String getNameEn() {
		return nameEn;
	}
	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}
	public String getNameNick() {
		return nameNick;
	}
	public void setNameNick(String nameNick) {
		this.nameNick = nameNick;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getSkype() {
		return skype;
	}
	public void setSkype(String skype) {
		this.skype = skype;
	}
	public String getFacebook() {
		return facebook;
	}
	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}
	public String getTwitter() {
		return twitter;
	}
	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}
	public BigDecimal getMarkUp() {
		return markUp;
	}
	public void setMarkUp(BigDecimal markUp) {
		this.markUp = markUp;
	}
	public String getSalesId() {
		return salesId;
	}
	public void setSalesId(String salesId) {
		this.salesId = salesId;
	}
	public String getMobileId() {
		return mobileId;
	}
	public void setMobileId(String mobileId) {
		this.mobileId = mobileId;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
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
	public String getSignaturePath() {
		return signaturePath;
	}
	public void setSignaturePath(String signaturePath) {
		this.signaturePath = signaturePath;
	}
}
