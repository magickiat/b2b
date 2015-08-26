
package com.starboard.b2b.entity;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class User implements Serializable {
    
    /** Creates a new instance of User */
    public User() {
    }
    public User(
            String id	
            , String roleId	
            , String departmentId	
            , String managerId	
            , String name	
            , String nickName	
            , String password	
            , String email	
            , String emailEnable	
            , java.sql.Date birthDate	
            , String address	
            , java.sql.Date startDate	
            , String enable	
            , String pathSignature	
            , java.sql.Timestamp timeCreate	
            , java.sql.Timestamp timeUpdate	
        ) {
        this.id = id;	
        this.roleId = roleId;	
        this.departmentId = departmentId;	
        this.managerId = managerId;	
        this.name = name;	
        this.nickName = nickName;	
        this.password = password;	
        this.email = email;	
        this.emailEnable = emailEnable;	
        this.birthDate = birthDate;	
        this.address = address;	
        this.startDate = startDate;	
        this.enable = enable;	
        this.pathSignature = pathSignature;	
        this.timeCreate = timeCreate;	
        this.timeUpdate = timeUpdate;	
    }
    private String id;	
    private String roleId;	
    private String departmentId;	
    private String managerId;	
    private String name;	
    private String nickName;	
    private String password;	
    private String email;	
    private String emailEnable;	
    private java.sql.Date birthDate;	
    private String address;	
    private java.sql.Date startDate;	
    private String enable;	
    private String pathSignature;	
    private java.sql.Timestamp timeCreate;	
    private java.sql.Timestamp timeUpdate;	



    public String getId() {
        return this.id;
    }		
    public void setId(String id) {
        this.id = id;
    }
    public String getRoleId() {
        return this.roleId;
    }		
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
    public String getDepartmentId() {
        return this.departmentId;
    }		
    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }
    public String getManagerId() {
        return this.managerId;
    }		
    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }
    public String getName() {
        return this.name;
    }		
    public void setName(String name) {
        this.name = name;
    }
    public String getNickName() {
        return this.nickName;
    }		
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    public String getPassword() {
        return this.password;
    }		
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return this.email;
    }		
    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmailEnable() {
        return this.emailEnable;
    }		
    public void setEmailEnable(String emailEnable) {
        this.emailEnable = emailEnable;
    }
    public java.sql.Date getBirthDate() {
        return this.birthDate;
    }		
    public void setBirthDate(java.sql.Date birthDate) {
        this.birthDate = birthDate;
    }
    public String getAddress() {
        return this.address;
    }		
    public void setAddress(String address) {
        this.address = address;
    }
    public java.sql.Date getStartDate() {
        return this.startDate;
    }		
    public void setStartDate(java.sql.Date startDate) {
        this.startDate = startDate;
    }
    public String getEnable() {
        return this.enable;
    }		
    public void setEnable(String enable) {
        this.enable = enable;
    }
    public String getPathSignature() {
        return this.pathSignature;
    }		
    public void setPathSignature(String pathSignature) {
        this.pathSignature = pathSignature;
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
        return super.toString() + "id=[" + id + "]\n" + "roleId=[" + roleId + "]\n" + "departmentId=[" + departmentId + "]\n" + "managerId=[" + managerId + "]\n" + "name=[" + name + "]\n" + "nickName=[" + nickName + "]\n" + "password=[" + password + "]\n" + "email=[" + email + "]\n" + "emailEnable=[" + emailEnable + "]\n" + "birthDate=[" + birthDate + "]\n" + "address=[" + address + "]\n" + "startDate=[" + startDate + "]\n" + "enable=[" + enable + "]\n" + "pathSignature=[" + pathSignature + "]\n" + "timeCreate=[" + timeCreate + "]\n" + "timeUpdate=[" + timeUpdate + "]\n";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof User)) {
                return false;
        }
        User that = (User) obj;
        if (!(that.getId() == null ? this.getId() == null
                        : that.getId().equals(this.getId()))) {
                return false;
        }
        if (!(that.getRoleId() == null ? this.getRoleId() == null
                        : that.getRoleId().equals(this.getRoleId()))) {
                return false;
        }
        if (!(that.getDepartmentId() == null ? this.getDepartmentId() == null
                        : that.getDepartmentId().equals(this.getDepartmentId()))) {
                return false;
        }
        if (!(that.getManagerId() == null ? this.getManagerId() == null
                        : that.getManagerId().equals(this.getManagerId()))) {
                return false;
        }
        if (!(that.getName() == null ? this.getName() == null
                        : that.getName().equals(this.getName()))) {
                return false;
        }
        if (!(that.getNickName() == null ? this.getNickName() == null
                        : that.getNickName().equals(this.getNickName()))) {
                return false;
        }
        if (!(that.getPassword() == null ? this.getPassword() == null
                        : that.getPassword().equals(this.getPassword()))) {
                return false;
        }
        if (!(that.getEmail() == null ? this.getEmail() == null
                        : that.getEmail().equals(this.getEmail()))) {
                return false;
        }
        if (!(that.getEmailEnable() == null ? this.getEmailEnable() == null
                        : that.getEmailEnable().equals(this.getEmailEnable()))) {
                return false;
        }
        if (!(that.getBirthDate() == null ? this.getBirthDate() == null
                        : that.getBirthDate().equals(this.getBirthDate()))) {
                return false;
        }
        if (!(that.getAddress() == null ? this.getAddress() == null
                        : that.getAddress().equals(this.getAddress()))) {
                return false;
        }
        if (!(that.getStartDate() == null ? this.getStartDate() == null
                        : that.getStartDate().equals(this.getStartDate()))) {
                return false;
        }
        if (!(that.getEnable() == null ? this.getEnable() == null
                        : that.getEnable().equals(this.getEnable()))) {
                return false;
        }
        if (!(that.getPathSignature() == null ? this.getPathSignature() == null
                        : that.getPathSignature().equals(this.getPathSignature()))) {
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
