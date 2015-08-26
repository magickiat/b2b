
package com.starboard.b2b.entity;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class PmImg implements Serializable {
    
    /** Creates a new instance of PmImg */
    public PmImg() {
    }
    public PmImg(
            long pmId	
            , String imgPath	
        ) {
        this.pmId = pmId;	
        this.imgPath = imgPath;	
    }
    private long pmId;	
    private String imgPath;	



    public long getPmId() {
        return this.pmId;
    }		
    public void setPmId(long pmId) {
        this.pmId = pmId;
    }
    public String getImgPath() {
        return this.imgPath;
    }		
    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }



    public String toString() {
        return super.toString() + "pmId=[" + pmId + "]\n" + "imgPath=[" + imgPath + "]\n";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof PmImg)) {
                return false;
        }
        PmImg that = (PmImg) obj;
        if (that.getPmId() != this.getPmId()) {
                return false;
        }
        if (!(that.getImgPath() == null ? this.getImgPath() == null
                        : that.getImgPath().equals(this.getImgPath()))) {
                return false;
        }
    return true;
    }

}
