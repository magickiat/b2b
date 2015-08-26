
package com.starboard.b2b.entity;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class ProductImgPK  implements Serializable {
    
    /** Creates a new instance of ProductImg */
    public ProductImgPK(
            long productImgId	
        ) {
        this.productImgId = productImgId;	
    }
    private long productImgId;	

    public long getProductImgId() {
        return this.productImgId;
    }		
    public void setProductImgId(long productImgId) {
        this.productImgId = productImgId;
    }

    public String toString() {
        return super.toString() + " " + productImgId;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof ProductImg)) {
                return false;
        }
        ProductImg that = (ProductImg) obj;
        if (that.getProductImgId() != this.getProductImgId()) {
                return false;
        }
    return true;
    }

}
