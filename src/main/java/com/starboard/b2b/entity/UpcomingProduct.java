
package com.starboard.b2b.entity;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class UpcomingProduct implements Serializable {
    
    /** Creates a new instance of UpcomingProduct */
    public UpcomingProduct() {
    }
    public UpcomingProduct(
            int idUpcomming	
            , String nameUpcomming	
            , String typeUpcomming	
            , java.sql.Date dateUpcomming	
            , int sequence	
            , String filesupload	
            , String userCreate	
            , String userUpdate	
            , java.sql.Timestamp timeCreate	
            , java.sql.Timestamp timeUpdate	
        ) {
        this.idUpcomming = idUpcomming;	
        this.nameUpcomming = nameUpcomming;	
        this.typeUpcomming = typeUpcomming;	
        this.dateUpcomming = dateUpcomming;	
        this.sequence = sequence;	
        this.filesupload = filesupload;	
        this.userCreate = userCreate;	
        this.userUpdate = userUpdate;	
        this.timeCreate = timeCreate;	
        this.timeUpdate = timeUpdate;	
    }
    private int idUpcomming;	
    private String nameUpcomming;	
    private String typeUpcomming;	
    private java.sql.Date dateUpcomming;	
    private int sequence;	
    private String filesupload;	
    private String userCreate;	
    private String userUpdate;	
    private java.sql.Timestamp timeCreate;	
    private java.sql.Timestamp timeUpdate;	



    public int getIdUpcomming() {
        return this.idUpcomming;
    }		
    public void setIdUpcomming(int idUpcomming) {
        this.idUpcomming = idUpcomming;
    }
    public String getNameUpcomming() {
        return this.nameUpcomming;
    }		
    public void setNameUpcomming(String nameUpcomming) {
        this.nameUpcomming = nameUpcomming;
    }
    public String getTypeUpcomming() {
        return this.typeUpcomming;
    }		
    public void setTypeUpcomming(String typeUpcomming) {
        this.typeUpcomming = typeUpcomming;
    }
    public java.sql.Date getDateUpcomming() {
        return this.dateUpcomming;
    }		
    public void setDateUpcomming(java.sql.Date dateUpcomming) {
        this.dateUpcomming = dateUpcomming;
    }
    public int getSequence() {
        return this.sequence;
    }		
    public void setSequence(int sequence) {
        this.sequence = sequence;
    }
    public String getFilesupload() {
        return this.filesupload;
    }		
    public void setFilesupload(String filesupload) {
        this.filesupload = filesupload;
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
        return super.toString() + "idUpcomming=[" + idUpcomming + "]\n" + "nameUpcomming=[" + nameUpcomming + "]\n" + "typeUpcomming=[" + typeUpcomming + "]\n" + "dateUpcomming=[" + dateUpcomming + "]\n" + "sequence=[" + sequence + "]\n" + "filesupload=[" + filesupload + "]\n" + "userCreate=[" + userCreate + "]\n" + "userUpdate=[" + userUpdate + "]\n" + "timeCreate=[" + timeCreate + "]\n" + "timeUpdate=[" + timeUpdate + "]\n";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof UpcomingProduct)) {
                return false;
        }
        UpcomingProduct that = (UpcomingProduct) obj;
        if (that.getIdUpcomming() != this.getIdUpcomming()) {
                return false;
        }
        if (!(that.getNameUpcomming() == null ? this.getNameUpcomming() == null
                        : that.getNameUpcomming().equals(this.getNameUpcomming()))) {
                return false;
        }
        if (!(that.getTypeUpcomming() == null ? this.getTypeUpcomming() == null
                        : that.getTypeUpcomming().equals(this.getTypeUpcomming()))) {
                return false;
        }
        if (!(that.getDateUpcomming() == null ? this.getDateUpcomming() == null
                        : that.getDateUpcomming().equals(this.getDateUpcomming()))) {
                return false;
        }
        if (that.getSequence() != this.getSequence()) {
                return false;
        }
        if (!(that.getFilesupload() == null ? this.getFilesupload() == null
                        : that.getFilesupload().equals(this.getFilesupload()))) {
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
