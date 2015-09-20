
package com.starboard.b2b.dto.original;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class SoDetail implements Serializable {
    
    /** Creates a new instance of SoDetail */
    public SoDetail() {
    }
    public SoDetail(
            long soProductId	
            , long orderProductId	
            , long soId	
            , long productId	
            , long amount	
            , String productBuyerGroupId	
            , java.math.BigDecimal price	
            , String productCurrency	
            , String productUnitId	
            , String userCreate	
            , String userUpdate	
            , java.sql.Timestamp timeCreate	
            , java.sql.Timestamp timeUpdate	
        ) {
        this.soProductId = soProductId;	
        this.orderProductId = orderProductId;	
        this.soId = soId;	
        this.productId = productId;	
        this.amount = amount;	
        this.productBuyerGroupId = productBuyerGroupId;	
        this.price = price;	
        this.productCurrency = productCurrency;	
        this.productUnitId = productUnitId;	
        this.userCreate = userCreate;	
        this.userUpdate = userUpdate;	
        this.timeCreate = timeCreate;	
        this.timeUpdate = timeUpdate;	
    }
    private long soProductId;	
    private long orderProductId;	
    private long soId;	
    private long productId;	
    private long amount;	
    private String productBuyerGroupId;	
    private java.math.BigDecimal price;	
    private String productCurrency;	
    private String productUnitId;	
    private String userCreate;	
    private String userUpdate;	
    private java.sql.Timestamp timeCreate;	
    private java.sql.Timestamp timeUpdate;	



    public long getSoProductId() {
        return this.soProductId;
    }		
    public void setSoProductId(long soProductId) {
        this.soProductId = soProductId;
    }
    public long getOrderProductId() {
        return this.orderProductId;
    }		
    public void setOrderProductId(long orderProductId) {
        this.orderProductId = orderProductId;
    }
    public long getSoId() {
        return this.soId;
    }		
    public void setSoId(long soId) {
        this.soId = soId;
    }
    public long getProductId() {
        return this.productId;
    }		
    public void setProductId(long productId) {
        this.productId = productId;
    }
    public long getAmount() {
        return this.amount;
    }		
    public void setAmount(long amount) {
        this.amount = amount;
    }
    public String getProductBuyerGroupId() {
        return this.productBuyerGroupId;
    }		
    public void setProductBuyerGroupId(String productBuyerGroupId) {
        this.productBuyerGroupId = productBuyerGroupId;
    }
    public java.math.BigDecimal getPrice() {
        return this.price;
    }		
    public void setPrice(java.math.BigDecimal price) {
        this.price = price;
    }
    public String getProductCurrency() {
        return this.productCurrency;
    }		
    public void setProductCurrency(String productCurrency) {
        this.productCurrency = productCurrency;
    }
    public String getProductUnitId() {
        return this.productUnitId;
    }		
    public void setProductUnitId(String productUnitId) {
        this.productUnitId = productUnitId;
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
        return super.toString() + "soProductId=[" + soProductId + "]\n" + "orderProductId=[" + orderProductId + "]\n" + "soId=[" + soId + "]\n" + "productId=[" + productId + "]\n" + "amount=[" + amount + "]\n" + "productBuyerGroupId=[" + productBuyerGroupId + "]\n" + "price=[" + price + "]\n" + "productCurrency=[" + productCurrency + "]\n" + "productUnitId=[" + productUnitId + "]\n" + "userCreate=[" + userCreate + "]\n" + "userUpdate=[" + userUpdate + "]\n" + "timeCreate=[" + timeCreate + "]\n" + "timeUpdate=[" + timeUpdate + "]\n";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof SoDetail)) {
                return false;
        }
        SoDetail that = (SoDetail) obj;
        if (that.getSoProductId() != this.getSoProductId()) {
                return false;
        }
        if (that.getOrderProductId() != this.getOrderProductId()) {
                return false;
        }
        if (that.getSoId() != this.getSoId()) {
                return false;
        }
        if (that.getProductId() != this.getProductId()) {
                return false;
        }
        if (that.getAmount() != this.getAmount()) {
                return false;
        }
        if (!(that.getProductBuyerGroupId() == null ? this.getProductBuyerGroupId() == null
                        : that.getProductBuyerGroupId().equals(this.getProductBuyerGroupId()))) {
                return false;
        }
        if (!(that.getPrice() == null ? this.getPrice() == null
                        : 0 == that.getPrice().compareTo(this.getPrice()))) {
                return false;
        }
        if (!(that.getProductCurrency() == null ? this.getProductCurrency() == null
                        : that.getProductCurrency().equals(this.getProductCurrency()))) {
                return false;
        }
        if (!(that.getProductUnitId() == null ? this.getProductUnitId() == null
                        : that.getProductUnitId().equals(this.getProductUnitId()))) {
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
