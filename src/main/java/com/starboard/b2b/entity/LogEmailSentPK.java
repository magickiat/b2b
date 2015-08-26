
package com.starboard.b2b.entity;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class LogEmailSentPK  implements Serializable {
    
    /** Creates a new instance of LogEmailSent */
    public LogEmailSentPK(
            long logEmailSentId	
        ) {
        this.logEmailSentId = logEmailSentId;	
    }
    private long logEmailSentId;	

    public long getLogEmailSentId() {
        return this.logEmailSentId;
    }		
    public void setLogEmailSentId(long logEmailSentId) {
        this.logEmailSentId = logEmailSentId;
    }

    public String toString() {
        return super.toString() + " " + logEmailSentId;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof LogEmailSent)) {
                return false;
        }
        LogEmailSent that = (LogEmailSent) obj;
        if (that.getLogEmailSentId() != this.getLogEmailSentId()) {
                return false;
        }
    return true;
    }

}
