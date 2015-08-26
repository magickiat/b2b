
package com.starboard.b2b.entity;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class TmpOrders implements Serializable {
    
    /** Creates a new instance of TmpOrders */
    public TmpOrders() {
    }
    public TmpOrders(
            long orderId	
            , String orderCode	
            , String soCode	
            , long custId	
            , String custCode	
            , long memberId	
            , long brandGroupId	
            , java.math.BigDecimal discount	
            , java.math.BigDecimal price	
            , java.math.BigDecimal totalPrice	
            , java.math.BigDecimal shipPrice	
            , java.math.BigDecimal netPrice	
            , String productUnitId	
            , String trackId	
            , String shippingId	
            , String paymentId	
            , String paymentCurrencyId	
            , String paymentTermId	
            , String paymentMethodId	
            , String orderStatus	
            , java.sql.Timestamp orderDate	
            , java.sql.Timestamp expectShipmentDate	
            , String remarkCustomer	
            , String remarkOrders	
            , long importStatus	
            , String dtsSystem	
            , java.sql.Timestamp dtsUpdate	
        ) {
        this.orderId = orderId;	
        this.orderCode = orderCode;	
        this.soCode = soCode;	
        this.custId = custId;	
        this.custCode = custCode;	
        this.memberId = memberId;	
        this.brandGroupId = brandGroupId;	
        this.discount = discount;	
        this.price = price;	
        this.totalPrice = totalPrice;	
        this.shipPrice = shipPrice;	
        this.netPrice = netPrice;	
        this.productUnitId = productUnitId;	
        this.trackId = trackId;	
        this.shippingId = shippingId;	
        this.paymentId = paymentId;	
        this.paymentCurrencyId = paymentCurrencyId;	
        this.paymentTermId = paymentTermId;	
        this.paymentMethodId = paymentMethodId;	
        this.orderStatus = orderStatus;	
        this.orderDate = orderDate;	
        this.expectShipmentDate = expectShipmentDate;	
        this.remarkCustomer = remarkCustomer;	
        this.remarkOrders = remarkOrders;	
        this.importStatus = importStatus;	
        this.dtsSystem = dtsSystem;	
        this.dtsUpdate = dtsUpdate;	
    }
    private long orderId;	
    private String orderCode;	
    private String soCode;	
    private long custId;	
    private String custCode;	
    private long memberId;	
    private long brandGroupId;	
    private java.math.BigDecimal discount;	
    private java.math.BigDecimal price;	
    private java.math.BigDecimal totalPrice;	
    private java.math.BigDecimal shipPrice;	
    private java.math.BigDecimal netPrice;	
    private String productUnitId;	
    private String trackId;	
    private String shippingId;	
    private String paymentId;	
    private String paymentCurrencyId;	
    private String paymentTermId;	
    private String paymentMethodId;	
    private String orderStatus;	
    private java.sql.Timestamp orderDate;	
    private java.sql.Timestamp expectShipmentDate;	
    private String remarkCustomer;	
    private String remarkOrders;	
    private long importStatus;	
    private String dtsSystem;	
    private java.sql.Timestamp dtsUpdate;	



    public long getOrderId() {
        return this.orderId;
    }		
    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }
    public String getOrderCode() {
        return this.orderCode;
    }		
    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }
    public String getSoCode() {
        return this.soCode;
    }		
    public void setSoCode(String soCode) {
        this.soCode = soCode;
    }
    public long getCustId() {
        return this.custId;
    }		
    public void setCustId(long custId) {
        this.custId = custId;
    }
    public String getCustCode() {
        return this.custCode;
    }		
    public void setCustCode(String custCode) {
        this.custCode = custCode;
    }
    public long getMemberId() {
        return this.memberId;
    }		
    public void setMemberId(long memberId) {
        this.memberId = memberId;
    }
    public long getBrandGroupId() {
        return this.brandGroupId;
    }		
    public void setBrandGroupId(long brandGroupId) {
        this.brandGroupId = brandGroupId;
    }
    public java.math.BigDecimal getDiscount() {
        return this.discount;
    }		
    public void setDiscount(java.math.BigDecimal discount) {
        this.discount = discount;
    }
    public java.math.BigDecimal getPrice() {
        return this.price;
    }		
    public void setPrice(java.math.BigDecimal price) {
        this.price = price;
    }
    public java.math.BigDecimal getTotalPrice() {
        return this.totalPrice;
    }		
    public void setTotalPrice(java.math.BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
    public java.math.BigDecimal getShipPrice() {
        return this.shipPrice;
    }		
    public void setShipPrice(java.math.BigDecimal shipPrice) {
        this.shipPrice = shipPrice;
    }
    public java.math.BigDecimal getNetPrice() {
        return this.netPrice;
    }		
    public void setNetPrice(java.math.BigDecimal netPrice) {
        this.netPrice = netPrice;
    }
    public String getProductUnitId() {
        return this.productUnitId;
    }		
    public void setProductUnitId(String productUnitId) {
        this.productUnitId = productUnitId;
    }
    public String getTrackId() {
        return this.trackId;
    }		
    public void setTrackId(String trackId) {
        this.trackId = trackId;
    }
    public String getShippingId() {
        return this.shippingId;
    }		
    public void setShippingId(String shippingId) {
        this.shippingId = shippingId;
    }
    public String getPaymentId() {
        return this.paymentId;
    }		
    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }
    public String getPaymentCurrencyId() {
        return this.paymentCurrencyId;
    }		
    public void setPaymentCurrencyId(String paymentCurrencyId) {
        this.paymentCurrencyId = paymentCurrencyId;
    }
    public String getPaymentTermId() {
        return this.paymentTermId;
    }		
    public void setPaymentTermId(String paymentTermId) {
        this.paymentTermId = paymentTermId;
    }
    public String getPaymentMethodId() {
        return this.paymentMethodId;
    }		
    public void setPaymentMethodId(String paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }
    public String getOrderStatus() {
        return this.orderStatus;
    }		
    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
    public java.sql.Timestamp getOrderDate() {
        return this.orderDate;
    }		
    public void setOrderDate(java.sql.Timestamp orderDate) {
        this.orderDate = orderDate;
    }
    public java.sql.Timestamp getExpectShipmentDate() {
        return this.expectShipmentDate;
    }		
    public void setExpectShipmentDate(java.sql.Timestamp expectShipmentDate) {
        this.expectShipmentDate = expectShipmentDate;
    }
    public String getRemarkCustomer() {
        return this.remarkCustomer;
    }		
    public void setRemarkCustomer(String remarkCustomer) {
        this.remarkCustomer = remarkCustomer;
    }
    public String getRemarkOrders() {
        return this.remarkOrders;
    }		
    public void setRemarkOrders(String remarkOrders) {
        this.remarkOrders = remarkOrders;
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
        return super.toString() + "orderId=[" + orderId + "]\n" + "orderCode=[" + orderCode + "]\n" + "soCode=[" + soCode + "]\n" + "custId=[" + custId + "]\n" + "custCode=[" + custCode + "]\n" + "memberId=[" + memberId + "]\n" + "brandGroupId=[" + brandGroupId + "]\n" + "discount=[" + discount + "]\n" + "price=[" + price + "]\n" + "totalPrice=[" + totalPrice + "]\n" + "shipPrice=[" + shipPrice + "]\n" + "netPrice=[" + netPrice + "]\n" + "productUnitId=[" + productUnitId + "]\n" + "trackId=[" + trackId + "]\n" + "shippingId=[" + shippingId + "]\n" + "paymentId=[" + paymentId + "]\n" + "paymentCurrencyId=[" + paymentCurrencyId + "]\n" + "paymentTermId=[" + paymentTermId + "]\n" + "paymentMethodId=[" + paymentMethodId + "]\n" + "orderStatus=[" + orderStatus + "]\n" + "orderDate=[" + orderDate + "]\n" + "expectShipmentDate=[" + expectShipmentDate + "]\n" + "remarkCustomer=[" + remarkCustomer + "]\n" + "remarkOrders=[" + remarkOrders + "]\n" + "importStatus=[" + importStatus + "]\n" + "dtsSystem=[" + dtsSystem + "]\n" + "dtsUpdate=[" + dtsUpdate + "]\n";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof TmpOrders)) {
                return false;
        }
        TmpOrders that = (TmpOrders) obj;
        if (that.getOrderId() != this.getOrderId()) {
                return false;
        }
        if (!(that.getOrderCode() == null ? this.getOrderCode() == null
                        : that.getOrderCode().equals(this.getOrderCode()))) {
                return false;
        }
        if (!(that.getSoCode() == null ? this.getSoCode() == null
                        : that.getSoCode().equals(this.getSoCode()))) {
                return false;
        }
        if (that.getCustId() != this.getCustId()) {
                return false;
        }
        if (!(that.getCustCode() == null ? this.getCustCode() == null
                        : that.getCustCode().equals(this.getCustCode()))) {
                return false;
        }
        if (that.getMemberId() != this.getMemberId()) {
                return false;
        }
        if (that.getBrandGroupId() != this.getBrandGroupId()) {
                return false;
        }
        if (!(that.getDiscount() == null ? this.getDiscount() == null
                        : 0 == that.getDiscount().compareTo(this.getDiscount()))) {
                return false;
        }
        if (!(that.getPrice() == null ? this.getPrice() == null
                        : 0 == that.getPrice().compareTo(this.getPrice()))) {
                return false;
        }
        if (!(that.getTotalPrice() == null ? this.getTotalPrice() == null
                        : 0 == that.getTotalPrice().compareTo(this.getTotalPrice()))) {
                return false;
        }
        if (!(that.getShipPrice() == null ? this.getShipPrice() == null
                        : 0 == that.getShipPrice().compareTo(this.getShipPrice()))) {
                return false;
        }
        if (!(that.getNetPrice() == null ? this.getNetPrice() == null
                        : 0 == that.getNetPrice().compareTo(this.getNetPrice()))) {
                return false;
        }
        if (!(that.getProductUnitId() == null ? this.getProductUnitId() == null
                        : that.getProductUnitId().equals(this.getProductUnitId()))) {
                return false;
        }
        if (!(that.getTrackId() == null ? this.getTrackId() == null
                        : that.getTrackId().equals(this.getTrackId()))) {
                return false;
        }
        if (!(that.getShippingId() == null ? this.getShippingId() == null
                        : that.getShippingId().equals(this.getShippingId()))) {
                return false;
        }
        if (!(that.getPaymentId() == null ? this.getPaymentId() == null
                        : that.getPaymentId().equals(this.getPaymentId()))) {
                return false;
        }
        if (!(that.getPaymentCurrencyId() == null ? this.getPaymentCurrencyId() == null
                        : that.getPaymentCurrencyId().equals(this.getPaymentCurrencyId()))) {
                return false;
        }
        if (!(that.getPaymentTermId() == null ? this.getPaymentTermId() == null
                        : that.getPaymentTermId().equals(this.getPaymentTermId()))) {
                return false;
        }
        if (!(that.getPaymentMethodId() == null ? this.getPaymentMethodId() == null
                        : that.getPaymentMethodId().equals(this.getPaymentMethodId()))) {
                return false;
        }
        if (!(that.getOrderStatus() == null ? this.getOrderStatus() == null
                        : that.getOrderStatus().equals(this.getOrderStatus()))) {
                return false;
        }
        if (!(that.getOrderDate() == null ? this.getOrderDate() == null
                        : that.getOrderDate().equals(this.getOrderDate()))) {
                return false;
        }
        if (!(that.getExpectShipmentDate() == null ? this.getExpectShipmentDate() == null
                        : that.getExpectShipmentDate().equals(this.getExpectShipmentDate()))) {
                return false;
        }
        if (!(that.getRemarkCustomer() == null ? this.getRemarkCustomer() == null
                        : that.getRemarkCustomer().equals(this.getRemarkCustomer()))) {
                return false;
        }
        if (!(that.getRemarkOrders() == null ? this.getRemarkOrders() == null
                        : that.getRemarkOrders().equals(this.getRemarkOrders()))) {
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
