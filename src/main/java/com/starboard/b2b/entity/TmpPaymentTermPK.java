
package com.starboard.b2b.entity;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class TmpPaymentTermPK  implements Serializable {
    
    /** Creates a new instance of TmpPaymentTerm */
    public TmpPaymentTermPK(
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
        if (!(obj instanceof TmpPaymentTerm)) {
                return false;
        }
        TmpPaymentTerm that = (TmpPaymentTerm) obj;
        if (!(that.getPaymentTermId() == null ? this.getPaymentTermId() == null
                        : that.getPaymentTermId().equals(this.getPaymentTermId()))) {
                return false;
        }
    return true;
    }

}
