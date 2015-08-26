
package com.starboard.b2b.entity;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class MobileTypePK  implements Serializable {
    
    /** Creates a new instance of MobileType */
    public MobileTypePK(
            String mobileId	
        ) {
        this.mobileId = mobileId;	
    }
    private String mobileId;	

    public String getMobileId() {
        return this.mobileId;
    }		
    public void setMobileId(String mobileId) {
        this.mobileId = mobileId;
    }

    public String toString() {
        return super.toString() + " " + mobileId;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof MobileType)) {
                return false;
        }
        MobileType that = (MobileType) obj;
        if (!(that.getMobileId() == null ? this.getMobileId() == null
                        : that.getMobileId().equals(this.getMobileId()))) {
                return false;
        }
    return true;
    }

}
