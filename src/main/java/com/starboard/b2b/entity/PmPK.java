
package com.starboard.b2b.entity;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class PmPK  implements Serializable {
    
    /** Creates a new instance of Pm */
    public PmPK(
            long pmId	
        ) {
        this.pmId = pmId;	
    }
    private long pmId;	

    public long getPmId() {
        return this.pmId;
    }		
    public void setPmId(long pmId) {
        this.pmId = pmId;
    }

    public String toString() {
        return super.toString() + " " + pmId;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof Pm)) {
                return false;
        }
        Pm that = (Pm) obj;
        if (that.getPmId() != this.getPmId()) {
                return false;
        }
    return true;
    }

}
