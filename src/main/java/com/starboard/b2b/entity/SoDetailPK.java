
package com.starboard.b2b.entity;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class SoDetailPK  implements Serializable {
    
    /** Creates a new instance of SoDetail */
    public SoDetailPK(
            long soProductId	
        ) {
        this.soProductId = soProductId;	
    }
    private long soProductId;	

    public long getSoProductId() {
        return this.soProductId;
    }		
    public void setSoProductId(long soProductId) {
        this.soProductId = soProductId;
    }

    public String toString() {
        return super.toString() + " " + soProductId;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof SoDetail)) {
                return false;
        }
        SoDetail that = (SoDetail) obj;
        if (that.getSoProductId() != this.getSoProductId()) {
                return false;
        }
    return true;
    }

}
