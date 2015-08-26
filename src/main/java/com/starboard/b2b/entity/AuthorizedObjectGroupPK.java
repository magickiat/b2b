
package com.starboard.b2b.entity;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class AuthorizedObjectGroupPK  implements Serializable {
    
    /** Creates a new instance of AuthorizedObjectGroup */
    public AuthorizedObjectGroupPK(
            long authorizedObjectGroupId	
        ) {
        this.authorizedObjectGroupId = authorizedObjectGroupId;	
    }
    private long authorizedObjectGroupId;	

    public long getAuthorizedObjectGroupId() {
        return this.authorizedObjectGroupId;
    }		
    public void setAuthorizedObjectGroupId(long authorizedObjectGroupId) {
        this.authorizedObjectGroupId = authorizedObjectGroupId;
    }

    public String toString() {
        return super.toString() + " " + authorizedObjectGroupId;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof AuthorizedObjectGroup)) {
                return false;
        }
        AuthorizedObjectGroup that = (AuthorizedObjectGroup) obj;
        if (that.getAuthorizedObjectGroupId() != this.getAuthorizedObjectGroupId()) {
                return false;
        }
    return true;
    }

}
