
package com.starboard.b2b.entity;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class RelateProductPK  implements Serializable {
    
    /** Creates a new instance of RelateProduct */
    public RelateProductPK(
            long productId	
            , long relateProductId	
        ) {
        this.productId = productId;	
        this.relateProductId = relateProductId;	
    }
    private long productId;	
    private long relateProductId;	

    public long getProductId() {
        return this.productId;
    }		
    public void setProductId(long productId) {
        this.productId = productId;
    }
    public long getRelateProductId() {
        return this.relateProductId;
    }		
    public void setRelateProductId(long relateProductId) {
        this.relateProductId = relateProductId;
    }

    public String toString() {
        return super.toString() + " " + productId + " " + relateProductId;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof RelateProduct)) {
                return false;
        }
        RelateProduct that = (RelateProduct) obj;
        if (that.getProductId() != this.getProductId()) {
                return false;
        }
        if (that.getRelateProductId() != this.getRelateProductId()) {
                return false;
        }
    return true;
    }

}
