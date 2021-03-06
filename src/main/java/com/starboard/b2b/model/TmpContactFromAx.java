package com.starboard.b2b.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tmp_contact_from_ax")
public class TmpContactFromAx {
	private long contactId;
	private long custId;
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

	public TmpContactFromAx() {
	}

	public TmpContactFromAx(long contactId, long custId, String address) {
		this.contactId = contactId;
		this.custId = custId;
		this.address = address;
	}

	public TmpContactFromAx(long contactId, long custId, String nameTh, String nameTitle, String nameEn, String nameNick, String position, Date birthDate,
			String address, String email, String tel, String mobile, String fax, String skype, String facebook, String twitter, BigDecimal markUp,
			String salesId, String mobileId, String imgPath, String userCreate, String userUpdate, Date timeCreate, Date timeUpdate,
			String signaturePath) {
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

	@Id
	@Column(name = "contact_id", unique = true, nullable = false)
	public long getContactId() {
		return this.contactId;
	}

	public void setContactId(long contactId) {
		this.contactId = contactId;
	}

	@Column(name = "cust_id", nullable = false)
	public long getCustId() {
		return this.custId;
	}

	public void setCustId(long custId) {
		this.custId = custId;
	}

	@Column(name = "name_th")
	public String getNameTh() {
		return this.nameTh;
	}

	public void setNameTh(String nameTh) {
		this.nameTh = nameTh;
	}

	@Column(name = "name_title", length = 100)
	public String getNameTitle() {
		return this.nameTitle;
	}

	public void setNameTitle(String nameTitle) {
		this.nameTitle = nameTitle;
	}

	@Column(name = "name_en")
	public String getNameEn() {
		return this.nameEn;
	}

	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}

	@Column(name = "name_nick", length = 32)
	public String getNameNick() {
		return this.nameNick;
	}

	public void setNameNick(String nameNick) {
		this.nameNick = nameNick;
	}

	@Column(name = "position", length = 100)
	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "birth_date", length = 19)
	public Date getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Column(name = "address", nullable = false, length = 1024)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "email", length = 100)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "tel", length = 100)
	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Column(name = "mobile", length = 100)
	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Column(name = "fax", length = 100)
	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	@Column(name = "skype")
	public String getSkype() {
		return this.skype;
	}

	public void setSkype(String skype) {
		this.skype = skype;
	}

	@Column(name = "facebook")
	public String getFacebook() {
		return this.facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	@Column(name = "twitter")
	public String getTwitter() {
		return this.twitter;
	}

	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}

	@Column(name = "mark_up", precision = 5)
	public BigDecimal getMarkUp() {
		return this.markUp;
	}

	public void setMarkUp(BigDecimal markUp) {
		this.markUp = markUp;
	}

	@Column(name = "sales_id", length = 32)
	public String getSalesId() {
		return this.salesId;
	}

	public void setSalesId(String salesId) {
		this.salesId = salesId;
	}

	@Column(name = "mobile_id", length = 2)
	public String getMobileId() {
		return this.mobileId;
	}

	public void setMobileId(String mobileId) {
		this.mobileId = mobileId;
	}

	@Column(name = "img_path")
	public String getImgPath() {
		return this.imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
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

	@Column(name = "signature_path")
	public String getSignaturePath() {
		return this.signaturePath;
	}

	public void setSignaturePath(String signaturePath) {
		this.signaturePath = signaturePath;
	}

}
