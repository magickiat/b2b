
package com.starboard.b2b.entity;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class DownloadImagesBrandGroupPK  implements Serializable {
    
    /** Creates a new instance of DownloadImagesBrandGroup */
    public DownloadImagesBrandGroupPK(
            long downloadImagesBrandGroupId	
        ) {
        this.downloadImagesBrandGroupId = downloadImagesBrandGroupId;	
    }
    private long downloadImagesBrandGroupId;	

    public long getDownloadImagesBrandGroupId() {
        return this.downloadImagesBrandGroupId;
    }		
    public void setDownloadImagesBrandGroupId(long downloadImagesBrandGroupId) {
        this.downloadImagesBrandGroupId = downloadImagesBrandGroupId;
    }

    public String toString() {
        return super.toString() + " " + downloadImagesBrandGroupId;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof DownloadImagesBrandGroup)) {
                return false;
        }
        DownloadImagesBrandGroup that = (DownloadImagesBrandGroup) obj;
        if (that.getDownloadImagesBrandGroupId() != this.getDownloadImagesBrandGroupId()) {
                return false;
        }
    return true;
    }

}
