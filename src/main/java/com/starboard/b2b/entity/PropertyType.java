
package com.starboard.b2b.entity;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class PropertyType implements Serializable {
    
    /** Creates a new instance of PropertyType */
    public PropertyType() {
    }
    public PropertyType(
            long propertyTypeId	
            , String propertyForId	
            , String propertyTypeName	
            , long propertyTypeParentId	
            , String propertyTypeDescription	
            , String status	
            , String userCreate	
            , String userUpdate	
            , java.sql.Timestamp timeCreate	
            , java.sql.Timestamp timeUpdate	
        ) {
        this.propertyTypeId = propertyTypeId;	
        this.propertyForId = propertyForId;	
        this.propertyTypeName = propertyTypeName;	
        this.propertyTypeParentId = propertyTypeParentId;	
        this.propertyTypeDescription = propertyTypeDescription;	
        this.status = status;	
        this.userCreate = userCreate;	
        this.userUpdate = userUpdate;	
        this.timeCreate = timeCreate;	
        this.timeUpdate = timeUpdate;	
    }
    private long propertyTypeId;	
    private String propertyForId;	
    private String propertyTypeName;	
    private long propertyTypeParentId;	
    private String propertyTypeDescription;	
    private String status;	
    private String userCreate;	
    private String userUpdate;	
    private java.sql.Timestamp timeCreate;	
    private java.sql.Timestamp timeUpdate;	



    public long getPropertyTypeId() {
        return this.propertyTypeId;
    }		
    public void setPropertyTypeId(long propertyTypeId) {
        this.propertyTypeId = propertyTypeId;
    }
    public String getPropertyForId() {
        return this.propertyForId;
    }		
    public void setPropertyForId(String propertyForId) {
        this.propertyForId = propertyForId;
    }
    public String getPropertyTypeName() {
        return this.propertyTypeName;
    }		
    public void setPropertyTypeName(String propertyTypeName) {
        this.propertyTypeName = propertyTypeName;
    }
    public long getPropertyTypeParentId() {
        return this.propertyTypeParentId;
    }		
    public void setPropertyTypeParentId(long propertyTypeParentId) {
        this.propertyTypeParentId = propertyTypeParentId;
    }
    public String getPropertyTypeDescription() {
        return this.propertyTypeDescription;
    }		
    public void setPropertyTypeDescription(String propertyTypeDescription) {
        this.propertyTypeDescription = propertyTypeDescription;
    }
    public String getStatus() {
        return this.status;
    }		
    public void setStatus(String status) {
        this.status = status;
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
        return super.toString() + "propertyTypeId=[" + propertyTypeId + "]\n" + "propertyForId=[" + propertyForId + "]\n" + "propertyTypeName=[" + propertyTypeName + "]\n" + "propertyTypeParentId=[" + propertyTypeParentId + "]\n" + "propertyTypeDescription=[" + propertyTypeDescription + "]\n" + "status=[" + status + "]\n" + "userCreate=[" + userCreate + "]\n" + "userUpdate=[" + userUpdate + "]\n" + "timeCreate=[" + timeCreate + "]\n" + "timeUpdate=[" + timeUpdate + "]\n";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof PropertyType)) {
                return false;
        }
        PropertyType that = (PropertyType) obj;
        if (that.getPropertyTypeId() != this.getPropertyTypeId()) {
                return false;
        }
        if (!(that.getPropertyForId() == null ? this.getPropertyForId() == null
                        : that.getPropertyForId().equals(this.getPropertyForId()))) {
                return false;
        }
        if (!(that.getPropertyTypeName() == null ? this.getPropertyTypeName() == null
                        : that.getPropertyTypeName().equals(this.getPropertyTypeName()))) {
                return false;
        }
        if (that.getPropertyTypeParentId() != this.getPropertyTypeParentId()) {
                return false;
        }
        if (!(that.getPropertyTypeDescription() == null ? this.getPropertyTypeDescription() == null
                        : that.getPropertyTypeDescription().equals(this.getPropertyTypeDescription()))) {
                return false;
        }
        if (!(that.getStatus() == null ? this.getStatus() == null
                        : that.getStatus().equals(this.getStatus()))) {
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
