
package com.starboard.b2b.entity;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class PaymentPK  implements Serializable {
    
    /** Creates a new instance of Payment */
    public PaymentPK(
            String paymentId	
        ) {
        this.paymentId = paymentId;	
    }
    private String paymentId;	

    public String getPaymentId() {
        return this.paymentId;
    }		
    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String toString() {
        return super.toString() + " " + paymentId;
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
    return true;
    }

}
