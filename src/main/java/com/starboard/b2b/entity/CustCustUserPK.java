
package com.starboard.b2b.entity;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class CustCustUserPK  implements Serializable {
    
    /** Creates a new instance of CustCustUser */
    public CustCustUserPK(
            String custUserId	
            , long custId	
        ) {
        this.custUserId = custUserId;	
        this.custId = custId;	
    }
    private String custUserId;	
    private long custId;	

    public String getCustUserId() {
        return this.custUserId;
    }		
    public void setCustUserId(String custUserId) {
        this.custUserId = custUserId;
    }
    public long getCustId() {
        return this.custId;
    }		
    public void setCustId(long custId) {
        this.custId = custId;
    }

    public String toString() {
        return super.toString() + " " + custUserId + " " + custId;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof CustCustUser)) {
                return false;
        }
        CustCustUser that = (CustCustUser) obj;
        if (!(that.getCustUserId() == null ? this.getCustUserId() == null
                        : that.getCustUserId().equals(this.getCustUserId()))) {
                return false;
        }
        if (that.getCustId() != this.getCustId()) {
                return false;
        }
    return true;
    }

}
