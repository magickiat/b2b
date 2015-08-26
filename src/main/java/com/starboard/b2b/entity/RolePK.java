
package com.starboard.b2b.entity;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class RolePK  implements Serializable {
    
    /** Creates a new instance of Role */
    public RolePK(
            String id	
        ) {
        this.id = id;	
    }
    private String id;	

    public String getId() {
        return this.id;
    }		
    public void setId(String id) {
        this.id = id;
    }

    public String toString() {
        return super.toString() + " " + id;
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
    return true;
    }

}
