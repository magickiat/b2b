
package com.starboard.b2b.entity;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class PaymentTermPK  implements Serializable {
    
    /** Creates a new instance of PaymentTerm */
    public PaymentTermPK(
            String paymentTermId	
        ) {
        this.paymentTermId = paymentTermId;	
    }
    private String paymentTermId;	

    public String getPaymentTermId() {
        return this.paymentTermId;
    }		
    public void setPaymentTermId(String paymentTermId) {
        this.paymentTermId = paymentTermId;
    }

    public String toString() {
        return super.toString() + " " + paymentTermId;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof PaymentTerm)) {
                return false;
        }
        PaymentTerm that = (PaymentTerm) obj;
        if (!(that.getPaymentTermId() == null ? this.getPaymentTermId() == null
                        : that.getPaymentTermId().equals(this.getPaymentTermId()))) {
                return false;
        }
    return true;
    }

}
