
package com.starboard.b2b.dto.original;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class Payment implements Serializable {
    
    /** Creates a new instance of Payment */
    public Payment() {
    }
    public Payment(
            String paymentId	
            , String paymentName	
            , String description	
        ) {
        this.paymentId = paymentId;	
        this.paymentName = paymentName;	
        this.description = description;	
    }
    private String paymentId;	
    private String paymentName;	
    private String description;	



    public String getPaymentId() {
        return this.paymentId;
    }		
    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }
    public String getPaymentName() {
        return this.paymentName;
    }		
    public void setPaymentName(String paymentName) {
        this.paymentName = paymentName;
    }
    public String getDescription() {
        return this.description;
    }		
    public void setDescription(String description) {
        this.description = description;
    }



    public String toString() {
        return super.toString() + "paymentId=[" + paymentId + "]\n" + "paymentName=[" + paymentName + "]\n" + "description=[" + description + "]\n";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof Payment)) {
                return false;
        }
        Payment that = (Payment) obj;
        if (!(that.getPaymentId() == null ? this.getPaymentId() == null
                        : that.getPaymentId().equals(this.getPaymentId()))) {
                return false;
        }
        if (!(that.getPaymentName() == null ? this.getPaymentName() == null
                        : that.getPaymentName().equals(this.getPaymentName()))) {
                return false;
        }
        if (!(that.getDescription() == null ? this.getDescription() == null
                        : that.getDescription().equals(this.getDescription()))) {
                return false;
        }
    return true;
    }

}
