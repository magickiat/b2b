
package com.starboard.b2b.entity;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class CustUserPK  implements Serializable {
    
    /** Creates a new instance of CustUser */
    public CustUserPK(
            String custUserId	
        ) {
        this.custUserId = custUserId;	
    }
    private String custUserId;	

    public String getCustUserId() {
        return this.custUserId;
    }		
    public void setCustUserId(String custUserId) {
        this.custUserId = custUserId;
    }

    public String toString() {
        return super.toString() + " " + custUserId;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof CustUser)) {
                return false;
        }
        CustUser that = (CustUser) obj;
        if (!(that.getCustUserId() == null ? this.getCustUserId() == null
                        : that.getCustUserId().equals(this.getCustUserId()))) {
                return false;
        }
    return true;
    }

}
