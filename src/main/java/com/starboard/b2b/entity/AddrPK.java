
package com.starboard.b2b.entity;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class AddrPK  implements Serializable {
    
    /** Creates a new instance of Addr */
    public AddrPK(
            long addrId	
        ) {
        this.addrId = addrId;	
    }
    private long addrId;	

    public long getAddrId() {
        return this.addrId;
    }		
    public void setAddrId(long addrId) {
        this.addrId = addrId;
    }

    public String toString() {
        return super.toString() + " " + addrId;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof Addr)) {
                return false;
        }
        Addr that = (Addr) obj;
        if (that.getAddrId() != this.getAddrId()) {
                return false;
        }
    return true;
    }

}
