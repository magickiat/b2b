
package com.starboard.b2b.dto.original;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class ProductModel implements Serializable {
    
    /** Creates a new instance of ProductModel */
    public ProductModel() {
    }
    public ProductModel(
            String productModelId	
            , String productModelName	
            , String description	
            , String userCreate	
            , String userUpdate	
            , java.sql.Timestamp timeCreate	
            , java.sql.Timestamp timeUpdate	
            , String image	
            , String headerText1	
            , String headerText2	
        ) {
        this.productModelId = productModelId;	
        this.productModelName = productModelName;	
        this.description = description;	
        this.userCreate = userCreate;	
        this.userUpdate = userUpdate;	
        this.timeCreate = timeCreate;	
        this.timeUpdate = timeUpdate;	
        this.image = image;	
        this.headerText1 = headerText1;	
        this.headerText2 = headerText2;	
    }
    private String productModelId;	
    private String productModelName;	
    private String description;	
    private String userCreate;	
    private String userUpdate;	
    private java.sql.Timestamp timeCreate;	
    private java.sql.Timestamp timeUpdate;	
    private String image;	
    private String headerText1;	
    private String headerText2;	



    public String getProductModelId() {
        return this.productModelId;
    }		
    public void setProductModelId(String productModelId) {
        this.productModelId = productModelId;
    }
    public String getProductModelName() {
        return this.productModelName;
    }		
    public void setProductModelName(String productModelName) {
        this.productModelName = productModelName;
    }
    public String getDescription() {
        return this.description;
    }		
    public void setDescription(String description) {
        this.description = description;
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
    public String getImage() {
        return this.image;
    }		
    public void setImage(String image) {
        this.image = image;
    }
    public String getHeaderText1() {
        return this.headerText1;
    }		
    public void setHeaderText1(String headerText1) {
        this.headerText1 = headerText1;
    }
    public String getHeaderText2() {
        return this.headerText2;
    }		
    public void setHeaderText2(String headerText2) {
        this.headerText2 = headerText2;
    }



    public String toString() {
        return super.toString() + "productModelId=[" + productModelId + "]\n" + "productModelName=[" + productModelName + "]\n" + "description=[" + description + "]\n" + "userCreate=[" + userCreate + "]\n" + "userUpdate=[" + userUpdate + "]\n" + "timeCreate=[" + timeCreate + "]\n" + "timeUpdate=[" + timeUpdate + "]\n" + "image=[" + image + "]\n" + "headerText1=[" + headerText1 + "]\n" + "headerText2=[" + headerText2 + "]\n";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof ProductModel)) {
                return false;
        }
        ProductModel that = (ProductModel) obj;
        if (!(that.getProductModelId() == null ? this.getProductModelId() == null
                        : that.getProductModelId().equals(this.getProductModelId()))) {
                return false;
        }
        if (!(that.getProductModelName() == null ? this.getProductModelName() == null
                        : that.getProductModelName().equals(this.getProductModelName()))) {
                return false;
        }
        if (!(that.getDescription() == null ? this.getDescription() == null
                        : that.getDescription().equals(this.getDescription()))) {
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
        if (!(that.getImage() == null ? this.getImage() == null
                        : that.getImage().equals(this.getImage()))) {
                return false;
        }
        if (!(that.getHeaderText1() == null ? this.getHeaderText1() == null
                        : that.getHeaderText1().equals(this.getHeaderText1()))) {
                return false;
        }
        if (!(that.getHeaderText2() == null ? this.getHeaderText2() == null
                        : that.getHeaderText2().equals(this.getHeaderText2()))) {
                return false;
        }
    return true;
    }

}
