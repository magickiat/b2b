
package com.starboard.b2b.entity;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class ProductItemGroupPK  implements Serializable {
    
    /** Creates a new instance of ProductItemGroup */
    public ProductItemGroupPK(
            String productItemGroupId	
        ) {
        this.productItemGroupId = productItemGroupId;	
    }
    private String productItemGroupId;	

    public String getProductItemGroupId() {
        return this.productItemGroupId;
    }		
    public void setProductItemGroupId(String productItemGroupId) {
        this.productItemGroupId = productItemGroupId;
    }

    public String toString() {
        return super.toString() + " " + productItemGroupId;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof ProductItemGroup)) {
                return false;
        }
        ProductItemGroup that = (ProductItemGroup) obj;
        if (!(that.getProductItemGroupId() == null ? this.getProductItemGroupId() == null
                        : that.getProductItemGroupId().equals(this.getProductItemGroupId()))) {
                return false;
        }
    return true;
    }

}
