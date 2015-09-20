
package com.starboard.b2b.dto.original;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class TmpCustPriceGroup implements Serializable {
    
    /** Creates a new instance of TmpCustPriceGroup */
    public TmpCustPriceGroup() {
    }
    public TmpCustPriceGroup(
            long custPriceGroupId	
            , String custCode	
            , long productTypeId	
            , String productBuyerGroupId	
            , long importStatus	
            , String dtsSystem	
            , java.sql.Timestamp dtsUpdate	
        ) {
        this.custPriceGroupId = custPriceGroupId;	
        this.custCode = custCode;	
        this.productTypeId = productTypeId;	
        this.productBuyerGroupId = productBuyerGroupId;	
        this.importStatus = importStatus;	
        this.dtsSystem = dtsSystem;	
        this.dtsUpdate = dtsUpdate;	
    }
    private long custPriceGroupId;	
    private String custCode;	
    private long productTypeId;	
    private String productBuyerGroupId;	
    private long importStatus;	
    private String dtsSystem;	
    private java.sql.Timestamp dtsUpdate;	



    public long getCustPriceGroupId() {
        return this.custPriceGroupId;
    }		
    public void setCustPriceGroupId(long custPriceGroupId) {
        this.custPriceGroupId = custPriceGroupId;
    }
    public String getCustCode() {
        return this.custCode;
    }		
    public void setCustCode(String custCode) {
        this.custCode = custCode;
    }
    public long getProductTypeId() {
        return this.productTypeId;
    }		
    public void setProductTypeId(long productTypeId) {
        this.productTypeId = productTypeId;
    }
    public String getProductBuyerGroupId() {
        return this.productBuyerGroupId;
    }		
    public void setProductBuyerGroupId(String productBuyerGroupId) {
        this.productBuyerGroupId = productBuyerGroupId;
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
        return super.toString() + "custPriceGroupId=[" + custPriceGroupId + "]\n" + "custCode=[" + custCode + "]\n" + "productTypeId=[" + productTypeId + "]\n" + "productBuyerGroupId=[" + productBuyerGroupId + "]\n" + "importStatus=[" + importStatus + "]\n" + "dtsSystem=[" + dtsSystem + "]\n" + "dtsUpdate=[" + dtsUpdate + "]\n";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof TmpCustPriceGroup)) {
                return false;
        }
        TmpCustPriceGroup that = (TmpCustPriceGroup) obj;
        if (that.getCustPriceGroupId() != this.getCustPriceGroupId()) {
                return false;
        }
        if (!(that.getCustCode() == null ? this.getCustCode() == null
                        : that.getCustCode().equals(this.getCustCode()))) {
                return false;
        }
        if (that.getProductTypeId() != this.getProductTypeId()) {
                return false;
        }
        if (!(that.getProductBuyerGroupId() == null ? this.getProductBuyerGroupId() == null
                        : that.getProductBuyerGroupId().equals(this.getProductBuyerGroupId()))) {
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
