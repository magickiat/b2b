
package com.starboard.b2b.entity;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class PositionPK  implements Serializable {
    
    /** Creates a new instance of Position */
    public PositionPK(
            long positionId	
        ) {
        this.positionId = positionId;	
    }
    private long positionId;	

    public long getPositionId() {
        return this.positionId;
    }		
    public void setPositionId(long positionId) {
        this.positionId = positionId;
    }

    public String toString() {
        return super.toString() + " " + positionId;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof Position)) {
                return false;
        }
        Position that = (Position) obj;
        if (that.getPositionId() != this.getPositionId()) {
                return false;
        }
    return true;
    }

}
