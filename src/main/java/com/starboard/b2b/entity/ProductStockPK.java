
package com.starboard.b2b.entity;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class ProductStockPK  implements Serializable {
    
    /** Creates a new instance of ProductStock */
    public ProductStockPK(
            long productStockId	
        ) {
        this.productStockId = productStockId;	
    }
    private long productStockId;	

    public long getProductStockId() {
        return this.productStockId;
    }		
    public void setProductStockId(long productStockId) {
        this.productStockId = productStockId;
    }

    public String toString() {
        return super.toString() + " " + productStockId;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof ProductStock)) {
                return false;
        }
        ProductStock that = (ProductStock) obj;
        if (that.getProductStockId() != this.getProductStockId()) {
                return false;
        }
    return true;
    }

}
