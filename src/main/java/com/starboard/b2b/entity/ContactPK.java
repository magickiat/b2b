
package com.starboard.b2b.entity;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class ContactPK  implements Serializable {
    
    /** Creates a new instance of Contact */
    public ContactPK(
            long contactId	
        ) {
        this.contactId = contactId;	
    }
    private long contactId;	

    public long getContactId() {
        return this.contactId;
    }		
    public void setContactId(long contactId) {
        this.contactId = contactId;
    }

    public String toString() {
        return super.toString() + " " + contactId;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof Contact)) {
                return false;
        }
        Contact that = (Contact) obj;
        if (that.getContactId() != this.getContactId()) {
                return false;
        }
    return true;
    }

}
