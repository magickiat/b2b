
package com.starboard.b2b.dto.original;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class TmpProductType implements Serializable {
    
    /** Creates a new instance of TmpProductType */
    public TmpProductType() {
    }
    public TmpProductType(
            long productTypeId	
            , String productTypeName	
            , long productTypeParentId	
            , String productTypeDescription	
            , long importStatus	
            , String dtsSystem	
            , java.sql.Timestamp dtsUpdate	
        ) {
        this.productTypeId = productTypeId;	
        this.productTypeName = productTypeName;	
        this.productTypeParentId = productTypeParentId;	
        this.productTypeDescription = productTypeDescription;	
        this.importStatus = importStatus;	
        this.dtsSystem = dtsSystem;	
        this.dtsUpdate = dtsUpdate;	
    }
    private long productTypeId;	
    private String productTypeName;	
    private long productTypeParentId;	
    private String productTypeDescription;	
    private long importStatus;	
    private String dtsSystem;	
    private java.sql.Timestamp dtsUpdate;	



    public long getProductTypeId() {
        return this.productTypeId;
    }		
    public void setProductTypeId(long productTypeId) {
        this.productTypeId = productTypeId;
    }
    public String getProductTypeName() {
        return this.productTypeName;
    }		
    public void setProductTypeName(String productTypeName) {
        this.productTypeName = productTypeName;
    }
    public long getProductTypeParentId() {
        return this.productTypeParentId;
    }		
    public void setProductTypeParentId(long productTypeParentId) {
        this.productTypeParentId = productTypeParentId;
    }
    public String getProductTypeDescription() {
        return this.productTypeDescription;
    }		
    public void setProductTypeDescription(String productTypeDescription) {
        this.productTypeDescription = productTypeDescription;
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
        return super.toString() + "productTypeId=[" + productTypeId + "]\n" + "productTypeName=[" + productTypeName + "]\n" + "productTypeParentId=[" + productTypeParentId + "]\n" + "productTypeDescription=[" + productTypeDescription + "]\n" + "importStatus=[" + importStatus + "]\n" + "dtsSystem=[" + dtsSystem + "]\n" + "dtsUpdate=[" + dtsUpdate + "]\n";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof TmpProductType)) {
                return false;
        }
        TmpProductType that = (TmpProductType) obj;
        if (that.getProductTypeId() != this.getProductTypeId()) {
                return false;
        }
        if (!(that.getProductTypeName() == null ? this.getProductTypeName() == null
                        : that.getProductTypeName().equals(this.getProductTypeName()))) {
                return false;
        }
        if (that.getProductTypeParentId() != this.getProductTypeParentId()) {
                return false;
        }
        if (!(that.getProductTypeDescription() == null ? this.getProductTypeDescription() == null
                        : that.getProductTypeDescription().equals(this.getProductTypeDescription()))) {
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
