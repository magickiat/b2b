
package com.starboard.b2b.entity;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class CustBrandGroupPK  implements Serializable {
    
    /** Creates a new instance of CustBrandGroup */
    public CustBrandGroupPK(
            long custId	
            , long brandGroupId	
        ) {
        this.custId = custId;	
        this.brandGroupId = brandGroupId;	
    }
    private long custId;	
    private long brandGroupId;	

    public long getCustId() {
        return this.custId;
    }		
    public void setCustId(long custId) {
        this.custId = custId;
    }
    public long getBrandGroupId() {
        return this.brandGroupId;
    }		
    public void setBrandGroupId(long brandGroupId) {
        this.brandGroupId = brandGroupId;
    }

    public String toString() {
        return super.toString() + " " + custId + " " + brandGroupId;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof CustBrandGroup)) {
                return false;
        }
        CustBrandGroup that = (CustBrandGroup) obj;
        if (that.getCustId() != this.getCustId()) {
                return false;
        }
        if (that.getBrandGroupId() != this.getBrandGroupId()) {
                return false;
        }
    return true;
    }

}
