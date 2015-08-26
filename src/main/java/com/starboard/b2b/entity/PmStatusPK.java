
package com.starboard.b2b.entity;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class PmStatusPK  implements Serializable {
    
    /** Creates a new instance of PmStatus */
    public PmStatusPK(
            String pmStatusId	
        ) {
        this.pmStatusId = pmStatusId;	
    }
    private String pmStatusId;	

    public String getPmStatusId() {
        return this.pmStatusId;
    }		
    public void setPmStatusId(String pmStatusId) {
        this.pmStatusId = pmStatusId;
    }

    public String toString() {
        return super.toString() + " " + pmStatusId;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof PmStatus)) {
                return false;
        }
        PmStatus that = (PmStatus) obj;
        if (!(that.getPmStatusId() == null ? this.getPmStatusId() == null
                        : that.getPmStatusId().equals(this.getPmStatusId()))) {
                return false;
        }
    return true;
    }

}
