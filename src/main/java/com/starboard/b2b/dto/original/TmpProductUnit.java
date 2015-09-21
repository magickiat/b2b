
package com.starboard.b2b.dto.original;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class TmpProductUnit implements Serializable {
    
    /** Creates a new instance of TmpProductUnit */
    public TmpProductUnit() {
    }
    public TmpProductUnit(
            String productUnitId	
            , String productUnitName	
            , String description	
            , long importStatus	
            , String dtsSystem	
            , java.sql.Timestamp dtsUpdate	
        ) {
        this.productUnitId = productUnitId;	
        this.productUnitName = productUnitName;	
        this.description = description;	
        this.importStatus = importStatus;	
        this.dtsSystem = dtsSystem;	
        this.dtsUpdate = dtsUpdate;	
    }
    private String productUnitId;	
    private String productUnitName;	
    private String description;	
    private long importStatus;	
    private String dtsSystem;	
    private java.sql.Timestamp dtsUpdate;	



    public String getProductUnitId() {
        return this.productUnitId;
    }		
    public void setProductUnitId(String productUnitId) {
        this.productUnitId = productUnitId;
    }
    public String getProductUnitName() {
        return this.productUnitName;
    }		
    public void setProductUnitName(String productUnitName) {
        this.productUnitName = productUnitName;
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
        return super.toString() + "productUnitId=[" + productUnitId + "]\n" + "productUnitName=[" + productUnitName + "]\n" + "description=[" + description + "]\n" + "importStatus=[" + importStatus + "]\n" + "dtsSystem=[" + dtsSystem + "]\n" + "dtsUpdate=[" + dtsUpdate + "]\n";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof TmpProductUnit)) {
                return false;
        }
        TmpProductUnit that = (TmpProductUnit) obj;
        if (!(that.getProductUnitId() == null ? this.getProductUnitId() == null
                        : that.getProductUnitId().equals(this.getProductUnitId()))) {
                return false;
        }
        if (!(that.getProductUnitName() == null ? this.getProductUnitName() == null
                        : that.getProductUnitName().equals(this.getProductUnitName()))) {
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