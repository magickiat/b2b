
package com.starboard.b2b.entity;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class ProductCalendarPK  implements Serializable {
    
    /** Creates a new instance of ProductCalendar */
    public ProductCalendarPK(
            int idCalendar	
        ) {
        this.idCalendar = idCalendar;	
    }
    private int idCalendar;	

    public int getIdCalendar() {
        return this.idCalendar;
    }		
    public void setIdCalendar(int idCalendar) {
        this.idCalendar = idCalendar;
    }

    public String toString() {
        return super.toString() + " " + idCalendar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof ProductCalendar)) {
                return false;
        }
        ProductCalendar that = (ProductCalendar) obj;
        if (that.getIdCalendar() != this.getIdCalendar()) {
                return false;
        }
    return true;
    }

}
