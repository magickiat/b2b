
package com.starboard.b2b.dto.original;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class ShippingType implements Serializable {
    
    /** Creates a new instance of ShippingType */
    public ShippingType() {
    }
    public ShippingType(
            String shippingTypeId	
            , String shippingTypeName	
            , String description	
            , String userCreate	
            , String userUpdate	
            , java.sql.Timestamp timeCreate	
            , java.sql.Timestamp timeUpdate	
        ) {
        this.shippingTypeId = shippingTypeId;	
        this.shippingTypeName = shippingTypeName;	
        this.description = description;	
        this.userCreate = userCreate;	
        this.userUpdate = userUpdate;	
        this.timeCreate = timeCreate;	
        this.timeUpdate = timeUpdate;	
    }
    private String shippingTypeId;	
    private String shippingTypeName;	
    private String description;	
    private String userCreate;	
    private String userUpdate;	
    private java.sql.Timestamp timeCreate;	
    private java.sql.Timestamp timeUpdate;	



    public String getShippingTypeId() {
        return this.shippingTypeId;
    }		
    public void setShippingTypeId(String shippingTypeId) {
        this.shippingTypeId = shippingTypeId;
    }
    public String getShippingTypeName() {
        return this.shippingTypeName;
    }		
    public void setShippingTypeName(String shippingTypeName) {
        this.shippingTypeName = shippingTypeName;
    }
    public String getDescription() {
        return this.description;
    }		
    public void setDescription(String description) {
        this.description = description;
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
        return super.toString() + "shippingTypeId=[" + shippingTypeId + "]\n" + "shippingTypeName=[" + shippingTypeName + "]\n" + "description=[" + description + "]\n" + "userCreate=[" + userCreate + "]\n" + "userUpdate=[" + userUpdate + "]\n" + "timeCreate=[" + timeCreate + "]\n" + "timeUpdate=[" + timeUpdate + "]\n";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof ShippingType)) {
                return false;
        }
        ShippingType that = (ShippingType) obj;
        if (!(that.getShippingTypeId() == null ? this.getShippingTypeId() == null
                        : that.getShippingTypeId().equals(this.getShippingTypeId()))) {
                return false;
        }
        if (!(that.getShippingTypeName() == null ? this.getShippingTypeName() == null
                        : that.getShippingTypeName().equals(this.getShippingTypeName()))) {
                return false;
        }
        if (!(that.getDescription() == null ? this.getDescription() == null
                        : that.getDescription().equals(this.getDescription()))) {
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
