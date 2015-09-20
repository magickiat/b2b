
package com.starboard.b2b.dto.original;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class TmpProductBuyerGroup implements Serializable {
    
    /** Creates a new instance of TmpProductBuyerGroup */
    public TmpProductBuyerGroup() {
    }
    public TmpProductBuyerGroup(
            String productBuyerGroupId	
            , String productBuyerGroupName	
            , String description	
            , long importStatus	
            , String dtsSystem	
            , java.sql.Timestamp dtsUpdate	
        ) {
        this.productBuyerGroupId = productBuyerGroupId;	
        this.productBuyerGroupName = productBuyerGroupName;	
        this.description = description;	
        this.importStatus = importStatus;	
        this.dtsSystem = dtsSystem;	
        this.dtsUpdate = dtsUpdate;	
    }
    private String productBuyerGroupId;	
    private String productBuyerGroupName;	
    private String description;	
    private long importStatus;	
    private String dtsSystem;	
    private java.sql.Timestamp dtsUpdate;	



    public String getProductBuyerGroupId() {
        return this.productBuyerGroupId;
    }		
    public void setProductBuyerGroupId(String productBuyerGroupId) {
        this.productBuyerGroupId = productBuyerGroupId;
    }
    public String getProductBuyerGroupName() {
        return this.productBuyerGroupName;
    }		
    public void setProductBuyerGroupName(String productBuyerGroupName) {
        this.productBuyerGroupName = productBuyerGroupName;
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
        return super.toString() + "productBuyerGroupId=[" + productBuyerGroupId + "]\n" + "productBuyerGroupName=[" + productBuyerGroupName + "]\n" + "description=[" + description + "]\n" + "importStatus=[" + importStatus + "]\n" + "dtsSystem=[" + dtsSystem + "]\n" + "dtsUpdate=[" + dtsUpdate + "]\n";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof TmpProductBuyerGroup)) {
                return false;
        }
        TmpProductBuyerGroup that = (TmpProductBuyerGroup) obj;
        if (!(that.getProductBuyerGroupId() == null ? this.getProductBuyerGroupId() == null
                        : that.getProductBuyerGroupId().equals(this.getProductBuyerGroupId()))) {
                return false;
        }
        if (!(that.getProductBuyerGroupName() == null ? this.getProductBuyerGroupName() == null
                        : that.getProductBuyerGroupName().equals(this.getProductBuyerGroupName()))) {
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
