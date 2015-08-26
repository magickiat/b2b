
package com.starboard.b2b.entity;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class OtherPK  implements Serializable {
    
    /** Creates a new instance of Other */
    public OtherPK(
            long otherId	
        ) {
        this.otherId = otherId;	
    }
    private long otherId;	

    public long getOtherId() {
        return this.otherId;
    }		
    public void setOtherId(long otherId) {
        this.otherId = otherId;
    }

    public String toString() {
        return super.toString() + " " + otherId;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof Other)) {
                return false;
        }
        Other that = (Other) obj;
        if (that.getOtherId() != this.getOtherId()) {
                return false;
        }
    return true;
    }

}
