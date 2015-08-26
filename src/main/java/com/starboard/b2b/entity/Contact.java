
package com.starboard.b2b.entity;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class Contact implements Serializable {
    
    /** Creates a new instance of Contact */
    public Contact() {
    }
    public Contact(
            long contactId	
            , long custId	
            , String nameTh	
            , String nameTitle	
            , String nameEn	
            , String nameNick	
            , String position	
            , java.sql.Timestamp birthDate	
            , String address	
            , String email	
            , String tel	
            , String mobile	
            , String fax	
            , String skype	
            , String facebook	
            , String twitter	
            , java.math.BigDecimal markUp	
            , String salesId	
            , String mobileId	
            , String imgPath	
            , String userCreate	
            , String userUpdate	
            , java.sql.Timestamp timeCreate	
            , java.sql.Timestamp timeUpdate	
            , String signaturePath	
        ) {
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
    private long contactId;	
    private long custId;	
    private String nameTh;	
    private String nameTitle;	
    private String nameEn;	
    private String nameNick;	
    private String position;	
    private java.sql.Timestamp birthDate;	
    private String address;	
    private String email;	
    private String tel;	
    private String mobile;	
    private String fax;	
    private String skype;	
    private String facebook;	
    private String twitter;	
    private java.math.BigDecimal markUp;	
    private String salesId;	
    private String mobileId;	
    private String imgPath;	
    private String userCreate;	
    private String userUpdate;	
    private java.sql.Timestamp timeCreate;	
    private java.sql.Timestamp timeUpdate;	
    private String signaturePath;	



    public long getContactId() {
        return this.contactId;
    }		
    public void setContactId(long contactId) {
        this.contactId = contactId;
    }
    public long getCustId() {
        return this.custId;
    }		
    public void setCustId(long custId) {
        this.custId = custId;
    }
    public String getNameTh() {
        return this.nameTh;
    }		
    public void setNameTh(String nameTh) {
        this.nameTh = nameTh;
    }
    public String getNameTitle() {
        return this.nameTitle;
    }		
    public void setNameTitle(String nameTitle) {
        this.nameTitle = nameTitle;
    }
    public String getNameEn() {
        return this.nameEn;
    }		
    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }
    public String getNameNick() {
        return this.nameNick;
    }		
    public void setNameNick(String nameNick) {
        this.nameNick = nameNick;
    }
    public String getPosition() {
        return this.position;
    }		
    public void setPosition(String position) {
        this.position = position;
    }
    public java.sql.Timestamp getBirthDate() {
        return this.birthDate;
    }		
    public void setBirthDate(java.sql.Timestamp birthDate) {
        this.birthDate = birthDate;
    }
    public String getAddress() {
        return this.address;
    }		
    public void setAddress(String address) {
        this.address = address;
    }
    public String getEmail() {
        return this.email;
    }		
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTel() {
        return this.tel;
    }		
    public void setTel(String tel) {
        this.tel = tel;
    }
    public String getMobile() {
        return this.mobile;
    }		
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    public String getFax() {
        return this.fax;
    }		
    public void setFax(String fax) {
        this.fax = fax;
    }
    public String getSkype() {
        return this.skype;
    }		
    public void setSkype(String skype) {
        this.skype = skype;
    }
    public String getFacebook() {
        return this.facebook;
    }		
    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }
    public String getTwitter() {
        return this.twitter;
    }		
    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }
    public java.math.BigDecimal getMarkUp() {
        return this.markUp;
    }		
    public void setMarkUp(java.math.BigDecimal markUp) {
        this.markUp = markUp;
    }
    public String getSalesId() {
        return this.salesId;
    }		
    public void setSalesId(String salesId) {
        this.salesId = salesId;
    }
    public String getMobileId() {
        return this.mobileId;
    }		
    public void setMobileId(String mobileId) {
        this.mobileId = mobileId;
    }
    public String getImgPath() {
        return this.imgPath;
    }		
    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }
    public String getUserCreate() {
        return this.userCreate;
    }		
    public void setUserCreate(String userCreate) {
        this.userCreate = userCreate;
    }
    public String getUserUpdate() {
        return this.userUpdate;
    }		
    public void setUserUpdate(String userUpdate) {
        this.userUpdate = userUpdate;
    }
    public java.sql.Timestamp getTimeCreate() {
        return this.timeCreate;
    }		
    public void setTimeCreate(java.sql.Timestamp timeCreate) {
        this.timeCreate = timeCreate;
    }
    public java.sql.Timestamp getTimeUpdate() {
        return this.timeUpdate;
    }		
    public void setTimeUpdate(java.sql.Timestamp timeUpdate) {
        this.timeUpdate = timeUpdate;
    }
    public String getSignaturePath() {
        return this.signaturePath;
    }		
    public void setSignaturePath(String signaturePath) {
        this.signaturePath = signaturePath;
    }



    public String toString() {
        return super.toString() + "contactId=[" + contactId + "]\n" + "custId=[" + custId + "]\n" + "nameTh=[" + nameTh + "]\n" + "nameTitle=[" + nameTitle + "]\n" + "nameEn=[" + nameEn + "]\n" + "nameNick=[" + nameNick + "]\n" + "position=[" + position + "]\n" + "birthDate=[" + birthDate + "]\n" + "address=[" + address + "]\n" + "email=[" + email + "]\n" + "tel=[" + tel + "]\n" + "mobile=[" + mobile + "]\n" + "fax=[" + fax + "]\n" + "skype=[" + skype + "]\n" + "facebook=[" + facebook + "]\n" + "twitter=[" + twitter + "]\n" + "markUp=[" + markUp + "]\n" + "salesId=[" + salesId + "]\n" + "mobileId=[" + mobileId + "]\n" + "imgPath=[" + imgPath + "]\n" + "userCreate=[" + userCreate + "]\n" + "userUpdate=[" + userUpdate + "]\n" + "timeCreate=[" + timeCreate + "]\n" + "timeUpdate=[" + timeUpdate + "]\n" + "signaturePath=[" + signaturePath + "]\n";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof Contact)) {
                return false;
        }
        Contact that = (Contact) obj;
        if (that.getContactId() != this.getContactId()) {
                return false;
        }
        if (that.getCustId() != this.getCustId()) {
                return false;
        }
        if (!(that.getNameTh() == null ? this.getNameTh() == null
                        : that.getNameTh().equals(this.getNameTh()))) {
                return false;
        }
        if (!(that.getNameTitle() == null ? this.getNameTitle() == null
                        : that.getNameTitle().equals(this.getNameTitle()))) {
                return false;
        }
        if (!(that.getNameEn() == null ? this.getNameEn() == null
                        : that.getNameEn().equals(this.getNameEn()))) {
                return false;
        }
        if (!(that.getNameNick() == null ? this.getNameNick() == null
                        : that.getNameNick().equals(this.getNameNick()))) {
                return false;
        }
        if (!(that.getPosition() == null ? this.getPosition() == null
                        : that.getPosition().equals(this.getPosition()))) {
                return false;
        }
        if (!(that.getBirthDate() == null ? this.getBirthDate() == null
                        : that.getBirthDate().equals(this.getBirthDate()))) {
                return false;
        }
        if (!(that.getAddress() == null ? this.getAddress() == null
                        : that.getAddress().equals(this.getAddress()))) {
                return false;
        }
        if (!(that.getEmail() == null ? this.getEmail() == null
                        : that.getEmail().equals(this.getEmail()))) {
                return false;
        }
        if (!(that.getTel() == null ? this.getTel() == null
                        : that.getTel().equals(this.getTel()))) {
                return false;
        }
        if (!(that.getMobile() == null ? this.getMobile() == null
                        : that.getMobile().equals(this.getMobile()))) {
                return false;
        }
        if (!(that.getFax() == null ? this.getFax() == null
                        : that.getFax().equals(this.getFax()))) {
                return false;
        }
        if (!(that.getSkype() == null ? this.getSkype() == null
                        : that.getSkype().equals(this.getSkype()))) {
                return false;
        }
        if (!(that.getFacebook() == null ? this.getFacebook() == null
                        : that.getFacebook().equals(this.getFacebook()))) {
                return false;
        }
        if (!(that.getTwitter() == null ? this.getTwitter() == null
                        : that.getTwitter().equals(this.getTwitter()))) {
                return false;
        }
        if (!(that.getMarkUp() == null ? this.getMarkUp() == null
                        : 0 == that.getMarkUp().compareTo(this.getMarkUp()))) {
                return false;
        }
        if (!(that.getSalesId() == null ? this.getSalesId() == null
                        : that.getSalesId().equals(this.getSalesId()))) {
                return false;
        }
        if (!(that.getMobileId() == null ? this.getMobileId() == null
                        : that.getMobileId().equals(this.getMobileId()))) {
                return false;
        }
        if (!(that.getImgPath() == null ? this.getImgPath() == null
                        : that.getImgPath().equals(this.getImgPath()))) {
                return false;
        }
        if (!(that.getUserCreate() == null ? this.getUserCreate() == null
                        : that.getUserCreate().equals(this.getUserCreate()))) {
                return false;
        }
        if (!(that.getUserUpdate() == null ? this.getUserUpdate() == null
                        : that.getUserUpdate().equals(this.getUserUpdate()))) {
                return false;
        }
        if (!(that.getTimeCreate() == null ? this.getTimeCreate() == null
                        : that.getTimeCreate().equals(this.getTimeCreate()))) {
                return false;
        }
        if (!(that.getTimeUpdate() == null ? this.getTimeUpdate() == null
                        : that.getTimeUpdate().equals(this.getTimeUpdate()))) {
                return false;
        }
        if (!(that.getSignaturePath() == null ? this.getSignaturePath() == null
                        : that.getSignaturePath().equals(this.getSignaturePath()))) {
                return false;
        }
    return true;
    }

}
