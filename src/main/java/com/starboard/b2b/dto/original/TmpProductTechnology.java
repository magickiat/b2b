
package com.starboard.b2b.dto.original;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class TmpProductTechnology implements Serializable {
    
    /** Creates a new instance of TmpProductTechnology */
    public TmpProductTechnology() {
    }
    public TmpProductTechnology(
            String productTechnologyId	
            , String productTechnologyName	
            , String description	
            , long importStatus	
            , String dtsSystem	
            , java.sql.Timestamp dtsUpdate	
        ) {
        this.productTechnologyId = productTechnologyId;	
        this.productTechnologyName = productTechnologyName;	
        this.description = description;	
        this.importStatus = importStatus;	
        this.dtsSystem = dtsSystem;	
        this.dtsUpdate = dtsUpdate;	
    }
    private String productTechnologyId;	
    private String productTechnologyName;	
    private String description;	
    private long importStatus;	
    private String dtsSystem;	
    private java.sql.Timestamp dtsUpdate;	



    public String getProductTechnologyId() {
        return this.productTechnologyId;
    }		
    public void setProductTechnologyId(String productTechnologyId) {
        this.productTechnologyId = productTechnologyId;
    }
    public String getProductTechnologyName() {
        return this.productTechnologyName;
    }		
    public void setProductTechnologyName(String productTechnologyName) {
        this.productTechnologyName = productTechnologyName;
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
        return super.toString() + "productTechnologyId=[" + productTechnologyId + "]\n" + "productTechnologyName=[" + productTechnologyName + "]\n" + "description=[" + description + "]\n" + "importStatus=[" + importStatus + "]\n" + "dtsSystem=[" + dtsSystem + "]\n" + "dtsUpdate=[" + dtsUpdate + "]\n";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof TmpProductTechnology)) {
                return false;
        }
        TmpProductTechnology that = (TmpProductTechnology) obj;
        if (!(that.getProductTechnologyId() == null ? this.getProductTechnologyId() == null
                        : that.getProductTechnologyId().equals(this.getProductTechnologyId()))) {
                return false;
        }
        if (!(that.getProductTechnologyName() == null ? this.getProductTechnologyName() == null
                        : that.getProductTechnologyName().equals(this.getProductTechnologyName()))) {
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
