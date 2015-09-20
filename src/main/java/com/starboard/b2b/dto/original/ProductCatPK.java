
package com.starboard.b2b.dto.original;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class ProductCatPK  implements Serializable {
    
    /** Creates a new instance of ProductCat */
    public ProductCatPK(
            long productCatId	
        ) {
        this.productCatId = productCatId;	
    }
    private long productCatId;	

    public long getProductCatId() {
        return this.productCatId;
    }		
    public void setProductCatId(long productCatId) {
        this.productCatId = productCatId;
    }

    public String toString() {
        return super.toString() + " " + productCatId;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof ProductCat)) {
                return false;
        }
        ProductCat that = (ProductCat) obj;
        if (that.getProductCatId() != this.getProductCatId()) {
                return false;
        }
    return true;
    }

}
