
package com.starboard.b2b.entity;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class TmpOrdDetail implements Serializable {
    
    /** Creates a new instance of TmpOrdDetail */
    public TmpOrdDetail() {
    }
    public TmpOrdDetail(
            long orderProductId	
            , long orderId	
            , long productId	
            , long amount	
            , long status	
            , java.math.BigDecimal price	
            , String productUnitId	
            , String productBuyerGroupId	
            , String productCurrency	
            , long importStatus	
            , String dtsSystem	
            , java.sql.Timestamp dtsUpdate	
        ) {
        this.orderProductId = orderProductId;	
        this.orderId = orderId;	
        this.productId = productId;	
        this.amount = amount;	
        this.status = status;	
        this.price = price;	
        this.productUnitId = productUnitId;	
        this.productBuyerGroupId = productBuyerGroupId;	
        this.productCurrency = productCurrency;	
        this.importStatus = importStatus;	
        this.dtsSystem = dtsSystem;	
        this.dtsUpdate = dtsUpdate;	
    }
    private long orderProductId;	
    private long orderId;	
    private long productId;	
    private long amount;	
    private long status;	
    private java.math.BigDecimal price;	
    private String productUnitId;	
    private String productBuyerGroupId;	
    private String productCurrency;	
    private long importStatus;	
    private String dtsSystem;	
    private java.sql.Timestamp dtsUpdate;	



    public long getOrderProductId() {
        return this.orderProductId;
    }		
    public void setOrderProductId(long orderProductId) {
        this.orderProductId = orderProductId;
    }
    public long getOrderId() {
        return this.orderId;
    }		
    public void setOrderId(long orderId) {
        this.orderId = orderId;
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
    public long getStatus() {
        return this.status;
    }		
    public void setStatus(long status) {
        this.status = status;
    }
    public java.math.BigDecimal getPrice() {
        return this.price;
    }		
    public void setPrice(java.math.BigDecimal price) {
        this.price = price;
    }
    public String getProductUnitId() {
        return this.productUnitId;
    }		
    public void setProductUnitId(String productUnitId) {
        this.productUnitId = productUnitId;
    }
    public String getProductBuyerGroupId() {
        return this.productBuyerGroupId;
    }		
    public void setProductBuyerGroupId(String productBuyerGroupId) {
        this.productBuyerGroupId = productBuyerGroupId;
    }
    public String getProductCurrency() {
        return this.productCurrency;
    }		
    public void setProductCurrency(String productCurrency) {
        this.productCurrency = productCurrency;
    }
    public long getImportStatus() {
        return this.importStatus;
    }		
    public void setImportStatus(long importStatus) {
        this.importStatus = importStatus;
    }
    public String getDtsSystem() {
        return this.dtsSystem;
    }		
    public void setDtsSystem(String dtsSystem) {
        this.dtsSystem = dtsSystem;
    }
    public java.sql.Timestamp getDtsUpdate() {
        return this.dtsUpdate;
    }		
    public void setDtsUpdate(java.sql.Timestamp dtsUpdate) {
        this.dtsUpdate = dtsUpdate;
    }



    public String toString() {
        return super.toString() + "orderProductId=[" + orderProductId + "]\n" + "orderId=[" + orderId + "]\n" + "productId=[" + productId + "]\n" + "amount=[" + amount + "]\n" + "status=[" + status + "]\n" + "price=[" + price + "]\n" + "productUnitId=[" + productUnitId + "]\n" + "productBuyerGroupId=[" + productBuyerGroupId + "]\n" + "productCurrency=[" + productCurrency + "]\n" + "importStatus=[" + importStatus + "]\n" + "dtsSystem=[" + dtsSystem + "]\n" + "dtsUpdate=[" + dtsUpdate + "]\n";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof TmpOrdDetail)) {
                return false;
        }
        TmpOrdDetail that = (TmpOrdDetail) obj;
        if (that.getOrderProductId() != this.getOrderProductId()) {
                return false;
        }
        if (that.getOrderId() != this.getOrderId()) {
                return false;
        }
        if (that.getProductId() != this.getProductId()) {
                return false;
        }
        if (that.getAmount() != this.getAmount()) {
                return false;
        }
        if (that.getStatus() != this.getStatus()) {
                return false;
        }
        if (!(that.getPrice() == null ? this.getPrice() == null
                        : 0 == that.getPrice().compareTo(this.getPrice()))) {
                return false;
        }
        if (!(that.getProductUnitId() == null ? this.getProductUnitId() == null
                        : that.getProductUnitId().equals(this.getProductUnitId()))) {
                return false;
        }
        if (!(that.getProductBuyerGroupId() == null ? this.getProductBuyerGroupId() == null
                        : that.getProductBuyerGroupId().equals(this.getProductBuyerGroupId()))) {
                return false;
        }
        if (!(that.getProductCurrency() == null ? this.getProductCurrency() == null
                        : that.getProductCurrency().equals(this.getProductCurrency()))) {
                return false;
        }
        if (that.getImportStatus() != this.getImportStatus()) {
                return false;
        }
        if (!(that.getDtsSystem() == null ? this.getDtsSystem() == null
                        : that.getDtsSystem().equals(this.getDtsSystem()))) {
                return false;
        }
        if (!(that.getDtsUpdate() == null ? this.getDtsUpdate() == null
                        : that.getDtsUpdate().equals(this.getDtsUpdate()))) {
                return false;
        }
    return true;
    }

}
