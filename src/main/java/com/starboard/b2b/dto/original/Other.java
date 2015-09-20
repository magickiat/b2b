
package com.starboard.b2b.dto.original;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class Other implements Serializable {
    
    /** Creates a new instance of Other */
    public Other() {
    }
    public Other(
            long otherId	
            , String otherStatusId	
            , String otherTypeId	
            , String otherName	
            , java.sql.Date otherDate	
            , java.sql.Date dueDate	
            , String userAssign	
            , String userResponse	
            , java.math.BigDecimal totalEstAmount	
            , java.math.BigDecimal totalActAmount	
            , String remark	
            , String userCreate	
            , String userUpdate	
            , java.sql.Timestamp timeCreate	
            , java.sql.Timestamp timeUpdate	
            , long pmId	
            , String otherLevelId	
            , String otherProcId	
            , String moveClose	
            , long contactId	
        ) {
        this.otherId = otherId;	
        this.otherStatusId = otherStatusId;	
        this.otherTypeId = otherTypeId;	
        this.otherName = otherName;	
        this.otherDate = otherDate;	
        this.dueDate = dueDate;	
        this.userAssign = userAssign;	
        this.userResponse = userResponse;	
        this.totalEstAmount = totalEstAmount;	
        this.totalActAmount = totalActAmount;	
        this.remark = remark;	
        this.userCreate = userCreate;	
        this.userUpdate = userUpdate;	
        this.timeCreate = timeCreate;	
        this.timeUpdate = timeUpdate;	
        this.pmId = pmId;	
        this.otherLevelId = otherLevelId;	
        this.otherProcId = otherProcId;	
        this.moveClose = moveClose;	
        this.contactId = contactId;	
    }
    private long otherId;	
    private String otherStatusId;	
    private String otherTypeId;	
    private String otherName;	
    private java.sql.Date otherDate;	
    private java.sql.Date dueDate;	
    private String userAssign;	
    private String userResponse;	
    private java.math.BigDecimal totalEstAmount;	
    private java.math.BigDecimal totalActAmount;	
    private String remark;	
    private String userCreate;	
    private String userUpdate;	
    private java.sql.Timestamp timeCreate;	
    private java.sql.Timestamp timeUpdate;	
    private long pmId;	
    private String otherLevelId;	
    private String otherProcId;	
    private String moveClose;	
    private long contactId;	



    public long getOtherId() {
        return this.otherId;
    }		
    public void setOtherId(long otherId) {
        this.otherId = otherId;
    }
    public String getOtherStatusId() {
        return this.otherStatusId;
    }		
    public void setOtherStatusId(String otherStatusId) {
        this.otherStatusId = otherStatusId;
    }
    public String getOtherTypeId() {
        return this.otherTypeId;
    }		
    public void setOtherTypeId(String otherTypeId) {
        this.otherTypeId = otherTypeId;
    }
    public String getOtherName() {
        return this.otherName;
    }		
    public void setOtherName(String otherName) {
        this.otherName = otherName;
    }
    public java.sql.Date getOtherDate() {
        return this.otherDate;
    }		
    public void setOtherDate(java.sql.Date otherDate) {
        this.otherDate = otherDate;
    }
    public java.sql.Date getDueDate() {
        return this.dueDate;
    }		
    public void setDueDate(java.sql.Date dueDate) {
        this.dueDate = dueDate;
    }
    public String getUserAssign() {
        return this.userAssign;
    }		
    public void setUserAssign(String userAssign) {
        this.userAssign = userAssign;
    }
    public String getUserResponse() {
        return this.userResponse;
    }		
    public void setUserResponse(String userResponse) {
        this.userResponse = userResponse;
    }
    public java.math.BigDecimal getTotalEstAmount() {
        return this.totalEstAmount;
    }		
    public void setTotalEstAmount(java.math.BigDecimal totalEstAmount) {
        this.totalEstAmount = totalEstAmount;
    }
    public java.math.BigDecimal getTotalActAmount() {
        return this.totalActAmount;
    }		
    public void setTotalActAmount(java.math.BigDecimal totalActAmount) {
        this.totalActAmount = totalActAmount;
    }
    public String getRemark() {
        return this.remark;
    }		
    public void setRemark(String remark) {
        this.remark = remark;
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
    public long getPmId() {
        return this.pmId;
    }		
    public void setPmId(long pmId) {
        this.pmId = pmId;
    }
    public String getOtherLevelId() {
        return this.otherLevelId;
    }		
    public void setOtherLevelId(String otherLevelId) {
        this.otherLevelId = otherLevelId;
    }
    public String getOtherProcId() {
        return this.otherProcId;
    }		
    public void setOtherProcId(String otherProcId) {
        this.otherProcId = otherProcId;
    }
    public String getMoveClose() {
        return this.moveClose;
    }		
    public void setMoveClose(String moveClose) {
        this.moveClose = moveClose;
    }
    public long getContactId() {
        return this.contactId;
    }		
    public void setContactId(long contactId) {
        this.contactId = contactId;
    }



    public String toString() {
        return super.toString() + "otherId=[" + otherId + "]\n" + "otherStatusId=[" + otherStatusId + "]\n" + "otherTypeId=[" + otherTypeId + "]\n" + "otherName=[" + otherName + "]\n" + "otherDate=[" + otherDate + "]\n" + "dueDate=[" + dueDate + "]\n" + "userAssign=[" + userAssign + "]\n" + "userResponse=[" + userResponse + "]\n" + "totalEstAmount=[" + totalEstAmount + "]\n" + "totalActAmount=[" + totalActAmount + "]\n" + "remark=[" + remark + "]\n" + "userCreate=[" + userCreate + "]\n" + "userUpdate=[" + userUpdate + "]\n" + "timeCreate=[" + timeCreate + "]\n" + "timeUpdate=[" + timeUpdate + "]\n" + "pmId=[" + pmId + "]\n" + "otherLevelId=[" + otherLevelId + "]\n" + "otherProcId=[" + otherProcId + "]\n" + "moveClose=[" + moveClose + "]\n" + "contactId=[" + contactId + "]\n";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof Other)) {
                return false;
        }
        Other that = (Other) obj;
        if (that.getOtherId() != this.getOtherId()) {
                return false;
        }
        if (!(that.getOtherStatusId() == null ? this.getOtherStatusId() == null
                        : that.getOtherStatusId().equals(this.getOtherStatusId()))) {
                return false;
        }
        if (!(that.getOtherTypeId() == null ? this.getOtherTypeId() == null
                        : that.getOtherTypeId().equals(this.getOtherTypeId()))) {
                return false;
        }
        if (!(that.getOtherName() == null ? this.getOtherName() == null
                        : that.getOtherName().equals(this.getOtherName()))) {
                return false;
        }
        if (!(that.getOtherDate() == null ? this.getOtherDate() == null
                        : that.getOtherDate().equals(this.getOtherDate()))) {
                return false;
        }
        if (!(that.getDueDate() == null ? this.getDueDate() == null
                        : that.getDueDate().equals(this.getDueDate()))) {
                return false;
        }
        if (!(that.getUserAssign() == null ? this.getUserAssign() == null
                        : that.getUserAssign().equals(this.getUserAssign()))) {
                return false;
        }
        if (!(that.getUserResponse() == null ? this.getUserResponse() == null
                        : that.getUserResponse().equals(this.getUserResponse()))) {
                return false;
        }
        if (!(that.getTotalEstAmount() == null ? this.getTotalEstAmount() == null
                        : that.getTotalEstAmount().equals(this.getTotalEstAmount()))) {
                return false;
        }
        if (!(that.getTotalActAmount() == null ? this.getTotalActAmount() == null
                        : that.getTotalActAmount().equals(this.getTotalActAmount()))) {
                return false;
        }
        if (!(that.getRemark() == null ? this.getRemark() == null
                        : that.getRemark().equals(this.getRemark()))) {
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
        if (that.getPmId() != this.getPmId()) {
                return false;
        }
        if (!(that.getOtherLevelId() == null ? this.getOtherLevelId() == null
                        : that.getOtherLevelId().equals(this.getOtherLevelId()))) {
                return false;
        }
        if (!(that.getOtherProcId() == null ? this.getOtherProcId() == null
                        : that.getOtherProcId().equals(this.getOtherProcId()))) {
                return false;
        }
        if (!(that.getMoveClose() == null ? this.getMoveClose() == null
                        : that.getMoveClose().equals(this.getMoveClose()))) {
                return false;
        }
        if (that.getContactId() != this.getContactId()) {
                return false;
        }
    return true;
    }

}
