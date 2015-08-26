
package com.starboard.b2b.entity;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class AuthorizedObjectPK  implements Serializable {
    
    /** Creates a new instance of AuthorizedObject */
    public AuthorizedObjectPK(
            String authorizedObjectId	
        ) {
        this.authorizedObjectId = authorizedObjectId;	
    }
    private String authorizedObjectId;	

    public String getAuthorizedObjectId() {
        return this.authorizedObjectId;
    }		
    public void setAuthorizedObjectId(String authorizedObjectId) {
        this.authorizedObjectId = authorizedObjectId;
    }

    public String toString() {
        return super.toString() + " " + authorizedObjectId;
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
    return true;
    }

}
