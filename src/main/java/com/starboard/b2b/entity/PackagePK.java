
package com.starboard.b2b.entity;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class PackagePK  implements Serializable {
    
    /** Creates a new instance of Package */
    public PackagePK(
            long packageId	
        ) {
        this.packageId = packageId;	
    }
    private long packageId;	

    public long getPackageId() {
        return this.packageId;
    }		
    public void setPackageId(long packageId) {
        this.packageId = packageId;
    }

    public String toString() {
        return super.toString() + " " + packageId;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof Package)) {
                return false;
        }
        Package that = (Package) obj;
        if (that.getPackageId() != this.getPackageId()) {
                return false;
        }
    return true;
    }

}
