
package com.starboard.b2b.dto.original;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class TmpBrandGroup implements Serializable {
    
    /** Creates a new instance of TmpBrandGroup */
    public TmpBrandGroup() {
    }
    public TmpBrandGroup(
            long brandGroupId	
            , String brandGroupName	
            , String brandGroupDescription	
            , long importStatus	
            , String dtsSystem	
            , java.sql.Timestamp dtsUpdate	
        ) {
        this.brandGroupId = brandGroupId;	
        this.brandGroupName = brandGroupName;	
        this.brandGroupDescription = brandGroupDescription;	
        this.importStatus = importStatus;	
        this.dtsSystem = dtsSystem;	
        this.dtsUpdate = dtsUpdate;	
    }
    private long brandGroupId;	
    private String brandGroupName;	
    private String brandGroupDescription;	
    private long importStatus;	
    private String dtsSystem;	
    private java.sql.Timestamp dtsUpdate;	



    public long getBrandGroupId() {
        return this.brandGroupId;
    }		
    public void setBrandGroupId(long brandGroupId) {
        this.brandGroupId = brandGroupId;
    }
    public String getBrandGroupName() {
        return this.brandGroupName;
    }		
    public void setBrandGroupName(String brandGroupName) {
        this.brandGroupName = brandGroupName;
    }
    public String getBrandGroupDescription() {
        return this.brandGroupDescription;
    }		
    public void setBrandGroupDescription(String brandGroupDescription) {
        this.brandGroupDescription = brandGroupDescription;
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
        return super.toString() + "brandGroupId=[" + brandGroupId + "]\n" + "brandGroupName=[" + brandGroupName + "]\n" + "brandGroupDescription=[" + brandGroupDescription + "]\n" + "importStatus=[" + importStatus + "]\n" + "dtsSystem=[" + dtsSystem + "]\n" + "dtsUpdate=[" + dtsUpdate + "]\n";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof TmpBrandGroup)) {
                return false;
        }
        TmpBrandGroup that = (TmpBrandGroup) obj;
        if (that.getBrandGroupId() != this.getBrandGroupId()) {
                return false;
        }
        if (!(that.getBrandGroupName() == null ? this.getBrandGroupName() == null
                        : that.getBrandGroupName().equals(this.getBrandGroupName()))) {
                return false;
        }
        if (!(that.getBrandGroupDescription() == null ? this.getBrandGroupDescription() == null
                        : that.getBrandGroupDescription().equals(this.getBrandGroupDescription()))) {
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
