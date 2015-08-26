
package com.starboard.b2b.entity;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class TmpProductBuyerGroupPK  implements Serializable {
    
    /** Creates a new instance of TmpProductBuyerGroup */
    public TmpProductBuyerGroupPK(
            String productBuyerGroupId	
        ) {
        this.productBuyerGroupId = productBuyerGroupId;	
    }
    private String productBuyerGroupId;	

    public String getProductBuyerGroupId() {
        return this.productBuyerGroupId;
    }		
    public void setProductBuyerGroupId(String productBuyerGroupId) {
        this.productBuyerGroupId = productBuyerGroupId;
    }

    public String toString() {
        return super.toString() + " " + productBuyerGroupId;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof TmpProductBuyerGroup)) {
                return false;
        }
        TmpProductBuyerGroup that = (TmpProductBuyerGroup) obj;
        if (!(that.getProductBuyerGroupId() == null ? this.getProductBuyerGroupId() == null
                        : that.getProductBuyerGroupId().equals(this.getProductBuyerGroupId()))) {
                return false;
        }
    return true;
    }

}
