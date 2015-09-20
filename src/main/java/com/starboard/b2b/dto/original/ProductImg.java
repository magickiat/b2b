
package com.starboard.b2b.dto.original;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class ProductImg implements Serializable {
    
    /** Creates a new instance of ProductImg */
    public ProductImg() {
    }
    public ProductImg(
            long productImgId	
            , String productCode	
            , String imgPath	
            , String productImgType	
            , String userCreate	
            , String userUpdate	
            , java.sql.Timestamp timeCreate	
            , java.sql.Timestamp timeUpdate	
        ) {
        this.productImgId = productImgId;	
        this.productCode = productCode;	
        this.imgPath = imgPath;	
        this.productImgType = productImgType;	
        this.userCreate = userCreate;	
        this.userUpdate = userUpdate;	
        this.timeCreate = timeCreate;	
        this.timeUpdate = timeUpdate;	
    }
    private long productImgId;	
    private String productCode;	
    private String imgPath;	
    private String productImgType;	
    private String userCreate;	
    private String userUpdate;	
    private java.sql.Timestamp timeCreate;	
    private java.sql.Timestamp timeUpdate;	



    public long getProductImgId() {
        return this.productImgId;
    }		
    public void setProductImgId(long productImgId) {
        this.productImgId = productImgId;
    }
    public String getProductCode() {
        return this.productCode;
    }		
    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }
    public String getImgPath() {
        return this.imgPath;
    }		
    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }
    public String getProductImgType() {
        return this.productImgType;
    }		
    public void setProductImgType(String productImgType) {
        this.productImgType = productImgType;
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
        return super.toString() + "productImgId=[" + productImgId + "]\n" + "productCode=[" + productCode + "]\n" + "imgPath=[" + imgPath + "]\n" + "productImgType=[" + productImgType + "]\n" + "userCreate=[" + userCreate + "]\n" + "userUpdate=[" + userUpdate + "]\n" + "timeCreate=[" + timeCreate + "]\n" + "timeUpdate=[" + timeUpdate + "]\n";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof ProductImg)) {
                return false;
        }
        ProductImg that = (ProductImg) obj;
        if (that.getProductImgId() != this.getProductImgId()) {
                return false;
        }
        if (!(that.getProductCode() == null ? this.getProductCode() == null
                        : that.getProductCode().equals(this.getProductCode()))) {
                return false;
        }
        if (!(that.getImgPath() == null ? this.getImgPath() == null
                        : that.getImgPath().equals(this.getImgPath()))) {
                return false;
        }
        if (!(that.getProductImgType() == null ? this.getProductImgType() == null
                        : that.getProductImgType().equals(this.getProductImgType()))) {
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
