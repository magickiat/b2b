
package com.starboard.b2b.entity;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class DownloadImagesTypePK  implements Serializable {
    
    /** Creates a new instance of DownloadImagesType */
    public DownloadImagesTypePK(
            long downloadImagesTypeId	
        ) {
        this.downloadImagesTypeId = downloadImagesTypeId;	
    }
    private long downloadImagesTypeId;	

    public long getDownloadImagesTypeId() {
        return this.downloadImagesTypeId;
    }		
    public void setDownloadImagesTypeId(long downloadImagesTypeId) {
        this.downloadImagesTypeId = downloadImagesTypeId;
    }

    public String toString() {
        return super.toString() + " " + downloadImagesTypeId;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof DownloadImagesType)) {
                return false;
        }
        DownloadImagesType that = (DownloadImagesType) obj;
        if (that.getDownloadImagesTypeId() != this.getDownloadImagesTypeId()) {
                return false;
        }
    return true;
    }

}
