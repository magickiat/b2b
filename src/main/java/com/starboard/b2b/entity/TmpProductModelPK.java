
package com.starboard.b2b.entity;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class TmpProductModelPK  implements Serializable {
    
    /** Creates a new instance of TmpProductModel */
    public TmpProductModelPK(
            String productModelId	
        ) {
        this.productModelId = productModelId;	
    }
    private String productModelId;	

    public String getProductModelId() {
        return this.productModelId;
    }		
    public void setProductModelId(String productModelId) {
        this.productModelId = productModelId;
    }

    public String toString() {
        return super.toString() + " " + productModelId;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof TmpProductModel)) {
                return false;
        }
        TmpProductModel that = (TmpProductModel) obj;
        if (!(that.getProductModelId() == null ? this.getProductModelId() == null
                        : that.getProductModelId().equals(this.getProductModelId()))) {
                return false;
        }
    return true;
    }

}
