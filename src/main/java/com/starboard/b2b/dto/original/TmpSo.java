
package com.starboard.b2b.dto.original;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class TmpSo implements Serializable {
    
    /** Creates a new instance of TmpSo */
    public TmpSo() {
    }
    public TmpSo(
            long runningNo	
            , long orderProductId	
            , String soNo	
            , String itemCode	
            , String roCode	
            , long amount	
            , String productBuyerGroupId	
            , java.math.BigDecimal price	
            , String productCurrency	
            , String productUnitId	
            , String shippingId	
            , String termCode	
            , String paymentMethodId	
            , java.sql.Timestamp expectShipmentDate	
            , long importStatus	
            , String dtsSystem	
            , java.sql.Timestamp dtsUpdate	
        ) {
        this.runningNo = runningNo;	
        this.orderProductId = orderProductId;	
        this.soNo = soNo;	
        this.itemCode = itemCode;	
        this.roCode = roCode;	
        this.amount = amount;	
        this.productBuyerGroupId = productBuyerGroupId;	
        this.price = price;	
        this.productCurrency = productCurrency;	
        this.productUnitId = productUnitId;	
        this.shippingId = shippingId;	
        this.termCode = termCode;	
        this.paymentMethodId = paymentMethodId;	
        this.expectShipmentDate = expectShipmentDate;	
        this.importStatus = importStatus;	
        this.dtsSystem = dtsSystem;	
        this.dtsUpdate = dtsUpdate;	
    }
    private long runningNo;	
    private long orderProductId;	
    private String soNo;	
    private String itemCode;	
    private String roCode;	
    private long amount;	
    private String productBuyerGroupId;	
    private java.math.BigDecimal price;	
    private String productCurrency;	
    private String productUnitId;	
    private String shippingId;	
    private String termCode;	
    private String paymentMethodId;	
    private java.sql.Timestamp expectShipmentDate;	
    private long importStatus;	
    private String dtsSystem;	
    private java.sql.Timestamp dtsUpdate;	



    public long getRunningNo() {
        return this.runningNo;
    }		
    public void setRunningNo(long runningNo) {
        this.runningNo = runningNo;
    }
    public long getOrderProductId() {
        return this.orderProductId;
    }		
    public void setOrderProductId(long orderProductId) {
        this.orderProductId = orderProductId;
    }
    public String getSoNo() {
        return this.soNo;
    }		
    public void setSoNo(String soNo) {
        this.soNo = soNo;
    }
    public String getItemCode() {
        return this.itemCode;
    }		
    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }
    public String getRoCode() {
        return this.roCode;
    }		
    public void setRoCode(String roCode) {
        this.roCode = roCode;
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
    public String getShippingId() {
        return this.shippingId;
    }		
    public void setShippingId(String shippingId) {
        this.shippingId = shippingId;
    }
    public String getTermCode() {
        return this.termCode;
    }		
    public void setTermCode(String termCode) {
        this.termCode = termCode;
    }
    public String getPaymentMethodId() {
        return this.paymentMethodId;
    }		
    public void setPaymentMethodId(String paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }
    public java.sql.Timestamp getExpectShipmentDate() {
        return this.expectShipmentDate;
    }		
    public void setExpectShipmentDate(java.sql.Timestamp expectShipmentDate) {
        this.expectShipmentDate = expectShipmentDate;
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
        return super.toString() + "runningNo=[" + runningNo + "]\n" + "orderProductId=[" + orderProductId + "]\n" + "soNo=[" + soNo + "]\n" + "itemCode=[" + itemCode + "]\n" + "roCode=[" + roCode + "]\n" + "amount=[" + amount + "]\n" + "productBuyerGroupId=[" + productBuyerGroupId + "]\n" + "price=[" + price + "]\n" + "productCurrency=[" + productCurrency + "]\n" + "productUnitId=[" + productUnitId + "]\n" + "shippingId=[" + shippingId + "]\n" + "termCode=[" + termCode + "]\n" + "paymentMethodId=[" + paymentMethodId + "]\n" + "expectShipmentDate=[" + expectShipmentDate + "]\n" + "importStatus=[" + importStatus + "]\n" + "dtsSystem=[" + dtsSystem + "]\n" + "dtsUpdate=[" + dtsUpdate + "]\n";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof TmpSo)) {
                return false;
        }
        TmpSo that = (TmpSo) obj;
        if (that.getRunningNo() != this.getRunningNo()) {
                return false;
        }
        if (that.getOrderProductId() != this.getOrderProductId()) {
                return false;
        }
        if (!(that.getSoNo() == null ? this.getSoNo() == null
                        : that.getSoNo().equals(this.getSoNo()))) {
                return false;
        }
        if (!(that.getItemCode() == null ? this.getItemCode() == null
                        : that.getItemCode().equals(this.getItemCode()))) {
                return false;
        }
        if (!(that.getRoCode() == null ? this.getRoCode() == null
                        : that.getRoCode().equals(this.getRoCode()))) {
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
        if (!(that.getShippingId() == null ? this.getShippingId() == null
                        : that.getShippingId().equals(this.getShippingId()))) {
                return false;
        }
        if (!(that.getTermCode() == null ? this.getTermCode() == null
                        : that.getTermCode().equals(this.getTermCode()))) {
                return false;
        }
        if (!(that.getPaymentMethodId() == null ? this.getPaymentMethodId() == null
                        : that.getPaymentMethodId().equals(this.getPaymentMethodId()))) {
                return false;
        }
        if (!(that.getExpectShipmentDate() == null ? this.getExpectShipmentDate() == null
                        : that.getExpectShipmentDate().equals(this.getExpectShipmentDate()))) {
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
