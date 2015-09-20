
package com.starboard.b2b.dto.original;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class AuthorizedObject implements Serializable {
    
    /** Creates a new instance of AuthorizedObject */
    public AuthorizedObject() {
    }
    public AuthorizedObject(
            String authorizedObjectId	
            , String name	
            , String description	
            , java.sql.Timestamp timeCreate	
            , java.sql.Timestamp timeUpdate	
            , long authorizedObjectGroupId	
        ) {
        this.authorizedObjectId = authorizedObjectId;	
        this.name = name;	
        this.description = description;	
        this.timeCreate = timeCreate;	
        this.timeUpdate = timeUpdate;	
        this.authorizedObjectGroupId = authorizedObjectGroupId;	
    }
    private String authorizedObjectId;	
    private String name;	
    private String description;	
    private java.sql.Timestamp timeCreate;	
    private java.sql.Timestamp timeUpdate;	
    private long authorizedObjectGroupId;	



    public String getAuthorizedObjectId() {
        return this.authorizedObjectId;
    }		
    public void setAuthorizedObjectId(String authorizedObjectId) {
        this.authorizedObjectId = authorizedObjectId;
    }
    public String getName() {
        return this.name;
    }		
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return this.description;
    }		
    public void setDescription(String description) {
        this.description = description;
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
    public long getAuthorizedObjectGroupId() {
        return this.authorizedObjectGroupId;
    }		
    public void setAuthorizedObjectGroupId(long authorizedObjectGroupId) {
        this.authorizedObjectGroupId = authorizedObjectGroupId;
    }



    public String toString() {
        return super.toString() + "authorizedObjectId=[" + authorizedObjectId + "]\n" + "name=[" + name + "]\n" + "description=[" + description + "]\n" + "timeCreate=[" + timeCreate + "]\n" + "timeUpdate=[" + timeUpdate + "]\n" + "authorizedObjectGroupId=[" + authorizedObjectGroupId + "]\n";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof AuthorizedObject)) {
                return false;
        }
        AuthorizedObject that = (AuthorizedObject) obj;
        if (!(that.getAuthorizedObjectId() == null ? this.getAuthorizedObjectId() == null
                        : that.getAuthorizedObjectId().equals(this.getAuthorizedObjectId()))) {
                return false;
        }
        if (!(that.getName() == null ? this.getName() == null
                        : that.getName().equals(this.getName()))) {
                return false;
        }
        if (!(that.getDescription() == null ? this.getDescription() == null
                        : that.getDescription().equals(this.getDescription()))) {
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
        if (that.getAuthorizedObjectGroupId() != this.getAuthorizedObjectGroupId()) {
                return false;
        }
    return true;
    }

}
