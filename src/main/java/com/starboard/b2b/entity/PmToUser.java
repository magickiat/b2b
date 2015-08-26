
package com.starboard.b2b.entity;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class PmToUser implements Serializable {
    
    /** Creates a new instance of PmToUser */
    public PmToUser() {
    }
    public PmToUser(
            long pmId	
            , String userId	
            , java.sql.Timestamp timeView	
        ) {
        this.pmId = pmId;	
        this.userId = userId;	
        this.timeView = timeView;	
    }
    private long pmId;	
    private String userId;	
    private java.sql.Timestamp timeView;	



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
    public java.sql.Timestamp getTimeView() {
        return this.timeView;
    }		
    public void setTimeView(java.sql.Timestamp timeView) {
        this.timeView = timeView;
    }



    public String toString() {
        return super.toString() + "pmId=[" + pmId + "]\n" + "userId=[" + userId + "]\n" + "timeView=[" + timeView + "]\n";
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
        if (!(that.getTimeView() == null ? this.getTimeView() == null
                        : that.getTimeView().equals(this.getTimeView()))) {
                return false;
        }
    return true;
    }

}
