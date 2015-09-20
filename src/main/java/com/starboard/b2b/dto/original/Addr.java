
package com.starboard.b2b.dto.original;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class Addr implements Serializable {
    
    /** Creates a new instance of Addr */
    public Addr() {
    }
    public Addr(
            long addrId	
            , long custId	
            , String custCode	
            , long contactId	
            , String address	
            , long subDistrict	
            , long district	
            , long province	
            , String regionCountryId	
            , String postCode	
            , String tel1	
            , String tel2	
            , String fax	
            , String email	
            , long transType	
            , String transTel	
            , String type	
            , String userCreate	
            , String userUpdate	
            , java.sql.Timestamp timeCreate	
            , java.sql.Timestamp timeUpdate	
        ) {
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
    private long addrId;	
    private long custId;	
    private String custCode;	
    private long contactId;	
    private String address;	
    private long subDistrict;	
    private long district;	
    private long province;	
    private String regionCountryId;	
    private String postCode;	
    private String tel1;	
    private String tel2;	
    private String fax;	
    private String email;	
    private long transType;	
    private String transTel;	
    private String type;	
    private String userCreate;	
    private String userUpdate;	
    private java.sql.Timestamp timeCreate;	
    private java.sql.Timestamp timeUpdate;	



    public long getAddrId() {
        return this.addrId;
    }		
    public void setAddrId(long addrId) {
        this.addrId = addrId;
    }
    public long getCustId() {
        return this.custId;
    }		
    public void setCustId(long custId) {
        this.custId = custId;
    }
    public String getCustCode() {
        return this.custCode;
    }		
    public void setCustCode(String custCode) {
        this.custCode = custCode;
    }
    public long getContactId() {
        return this.contactId;
    }		
    public void setContactId(long contactId) {
        this.contactId = contactId;
    }
    public String getAddress() {
        return this.address;
    }		
    public void setAddress(String address) {
        this.address = address;
    }
    public long getSubDistrict() {
        return this.subDistrict;
    }		
    public void setSubDistrict(long subDistrict) {
        this.subDistrict = subDistrict;
    }
    public long getDistrict() {
        return this.district;
    }		
    public void setDistrict(long district) {
        this.district = district;
    }
    public long getProvince() {
        return this.province;
    }		
    public void setProvince(long province) {
        this.province = province;
    }
    public String getRegionCountryId() {
        return this.regionCountryId;
    }		
    public void setRegionCountryId(String regionCountryId) {
        this.regionCountryId = regionCountryId;
    }
    public String getPostCode() {
        return this.postCode;
    }		
    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }
    public String getTel1() {
        return this.tel1;
    }		
    public void setTel1(String tel1) {
        this.tel1 = tel1;
    }
    public String getTel2() {
        return this.tel2;
    }		
    public void setTel2(String tel2) {
        this.tel2 = tel2;
    }
    public String getFax() {
        return this.fax;
    }		
    public void setFax(String fax) {
        this.fax = fax;
    }
    public String getEmail() {
        return this.email;
    }		
    public void setEmail(String email) {
        this.email = email;
    }
    public long getTransType() {
        return this.transType;
    }		
    public void setTransType(long transType) {
        this.transType = transType;
    }
    public String getTransTel() {
        return this.transTel;
    }		
    public void setTransTel(String transTel) {
        this.transTel = transTel;
    }
    public String getType() {
        return this.type;
    }		
    public void setType(String type) {
        this.type = type;
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



    public String toString() {
        return super.toString() + "addrId=[" + addrId + "]\n" + "custId=[" + custId + "]\n" + "custCode=[" + custCode + "]\n" + "contactId=[" + contactId + "]\n" + "address=[" + address + "]\n" + "subDistrict=[" + subDistrict + "]\n" + "district=[" + district + "]\n" + "province=[" + province + "]\n" + "regionCountryId=[" + regionCountryId + "]\n" + "postCode=[" + postCode + "]\n" + "tel1=[" + tel1 + "]\n" + "tel2=[" + tel2 + "]\n" + "fax=[" + fax + "]\n" + "email=[" + email + "]\n" + "transType=[" + transType + "]\n" + "transTel=[" + transTel + "]\n" + "type=[" + type + "]\n" + "userCreate=[" + userCreate + "]\n" + "userUpdate=[" + userUpdate + "]\n" + "timeCreate=[" + timeCreate + "]\n" + "timeUpdate=[" + timeUpdate + "]\n";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof Addr)) {
                return false;
        }
        Addr that = (Addr) obj;
        if (that.getAddrId() != this.getAddrId()) {
                return false;
        }
        if (that.getCustId() != this.getCustId()) {
                return false;
        }
        if (!(that.getCustCode() == null ? this.getCustCode() == null
                        : that.getCustCode().equals(this.getCustCode()))) {
                return false;
        }
        if (that.getContactId() != this.getContactId()) {
                return false;
        }
        if (!(that.getAddress() == null ? this.getAddress() == null
                        : that.getAddress().equals(this.getAddress()))) {
                return false;
        }
        if (that.getSubDistrict() != this.getSubDistrict()) {
                return false;
        }
        if (that.getDistrict() != this.getDistrict()) {
                return false;
        }
        if (that.getProvince() != this.getProvince()) {
                return false;
        }
        if (!(that.getRegionCountryId() == null ? this.getRegionCountryId() == null
                        : that.getRegionCountryId().equals(this.getRegionCountryId()))) {
                return false;
        }
        if (!(that.getPostCode() == null ? this.getPostCode() == null
                        : that.getPostCode().equals(this.getPostCode()))) {
                return false;
        }
        if (!(that.getTel1() == null ? this.getTel1() == null
                        : that.getTel1().equals(this.getTel1()))) {
                return false;
        }
        if (!(that.getTel2() == null ? this.getTel2() == null
                        : that.getTel2().equals(this.getTel2()))) {
                return false;
        }
        if (!(that.getFax() == null ? this.getFax() == null
                        : that.getFax().equals(this.getFax()))) {
                return false;
        }
        if (!(that.getEmail() == null ? this.getEmail() == null
                        : that.getEmail().equals(this.getEmail()))) {
                return false;
        }
        if (that.getTransType() != this.getTransType()) {
                return false;
        }
        if (!(that.getTransTel() == null ? this.getTransTel() == null
                        : that.getTransTel().equals(this.getTransTel()))) {
                return false;
        }
        if (that.getType() != this.getType()) {
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
    return true;
    }

}
