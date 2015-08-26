
package com.starboard.b2b.entity;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class TmpProductTypePK  implements Serializable {
    
    /** Creates a new instance of TmpProductType */
    public TmpProductTypePK(
            long productTypeId	
        ) {
        this.productTypeId = productTypeId;	
    }
    private long productTypeId;	

    public long getProductTypeId() {
        return this.productTypeId;
    }		
    public void setProductTypeId(long productTypeId) {
        this.productTypeId = productTypeId;
    }

    public String toString() {
        return super.toString() + " " + productTypeId;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof TmpProductType)) {
                return false;
        }
        TmpProductType that = (TmpProductType) obj;
        if (that.getProductTypeId() != this.getProductTypeId()) {
                return false;
        }
    return true;
    }

}
