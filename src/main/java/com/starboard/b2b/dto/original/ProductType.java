
package com.starboard.b2b.dto.original;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class ProductType implements Serializable {
    
    /** Creates a new instance of ProductType */
    public ProductType() {
    }
    public ProductType(
            long productTypeId	
            , String productTypeName	
            , long productTypeParentId	
            , String productTypeDescription	
            , String userCreate	
            , String userUpdate	
            , java.sql.Timestamp timeCreate	
            , java.sql.Timestamp timeUpdate	
        ) {
        this.productTypeId = productTypeId;	
        this.productTypeName = productTypeName;	
        this.productTypeParentId = productTypeParentId;	
        this.productTypeDescription = productTypeDescription;	
        this.userCreate = userCreate;	
        this.userUpdate = userUpdate;	
        this.timeCreate = timeCreate;	
        this.timeUpdate = timeUpdate;	
    }
    private long productTypeId;	
    private String productTypeName;	
    private long productTypeParentId;	
    private String productTypeDescription;	
    private String userCreate;	
    private String userUpdate;	
    private java.sql.Timestamp timeCreate;	
    private java.sql.Timestamp timeUpdate;	



    public long getProductTypeId() {
        return this.productTypeId;
    }		
    public void setProductTypeId(long productTypeId) {
        this.productTypeId = productTypeId;
    }
    public String getProductTypeName() {
        return this.productTypeName;
    }		
    public void setProductTypeName(String productTypeName) {
        this.productTypeName = productTypeName;
    }
    public long getProductTypeParentId() {
        return this.productTypeParentId;
    }		
    public void setProductTypeParentId(long productTypeParentId) {
        this.productTypeParentId = productTypeParentId;
    }
    public String getProductTypeDescription() {
        return this.productTypeDescription;
    }		
    public void setProductTypeDescription(String productTypeDescription) {
        this.productTypeDescription = productTypeDescription;
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
        return super.toString() + "productTypeId=[" + productTypeId + "]\n" + "productTypeName=[" + productTypeName + "]\n" + "productTypeParentId=[" + productTypeParentId + "]\n" + "productTypeDescription=[" + productTypeDescription + "]\n" + "userCreate=[" + userCreate + "]\n" + "userUpdate=[" + userUpdate + "]\n" + "timeCreate=[" + timeCreate + "]\n" + "timeUpdate=[" + timeUpdate + "]\n";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof ProductType)) {
                return false;
        }
        ProductType that = (ProductType) obj;
        if (that.getProductTypeId() != this.getProductTypeId()) {
                return false;
        }
        if (!(that.getProductTypeName() == null ? this.getProductTypeName() == null
                        : that.getProductTypeName().equals(this.getProductTypeName()))) {
                return false;
        }
        if (that.getProductTypeParentId() != this.getProductTypeParentId()) {
                return false;
        }
        if (!(that.getProductTypeDescription() == null ? this.getProductTypeDescription() == null
                        : that.getProductTypeDescription().equals(this.getProductTypeDescription()))) {
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
