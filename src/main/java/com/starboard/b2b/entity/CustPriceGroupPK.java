
package com.starboard.b2b.entity;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class CustPriceGroupPK  implements Serializable {
    
    /** Creates a new instance of CustPriceGroup */
    public CustPriceGroupPK(
            long custPriceGroupId	
        ) {
        this.custPriceGroupId = custPriceGroupId;	
    }
    private long custPriceGroupId;	

    public long getCustPriceGroupId() {
        return this.custPriceGroupId;
    }		
    public void setCustPriceGroupId(long custPriceGroupId) {
        this.custPriceGroupId = custPriceGroupId;
    }

    public String toString() {
        return super.toString() + " " + custPriceGroupId;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof CustPriceGroup)) {
                return false;
        }
        CustPriceGroup that = (CustPriceGroup) obj;
        if (that.getCustPriceGroupId() != this.getCustPriceGroupId()) {
                return false;
        }
    return true;
    }

}
