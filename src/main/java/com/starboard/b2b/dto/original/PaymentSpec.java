
package com.starboard.b2b.dto.original;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class PaymentSpec implements Serializable {
    
    /** Creates a new instance of PaymentSpec */
    public PaymentSpec() {
    }
    public PaymentSpec(
            long id	
            , String name	
            , String description	
            , String status	
        ) {
        this.id = id;	
        this.name = name;	
        this.description = description;	
        this.status = status;	
    }
    private long id;	
    private String name;	
    private String description;	
    private String status;	



    public long getId() {
        return this.id;
    }		
    public void setId(long id) {
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
    public String getStatus() {
        return this.status;
    }		
    public void setStatus(String status) {
        this.status = status;
    }



    public String toString() {
        return super.toString() + "id=[" + id + "]\n" + "name=[" + name + "]\n" + "description=[" + description + "]\n" + "status=[" + status + "]\n";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof PaymentSpec)) {
                return false;
        }
        PaymentSpec that = (PaymentSpec) obj;
        if (that.getId() != this.getId()) {
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
        if (!(that.getStatus() == null ? this.getStatus() == null
                        : that.getStatus().equals(this.getStatus()))) {
                return false;
        }
    return true;
    }

}
