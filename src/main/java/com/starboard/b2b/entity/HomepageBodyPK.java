
package com.starboard.b2b.entity;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class HomepageBodyPK  implements Serializable {
    
    /** Creates a new instance of HomepageBody */
    public HomepageBodyPK(
            long homepageBodyId	
        ) {
        this.homepageBodyId = homepageBodyId;	
    }
    private long homepageBodyId;	

    public long getHomepageBodyId() {
        return this.homepageBodyId;
    }		
    public void setHomepageBodyId(long homepageBodyId) {
        this.homepageBodyId = homepageBodyId;
    }

    public String toString() {
        return super.toString() + " " + homepageBodyId;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof HomepageBody)) {
                return false;
        }
        HomepageBody that = (HomepageBody) obj;
        if (that.getHomepageBodyId() != this.getHomepageBodyId()) {
                return false;
        }
    return true;
    }

}
