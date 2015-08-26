
package com.starboard.b2b.entity;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class ProductCalendar implements Serializable {
    
    /** Creates a new instance of ProductCalendar */
    public ProductCalendar() {
    }
    public ProductCalendar(
            int idCalendar	
            , String descriptions	
            , java.sql.Timestamp dateEvent	
            , String userCreate	
            , String userUpdate	
            , java.sql.Timestamp timeCreate	
            , java.sql.Timestamp timeUpdate	
        ) {
        this.idCalendar = idCalendar;	
        this.descriptions = descriptions;	
        this.dateEvent = dateEvent;	
        this.userCreate = userCreate;	
        this.userUpdate = userUpdate;	
        this.timeCreate = timeCreate;	
        this.timeUpdate = timeUpdate;	
    }
    private int idCalendar;	
    private String descriptions;	
    private java.sql.Timestamp dateEvent;	
    private String userCreate;	
    private String userUpdate;	
    private java.sql.Timestamp timeCreate;	
    private java.sql.Timestamp timeUpdate;	



    public int getIdCalendar() {
        return this.idCalendar;
    }		
    public void setIdCalendar(int idCalendar) {
        this.idCalendar = idCalendar;
    }
    public String getDescriptions() {
        return this.descriptions;
    }		
    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }
    public java.sql.Timestamp getDateEvent() {
        return this.dateEvent;
    }		
    public void setDateEvent(java.sql.Timestamp dateEvent) {
        this.dateEvent = dateEvent;
    }
    public String getUserCreate() {
        return this.userCreate;
    }		
    public void setUserCreate(String userCreate) {
        this.userCreate = userCreate;
    }
    public String getUserUpdate() {
        return this.userUpdate;
    }		
    public void setUserUpdate(String userUpdate) {
        this.userUpdate = userUpdate;
    }
    public java.sql.Timestamp getTimeCreate() {
        return this.timeCreate;
    }		
    public void setTimeCreate(java.sql.Timestamp timeCreate) {
        this.timeCreate = timeCreate;
    }
    public java.sql.Timestamp getTimeUpdate() {
        return this.timeUpdate;
    }		
    public void setTimeUpdate(java.sql.Timestamp timeUpdate) {
        this.timeUpdate = timeUpdate;
    }



    public String toString() {
        return super.toString() + "idCalendar=[" + idCalendar + "]\n" + "descriptions=[" + descriptions + "]\n" + "dateEvent=[" + dateEvent + "]\n" + "userCreate=[" + userCreate + "]\n" + "userUpdate=[" + userUpdate + "]\n" + "timeCreate=[" + timeCreate + "]\n" + "timeUpdate=[" + timeUpdate + "]\n";
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
        if (!(that.getDescriptions() == null ? this.getDescriptions() == null
                        : that.getDescriptions().equals(this.getDescriptions()))) {
                return false;
        }
        if (!(that.getDateEvent() == null ? this.getDateEvent() == null
                        : that.getDateEvent().equals(this.getDateEvent()))) {
                return false;
        }
        if (!(that.getUserCreate() == null ? this.getUserCreate() == null
                        : that.getUserCreate().equals(this.getUserCreate()))) {
                return false;
        }
        if (!(that.getUserUpdate() == null ? this.getUserUpdate() == null
                        : that.getUserUpdate().equals(this.getUserUpdate()))) {
                return false;
        }
        if (!(that.getTimeCreate() == null ? this.getTimeCreate() == null
                        : that.getTimeCreate().equals(this.getTimeCreate()))) {
                return false;
        }
        if (!(that.getTimeUpdate() == null ? this.getTimeUpdate() == null
                        : that.getTimeUpdate().equals(this.getTimeUpdate()))) {
                return false;
        }
    return true;
    }

}
