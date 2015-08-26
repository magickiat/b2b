
package com.starboard.b2b.entity;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class ProductPriceGroupPK  implements Serializable {
    
    /** Creates a new instance of ProductPriceGroup */
    public ProductPriceGroupPK(
            String productPriceGroupId	
        ) {
        this.productPriceGroupId = productPriceGroupId;	
    }
    private String productPriceGroupId;	

    public String getProductPriceGroupId() {
        return this.productPriceGroupId;
    }		
    public void setProductPriceGroupId(String productPriceGroupId) {
        this.productPriceGroupId = productPriceGroupId;
    }

    public String toString() {
        return super.toString() + " " + productPriceGroupId;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof ProductPriceGroup)) {
                return false;
        }
        ProductPriceGroup that = (ProductPriceGroup) obj;
        if (!(that.getProductPriceGroupId() == null ? this.getProductPriceGroupId() == null
                        : that.getProductPriceGroupId().equals(this.getProductPriceGroupId()))) {
                return false;
        }
    return true;
    }

}
