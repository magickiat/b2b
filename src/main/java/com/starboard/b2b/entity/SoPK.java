
package com.starboard.b2b.entity;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class SoPK  implements Serializable {
    
    /** Creates a new instance of So */
    public SoPK(
            long soId	
        ) {
        this.soId = soId;	
    }
    private long soId;	

    public long getSoId() {
        return this.soId;
    }		
    public void setSoId(long soId) {
        this.soId = soId;
    }

    public String toString() {
        return super.toString() + " " + soId;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof So)) {
                return false;
        }
        So that = (So) obj;
        if (that.getSoId() != this.getSoId()) {
                return false;
        }
    return true;
    }

}
