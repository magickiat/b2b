
package com.starboard.b2b.dto.original;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class ProductBuyerGroup implements  Serializable  {
    
    /** Creates a new instance of ProductBuyerGroup */
    public ProductBuyerGroup() {
    }
    
    public ProductBuyerGroup(
            String productBuyerGroupId	
            , String productBuyerGroupName	
            , String description	
            , String userCreate	
            , String userUpdate	
            , java.sql.Timestamp timeCreate	
            , java.sql.Timestamp timeUpdate	
        ) {
        this.productBuyerGroupId = productBuyerGroupId;	
        this.productBuyerGroupName = productBuyerGroupName;	
        this.description = description;	
        this.userCreate = userCreate;	
        this.userUpdate = userUpdate;	
        this.timeCreate = timeCreate;	
        this.timeUpdate = timeUpdate;	
    }
    
    
    private String productBuyerGroupId;	
    private String productBuyerGroupName;	
    private String description;	
    private String userCreate;	
    private String userUpdate;	
    private int seq;
    private java.sql.Timestamp timeCreate;	
    private java.sql.Timestamp timeUpdate;	


    

    public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getProductBuyerGroupId() {
        return this.productBuyerGroupId;
    }		
    public void setProductBuyerGroupId(String productBuyerGroupId) {
        this.productBuyerGroupId = productBuyerGroupId;
    }
    public String getProductBuyerGroupName() {
        return this.productBuyerGroupName;
    }		
    public void setProductBuyerGroupName(String productBuyerGroupName) {
        this.productBuyerGroupName = productBuyerGroupName;
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
        return super.toString() + "productBuyerGroupId=[" + productBuyerGroupId + "]\n" + "productBuyerGroupName=[" + productBuyerGroupName + "]\n" + "description=[" + description + "]\n" + "userCreate=[" + userCreate + "]\n" + "userUpdate=[" + userUpdate + "]\n" + "timeCreate=[" + timeCreate + "]\n" + "timeUpdate=[" + timeUpdate + "]\n";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof ProductBuyerGroup)) {
                return false;
        }
        ProductBuyerGroup that = (ProductBuyerGroup) obj;
        if (!(that.getProductBuyerGroupId() == null ? this.getProductBuyerGroupId() == null
                        : that.getProductBuyerGroupId().equals(this.getProductBuyerGroupId()))) {
                return false;
        }
        if (!(that.getProductBuyerGroupName() == null ? this.getProductBuyerGroupName() == null
                        : that.getProductBuyerGroupName().equals(this.getProductBuyerGroupName()))) {
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
