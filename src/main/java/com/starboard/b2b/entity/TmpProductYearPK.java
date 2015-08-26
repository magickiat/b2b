
package com.starboard.b2b.entity;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class TmpProductYearPK  implements Serializable {
    
    /** Creates a new instance of TmpProductYear */
    public TmpProductYearPK(
            String productYearId	
        ) {
        this.productYearId = productYearId;	
    }
    private String productYearId;	

    public String getProductYearId() {
        return this.productYearId;
    }		
    public void setProductYearId(String productYearId) {
        this.productYearId = productYearId;
    }

    public String toString() {
        return super.toString() + " " + productYearId;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof TmpProductYear)) {
                return false;
        }
        TmpProductYear that = (TmpProductYear) obj;
        if (!(that.getProductYearId() == null ? this.getProductYearId() == null
                        : that.getProductYearId().equals(this.getProductYearId()))) {
                return false;
        }
    return true;
    }

}
