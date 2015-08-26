
package com.starboard.b2b.entity;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class TmpRo implements Serializable {
    
    /** Creates a new instance of TmpRo */
    public TmpRo() {
    }
    public TmpRo(
            long orderProductId	
            , long orderId	
            , String roNumber	
            , long productId	
            , String itemId	
            , String productName	
            , String category	
            , String custAccount	
            , String custName	
            , String numberSeqCode	
            , String site	
            , String warehouse	
            , java.sql.Timestamp reqShipDate	
            , java.sql.Timestamp reqReceiptDate	
            , long amount	
            , long status	
            , java.math.BigDecimal salesPrice	
            , String unit	
            , String productBuyerGroupId	
            , String currencyCode	
            , String termCode	
            , String userCreate	
            , String userUpdate	
            , java.sql.Timestamp timeCreate	
            , java.sql.Timestamp timeUpdate	
            , long runningNumber	
            , java.sql.Timestamp importDateTime	
            , String salesId	
            , long importStatus	
            , String dtsSystem	
            , java.sql.Timestamp dtsUpdate	
        ) {
        this.orderProductId = orderProductId;	
        this.orderId = orderId;	
        this.roNumber = roNumber;	
        this.productId = productId;	
        this.itemId = itemId;	
        this.productName = productName;	
        this.category = category;	
        this.custAccount = custAccount;	
        this.custName = custName;	
        this.numberSeqCode = numberSeqCode;	
        this.site = site;	
        this.warehouse = warehouse;	
        this.reqShipDate = reqShipDate;	
        this.reqReceiptDate = reqReceiptDate;	
        this.amount = amount;	
        this.status = status;	
        this.salesPrice = salesPrice;	
        this.unit = unit;	
        this.productBuyerGroupId = productBuyerGroupId;	
        this.currencyCode = currencyCode;	
        this.termCode = termCode;	
        this.userCreate = userCreate;	
        this.userUpdate = userUpdate;	
        this.timeCreate = timeCreate;	
        this.timeUpdate = timeUpdate;	
        this.runningNumber = runningNumber;	
        this.importDateTime = importDateTime;	
        this.salesId = salesId;	
        this.importStatus = importStatus;	
        this.dtsSystem = dtsSystem;	
        this.dtsUpdate = dtsUpdate;	
    }
    private long orderProductId;	
    private long orderId;	
    private String roNumber;	
    private long productId;	
    private String itemId;	
    private String productName;	
    private String category;	
    private String custAccount;	
    private String custName;	
    private String numberSeqCode;	
    private String site;	
    private String warehouse;	
    private java.sql.Timestamp reqShipDate;	
    private java.sql.Timestamp reqReceiptDate;	
    private long amount;	
    private long status;	
    private java.math.BigDecimal salesPrice;	
    private String unit;	
    private String productBuyerGroupId;	
    private String currencyCode;	
    private String termCode;	
    private String userCreate;	
    private String userUpdate;	
    private java.sql.Timestamp timeCreate;	
    private java.sql.Timestamp timeUpdate;	
    private long runningNumber;	
    private java.sql.Timestamp importDateTime;	
    private String salesId;	
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
    public String getRoNumber() {
        return this.roNumber;
    }		
    public void setRoNumber(String roNumber) {
        this.roNumber = roNumber;
    }
    public long getProductId() {
        return this.productId;
    }		
    public void setProductId(long productId) {
        this.productId = productId;
    }
    public String getItemId() {
        return this.itemId;
    }		
    public void setItemId(String itemId) {
        this.itemId = itemId;
    }
    public String getProductName() {
        return this.productName;
    }		
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public String getCategory() {
        return this.category;
    }		
    public void setCategory(String category) {
        this.category = category;
    }
    public String getCustAccount() {
        return this.custAccount;
    }		
    public void setCustAccount(String custAccount) {
        this.custAccount = custAccount;
    }
    public String getCustName() {
        return this.custName;
    }		
    public void setCustName(String custName) {
        this.custName = custName;
    }
    public String getNumberSeqCode() {
        return this.numberSeqCode;
    }		
    public void setNumberSeqCode(String numberSeqCode) {
        this.numberSeqCode = numberSeqCode;
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
    public java.sql.Timestamp getReqShipDate() {
        return this.reqShipDate;
    }		
    public void setReqShipDate(java.sql.Timestamp reqShipDate) {
        this.reqShipDate = reqShipDate;
    }
    public java.sql.Timestamp getReqReceiptDate() {
        return this.reqReceiptDate;
    }		
    public void setReqReceiptDate(java.sql.Timestamp reqReceiptDate) {
        this.reqReceiptDate = reqReceiptDate;
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
    public java.math.BigDecimal getSalesPrice() {
        return this.salesPrice;
    }		
    public void setSalesPrice(java.math.BigDecimal salesPrice) {
        this.salesPrice = salesPrice;
    }
    public String getUnit() {
        return this.unit;
    }		
    public void setUnit(String unit) {
        this.unit = unit;
    }
    public String getProductBuyerGroupId() {
        return this.productBuyerGroupId;
    }		
    public void setProductBuyerGroupId(String productBuyerGroupId) {
        this.productBuyerGroupId = productBuyerGroupId;
    }
    public String getCurrencyCode() {
        return this.currencyCode;
    }		
    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }
    public String getTermCode() {
        return this.termCode;
    }		
    public void setTermCode(String termCode) {
        this.termCode = termCode;
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
    public long getRunningNumber() {
        return this.runningNumber;
    }		
    public void setRunningNumber(long runningNumber) {
        this.runningNumber = runningNumber;
    }
    public java.sql.Timestamp getImportDateTime() {
        return this.importDateTime;
    }		
    public void setImportDateTime(java.sql.Timestamp importDateTime) {
        this.importDateTime = importDateTime;
    }
    public String getSalesId() {
        return this.salesId;
    }		
    public void setSalesId(String salesId) {
        this.salesId = salesId;
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
        return super.toString() + "orderProductId=[" + orderProductId + "]\n" + "orderId=[" + orderId + "]\n" + "roNumber=[" + roNumber + "]\n" + "productId=[" + productId + "]\n" + "itemId=[" + itemId + "]\n" + "productName=[" + productName + "]\n" + "category=[" + category + "]\n" + "custAccount=[" + custAccount + "]\n" + "custName=[" + custName + "]\n" + "numberSeqCode=[" + numberSeqCode + "]\n" + "site=[" + site + "]\n" + "warehouse=[" + warehouse + "]\n" + "reqShipDate=[" + reqShipDate + "]\n" + "reqReceiptDate=[" + reqReceiptDate + "]\n" + "amount=[" + amount + "]\n" + "status=[" + status + "]\n" + "salesPrice=[" + salesPrice + "]\n" + "unit=[" + unit + "]\n" + "productBuyerGroupId=[" + productBuyerGroupId + "]\n" + "currencyCode=[" + currencyCode + "]\n" + "termCode=[" + termCode + "]\n" + "userCreate=[" + userCreate + "]\n" + "userUpdate=[" + userUpdate + "]\n" + "timeCreate=[" + timeCreate + "]\n" + "timeUpdate=[" + timeUpdate + "]\n" + "runningNumber=[" + runningNumber + "]\n" + "importDateTime=[" + importDateTime + "]\n" + "salesId=[" + salesId + "]\n" + "importStatus=[" + importStatus + "]\n" + "dtsSystem=[" + dtsSystem + "]\n" + "dtsUpdate=[" + dtsUpdate + "]\n";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof TmpRo)) {
                return false;
        }
        TmpRo that = (TmpRo) obj;
        if (that.getOrderProductId() != this.getOrderProductId()) {
                return false;
        }
        if (that.getOrderId() != this.getOrderId()) {
                return false;
        }
        if (!(that.getRoNumber() == null ? this.getRoNumber() == null
                        : that.getRoNumber().equals(this.getRoNumber()))) {
                return false;
        }
        if (that.getProductId() != this.getProductId()) {
                return false;
        }
        if (!(that.getItemId() == null ? this.getItemId() == null
                        : that.getItemId().equals(this.getItemId()))) {
                return false;
        }
        if (!(that.getProductName() == null ? this.getProductName() == null
                        : that.getProductName().equals(this.getProductName()))) {
                return false;
        }
        if (!(that.getCategory() == null ? this.getCategory() == null
                        : that.getCategory().equals(this.getCategory()))) {
                return false;
        }
        if (!(that.getCustAccount() == null ? this.getCustAccount() == null
                        : that.getCustAccount().equals(this.getCustAccount()))) {
                return false;
        }
        if (!(that.getCustName() == null ? this.getCustName() == null
                        : that.getCustName().equals(this.getCustName()))) {
                return false;
        }
        if (!(that.getNumberSeqCode() == null ? this.getNumberSeqCode() == null
                        : that.getNumberSeqCode().equals(this.getNumberSeqCode()))) {
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
        if (!(that.getReqShipDate() == null ? this.getReqShipDate() == null
                        : that.getReqShipDate().equals(this.getReqShipDate()))) {
                return false;
        }
        if (!(that.getReqReceiptDate() == null ? this.getReqReceiptDate() == null
                        : that.getReqReceiptDate().equals(this.getReqReceiptDate()))) {
                return false;
        }
        if (that.getAmount() != this.getAmount()) {
                return false;
        }
        if (that.getStatus() != this.getStatus()) {
                return false;
        }
        if (!(that.getSalesPrice() == null ? this.getSalesPrice() == null
                        : 0 == that.getSalesPrice().compareTo(this.getSalesPrice()))) {
                return false;
        }
        if (!(that.getUnit() == null ? this.getUnit() == null
                        : that.getUnit().equals(this.getUnit()))) {
                return false;
        }
        if (!(that.getProductBuyerGroupId() == null ? this.getProductBuyerGroupId() == null
                        : that.getProductBuyerGroupId().equals(this.getProductBuyerGroupId()))) {
                return false;
        }
        if (!(that.getCurrencyCode() == null ? this.getCurrencyCode() == null
                        : that.getCurrencyCode().equals(this.getCurrencyCode()))) {
                return false;
        }
        if (!(that.getTermCode() == null ? this.getTermCode() == null
                        : that.getTermCode().equals(this.getTermCode()))) {
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
        if (that.getRunningNumber() != this.getRunningNumber()) {
                return false;
        }
        if (!(that.getImportDateTime() == null ? this.getImportDateTime() == null
                        : that.getImportDateTime().equals(this.getImportDateTime()))) {
                return false;
        }
        if (!(that.getSalesId() == null ? this.getSalesId() == null
                        : that.getSalesId().equals(this.getSalesId()))) {
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
