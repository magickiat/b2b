
package com.starboard.b2b.entity;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class TmpProductPK  implements Serializable {
    
    /** Creates a new instance of TmpProduct */
    public TmpProductPK(
            long productId	
        ) {
        this.productId = productId;	
    }
    private long productId;	

    public long getProductId() {
        return this.productId;
    }		
    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String toString() {
        return super.toString() + " " + productId;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof TmpProduct)) {
                return false;
        }
        TmpProduct that = (TmpProduct) obj;
        if (that.getProductId() != this.getProductId()) {
                return false;
        }
    return true;
    }

}
