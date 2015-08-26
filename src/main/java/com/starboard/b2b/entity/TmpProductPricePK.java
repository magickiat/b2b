
package com.starboard.b2b.entity;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class TmpProductPricePK  implements Serializable {
    
    /** Creates a new instance of TmpProductPrice */
    public TmpProductPricePK(
            String productCode	
            , String productPriceGroupId	
            , String productCurrency	
        ) {
        this.productCode = productCode;	
        this.productPriceGroupId = productPriceGroupId;	
        this.productCurrency = productCurrency;	
    }
    private String productCode;	
    private String productPriceGroupId;	
    private String productCurrency;	

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

    public String toString() {
        return super.toString() + " " + productCode + " " + productPriceGroupId + " " + productCurrency;
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
    return true;
    }

}
