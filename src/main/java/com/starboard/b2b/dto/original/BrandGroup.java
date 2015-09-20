
package com.starboard.b2b.dto.original;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class BrandGroup implements Serializable {
    
    /** Creates a new instance of BrandGroup */
    public BrandGroup() {
    }
    public BrandGroup(
            long brandGroupId	
            , String brandGroupName	
            , String brandGroupDescription	
            , String userCreate	
            , String userUpdate	
            , java.sql.Timestamp timeCreate	
            , java.sql.Timestamp timeUpdate	
        ) {
        this.brandGroupId = brandGroupId;	
        this.brandGroupName = brandGroupName;	
        this.brandGroupDescription = brandGroupDescription;	
        this.userCreate = userCreate;	
        this.userUpdate = userUpdate;	
        this.timeCreate = timeCreate;	
        this.timeUpdate = timeUpdate;	
    }
    private long brandGroupId;	
    private String brandGroupName;	
    private String brandGroupDescription;	
    private String userCreate;	
    private String userUpdate;	
    private java.sql.Timestamp timeCreate;	
    private java.sql.Timestamp timeUpdate;	



    public long getBrandGroupId() {
        return this.brandGroupId;
    }		
    public void setBrandGroupId(long brandGroupId) {
        this.brandGroupId = brandGroupId;
    }
    public String getBrandGroupName() {
        return this.brandGroupName;
    }		
    public void setBrandGroupName(String brandGroupName) {
        this.brandGroupName = brandGroupName;
    }
    public String getBrandGroupDescription() {
        return this.brandGroupDescription;
    }		
    public void setBrandGroupDescription(String brandGroupDescription) {
        this.brandGroupDescription = brandGroupDescription;
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
        return super.toString() + "brandGroupId=[" + brandGroupId + "]\n" + "brandGroupName=[" + brandGroupName + "]\n" + "brandGroupDescription=[" + brandGroupDescription + "]\n" + "userCreate=[" + userCreate + "]\n" + "userUpdate=[" + userUpdate + "]\n" + "timeCreate=[" + timeCreate + "]\n" + "timeUpdate=[" + timeUpdate + "]\n";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof BrandGroup)) {
                return false;
        }
        BrandGroup that = (BrandGroup) obj;
        if (that.getBrandGroupId() != this.getBrandGroupId()) {
                return false;
        }
        if (!(that.getBrandGroupName() == null ? this.getBrandGroupName() == null
                        : that.getBrandGroupName().equals(this.getBrandGroupName()))) {
                return false;
        }
        if (!(that.getBrandGroupDescription() == null ? this.getBrandGroupDescription() == null
                        : that.getBrandGroupDescription().equals(this.getBrandGroupDescription()))) {
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
