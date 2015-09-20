
package com.starboard.b2b.dto.original;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class TmpOrderStatus implements Serializable {
    
    /** Creates a new instance of TmpOrderStatus */
    public TmpOrderStatus() {
    }
    public TmpOrderStatus(
            String orderStatusId	
            , String orderStatusName	
            , String orderStatusDescription	
            , long importStatus	
            , String dtsSystem	
            , java.sql.Timestamp dtsUpdate	
        ) {
        this.orderStatusId = orderStatusId;	
        this.orderStatusName = orderStatusName;	
        this.orderStatusDescription = orderStatusDescription;	
        this.importStatus = importStatus;	
        this.dtsSystem = dtsSystem;	
        this.dtsUpdate = dtsUpdate;	
    }
    private String orderStatusId;	
    private String orderStatusName;	
    private String orderStatusDescription;	
    private long importStatus;	
    private String dtsSystem;	
    private java.sql.Timestamp dtsUpdate;	



    public String getOrderStatusId() {
        return this.orderStatusId;
    }		
    public void setOrderStatusId(String orderStatusId) {
        this.orderStatusId = orderStatusId;
    }
    public String getOrderStatusName() {
        return this.orderStatusName;
    }		
    public void setOrderStatusName(String orderStatusName) {
        this.orderStatusName = orderStatusName;
    }
    public String getOrderStatusDescription() {
        return this.orderStatusDescription;
    }		
    public void setOrderStatusDescription(String orderStatusDescription) {
        this.orderStatusDescription = orderStatusDescription;
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
        return super.toString() + "orderStatusId=[" + orderStatusId + "]\n" + "orderStatusName=[" + orderStatusName + "]\n" + "orderStatusDescription=[" + orderStatusDescription + "]\n" + "importStatus=[" + importStatus + "]\n" + "dtsSystem=[" + dtsSystem + "]\n" + "dtsUpdate=[" + dtsUpdate + "]\n";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof TmpOrderStatus)) {
                return false;
        }
        TmpOrderStatus that = (TmpOrderStatus) obj;
        if (!(that.getOrderStatusId() == null ? this.getOrderStatusId() == null
                        : that.getOrderStatusId().equals(this.getOrderStatusId()))) {
                return false;
        }
        if (!(that.getOrderStatusName() == null ? this.getOrderStatusName() == null
                        : that.getOrderStatusName().equals(this.getOrderStatusName()))) {
                return false;
        }
        if (!(that.getOrderStatusDescription() == null ? this.getOrderStatusDescription() == null
                        : that.getOrderStatusDescription().equals(this.getOrderStatusDescription()))) {
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
