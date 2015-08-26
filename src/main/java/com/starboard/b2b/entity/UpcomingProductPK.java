
package com.starboard.b2b.entity;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class UpcomingProductPK  implements Serializable {
    
    /** Creates a new instance of UpcomingProduct */
    public UpcomingProductPK(
            int idUpcomming	
        ) {
        this.idUpcomming = idUpcomming;	
    }
    private int idUpcomming;	

    public int getIdUpcomming() {
        return this.idUpcomming;
    }		
    public void setIdUpcomming(int idUpcomming) {
        this.idUpcomming = idUpcomming;
    }

    public String toString() {
        return super.toString() + " " + idUpcomming;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof UpcomingProduct)) {
                return false;
        }
        UpcomingProduct that = (UpcomingProduct) obj;
        if (that.getIdUpcomming() != this.getIdUpcomming()) {
                return false;
        }
    return true;
    }

}
