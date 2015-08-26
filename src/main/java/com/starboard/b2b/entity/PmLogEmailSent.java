
package com.starboard.b2b.entity;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class PmLogEmailSent implements Serializable {
    
    /** Creates a new instance of PmLogEmailSent */
    public PmLogEmailSent() {
    }
    public PmLogEmailSent(
            long pmId	
            , long logEmailSentId	
        ) {
        this.pmId = pmId;	
        this.logEmailSentId = logEmailSentId;	
    }
    private long pmId;	
    private long logEmailSentId;	



    public long getPmId() {
        return this.pmId;
    }		
    public void setPmId(long pmId) {
        this.pmId = pmId;
    }
    public long getLogEmailSentId() {
        return this.logEmailSentId;
    }		
    public void setLogEmailSentId(long logEmailSentId) {
        this.logEmailSentId = logEmailSentId;
    }



    public String toString() {
        return super.toString() + "pmId=[" + pmId + "]\n" + "logEmailSentId=[" + logEmailSentId + "]\n";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof PmLogEmailSent)) {
                return false;
        }
        PmLogEmailSent that = (PmLogEmailSent) obj;
        if (that.getPmId() != this.getPmId()) {
                return false;
        }
        if (that.getLogEmailSentId() != this.getLogEmailSentId()) {
                return false;
        }
    return true;
    }

}
