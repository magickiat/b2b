
package com.starboard.b2b.entity;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class PaymentMethodPK  implements Serializable {
    
    /** Creates a new instance of PaymentMethod */
    public PaymentMethodPK(
            String paymentMethodId	
        ) {
        this.paymentMethodId = paymentMethodId;	
    }
    private String paymentMethodId;	

    public String getPaymentMethodId() {
        return this.paymentMethodId;
    }		
    public void setPaymentMethodId(String paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public String toString() {
        return super.toString() + " " + paymentMethodId;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof PaymentMethod)) {
                return false;
        }
        PaymentMethod that = (PaymentMethod) obj;
        if (!(that.getPaymentMethodId() == null ? this.getPaymentMethodId() == null
                        : that.getPaymentMethodId().equals(this.getPaymentMethodId()))) {
                return false;
        }
    return true;
    }

}
