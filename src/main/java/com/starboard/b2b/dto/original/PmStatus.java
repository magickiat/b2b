
package com.starboard.b2b.dto.original;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class PmStatus implements Serializable {
    
    /** Creates a new instance of PmStatus */
    public PmStatus() {
    }
    public PmStatus(
            String pmStatusId	
            , String name	
            , String description	
        ) {
        this.pmStatusId = pmStatusId;	
        this.name = name;	
        this.description = description;	
    }
    private String pmStatusId;	
    private String name;	
    private String description;	



    public String getPmStatusId() {
        return this.pmStatusId;
    }		
    public void setPmStatusId(String pmStatusId) {
        this.pmStatusId = pmStatusId;
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



    public String toString() {
        return super.toString() + "pmStatusId=[" + pmStatusId + "]\n" + "name=[" + name + "]\n" + "description=[" + description + "]\n";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof PmStatus)) {
                return false;
        }
        PmStatus that = (PmStatus) obj;
        if (!(that.getPmStatusId() == null ? this.getPmStatusId() == null
                        : that.getPmStatusId().equals(this.getPmStatusId()))) {
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
    return true;
    }

}
