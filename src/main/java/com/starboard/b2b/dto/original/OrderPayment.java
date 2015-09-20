
package com.starboard.b2b.dto.original;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class OrderPayment implements Serializable {
    
    /** Creates a new instance of OrderPayment */
    public OrderPayment() {
    }
    public OrderPayment(
            long orderId	
            , String hostresp	
            , String reserved1	
            , String authcode	
            , String returninv	
            , String reserved2	
            , String cardnumber	
            , String amount	
            , String thbamount	
            , String curiso	
            , String fxrate	
            , String userCreate	
            , String userUpdate	
            , java.sql.Timestamp timeCreate	
            , java.sql.Timestamp timeUpdate	
        ) {
        this.orderId = orderId;	
        this.hostresp = hostresp;	
        this.reserved1 = reserved1;	
        this.authcode = authcode;	
        this.returninv = returninv;	
        this.reserved2 = reserved2;	
        this.cardnumber = cardnumber;	
        this.amount = amount;	
        this.thbamount = thbamount;	
        this.curiso = curiso;	
        this.fxrate = fxrate;	
        this.userCreate = userCreate;	
        this.userUpdate = userUpdate;	
        this.timeCreate = timeCreate;	
        this.timeUpdate = timeUpdate;	
    }
    private long orderId;	
    private String hostresp;	
    private String reserved1;	
    private String authcode;	
    private String returninv;	
    private String reserved2;	
    private String cardnumber;	
    private String amount;	
    private String thbamount;	
    private String curiso;	
    private String fxrate;	
    private String userCreate;	
    private String userUpdate;	
    private java.sql.Timestamp timeCreate;	
    private java.sql.Timestamp timeUpdate;	



    public long getOrderId() {
        return this.orderId;
    }		
    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }
    public String getHostresp() {
        return this.hostresp;
    }		
    public void setHostresp(String hostresp) {
        this.hostresp = hostresp;
    }
    public String getReserved1() {
        return this.reserved1;
    }		
    public void setReserved1(String reserved1) {
        this.reserved1 = reserved1;
    }
    public String getAuthcode() {
        return this.authcode;
    }		
    public void setAuthcode(String authcode) {
        this.authcode = authcode;
    }
    public String getReturninv() {
        return this.returninv;
    }		
    public void setReturninv(String returninv) {
        this.returninv = returninv;
    }
    public String getReserved2() {
        return this.reserved2;
    }		
    public void setReserved2(String reserved2) {
        this.reserved2 = reserved2;
    }
    public String getCardnumber() {
        return this.cardnumber;
    }		
    public void setCardnumber(String cardnumber) {
        this.cardnumber = cardnumber;
    }
    public String getAmount() {
        return this.amount;
    }		
    public void setAmount(String amount) {
        this.amount = amount;
    }
    public String getThbamount() {
        return this.thbamount;
    }		
    public void setThbamount(String thbamount) {
        this.thbamount = thbamount;
    }
    public String getCuriso() {
        return this.curiso;
    }		
    public void setCuriso(String curiso) {
        this.curiso = curiso;
    }
    public String getFxrate() {
        return this.fxrate;
    }		
    public void setFxrate(String fxrate) {
        this.fxrate = fxrate;
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
        return super.toString() + "orderId=[" + orderId + "]\n" + "hostresp=[" + hostresp + "]\n" + "reserved1=[" + reserved1 + "]\n" + "authcode=[" + authcode + "]\n" + "returninv=[" + returninv + "]\n" + "reserved2=[" + reserved2 + "]\n" + "cardnumber=[" + cardnumber + "]\n" + "amount=[" + amount + "]\n" + "thbamount=[" + thbamount + "]\n" + "curiso=[" + curiso + "]\n" + "fxrate=[" + fxrate + "]\n" + "userCreate=[" + userCreate + "]\n" + "userUpdate=[" + userUpdate + "]\n" + "timeCreate=[" + timeCreate + "]\n" + "timeUpdate=[" + timeUpdate + "]\n";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof OrderPayment)) {
                return false;
        }
        OrderPayment that = (OrderPayment) obj;
        if (that.getOrderId() != this.getOrderId()) {
                return false;
        }
        if (!(that.getHostresp() == null ? this.getHostresp() == null
                        : that.getHostresp().equals(this.getHostresp()))) {
                return false;
        }
        if (!(that.getReserved1() == null ? this.getReserved1() == null
                        : that.getReserved1().equals(this.getReserved1()))) {
                return false;
        }
        if (!(that.getAuthcode() == null ? this.getAuthcode() == null
                        : that.getAuthcode().equals(this.getAuthcode()))) {
                return false;
        }
        if (!(that.getReturninv() == null ? this.getReturninv() == null
                        : that.getReturninv().equals(this.getReturninv()))) {
                return false;
        }
        if (!(that.getReserved2() == null ? this.getReserved2() == null
                        : that.getReserved2().equals(this.getReserved2()))) {
                return false;
        }
        if (!(that.getCardnumber() == null ? this.getCardnumber() == null
                        : that.getCardnumber().equals(this.getCardnumber()))) {
                return false;
        }
        if (!(that.getAmount() == null ? this.getAmount() == null
                        : that.getAmount().equals(this.getAmount()))) {
                return false;
        }
        if (!(that.getThbamount() == null ? this.getThbamount() == null
                        : that.getThbamount().equals(this.getThbamount()))) {
                return false;
        }
        if (!(that.getCuriso() == null ? this.getCuriso() == null
                        : that.getCuriso().equals(this.getCuriso()))) {
                return false;
        }
        if (!(that.getFxrate() == null ? this.getFxrate() == null
                        : that.getFxrate().equals(this.getFxrate()))) {
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
