
package com.starboard.b2b.dto.original;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class Packages implements Serializable {
    
    /** Creates a new instance of Packages */
    public Packages() {
    }
    public Packages(
            long packagesId	
            , String packagesName	
            , int limitedDay	
            , int limitedPostJob	
            , int limitedDayPostJob	
            , int limitedSearchCandidate	
            , String userCreate	
            , String userUpdate	
            , java.sql.Timestamp timeCreate	
            , java.sql.Timestamp timeUpdate	
        ) {
        this.packagesId = packagesId;	
        this.packagesName = packagesName;	
        this.limitedDay = limitedDay;	
        this.limitedPostJob = limitedPostJob;	
        this.limitedDayPostJob = limitedDayPostJob;	
        this.limitedSearchCandidate = limitedSearchCandidate;	
        this.userCreate = userCreate;	
        this.userUpdate = userUpdate;	
        this.timeCreate = timeCreate;	
        this.timeUpdate = timeUpdate;	
    }
    private long packagesId;	
    private String packagesName;	
    private int limitedDay;	
    private int limitedPostJob;	
    private int limitedDayPostJob;	
    private int limitedSearchCandidate;	
    private String userCreate;	
    private String userUpdate;	
    private java.sql.Timestamp timeCreate;	
    private java.sql.Timestamp timeUpdate;	



    public long getPackagesId() {
        return this.packagesId;
    }		
    public void setPackagesId(long packagesId) {
        this.packagesId = packagesId;
    }
    public String getPackagesName() {
        return this.packagesName;
    }		
    public void setPackagesName(String packagesName) {
        this.packagesName = packagesName;
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
    public int getLimitedDayPostJob() {
        return this.limitedDayPostJob;
    }		
    public void setLimitedDayPostJob(int limitedDayPostJob) {
        this.limitedDayPostJob = limitedDayPostJob;
    }
    public int getLimitedSearchCandidate() {
        return this.limitedSearchCandidate;
    }		
    public void setLimitedSearchCandidate(int limitedSearchCandidate) {
        this.limitedSearchCandidate = limitedSearchCandidate;
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
        return super.toString() + "packagesId=[" + packagesId + "]\n" + "packagesName=[" + packagesName + "]\n" + "limitedDay=[" + limitedDay + "]\n" + "limitedPostJob=[" + limitedPostJob + "]\n" + "limitedDayPostJob=[" + limitedDayPostJob + "]\n" + "limitedSearchCandidate=[" + limitedSearchCandidate + "]\n" + "userCreate=[" + userCreate + "]\n" + "userUpdate=[" + userUpdate + "]\n" + "timeCreate=[" + timeCreate + "]\n" + "timeUpdate=[" + timeUpdate + "]\n";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof Packages)) {
                return false;
        }
        Packages that = (Packages) obj;
        if (that.getPackagesId() != this.getPackagesId()) {
                return false;
        }
        if (!(that.getPackagesName() == null ? this.getPackagesName() == null
                        : that.getPackagesName().equals(this.getPackagesName()))) {
                return false;
        }
        if (that.getLimitedDay() != this.getLimitedDay()) {
                return false;
        }
        if (that.getLimitedPostJob() != this.getLimitedPostJob()) {
                return false;
        }
        if (that.getLimitedDayPostJob() != this.getLimitedDayPostJob()) {
                return false;
        }
        if (that.getLimitedSearchCandidate() != this.getLimitedSearchCandidate()) {
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
