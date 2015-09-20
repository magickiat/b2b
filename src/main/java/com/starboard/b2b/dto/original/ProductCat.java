
package com.starboard.b2b.dto.original;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class ProductCat implements Serializable {
    
    /** Creates a new instance of ProductCat */
    public ProductCat() {
    }
    public ProductCat(
            long productCatId	
            , String productCatName	
            , long productCatParentId	
            , String productCatDescription	
            , String userCreate	
            , String userUpdate	
            , java.sql.Timestamp timeCreate	
            , java.sql.Timestamp timeUpdate	
        ) {
        this.productCatId = productCatId;	
        this.productCatName = productCatName;	
        this.productCatParentId = productCatParentId;	
        this.productCatDescription = productCatDescription;	
        this.userCreate = userCreate;	
        this.userUpdate = userUpdate;	
        this.timeCreate = timeCreate;	
        this.timeUpdate = timeUpdate;	
    }
    private long productCatId;	
    private String productCatName;	
    private long productCatParentId;	
    private String productCatDescription;	
    private String userCreate;	
    private String userUpdate;	
    private java.sql.Timestamp timeCreate;	
    private java.sql.Timestamp timeUpdate;	



    public long getProductCatId() {
        return this.productCatId;
    }		
    public void setProductCatId(long productCatId) {
        this.productCatId = productCatId;
    }
    public String getProductCatName() {
        return this.productCatName;
    }		
    public void setProductCatName(String productCatName) {
        this.productCatName = productCatName;
    }
    public long getProductCatParentId() {
        return this.productCatParentId;
    }		
    public void setProductCatParentId(long productCatParentId) {
        this.productCatParentId = productCatParentId;
    }
    public String getProductCatDescription() {
        return this.productCatDescription;
    }		
    public void setProductCatDescription(String productCatDescription) {
        this.productCatDescription = productCatDescription;
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
        return super.toString() + "productCatId=[" + productCatId + "]\n" + "productCatName=[" + productCatName + "]\n" + "productCatParentId=[" + productCatParentId + "]\n" + "productCatDescription=[" + productCatDescription + "]\n" + "userCreate=[" + userCreate + "]\n" + "userUpdate=[" + userUpdate + "]\n" + "timeCreate=[" + timeCreate + "]\n" + "timeUpdate=[" + timeUpdate + "]\n";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof ProductCat)) {
                return false;
        }
        ProductCat that = (ProductCat) obj;
        if (that.getProductCatId() != this.getProductCatId()) {
                return false;
        }
        if (!(that.getProductCatName() == null ? this.getProductCatName() == null
                        : that.getProductCatName().equals(this.getProductCatName()))) {
                return false;
        }
        if (that.getProductCatParentId() != this.getProductCatParentId()) {
                return false;
        }
        if (!(that.getProductCatDescription() == null ? this.getProductCatDescription() == null
                        : that.getProductCatDescription().equals(this.getProductCatDescription()))) {
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
