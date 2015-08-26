
package com.starboard.b2b.entity;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class TmpProductItemGroupPK  implements Serializable {
    
    /** Creates a new instance of TmpProductItemGroup */
    public TmpProductItemGroupPK(
            String productItemGroupId	
        ) {
        this.productItemGroupId = productItemGroupId;	
    }
    private String productItemGroupId;	

    public String getProductItemGroupId() {
        return this.productItemGroupId;
    }		
    public void setProductItemGroupId(String productItemGroupId) {
        this.productItemGroupId = productItemGroupId;
    }

    public String toString() {
        return super.toString() + " " + productItemGroupId;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof TmpProductItemGroup)) {
                return false;
        }
        TmpProductItemGroup that = (TmpProductItemGroup) obj;
        if (!(that.getProductItemGroupId() == null ? this.getProductItemGroupId() == null
                        : that.getProductItemGroupId().equals(this.getProductItemGroupId()))) {
                return false;
        }
    return true;
    }

}
