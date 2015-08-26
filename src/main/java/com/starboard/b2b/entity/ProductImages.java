
package com.starboard.b2b.entity;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class ProductImages implements Serializable {
    
    /** Creates a new instance of ProductImages */
    public ProductImages() {
    }
    public ProductImages(
            long productImageId	
            , long productId	
            , String imagePath	
            , String oldName	
            , String type	
            , long seq	
            , String userCreate	
            , String userUpdate	
            , java.sql.Timestamp timeCreate	
            , java.sql.Timestamp timeUpdate	
        ) {
        this.productImageId = productImageId;	
        this.productId = productId;	
        this.imagePath = imagePath;	
        this.oldName = oldName;	
        this.type = type;	
        this.seq = seq;	
        this.userCreate = userCreate;	
        this.userUpdate = userUpdate;	
        this.timeCreate = timeCreate;	
        this.timeUpdate = timeUpdate;	
    }
    private long productImageId;	
    private long productId;	
    private String imagePath;	
    private String oldName;	
    private String type;	
    private long seq;	
    private String userCreate;	
    private String userUpdate;	
    private java.sql.Timestamp timeCreate;	
    private java.sql.Timestamp timeUpdate;	



    public long getProductImageId() {
        return this.productImageId;
    }		
    public void setProductImageId(long productImageId) {
        this.productImageId = productImageId;
    }
    public long getProductId() {
        return this.productId;
    }		
    public void setProductId(long productId) {
        this.productId = productId;
    }
    public String getImagePath() {
        return this.imagePath;
    }		
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
    public String getOldName() {
        return this.oldName;
    }		
    public void setOldName(String oldName) {
        this.oldName = oldName;
    }
    public String getType() {
        return this.type;
    }		
    public void setType(String type) {
        this.type = type;
    }
    public long getSeq() {
        return this.seq;
    }		
    public void setSeq(long seq) {
        this.seq = seq;
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
        return super.toString() + "productImageId=[" + productImageId + "]\n" + "productId=[" + productId + "]\n" + "imagePath=[" + imagePath + "]\n" + "oldName=[" + oldName + "]\n" + "type=[" + type + "]\n" + "seq=[" + seq + "]\n" + "userCreate=[" + userCreate + "]\n" + "userUpdate=[" + userUpdate + "]\n" + "timeCreate=[" + timeCreate + "]\n" + "timeUpdate=[" + timeUpdate + "]\n";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof ProductImages)) {
                return false;
        }
        ProductImages that = (ProductImages) obj;
        if (that.getProductImageId() != this.getProductImageId()) {
                return false;
        }
        if (that.getProductId() != this.getProductId()) {
                return false;
        }
        if (!(that.getImagePath() == null ? this.getImagePath() == null
                        : that.getImagePath().equals(this.getImagePath()))) {
                return false;
        }
        if (!(that.getOldName() == null ? this.getOldName() == null
                        : that.getOldName().equals(this.getOldName()))) {
                return false;
        }
        if (!(that.getType() == null ? this.getType() == null
                        : that.getType().equals(this.getType()))) {
                return false;
        }
        if (that.getSeq() != this.getSeq()) {
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
