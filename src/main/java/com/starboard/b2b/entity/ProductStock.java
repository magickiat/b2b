
package com.starboard.b2b.entity;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class ProductStock implements Serializable {
    
    /** Creates a new instance of ProductStock */
    public ProductStock() {
    }
    public ProductStock(
            long productStockId	
            , String productCode	
            , String custCode	
            , java.math.BigDecimal amount	
            , java.sql.Timestamp asOf	
            , String userCreate	
            , String userUpdate	
            , java.sql.Timestamp timeCreate	
            , java.sql.Timestamp timeUpdate	
        ) {
        this.productStockId = productStockId;	
        this.productCode = productCode;	
        this.custCode = custCode;	
        this.amount = amount;	
        this.asOf = asOf;	
        this.userCreate = userCreate;	
        this.userUpdate = userUpdate;	
        this.timeCreate = timeCreate;	
        this.timeUpdate = timeUpdate;	
    }
    private long productStockId;	
    private String productCode;	
    private String custCode;	
    private java.math.BigDecimal amount;	
    private java.sql.Timestamp asOf;	
    private String userCreate;	
    private String userUpdate;	
    private java.sql.Timestamp timeCreate;	
    private java.sql.Timestamp timeUpdate;	



    public long getProductStockId() {
        return this.productStockId;
    }		
    public void setProductStockId(long productStockId) {
        this.productStockId = productStockId;
    }
    public String getProductCode() {
        return this.productCode;
    }		
    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }
    public String getCustCode() {
        return this.custCode;
    }		
    public void setCustCode(String custCode) {
        this.custCode = custCode;
    }
    public java.math.BigDecimal getAmount() {
        return this.amount;
    }		
    public void setAmount(java.math.BigDecimal amount) {
        this.amount = amount;
    }
    public java.sql.Timestamp getAsOf() {
        return this.asOf;
    }		
    public void setAsOf(java.sql.Timestamp asOf) {
        this.asOf = asOf;
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
        return super.toString() + "productStockId=[" + productStockId + "]\n" + "productCode=[" + productCode + "]\n" + "custCode=[" + custCode + "]\n" + "amount=[" + amount + "]\n" + "asOf=[" + asOf + "]\n" + "userCreate=[" + userCreate + "]\n" + "userUpdate=[" + userUpdate + "]\n" + "timeCreate=[" + timeCreate + "]\n" + "timeUpdate=[" + timeUpdate + "]\n";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof ProductStock)) {
                return false;
        }
        ProductStock that = (ProductStock) obj;
        if (that.getProductStockId() != this.getProductStockId()) {
                return false;
        }
        if (!(that.getProductCode() == null ? this.getProductCode() == null
                        : that.getProductCode().equals(this.getProductCode()))) {
                return false;
        }
        if (!(that.getCustCode() == null ? this.getCustCode() == null
                        : that.getCustCode().equals(this.getCustCode()))) {
                return false;
        }
        if (!(that.getAmount() == null ? this.getAmount() == null
                        : 0 == that.getAmount().compareTo(this.getAmount()))) {
                return false;
        }
        if (!(that.getAsOf() == null ? this.getAsOf() == null
                        : that.getAsOf().equals(this.getAsOf()))) {
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
