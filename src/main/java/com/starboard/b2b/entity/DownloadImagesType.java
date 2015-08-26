
package com.starboard.b2b.entity;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class DownloadImagesType implements Serializable {
    
    /** Creates a new instance of DownloadImagesType */
    public DownloadImagesType() {
    }
    public DownloadImagesType(
            long downloadImagesTypeId	
            , long productTypeId	
            , long downloadImagesId	
            , String userCreate	
            , String userUpdate	
            , java.sql.Timestamp timeCreate	
            , java.sql.Timestamp timeUpdate	
        ) {
        this.downloadImagesTypeId = downloadImagesTypeId;	
        this.productTypeId = productTypeId;	
        this.downloadImagesId = downloadImagesId;	
        this.userCreate = userCreate;	
        this.userUpdate = userUpdate;	
        this.timeCreate = timeCreate;	
        this.timeUpdate = timeUpdate;	
    }
    private long downloadImagesTypeId;	
    private long productTypeId;	
    private long downloadImagesId;	
    private String userCreate;	
    private String userUpdate;	
    private java.sql.Timestamp timeCreate;	
    private java.sql.Timestamp timeUpdate;	



    public long getDownloadImagesTypeId() {
        return this.downloadImagesTypeId;
    }		
    public void setDownloadImagesTypeId(long downloadImagesTypeId) {
        this.downloadImagesTypeId = downloadImagesTypeId;
    }
    public long getProductTypeId() {
        return this.productTypeId;
    }		
    public void setProductTypeId(long productTypeId) {
        this.productTypeId = productTypeId;
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
        return super.toString() + "downloadImagesTypeId=[" + downloadImagesTypeId + "]\n" + "productTypeId=[" + productTypeId + "]\n" + "downloadImagesId=[" + downloadImagesId + "]\n" + "userCreate=[" + userCreate + "]\n" + "userUpdate=[" + userUpdate + "]\n" + "timeCreate=[" + timeCreate + "]\n" + "timeUpdate=[" + timeUpdate + "]\n";
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
        if (that.getProductTypeId() != this.getProductTypeId()) {
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
