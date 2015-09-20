
package com.starboard.b2b.dto.original;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class TmpProductItemGroup implements Serializable {
    
    /** Creates a new instance of TmpProductItemGroup */
    public TmpProductItemGroup() {
    }
    public TmpProductItemGroup(
            String productItemGroupId	
            , String productItemGroupName	
            , String description	
            , long importStatus	
            , String dtsSystem	
            , java.sql.Timestamp dtsUpdate	
        ) {
        this.productItemGroupId = productItemGroupId;	
        this.productItemGroupName = productItemGroupName;	
        this.description = description;	
        this.importStatus = importStatus;	
        this.dtsSystem = dtsSystem;	
        this.dtsUpdate = dtsUpdate;	
    }
    private String productItemGroupId;	
    private String productItemGroupName;	
    private String description;	
    private long importStatus;	
    private String dtsSystem;	
    private java.sql.Timestamp dtsUpdate;	



    public String getProductItemGroupId() {
        return this.productItemGroupId;
    }		
    public void setProductItemGroupId(String productItemGroupId) {
        this.productItemGroupId = productItemGroupId;
    }
    public String getProductItemGroupName() {
        return this.productItemGroupName;
    }		
    public void setProductItemGroupName(String productItemGroupName) {
        this.productItemGroupName = productItemGroupName;
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
        return super.toString() + "productItemGroupId=[" + productItemGroupId + "]\n" + "productItemGroupName=[" + productItemGroupName + "]\n" + "description=[" + description + "]\n" + "importStatus=[" + importStatus + "]\n" + "dtsSystem=[" + dtsSystem + "]\n" + "dtsUpdate=[" + dtsUpdate + "]\n";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof TmpProductItemGroup)) {
                return false;
        }
        TmpProductItemGroup that = (TmpProductItemGroup) obj;
        if (!(that.getProductItemGroupId() == null ? this.getProductItemGroupId() == null
                        : that.getProductItemGroupId().equals(this.getProductItemGroupId()))) {
                return false;
        }
        if (!(that.getProductItemGroupName() == null ? this.getProductItemGroupName() == null
                        : that.getProductItemGroupName().equals(this.getProductItemGroupName()))) {
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
