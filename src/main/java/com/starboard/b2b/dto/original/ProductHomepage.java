
package com.starboard.b2b.dto.original;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class ProductHomepage implements Serializable {
    
    /** Creates a new instance of ProductHomepage */
    public ProductHomepage() {
    }
    public ProductHomepage(
            long productHomepageId	
            , long homePageId	
            , long productId	
            , long priority	
            , String userCreate	
            , String userUpdate	
            , java.sql.Timestamp timeCreate	
            , java.sql.Timestamp timeUpdate	
        ) {
        this.productHomepageId = productHomepageId;	
        this.homePageId = homePageId;	
        this.productId = productId;	
        this.priority = priority;	
        this.userCreate = userCreate;	
        this.userUpdate = userUpdate;	
        this.timeCreate = timeCreate;	
        this.timeUpdate = timeUpdate;	
    }
    private long productHomepageId;	
    private long homePageId;	
    private long productId;	
    private long priority;	
    private String userCreate;	
    private String userUpdate;	
    private java.sql.Timestamp timeCreate;	
    private java.sql.Timestamp timeUpdate;	



    public long getProductHomepageId() {
        return this.productHomepageId;
    }		
    public void setProductHomepageId(long productHomepageId) {
        this.productHomepageId = productHomepageId;
    }
    public long getHomePageId() {
        return this.homePageId;
    }		
    public void setHomePageId(long homePageId) {
        this.homePageId = homePageId;
    }
    public long getProductId() {
        return this.productId;
    }		
    public void setProductId(long productId) {
        this.productId = productId;
    }
    public long getPriority() {
        return this.priority;
    }		
    public void setPriority(long priority) {
        this.priority = priority;
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
        return super.toString() + "productHomepageId=[" + productHomepageId + "]\n" + "homePageId=[" + homePageId + "]\n" + "productId=[" + productId + "]\n" + "priority=[" + priority + "]\n" + "userCreate=[" + userCreate + "]\n" + "userUpdate=[" + userUpdate + "]\n" + "timeCreate=[" + timeCreate + "]\n" + "timeUpdate=[" + timeUpdate + "]\n";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof ProductHomepage)) {
                return false;
        }
        ProductHomepage that = (ProductHomepage) obj;
        if (that.getProductHomepageId() != this.getProductHomepageId()) {
                return false;
        }
        if (that.getHomePageId() != this.getHomePageId()) {
                return false;
        }
        if (that.getProductId() != this.getProductId()) {
                return false;
        }
        if (that.getPriority() != this.getPriority()) {
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
