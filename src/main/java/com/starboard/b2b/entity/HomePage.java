
package com.starboard.b2b.entity;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class HomePage implements Serializable {
    
    /** Creates a new instance of HomePage */
    public HomePage() {
    }
    public HomePage(
            long homePageId	
            , String homePageName	
            , String homePageBody	
            , String userCreate	
            , String userUpdate	
            , java.sql.Timestamp timeCreate	
            , java.sql.Timestamp timeUpdate	
        ) {
        this.homePageId = homePageId;	
        this.homePageName = homePageName;	
        this.homePageBody = homePageBody;	
        this.userCreate = userCreate;	
        this.userUpdate = userUpdate;	
        this.timeCreate = timeCreate;	
        this.timeUpdate = timeUpdate;	
    }
    private long homePageId;	
    private String homePageName;	
    private String homePageBody;	
    private String userCreate;	
    private String userUpdate;	
    private java.sql.Timestamp timeCreate;	
    private java.sql.Timestamp timeUpdate;	



    public long getHomePageId() {
        return this.homePageId;
    }		
    public void setHomePageId(long homePageId) {
        this.homePageId = homePageId;
    }
    public String getHomePageName() {
        return this.homePageName;
    }		
    public void setHomePageName(String homePageName) {
        this.homePageName = homePageName;
    }
    public String getHomePageBody() {
        return this.homePageBody;
    }		
    public void setHomePageBody(String homePageBody) {
        this.homePageBody = homePageBody;
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
        return super.toString() + "homePageId=[" + homePageId + "]\n" + "homePageName=[" + homePageName + "]\n" + "homePageBody=[" + homePageBody + "]\n" + "userCreate=[" + userCreate + "]\n" + "userUpdate=[" + userUpdate + "]\n" + "timeCreate=[" + timeCreate + "]\n" + "timeUpdate=[" + timeUpdate + "]\n";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof HomePage)) {
                return false;
        }
        HomePage that = (HomePage) obj;
        if (that.getHomePageId() != this.getHomePageId()) {
                return false;
        }
        if (!(that.getHomePageName() == null ? this.getHomePageName() == null
                        : that.getHomePageName().equals(this.getHomePageName()))) {
                return false;
        }
        if (!(that.getHomePageBody() == null ? this.getHomePageBody() == null
                        : that.getHomePageBody().equals(this.getHomePageBody()))) {
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
