
package com.starboard.b2b.entity;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class CustUser implements Serializable {
    
    /** Creates a new instance of CustUser */
    public CustUser() {
    }
    public CustUser(
            String custUserId	
            , long custId	
            , String name	
            , String password	
            , String custEmail	
            , String enable	
            , String isStaff	
            , java.sql.Timestamp timeActive	
            , String userCreate	
            , String userUpdate	
            , java.sql.Timestamp timeCreate	
            , java.sql.Timestamp timeUpdate	
        ) {
        this.custUserId = custUserId;	
        this.custId = custId;	
        this.name = name;	
        this.password = password;	
        this.custEmail = custEmail;	
        this.enable = enable;	
        this.isStaff = isStaff;	
        this.timeActive = timeActive;	
        this.userCreate = userCreate;	
        this.userUpdate = userUpdate;	
        this.timeCreate = timeCreate;	
        this.timeUpdate = timeUpdate;	
    }
    private String custUserId;	
    private long custId;	
    private String name;	
    private String password;	
    private String custEmail;	
    private String enable;	
    private String isStaff;	
    private java.sql.Timestamp timeActive;	
    private String userCreate;	
    private String userUpdate;	
    private java.sql.Timestamp timeCreate;	
    private java.sql.Timestamp timeUpdate;	



    public String getCustUserId() {
        return this.custUserId;
    }		
    public void setCustUserId(String custUserId) {
        this.custUserId = custUserId;
    }
    public long getCustId() {
        return this.custId;
    }		
    public void setCustId(long custId) {
        this.custId = custId;
    }
    public String getName() {
        return this.name;
    }		
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return this.password;
    }		
    public void setPassword(String password) {
        this.password = password;
    }
    public String getCustEmail() {
        return this.custEmail;
    }		
    public void setCustEmail(String custEmail) {
        this.custEmail = custEmail;
    }
    public String getEnable() {
        return this.enable;
    }		
    public void setEnable(String enable) {
        this.enable = enable;
    }
    public String getIsStaff() {
        return this.isStaff;
    }		
    public void setIsStaff(String isStaff) {
        this.isStaff = isStaff;
    }
    public java.sql.Timestamp getTimeActive() {
        return this.timeActive;
    }		
    public void setTimeActive(java.sql.Timestamp timeActive) {
        this.timeActive = timeActive;
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
        return super.toString() + "custUserId=[" + custUserId + "]\n" + "custId=[" + custId + "]\n" + "name=[" + name + "]\n" + "password=[" + password + "]\n" + "custEmail=[" + custEmail + "]\n" + "enable=[" + enable + "]\n" + "isStaff=[" + isStaff + "]\n" + "timeActive=[" + timeActive + "]\n" + "userCreate=[" + userCreate + "]\n" + "userUpdate=[" + userUpdate + "]\n" + "timeCreate=[" + timeCreate + "]\n" + "timeUpdate=[" + timeUpdate + "]\n";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof CustUser)) {
                return false;
        }
        CustUser that = (CustUser) obj;
        if (!(that.getCustUserId() == null ? this.getCustUserId() == null
                        : that.getCustUserId().equals(this.getCustUserId()))) {
                return false;
        }
        if (that.getCustId() != this.getCustId()) {
                return false;
        }
        if (!(that.getName() == null ? this.getName() == null
                        : that.getName().equals(this.getName()))) {
                return false;
        }
        if (!(that.getPassword() == null ? this.getPassword() == null
                        : that.getPassword().equals(this.getPassword()))) {
                return false;
        }
        if (!(that.getCustEmail() == null ? this.getCustEmail() == null
                        : that.getCustEmail().equals(this.getCustEmail()))) {
                return false;
        }
        if (!(that.getEnable() == null ? this.getEnable() == null
                        : that.getEnable().equals(this.getEnable()))) {
                return false;
        }
        if (!(that.getIsStaff() == null ? this.getIsStaff() == null
                        : that.getIsStaff().equals(this.getIsStaff()))) {
                return false;
        }
        if (!(that.getTimeActive() == null ? this.getTimeActive() == null
                        : that.getTimeActive().equals(this.getTimeActive()))) {
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
