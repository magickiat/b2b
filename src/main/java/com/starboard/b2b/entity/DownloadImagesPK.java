
package com.starboard.b2b.entity;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class DownloadImagesPK  implements Serializable {
    
    /** Creates a new instance of DownloadImages */
    public DownloadImagesPK(
            long downloadImagesId	
        ) {
        this.downloadImagesId = downloadImagesId;	
    }
    private long downloadImagesId;	

    public long getDownloadImagesId() {
        return this.downloadImagesId;
    }		
    public void setDownloadImagesId(long downloadImagesId) {
        this.downloadImagesId = downloadImagesId;
    }

    public String toString() {
        return super.toString() + " " + downloadImagesId;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof DownloadImages)) {
                return false;
        }
        DownloadImages that = (DownloadImages) obj;
        if (that.getDownloadImagesId() != this.getDownloadImagesId()) {
                return false;
        }
    return true;
    }

}
