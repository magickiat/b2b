
package com.starboard.b2b.dto.original;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class ProductSoCategory implements Serializable {
    
    /** Creates a new instance of ProductSoCategory */
    public ProductSoCategory() {
    }
    public ProductSoCategory(
            String soCategory	
            , String site	
            , String warehouse	
            , String saleOrderCat	
            , String email	
            , String userCreate	
            , String userUpdate	
            , java.sql.Timestamp timeCreate	
            , java.sql.Timestamp timeUpdate	
        ) {
        this.soCategory = soCategory;	
        this.site = site;	
        this.warehouse = warehouse;	
        this.saleOrderCat = saleOrderCat;	
        this.email = email;	
        this.userCreate = userCreate;	
        this.userUpdate = userUpdate;	
        this.timeCreate = timeCreate;	
        this.timeUpdate = timeUpdate;	
    }
    private String soCategory;	
    private String site;	
    private String warehouse;	
    private String saleOrderCat;	
    private String email;	
    private String userCreate;	
    private String userUpdate;	
    private java.sql.Timestamp timeCreate;	
    private java.sql.Timestamp timeUpdate;	



    public String getSoCategory() {
        return this.soCategory;
    }		
    public void setSoCategory(String soCategory) {
        this.soCategory = soCategory;
    }
    public String getSite() {
        return this.site;
    }		
    public void setSite(String site) {
        this.site = site;
    }
    public String getWarehouse() {
        return this.warehouse;
    }		
    public void setWarehouse(String warehouse) {
        this.warehouse = warehouse;
    }
    public String getSaleOrderCat() {
        return this.saleOrderCat;
    }		
    public void setSaleOrderCat(String saleOrderCat) {
        this.saleOrderCat = saleOrderCat;
    }
    public String getEmail() {
        return this.email;
    }		
    public void setEmail(String email) {
        this.email = email;
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
        return super.toString() + "soCategory=[" + soCategory + "]\n" + "site=[" + site + "]\n" + "warehouse=[" + warehouse + "]\n" + "saleOrderCat=[" + saleOrderCat + "]\n" + "email=[" + email + "]\n" + "userCreate=[" + userCreate + "]\n" + "userUpdate=[" + userUpdate + "]\n" + "timeCreate=[" + timeCreate + "]\n" + "timeUpdate=[" + timeUpdate + "]\n";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof ProductSoCategory)) {
                return false;
        }
        ProductSoCategory that = (ProductSoCategory) obj;
        if (!(that.getSoCategory() == null ? this.getSoCategory() == null
                        : that.getSoCategory().equals(this.getSoCategory()))) {
                return false;
        }
        if (!(that.getSite() == null ? this.getSite() == null
                        : that.getSite().equals(this.getSite()))) {
                return false;
        }
        if (!(that.getWarehouse() == null ? this.getWarehouse() == null
                        : that.getWarehouse().equals(this.getWarehouse()))) {
                return false;
        }
        if (!(that.getSaleOrderCat() == null ? this.getSaleOrderCat() == null
                        : that.getSaleOrderCat().equals(this.getSaleOrderCat()))) {
                return false;
        }
        if (!(that.getEmail() == null ? this.getEmail() == null
                        : that.getEmail().equals(this.getEmail()))) {
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
