
package com.starboard.b2b.entity;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class PmToUserPK  implements Serializable {
    
    /** Creates a new instance of PmToUser */
    public PmToUserPK(
            long pmId	
            , String userId	
        ) {
        this.pmId = pmId;	
        this.userId = userId;	
    }
    private long pmId;	
    private String userId;	

    public long getPmId() {
        return this.pmId;
    }		
    public void setPmId(long pmId) {
        this.pmId = pmId;
    }
    public String getUserId() {
        return this.userId;
    }		
    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String toString() {
        return super.toString() + " " + pmId + " " + userId;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof PmToUser)) {
                return false;
        }
        PmToUser that = (PmToUser) obj;
        if (that.getPmId() != this.getPmId()) {
                return false;
        }
        if (!(that.getUserId() == null ? this.getUserId() == null
                        : that.getUserId().equals(this.getUserId()))) {
                return false;
        }
    return true;
    }

}
