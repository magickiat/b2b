
package com.starboard.b2b.dto.original;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class TmpPaymentTerm implements Serializable {
    
    /** Creates a new instance of TmpPaymentTerm */
    public TmpPaymentTerm() {
    }
    public TmpPaymentTerm(
            String paymentTermId	
            , String paymentTermName	
            , String description	
            , long importStatus	
            , String dtsSystem	
            , java.sql.Timestamp dtsUpdate	
        ) {
        this.paymentTermId = paymentTermId;	
        this.paymentTermName = paymentTermName;	
        this.description = description;	
        this.importStatus = importStatus;	
        this.dtsSystem = dtsSystem;	
        this.dtsUpdate = dtsUpdate;	
    }
    private String paymentTermId;	
    private String paymentTermName;	
    private String description;	
    private long importStatus;	
    private String dtsSystem;	
    private java.sql.Timestamp dtsUpdate;	



    public String getPaymentTermId() {
        return this.paymentTermId;
    }		
    public void setPaymentTermId(String paymentTermId) {
        this.paymentTermId = paymentTermId;
    }
    public String getPaymentTermName() {
        return this.paymentTermName;
    }		
    public void setPaymentTermName(String paymentTermName) {
        this.paymentTermName = paymentTermName;
    }
    public String getDescription() {
        return this.description;
    }		
    public void setDescription(String description) {
        this.description = description;
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
        return super.toString() + "paymentTermId=[" + paymentTermId + "]\n" + "paymentTermName=[" + paymentTermName + "]\n" + "description=[" + description + "]\n" + "importStatus=[" + importStatus + "]\n" + "dtsSystem=[" + dtsSystem + "]\n" + "dtsUpdate=[" + dtsUpdate + "]\n";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof TmpPaymentTerm)) {
                return false;
        }
        TmpPaymentTerm that = (TmpPaymentTerm) obj;
        if (!(that.getPaymentTermId() == null ? this.getPaymentTermId() == null
                        : that.getPaymentTermId().equals(this.getPaymentTermId()))) {
                return false;
        }
        if (!(that.getPaymentTermName() == null ? this.getPaymentTermName() == null
                        : that.getPaymentTermName().equals(this.getPaymentTermName()))) {
                return false;
        }
        if (!(that.getDescription() == null ? this.getDescription() == null
                        : that.getDescription().equals(this.getDescription()))) {
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
