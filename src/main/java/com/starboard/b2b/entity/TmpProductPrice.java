
package com.starboard.b2b.entity;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class TmpProductPrice implements Serializable {
    
    /** Creates a new instance of TmpProductPrice */
    public TmpProductPrice() {
    }
    public TmpProductPrice(
            String productCode	
            , String productPriceGroupId	
            , String productCurrency	
            , java.math.BigDecimal amount	
            , String productUnitId	
            , long importStatus	
            , String dtsSystem	
            , java.sql.Timestamp dtsUpdate	
        ) {
        this.productCode = productCode;	
        this.productPriceGroupId = productPriceGroupId;	
        this.productCurrency = productCurrency;	
        this.amount = amount;	
        this.productUnitId = productUnitId;	
        this.importStatus = importStatus;	
        this.dtsSystem = dtsSystem;	
        this.dtsUpdate = dtsUpdate;	
    }
    private String productCode;	
    private String productPriceGroupId;	
    private String productCurrency;	
    private java.math.BigDecimal amount;	
    private String productUnitId;	
    private long importStatus;	
    private String dtsSystem;	
    private java.sql.Timestamp dtsUpdate;	



    public String getProductCode() {
        return this.productCode;
    }		
    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }
    public String getProductPriceGroupId() {
        return this.productPriceGroupId;
    }		
    public void setProductPriceGroupId(String productPriceGroupId) {
        this.productPriceGroupId = productPriceGroupId;
    }
    public String getProductCurrency() {
        return this.productCurrency;
    }		
    public void setProductCurrency(String productCurrency) {
        this.productCurrency = productCurrency;
    }
    public java.math.BigDecimal getAmount() {
        return this.amount;
    }		
    public void setAmount(java.math.BigDecimal amount) {
        this.amount = amount;
    }
    public String getProductUnitId() {
        return this.productUnitId;
    }		
    public void setProductUnitId(String productUnitId) {
        this.productUnitId = productUnitId;
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
        return super.toString() + "productCode=[" + productCode + "]\n" + "productPriceGroupId=[" + productPriceGroupId + "]\n" + "productCurrency=[" + productCurrency + "]\n" + "amount=[" + amount + "]\n" + "productUnitId=[" + productUnitId + "]\n" + "importStatus=[" + importStatus + "]\n" + "dtsSystem=[" + dtsSystem + "]\n" + "dtsUpdate=[" + dtsUpdate + "]\n";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof TmpProductPrice)) {
                return false;
        }
        TmpProductPrice that = (TmpProductPrice) obj;
        if (!(that.getProductCode() == null ? this.getProductCode() == null
                        : that.getProductCode().equals(this.getProductCode()))) {
                return false;
        }
        if (!(that.getProductPriceGroupId() == null ? this.getProductPriceGroupId() == null
                        : that.getProductPriceGroupId().equals(this.getProductPriceGroupId()))) {
                return false;
        }
        if (!(that.getProductCurrency() == null ? this.getProductCurrency() == null
                        : that.getProductCurrency().equals(this.getProductCurrency()))) {
                return false;
        }
        if (!(that.getAmount() == null ? this.getAmount() == null
                        : 0 == that.getAmount().compareTo(this.getAmount()))) {
                return false;
        }
        if (!(that.getProductUnitId() == null ? this.getProductUnitId() == null
                        : that.getProductUnitId().equals(this.getProductUnitId()))) {
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
