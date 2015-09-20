
package com.starboard.b2b.dto.original;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class Role implements Serializable {
    
    /** Creates a new instance of Role */
    public Role() {
    }
    public Role(
            String id	
            , String name	
            , String description	
            , java.sql.Timestamp timeCreate	
            , java.sql.Timestamp timeUpdate	
        ) {
        this.id = id;	
        this.name = name;	
        this.description = description;	
        this.timeCreate = timeCreate;	
        this.timeUpdate = timeUpdate;	
    }
    private String id;	
    private String name;	
    private String description;	
    private java.sql.Timestamp timeCreate;	
    private java.sql.Timestamp timeUpdate;	



    public String getId() {
        return this.id;
    }		
    public void setId(String id) {
        this.id = id;
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



    public String toString() {
        return super.toString() + "id=[" + id + "]\n" + "name=[" + name + "]\n" + "description=[" + description + "]\n" + "timeCreate=[" + timeCreate + "]\n" + "timeUpdate=[" + timeUpdate + "]\n";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof Role)) {
                return false;
        }
        Role that = (Role) obj;
        if (!(that.getId() == null ? this.getId() == null
                        : that.getId().equals(this.getId()))) {
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
    return true;
    }

}
