
package com.starboard.b2b.entity;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class EnewsEmail implements Serializable {
    
    /** Creates a new instance of EnewsEmail */
    public EnewsEmail() {
    }
    public EnewsEmail(
            long id	
            , String email	
        ) {
        this.id = id;	
        this.email = email;	
    }
    private long id;	
    private String email;	



    public long getId() {
        return this.id;
    }		
    public void setId(long id) {
        this.id = id;
    }
    public String getEmail() {
        return this.email;
    }		
    public void setEmail(String email) {
        this.email = email;
    }



    public String toString() {
        return super.toString() + "id=[" + id + "]\n" + "email=[" + email + "]\n";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof EnewsEmail)) {
                return false;
        }
        EnewsEmail that = (EnewsEmail) obj;
        if (that.getId() != this.getId()) {
                return false;
        }
        if (!(that.getEmail() == null ? this.getEmail() == null
                        : that.getEmail().equals(this.getEmail()))) {
                return false;
        }
    return true;
    }

}
