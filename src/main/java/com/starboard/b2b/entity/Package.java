
package com.starboard.b2b.entity;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class Package implements Serializable {
    
    /** Creates a new instance of Package */
    public Package() {
    }
    public Package(
            long packageId	
            , String packageName	
            , int limitedSearchCandidate	
            , int limitedDay	
            , int limitedPostJob	
            , String userCreate	
            , String userUpdate	
            , java.sql.Timestamp timeCreate	
            , java.sql.Timestamp timeUpdate	
        ) {
        this.packageId = packageId;	
        this.packageName = packageName;	
        this.limitedSearchCandidate = limitedSearchCandidate;	
        this.limitedDay = limitedDay;	
        this.limitedPostJob = limitedPostJob;	
        this.userCreate = userCreate;	
        this.userUpdate = userUpdate;	
        this.timeCreate = timeCreate;	
        this.timeUpdate = timeUpdate;	
    }
    private long packageId;	
    private String packageName;	
    private int limitedSearchCandidate;	
    private int limitedDay;	
    private int limitedPostJob;	
    private String userCreate;	
    private String userUpdate;	
    private java.sql.Timestamp timeCreate;	
    private java.sql.Timestamp timeUpdate;	



    public long getPackageId() {
        return this.packageId;
    }		
    public void setPackageId(long packageId) {
        this.packageId = packageId;
    }
    public String getPackageName() {
        return this.packageName;
    }		
    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }
    public int getLimitedSearchCandidate() {
        return this.limitedSearchCandidate;
    }		
    public void setLimitedSearchCandidate(int limitedSearchCandidate) {
        this.limitedSearchCandidate = limitedSearchCandidate;
    }
    public int getLimitedDay() {
        return this.limitedDay;
    }		
    public void setLimitedDay(int limitedDay) {
        this.limitedDay = limitedDay;
    }
    public int getLimitedPostJob() {
        return this.limitedPostJob;
    }		
    public void setLimitedPostJob(int limitedPostJob) {
        this.limitedPostJob = limitedPostJob;
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
        return super.toString() + "packageId=[" + packageId + "]\n" + "packageName=[" + packageName + "]\n" + "limitedSearchCandidate=[" + limitedSearchCandidate + "]\n" + "limitedDay=[" + limitedDay + "]\n" + "limitedPostJob=[" + limitedPostJob + "]\n" + "userCreate=[" + userCreate + "]\n" + "userUpdate=[" + userUpdate + "]\n" + "timeCreate=[" + timeCreate + "]\n" + "timeUpdate=[" + timeUpdate + "]\n";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof Package)) {
                return false;
        }
        Package that = (Package) obj;
        if (that.getPackageId() != this.getPackageId()) {
                return false;
        }
        if (!(that.getPackageName() == null ? this.getPackageName() == null
                        : that.getPackageName().equals(this.getPackageName()))) {
                return false;
        }
        if (that.getLimitedSearchCandidate() != this.getLimitedSearchCandidate()) {
                return false;
        }
        if (that.getLimitedDay() != this.getLimitedDay()) {
                return false;
        }
        if (that.getLimitedPostJob() != this.getLimitedPostJob()) {
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
