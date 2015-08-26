
package com.starboard.b2b.entity;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class EmailTemplatePK  implements Serializable {
    
    /** Creates a new instance of EmailTemplate */
    public EmailTemplatePK(
            long id	
        ) {
        this.id = id;	
    }
    private long id;	

    public long getId() {
        return this.id;
    }		
    public void setId(long id) {
        this.id = id;
    }

    public String toString() {
        return super.toString() + " " + id;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof EmailTemplate)) {
                return false;
        }
        EmailTemplate that = (EmailTemplate) obj;
        if (that.getId() != this.getId()) {
                return false;
        }
    return true;
    }

}
