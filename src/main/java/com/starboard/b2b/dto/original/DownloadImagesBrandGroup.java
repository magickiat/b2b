
package com.starboard.b2b.dto.original;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class DownloadImagesBrandGroup implements Serializable {
    
    /** Creates a new instance of DownloadImagesBrandGroup */
    public DownloadImagesBrandGroup() {
    }
    public DownloadImagesBrandGroup(
            long downloadImagesBrandGroupId	
            , long brandGroupId	
            , long downloadImagesId	
            , String userCreate	
            , String userUpdate	
            , java.sql.Timestamp timeCreate	
            , java.sql.Timestamp timeUpdate	
        ) {
        this.downloadImagesBrandGroupId = downloadImagesBrandGroupId;	
        this.brandGroupId = brandGroupId;	
        this.downloadImagesId = downloadImagesId;	
        this.userCreate = userCreate;	
        this.userUpdate = userUpdate;	
        this.timeCreate = timeCreate;	
        this.timeUpdate = timeUpdate;	
    }
    private long downloadImagesBrandGroupId;	
    private long brandGroupId;	
    private long downloadImagesId;	
    private String userCreate;	
    private String userUpdate;	
    private java.sql.Timestamp timeCreate;	
    private java.sql.Timestamp timeUpdate;	



    public long getDownloadImagesBrandGroupId() {
        return this.downloadImagesBrandGroupId;
    }		
    public void setDownloadImagesBrandGroupId(long downloadImagesBrandGroupId) {
        this.downloadImagesBrandGroupId = downloadImagesBrandGroupId;
    }
    public long getBrandGroupId() {
        return this.brandGroupId;
    }		
    public void setBrandGroupId(long brandGroupId) {
        this.brandGroupId = brandGroupId;
    }
    public long getDownloadImagesId() {
        return this.downloadImagesId;
    }		
    public void setDownloadImagesId(long downloadImagesId) {
        this.downloadImagesId = downloadImagesId;
    }
    public String getUserCreate() {
        return this.userCreate;
    }		
    public void setUserCreate(String userCreate) {
        this.userCreate = userCreate;
    }
    public String getUserUpdate() {
        return this.userUpdate;
    }		
    public void setUserUpdate(String userUpdate) {
        this.userUpdate = userUpdate;
    }
    public java.sql.Timestamp getTimeCreate() {
        return this.timeCreate;
    }		
    public void setTimeCreate(java.sql.Timestamp timeCreate) {
        this.timeCreate = timeCreate;
    }
    public java.sql.Timestamp getTimeUpdate() {
        return this.timeUpdate;
    }		
    public void setTimeUpdate(java.sql.Timestamp timeUpdate) {
        this.timeUpdate = timeUpdate;
    }



    public String toString() {
        return super.toString() + "downloadImagesBrandGroupId=[" + downloadImagesBrandGroupId + "]\n" + "brandGroupId=[" + brandGroupId + "]\n" + "downloadImagesId=[" + downloadImagesId + "]\n" + "userCreate=[" + userCreate + "]\n" + "userUpdate=[" + userUpdate + "]\n" + "timeCreate=[" + timeCreate + "]\n" + "timeUpdate=[" + timeUpdate + "]\n";
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
        if (that.getBrandGroupId() != this.getBrandGroupId()) {
                return false;
        }
        if (that.getDownloadImagesId() != this.getDownloadImagesId()) {
                return false;
        }
        if (!(that.getUserCreate() == null ? this.getUserCreate() == null
                        : that.getUserCreate().equals(this.getUserCreate()))) {
                return false;
        }
        if (!(that.getUserUpdate() == null ? this.getUserUpdate() == null
                        : that.getUserUpdate().equals(this.getUserUpdate()))) {
                return false;
        }
        if (!(that.getTimeCreate() == null ? this.getTimeCreate() == null
                        : that.getTimeCreate().equals(this.getTimeCreate()))) {
                return false;
        }
        if (!(that.getTimeUpdate() == null ? this.getTimeUpdate() == null
                        : that.getTimeUpdate().equals(this.getTimeUpdate()))) {
                return false;
        }
    return true;
    }

}
