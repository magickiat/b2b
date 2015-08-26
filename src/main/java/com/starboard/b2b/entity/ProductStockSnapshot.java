
package com.starboard.b2b.entity;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class ProductStockSnapshot implements Serializable {
    
    /** Creates a new instance of ProductStockSnapshot */
    public ProductStockSnapshot() {
    }
    public ProductStockSnapshot(
            long productStockSnapshotId	
            , String productCode	
            , String custCode	
            , java.math.BigDecimal amount	
            , java.sql.Timestamp asOf	
            , java.math.BigDecimal ontransit	
            , java.math.BigDecimal onorder	
            , String userCreate	
            , String userUpdate	
            , java.sql.Timestamp timeCreate	
            , java.sql.Timestamp timeUpdate	
        ) {
        this.productStockSnapshotId = productStockSnapshotId;	
        this.productCode = productCode;	
        this.custCode = custCode;	
        this.amount = amount;	
        this.asOf = asOf;	
        this.ontransit = ontransit;	
        this.onorder = onorder;	
        this.userCreate = userCreate;	
        this.userUpdate = userUpdate;	
        this.timeCreate = timeCreate;	
        this.timeUpdate = timeUpdate;	
    }
    private long productStockSnapshotId;	
    private String productCode;	
    private String custCode;	
    private java.math.BigDecimal amount;	
    private java.sql.Timestamp asOf;	
    private java.math.BigDecimal ontransit;	
    private java.math.BigDecimal onorder;	
    private String userCreate;	
    private String userUpdate;	
    private java.sql.Timestamp timeCreate;	
    private java.sql.Timestamp timeUpdate;	



    public long getProductStockSnapshotId() {
        return this.productStockSnapshotId;
    }		
    public void setProductStockSnapshotId(long productStockSnapshotId) {
        this.productStockSnapshotId = productStockSnapshotId;
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
    public java.math.BigDecimal getOntransit() {
        return this.ontransit;
    }		
    public void setOntransit(java.math.BigDecimal ontransit) {
        this.ontransit = ontransit;
    }
    public java.math.BigDecimal getOnorder() {
        return this.onorder;
    }		
    public void setOnorder(java.math.BigDecimal onorder) {
        this.onorder = onorder;
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
        return super.toString() + "productStockSnapshotId=[" + productStockSnapshotId + "]\n" + "productCode=[" + productCode + "]\n" + "custCode=[" + custCode + "]\n" + "amount=[" + amount + "]\n" + "asOf=[" + asOf + "]\n" + "ontransit=[" + ontransit + "]\n" + "onorder=[" + onorder + "]\n" + "userCreate=[" + userCreate + "]\n" + "userUpdate=[" + userUpdate + "]\n" + "timeCreate=[" + timeCreate + "]\n" + "timeUpdate=[" + timeUpdate + "]\n";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof ProductStockSnapshot)) {
                return false;
        }
        ProductStockSnapshot that = (ProductStockSnapshot) obj;
        if (that.getProductStockSnapshotId() != this.getProductStockSnapshotId()) {
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
        if (!(that.getOntransit() == null ? this.getOntransit() == null
                        : 0 == that.getOntransit().compareTo(this.getOntransit()))) {
                return false;
        }
        if (!(that.getOnorder() == null ? this.getOnorder() == null
                        : 0 == that.getOnorder().compareTo(this.getOnorder()))) {
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
