
package com.starboard.b2b.entity;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class TmpInvoice implements Serializable {
    
    /** Creates a new instance of TmpInvoice */
    public TmpInvoice() {
    }
    public TmpInvoice(
            long runningNo	
            , long orderProductId	
            , String invoiceNo	
            , String soNo	
            , String itemCode	
            , long amount	
            , String productBuyerGroupId	
            , java.math.BigDecimal price	
            , String productCurrency	
            , String productUnitId	
            , java.sql.Timestamp invoiceDate	
            , java.sql.Timestamp invoiceEtd	
            , java.sql.Timestamp invoiceEta	
            , long importStatus	
            , String dtsSystem	
            , java.sql.Timestamp dtsUpdate	
        ) {
        this.runningNo = runningNo;	
        this.orderProductId = orderProductId;	
        this.invoiceNo = invoiceNo;	
        this.soNo = soNo;	
        this.itemCode = itemCode;	
        this.amount = amount;	
        this.productBuyerGroupId = productBuyerGroupId;	
        this.price = price;	
        this.productCurrency = productCurrency;	
        this.productUnitId = productUnitId;	
        this.invoiceDate = invoiceDate;	
        this.invoiceEtd = invoiceEtd;	
        this.invoiceEta = invoiceEta;	
        this.importStatus = importStatus;	
        this.dtsSystem = dtsSystem;	
        this.dtsUpdate = dtsUpdate;	
    }
    private long runningNo;	
    private long orderProductId;	
    private String invoiceNo;	
    private String soNo;	
    private String itemCode;	
    private long amount;	
    private String productBuyerGroupId;	
    private java.math.BigDecimal price;	
    private String productCurrency;	
    private String productUnitId;	
    private java.sql.Timestamp invoiceDate;	
    private java.sql.Timestamp invoiceEtd;	
    private java.sql.Timestamp invoiceEta;	
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
    public String getInvoiceNo() {
        return this.invoiceNo;
    }		
    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
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
    public java.sql.Timestamp getInvoiceDate() {
        return this.invoiceDate;
    }		
    public void setInvoiceDate(java.sql.Timestamp invoiceDate) {
        this.invoiceDate = invoiceDate;
    }
    public java.sql.Timestamp getInvoiceEtd() {
        return this.invoiceEtd;
    }		
    public void setInvoiceEtd(java.sql.Timestamp invoiceEtd) {
        this.invoiceEtd = invoiceEtd;
    }
    public java.sql.Timestamp getInvoiceEta() {
        return this.invoiceEta;
    }		
    public void setInvoiceEta(java.sql.Timestamp invoiceEta) {
        this.invoiceEta = invoiceEta;
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
        return super.toString() + "runningNo=[" + runningNo + "]\n" + "orderProductId=[" + orderProductId + "]\n" + "invoiceNo=[" + invoiceNo + "]\n" + "soNo=[" + soNo + "]\n" + "itemCode=[" + itemCode + "]\n" + "amount=[" + amount + "]\n" + "productBuyerGroupId=[" + productBuyerGroupId + "]\n" + "price=[" + price + "]\n" + "productCurrency=[" + productCurrency + "]\n" + "productUnitId=[" + productUnitId + "]\n" + "invoiceDate=[" + invoiceDate + "]\n" + "invoiceEtd=[" + invoiceEtd + "]\n" + "invoiceEta=[" + invoiceEta + "]\n" + "importStatus=[" + importStatus + "]\n" + "dtsSystem=[" + dtsSystem + "]\n" + "dtsUpdate=[" + dtsUpdate + "]\n";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof TmpInvoice)) {
                return false;
        }
        TmpInvoice that = (TmpInvoice) obj;
        if (that.getRunningNo() != this.getRunningNo()) {
                return false;
        }
        if (that.getOrderProductId() != this.getOrderProductId()) {
                return false;
        }
        if (!(that.getInvoiceNo() == null ? this.getInvoiceNo() == null
                        : that.getInvoiceNo().equals(this.getInvoiceNo()))) {
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
        if (!(that.getInvoiceDate() == null ? this.getInvoiceDate() == null
                        : that.getInvoiceDate().equals(this.getInvoiceDate()))) {
                return false;
        }
        if (!(that.getInvoiceEtd() == null ? this.getInvoiceEtd() == null
                        : that.getInvoiceEtd().equals(this.getInvoiceEtd()))) {
                return false;
        }
        if (!(that.getInvoiceEta() == null ? this.getInvoiceEta() == null
                        : that.getInvoiceEta().equals(this.getInvoiceEta()))) {
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
