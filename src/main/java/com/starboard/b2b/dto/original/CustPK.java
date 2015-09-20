
package com.starboard.b2b.dto.original;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class CustPK  implements Serializable {
    
    /** Creates a new instance of Cust */
    public CustPK(
            long custId	
        ) {
        this.custId = custId;	
    }
    private long custId;	

    public long getCustId() {
        return this.custId;
    }		
    public void setCustId(long custId) {
        this.custId = custId;
    }

    public String toString() {
        return super.toString() + " " + custId;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof Cust)) {
                return false;
        }
        Cust that = (Cust) obj;
        if (that.getCustId() != this.getCustId()) {
                return false;
        }
    return true;
    }

}
