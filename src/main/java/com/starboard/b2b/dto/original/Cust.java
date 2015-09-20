
package com.starboard.b2b.dto.original;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class Cust implements Serializable {
    
    /** Creates a new instance of Cust */
    public Cust() {
    }
    public Cust(
            long custId	
            , String custCode	
            , String invoiceCode	
            , String saleId	
            , String nameTh	
            , String nameEn	
            , String currency	
            , String userCreate	
            , String userUpdate	
            , java.sql.Timestamp timeCreate	
            , java.sql.Timestamp timeUpdate	
        ) {
        this.custId = custId;	
        this.custCode = custCode;	
        this.invoiceCode = invoiceCode;	
        this.saleId = saleId;	
        this.nameTh = nameTh;	
        this.nameEn = nameEn;	
        this.currency = currency;	
        this.userCreate = userCreate;	
        this.userUpdate = userUpdate;	
        this.timeCreate = timeCreate;	
        this.timeUpdate = timeUpdate;	
    }
    private long custId;	
    private String custCode;	
    private String invoiceCode;	
    private String saleId;	
    private String nameTh;	
    private String nameEn;	
    private String currency;	
    private String userCreate;	
    private String userUpdate;	
    private java.sql.Timestamp timeCreate;	
    private java.sql.Timestamp timeUpdate;	



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
    public String getInvoiceCode() {
        return this.invoiceCode;
    }		
    public void setInvoiceCode(String invoiceCode) {
        this.invoiceCode = invoiceCode;
    }
    public String getSaleId() {
        return this.saleId;
    }		
    public void setSaleId(String saleId) {
        this.saleId = saleId;
    }
    public String getNameTh() {
        return this.nameTh;
    }		
    public void setNameTh(String nameTh) {
        this.nameTh = nameTh;
    }
    public String getNameEn() {
        return this.nameEn;
    }		
    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }
    public String getCurrency() {
        return this.currency;
    }		
    public void setCurrency(String currency) {
        this.currency = currency;
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
        return super.toString() + "custId=[" + custId + "]\n" + "custCode=[" + custCode + "]\n" + "invoiceCode=[" + invoiceCode + "]\n" + "saleId=[" + saleId + "]\n" + "nameTh=[" + nameTh + "]\n" + "nameEn=[" + nameEn + "]\n" + "currency=[" + currency + "]\n" + "userCreate=[" + userCreate + "]\n" + "userUpdate=[" + userUpdate + "]\n" + "timeCreate=[" + timeCreate + "]\n" + "timeUpdate=[" + timeUpdate + "]\n";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof Cust)) {
                return false;
        }
        Cust that = (Cust) obj;
        if (that.getCustId() != this.getCustId()) {
                return false;
        }
        if (!(that.getCustCode() == null ? this.getCustCode() == null
                        : that.getCustCode().equals(this.getCustCode()))) {
                return false;
        }
        if (!(that.getInvoiceCode() == null ? this.getInvoiceCode() == null
                        : that.getInvoiceCode().equals(this.getInvoiceCode()))) {
                return false;
        }
        if (!(that.getSaleId() == null ? this.getSaleId() == null
                        : that.getSaleId().equals(this.getSaleId()))) {
                return false;
        }
        if (!(that.getNameTh() == null ? this.getNameTh() == null
                        : that.getNameTh().equals(this.getNameTh()))) {
                return false;
        }
        if (!(that.getNameEn() == null ? this.getNameEn() == null
                        : that.getNameEn().equals(this.getNameEn()))) {
                return false;
        }
        if (!(that.getCurrency() == null ? this.getCurrency() == null
                        : that.getCurrency().equals(this.getCurrency()))) {
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
