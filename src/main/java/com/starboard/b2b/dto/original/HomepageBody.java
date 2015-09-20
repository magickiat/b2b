
package com.starboard.b2b.dto.original;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class HomepageBody implements Serializable {
    
    /** Creates a new instance of HomepageBody */
    public HomepageBody() {
    }
    public HomepageBody(
            long homepageBodyId	
            , String homepageBody	
            , String homepageBodyPicture	
            , String homepageBodyLink	
            , String userCreate	
            , String userUpdate	
            , java.sql.Timestamp timeCreate	
            , java.sql.Timestamp timeUpdate	
        ) {
        this.homepageBodyId = homepageBodyId;	
        this.homepageBody = homepageBody;	
        this.homepageBodyPicture = homepageBodyPicture;	
        this.homepageBodyLink = homepageBodyLink;	
        this.userCreate = userCreate;	
        this.userUpdate = userUpdate;	
        this.timeCreate = timeCreate;	
        this.timeUpdate = timeUpdate;	
    }
    private long homepageBodyId;	
    private String homepageBody;	
    private String homepageBodyPicture;	
    private String homepageBodyLink;	
    private String userCreate;	
    private String userUpdate;	
    private java.sql.Timestamp timeCreate;	
    private java.sql.Timestamp timeUpdate;	



    public long getHomepageBodyId() {
        return this.homepageBodyId;
    }		
    public void setHomepageBodyId(long homepageBodyId) {
        this.homepageBodyId = homepageBodyId;
    }
    public String getHomepageBody() {
        return this.homepageBody;
    }		
    public void setHomepageBody(String homepageBody) {
        this.homepageBody = homepageBody;
    }
    public String getHomepageBodyPicture() {
        return this.homepageBodyPicture;
    }		
    public void setHomepageBodyPicture(String homepageBodyPicture) {
        this.homepageBodyPicture = homepageBodyPicture;
    }
    public String getHomepageBodyLink() {
        return this.homepageBodyLink;
    }		
    public void setHomepageBodyLink(String homepageBodyLink) {
        this.homepageBodyLink = homepageBodyLink;
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
        return super.toString() + "homepageBodyId=[" + homepageBodyId + "]\n" + "homepageBody=[" + homepageBody + "]\n" + "homepageBodyPicture=[" + homepageBodyPicture + "]\n" + "homepageBodyLink=[" + homepageBodyLink + "]\n" + "userCreate=[" + userCreate + "]\n" + "userUpdate=[" + userUpdate + "]\n" + "timeCreate=[" + timeCreate + "]\n" + "timeUpdate=[" + timeUpdate + "]\n";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof HomepageBody)) {
                return false;
        }
        HomepageBody that = (HomepageBody) obj;
        if (that.getHomepageBodyId() != this.getHomepageBodyId()) {
                return false;
        }
        if (!(that.getHomepageBody() == null ? this.getHomepageBody() == null
                        : that.getHomepageBody().equals(this.getHomepageBody()))) {
                return false;
        }
        if (!(that.getHomepageBodyPicture() == null ? this.getHomepageBodyPicture() == null
                        : that.getHomepageBodyPicture().equals(this.getHomepageBodyPicture()))) {
                return false;
        }
        if (!(that.getHomepageBodyLink() == null ? this.getHomepageBodyLink() == null
                        : that.getHomepageBodyLink().equals(this.getHomepageBodyLink()))) {
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
