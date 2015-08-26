
package com.starboard.b2b.entity;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class ProductImagesPK  implements Serializable {
    
    /** Creates a new instance of ProductImages */
    public ProductImagesPK(
            long productImageId	
        ) {
        this.productImageId = productImageId;	
    }
    private long productImageId;	

    public long getProductImageId() {
        return this.productImageId;
    }		
    public void setProductImageId(long productImageId) {
        this.productImageId = productImageId;
    }

    public String toString() {
        return super.toString() + " " + productImageId;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof ProductImages)) {
                return false;
        }
        ProductImages that = (ProductImages) obj;
        if (that.getProductImageId() != this.getProductImageId()) {
                return false;
        }
    return true;
    }

}
