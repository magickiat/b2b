
package com.starboard.b2b.entity;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class Contactus implements Serializable {
    
    /** Creates a new instance of Contactus */
    public Contactus() {
    }
    public Contactus(
            long contactId	
            , String contactTitle	
            , String contactName	
            , String contactEmail	
            , String contactDetail	
            , String contactTel	
            , String userCreate	
            , String userUpdate	
            , java.sql.Timestamp timeCreate	
            , java.sql.Timestamp timeUpdate	
        ) {
        this.contactId = contactId;	
        this.contactTitle = contactTitle;	
        this.contactName = contactName;	
        this.contactEmail = contactEmail;	
        this.contactDetail = contactDetail;	
        this.contactTel = contactTel;	
        this.userCreate = userCreate;	
        this.userUpdate = userUpdate;	
        this.timeCreate = timeCreate;	
        this.timeUpdate = timeUpdate;	
    }
    private long contactId;	
    private String contactTitle;	
    private String contactName;	
    private String contactEmail;	
    private String contactDetail;	
    private String contactTel;	
    private String userCreate;	
    private String userUpdate;	
    private java.sql.Timestamp timeCreate;	
    private java.sql.Timestamp timeUpdate;	



    public long getContactId() {
        return this.contactId;
    }		
    public void setContactId(long contactId) {
        this.contactId = contactId;
    }
    public String getContactTitle() {
        return this.contactTitle;
    }		
    public void setContactTitle(String contactTitle) {
        this.contactTitle = contactTitle;
    }
    public String getContactName() {
        return this.contactName;
    }		
    public void setContactName(String contactName) {
        this.contactName = contactName;
    }
    public String getContactEmail() {
        return this.contactEmail;
    }		
    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }
    public String getContactDetail() {
        return this.contactDetail;
    }		
    public void setContactDetail(String contactDetail) {
        this.contactDetail = contactDetail;
    }
    public String getContactTel() {
        return this.contactTel;
    }		
    public void setContactTel(String contactTel) {
        this.contactTel = contactTel;
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
        return super.toString() + "contactId=[" + contactId + "]\n" + "contactTitle=[" + contactTitle + "]\n" + "contactName=[" + contactName + "]\n" + "contactEmail=[" + contactEmail + "]\n" + "contactDetail=[" + contactDetail + "]\n" + "contactTel=[" + contactTel + "]\n" + "userCreate=[" + userCreate + "]\n" + "userUpdate=[" + userUpdate + "]\n" + "timeCreate=[" + timeCreate + "]\n" + "timeUpdate=[" + timeUpdate + "]\n";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof Contactus)) {
                return false;
        }
        Contactus that = (Contactus) obj;
        if (that.getContactId() != this.getContactId()) {
                return false;
        }
        if (!(that.getContactTitle() == null ? this.getContactTitle() == null
                        : that.getContactTitle().equals(this.getContactTitle()))) {
                return false;
        }
        if (!(that.getContactName() == null ? this.getContactName() == null
                        : that.getContactName().equals(this.getContactName()))) {
                return false;
        }
        if (!(that.getContactEmail() == null ? this.getContactEmail() == null
                        : that.getContactEmail().equals(this.getContactEmail()))) {
                return false;
        }
        if (!(that.getContactDetail() == null ? this.getContactDetail() == null
                        : that.getContactDetail().equals(this.getContactDetail()))) {
                return false;
        }
        if (!(that.getContactTel() == null ? this.getContactTel() == null
                        : that.getContactTel().equals(this.getContactTel()))) {
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
