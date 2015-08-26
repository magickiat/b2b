
package com.starboard.b2b.entity;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class PackagesPK  implements Serializable {
    
    /** Creates a new instance of Packages */
    public PackagesPK(
            long packagesId	
        ) {
        this.packagesId = packagesId;	
    }
    private long packagesId;	

    public long getPackagesId() {
        return this.packagesId;
    }		
    public void setPackagesId(long packagesId) {
        this.packagesId = packagesId;
    }

    public String toString() {
        return super.toString() + " " + packagesId;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof Packages)) {
                return false;
        }
        Packages that = (Packages) obj;
        if (that.getPackagesId() != this.getPackagesId()) {
                return false;
        }
    return true;
    }

}
