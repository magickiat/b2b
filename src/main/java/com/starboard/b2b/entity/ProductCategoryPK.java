
package com.starboard.b2b.entity;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class ProductCategoryPK  implements Serializable {
    
    /** Creates a new instance of ProductCategory */
    public ProductCategoryPK(
            String productCategoryId	
        ) {
        this.productCategoryId = productCategoryId;	
    }
    private String productCategoryId;	

    public String getProductCategoryId() {
        return this.productCategoryId;
    }		
    public void setProductCategoryId(String productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    public String toString() {
        return super.toString() + " " + productCategoryId;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof ProductCategory)) {
                return false;
        }
        ProductCategory that = (ProductCategory) obj;
        if (!(that.getProductCategoryId() == null ? this.getProductCategoryId() == null
                        : that.getProductCategoryId().equals(this.getProductCategoryId()))) {
                return false;
        }
    return true;
    }

}
