
package com.starboard.b2b.entity;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class TmpProductUnitPK  implements Serializable {
    
    /** Creates a new instance of TmpProductUnit */
    public TmpProductUnitPK(
            String productUnitId	
        ) {
        this.productUnitId = productUnitId;	
    }
    private String productUnitId;	

    public String getProductUnitId() {
        return this.productUnitId;
    }		
    public void setProductUnitId(String productUnitId) {
        this.productUnitId = productUnitId;
    }

    public String toString() {
        return super.toString() + " " + productUnitId;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof TmpProductUnit)) {
                return false;
        }
        TmpProductUnit that = (TmpProductUnit) obj;
        if (!(that.getProductUnitId() == null ? this.getProductUnitId() == null
                        : that.getProductUnitId().equals(this.getProductUnitId()))) {
                return false;
        }
    return true;
    }

}
