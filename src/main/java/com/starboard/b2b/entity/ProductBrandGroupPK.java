
package com.starboard.b2b.entity;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class ProductBrandGroupPK  implements Serializable {
    
    /** Creates a new instance of ProductBrandGroup */
    public ProductBrandGroupPK(
            long brandGroupId	
            , long productTypeId	
        ) {
        this.brandGroupId = brandGroupId;	
        this.productTypeId = productTypeId;	
    }
    private long brandGroupId;	
    private long productTypeId;	

    public long getBrandGroupId() {
        return this.brandGroupId;
    }		
    public void setBrandGroupId(long brandGroupId) {
        this.brandGroupId = brandGroupId;
    }
    public long getProductTypeId() {
        return this.productTypeId;
    }		
    public void setProductTypeId(long productTypeId) {
        this.productTypeId = productTypeId;
    }

    public String toString() {
        return super.toString() + " " + brandGroupId + " " + productTypeId;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof ProductBrandGroup)) {
                return false;
        }
        ProductBrandGroup that = (ProductBrandGroup) obj;
        if (that.getBrandGroupId() != this.getBrandGroupId()) {
                return false;
        }
        if (that.getProductTypeId() != this.getProductTypeId()) {
                return false;
        }
    return true;
    }

}
