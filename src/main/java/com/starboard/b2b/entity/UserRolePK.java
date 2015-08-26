
package com.starboard.b2b.entity;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class UserRolePK  implements Serializable {
    
    /** Creates a new instance of UserRole */
    public UserRolePK(
            String userId	
            , String roleId	
        ) {
        this.userId = userId;	
        this.roleId = roleId;	
    }
    private String userId;	
    private String roleId;	

    public String getUserId() {
        return this.userId;
    }		
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getRoleId() {
        return this.roleId;
    }		
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String toString() {
        return super.toString() + " " + userId + " " + roleId;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof UserRole)) {
                return false;
        }
        UserRole that = (UserRole) obj;
        if (!(that.getUserId() == null ? this.getUserId() == null
                        : that.getUserId().equals(this.getUserId()))) {
                return false;
        }
        if (!(that.getRoleId() == null ? this.getRoleId() == null
                        : that.getRoleId().equals(this.getRoleId()))) {
                return false;
        }
    return true;
    }

}
