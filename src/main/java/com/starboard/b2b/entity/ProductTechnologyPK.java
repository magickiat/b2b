
package com.starboard.b2b.entity;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class ProductTechnologyPK  implements Serializable {
    
    /** Creates a new instance of ProductTechnology */
    public ProductTechnologyPK(
            String productTechnologyId	
        ) {
        this.productTechnologyId = productTechnologyId;	
    }
    private String productTechnologyId;	

    public String getProductTechnologyId() {
        return this.productTechnologyId;
    }		
    public void setProductTechnologyId(String productTechnologyId) {
        this.productTechnologyId = productTechnologyId;
    }

    public String toString() {
        return super.toString() + " " + productTechnologyId;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof ProductTechnology)) {
                return false;
        }
        ProductTechnology that = (ProductTechnology) obj;
        if (!(that.getProductTechnologyId() == null ? this.getProductTechnologyId() == null
                        : that.getProductTechnologyId().equals(this.getProductTechnologyId()))) {
                return false;
        }
    return true;
    }

}
