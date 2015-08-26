
package com.starboard.b2b.entity;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class Invoice implements Serializable {
    
    /** Creates a new instance of Invoice */
    public Invoice() {
    }
    public Invoice(
            long invoiceId	
            , long soId	
            , String invoiceNo	
            , java.sql.Timestamp invoiceDate	
            , java.sql.Timestamp invoiceEtd	
            , java.sql.Timestamp invoiceEta	
            , String userCreate	
            , String userUpdate	
            , java.sql.Timestamp timeCreate	
            , java.sql.Timestamp timeUpdate	
        ) {
        this.invoiceId = invoiceId;	
        this.soId = soId;	
        this.invoiceNo = invoiceNo;	
        this.invoiceDate = invoiceDate;	
        this.invoiceEtd = invoiceEtd;	
        this.invoiceEta = invoiceEta;	
        this.userCreate = userCreate;	
        this.userUpdate = userUpdate;	
        this.timeCreate = timeCreate;	
        this.timeUpdate = timeUpdate;	
    }
    private long invoiceId;	
    private long soId;	
    private String invoiceNo;	
    private java.sql.Timestamp invoiceDate;	
    private java.sql.Timestamp invoiceEtd;	
    private java.sql.Timestamp invoiceEta;	
    private String userCreate;	
    private String userUpdate;	
    private java.sql.Timestamp timeCreate;	
    private java.sql.Timestamp timeUpdate;	



    public long getInvoiceId() {
        return this.invoiceId;
    }		
    public void setInvoiceId(long invoiceId) {
        this.invoiceId = invoiceId;
    }
    public long getSoId() {
        return this.soId;
    }		
    public void setSoId(long soId) {
        this.soId = soId;
    }
    public String getInvoiceNo() {
        return this.invoiceNo;
    }		
    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
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
        return super.toString() + "invoiceId=[" + invoiceId + "]\n" + "soId=[" + soId + "]\n" + "invoiceNo=[" + invoiceNo + "]\n" + "invoiceDate=[" + invoiceDate + "]\n" + "invoiceEtd=[" + invoiceEtd + "]\n" + "invoiceEta=[" + invoiceEta + "]\n" + "userCreate=[" + userCreate + "]\n" + "userUpdate=[" + userUpdate + "]\n" + "timeCreate=[" + timeCreate + "]\n" + "timeUpdate=[" + timeUpdate + "]\n";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof Invoice)) {
                return false;
        }
        Invoice that = (Invoice) obj;
        if (that.getInvoiceId() != this.getInvoiceId()) {
                return false;
        }
        if (that.getSoId() != this.getSoId()) {
                return false;
        }
        if (!(that.getInvoiceNo() == null ? this.getInvoiceNo() == null
                        : that.getInvoiceNo().equals(this.getInvoiceNo()))) {
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
