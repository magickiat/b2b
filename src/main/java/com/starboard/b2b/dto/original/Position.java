
package com.starboard.b2b.dto.original;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class Position implements Serializable {
    
    /** Creates a new instance of Position */
    public Position() {
    }
    public Position(
            long positionId	
            , String positionName	
            , String positionDescription	
            , String userCreate	
            , String userUpdate	
            , java.sql.Timestamp timeCreate	
            , java.sql.Timestamp timeUpdate	
        ) {
        this.positionId = positionId;	
        this.positionName = positionName;	
        this.positionDescription = positionDescription;	
        this.userCreate = userCreate;	
        this.userUpdate = userUpdate;	
        this.timeCreate = timeCreate;	
        this.timeUpdate = timeUpdate;	
    }
    private long positionId;	
    private String positionName;	
    private String positionDescription;	
    private String userCreate;	
    private String userUpdate;	
    private java.sql.Timestamp timeCreate;	
    private java.sql.Timestamp timeUpdate;	



    public long getPositionId() {
        return this.positionId;
    }		
    public void setPositionId(long positionId) {
        this.positionId = positionId;
    }
    public String getPositionName() {
        return this.positionName;
    }		
    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }
    public String getPositionDescription() {
        return this.positionDescription;
    }		
    public void setPositionDescription(String positionDescription) {
        this.positionDescription = positionDescription;
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
        return super.toString() + "positionId=[" + positionId + "]\n" + "positionName=[" + positionName + "]\n" + "positionDescription=[" + positionDescription + "]\n" + "userCreate=[" + userCreate + "]\n" + "userUpdate=[" + userUpdate + "]\n" + "timeCreate=[" + timeCreate + "]\n" + "timeUpdate=[" + timeUpdate + "]\n";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof Position)) {
                return false;
        }
        Position that = (Position) obj;
        if (that.getPositionId() != this.getPositionId()) {
                return false;
        }
        if (!(that.getPositionName() == null ? this.getPositionName() == null
                        : that.getPositionName().equals(this.getPositionName()))) {
                return false;
        }
        if (!(that.getPositionDescription() == null ? this.getPositionDescription() == null
                        : that.getPositionDescription().equals(this.getPositionDescription()))) {
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
