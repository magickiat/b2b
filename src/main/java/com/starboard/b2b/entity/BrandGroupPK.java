
package com.starboard.b2b.entity;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class BrandGroupPK  implements Serializable {
    
    /** Creates a new instance of BrandGroup */
    public BrandGroupPK(
            long brandGroupId	
        ) {
        this.brandGroupId = brandGroupId;	
    }
    private long brandGroupId;	

    public long getBrandGroupId() {
        return this.brandGroupId;
    }		
    public void setBrandGroupId(long brandGroupId) {
        this.brandGroupId = brandGroupId;
    }

    public String toString() {
        return super.toString() + " " + brandGroupId;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof BrandGroup)) {
                return false;
        }
        BrandGroup that = (BrandGroup) obj;
        if (that.getBrandGroupId() != this.getBrandGroupId()) {
                return false;
        }
    return true;
    }

}
