
package com.starboard.b2b.entity;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class CustPriceGroup implements Serializable {
    
    /** Creates a new instance of CustPriceGroup */
    public CustPriceGroup() {
    }
    public CustPriceGroup(
            long custPriceGroupId	
            , String custCode	
            , long productTypeId	
            , String productBuyerGroupId	
            , String userCreate	
            , String userUpdate	
            , java.sql.Timestamp timeCreate	
            , java.sql.Timestamp timeUpdate	
        ) {
        this.custPriceGroupId = custPriceGroupId;	
        this.custCode = custCode;	
        this.productTypeId = productTypeId;	
        this.productBuyerGroupId = productBuyerGroupId;	
        this.userCreate = userCreate;	
        this.userUpdate = userUpdate;	
        this.timeCreate = timeCreate;	
        this.timeUpdate = timeUpdate;	
    }
    private long custPriceGroupId;	
    private String custCode;	
    private long productTypeId;	
    private String productBuyerGroupId;	
    private String userCreate;	
    private String userUpdate;	
    private java.sql.Timestamp timeCreate;	
    private java.sql.Timestamp timeUpdate;	



    public long getCustPriceGroupId() {
        return this.custPriceGroupId;
    }		
    public void setCustPriceGroupId(long custPriceGroupId) {
        this.custPriceGroupId = custPriceGroupId;
    }
    public String getCustCode() {
        return this.custCode;
    }		
    public void setCustCode(String custCode) {
        this.custCode = custCode;
    }
    public long getProductTypeId() {
        return this.productTypeId;
    }		
    public void setProductTypeId(long productTypeId) {
        this.productTypeId = productTypeId;
    }
    public String getProductBuyerGroupId() {
        return this.productBuyerGroupId;
    }		
    public void setProductBuyerGroupId(String productBuyerGroupId) {
        this.productBuyerGroupId = productBuyerGroupId;
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
        return super.toString() + "custPriceGroupId=[" + custPriceGroupId + "]\n" + "custCode=[" + custCode + "]\n" + "productTypeId=[" + productTypeId + "]\n" + "productBuyerGroupId=[" + productBuyerGroupId + "]\n" + "userCreate=[" + userCreate + "]\n" + "userUpdate=[" + userUpdate + "]\n" + "timeCreate=[" + timeCreate + "]\n" + "timeUpdate=[" + timeUpdate + "]\n";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof CustPriceGroup)) {
                return false;
        }
        CustPriceGroup that = (CustPriceGroup) obj;
        if (that.getCustPriceGroupId() != this.getCustPriceGroupId()) {
                return false;
        }
        if (!(that.getCustCode() == null ? this.getCustCode() == null
                        : that.getCustCode().equals(this.getCustCode()))) {
                return false;
        }
        if (that.getProductTypeId() != this.getProductTypeId()) {
                return false;
        }
        if (!(that.getProductBuyerGroupId() == null ? this.getProductBuyerGroupId() == null
                        : that.getProductBuyerGroupId().equals(this.getProductBuyerGroupId()))) {
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
