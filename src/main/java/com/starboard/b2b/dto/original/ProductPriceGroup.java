
package com.starboard.b2b.dto.original;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class ProductPriceGroup implements Serializable {
    
    /** Creates a new instance of ProductPriceGroup */
    public ProductPriceGroup() {
    }
    public ProductPriceGroup(
            String productPriceGroupId	
            , String productPriceGroupName	
            , String description	
            , String userCreate	
            , String userUpdate	
            , java.sql.Timestamp timeCreate	
            , java.sql.Timestamp timeUpdate	
        ) {
        this.productPriceGroupId = productPriceGroupId;	
        this.productPriceGroupName = productPriceGroupName;	
        this.description = description;	
        this.userCreate = userCreate;	
        this.userUpdate = userUpdate;	
        this.timeCreate = timeCreate;	
        this.timeUpdate = timeUpdate;	
    }
    private String productPriceGroupId;	
    private String productPriceGroupName;	
    private String description;	
    private String userCreate;	
    private String userUpdate;	
    private java.sql.Timestamp timeCreate;	
    private java.sql.Timestamp timeUpdate;	



    public String getProductPriceGroupId() {
        return this.productPriceGroupId;
    }		
    public void setProductPriceGroupId(String productPriceGroupId) {
        this.productPriceGroupId = productPriceGroupId;
    }
    public String getProductPriceGroupName() {
        return this.productPriceGroupName;
    }		
    public void setProductPriceGroupName(String productPriceGroupName) {
        this.productPriceGroupName = productPriceGroupName;
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
        return super.toString() + "productPriceGroupId=[" + productPriceGroupId + "]\n" + "productPriceGroupName=[" + productPriceGroupName + "]\n" + "description=[" + description + "]\n" + "userCreate=[" + userCreate + "]\n" + "userUpdate=[" + userUpdate + "]\n" + "timeCreate=[" + timeCreate + "]\n" + "timeUpdate=[" + timeUpdate + "]\n";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof ProductPriceGroup)) {
                return false;
        }
        ProductPriceGroup that = (ProductPriceGroup) obj;
        if (!(that.getProductPriceGroupId() == null ? this.getProductPriceGroupId() == null
                        : that.getProductPriceGroupId().equals(this.getProductPriceGroupId()))) {
                return false;
        }
        if (!(that.getProductPriceGroupName() == null ? this.getProductPriceGroupName() == null
                        : that.getProductPriceGroupName().equals(this.getProductPriceGroupName()))) {
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
