
package com.starboard.b2b.entity;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class EmployeePK  implements Serializable {
    
    /** Creates a new instance of Employee */
    public EmployeePK(
            int emid	
        ) {
        this.emid = emid;	
    }
    private int emid;	

    public int getEmid() {
        return this.emid;
    }		
    public void setEmid(int emid) {
        this.emid = emid;
    }

    public String toString() {
        return super.toString() + " " + emid;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof Employee)) {
                return false;
        }
        Employee that = (Employee) obj;
        if (that.getEmid() != this.getEmid()) {
                return false;
        }
    return true;
    }

}
