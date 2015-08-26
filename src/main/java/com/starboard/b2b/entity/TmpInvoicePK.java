
package com.starboard.b2b.entity;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class TmpInvoicePK  implements Serializable {
    
    /** Creates a new instance of TmpInvoice */
    public TmpInvoicePK(
            long runningNo	
        ) {
        this.runningNo = runningNo;	
    }
    private long runningNo;	

    public long getRunningNo() {
        return this.runningNo;
    }		
    public void setRunningNo(long runningNo) {
        this.runningNo = runningNo;
    }

    public String toString() {
        return super.toString() + " " + runningNo;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof TmpInvoice)) {
                return false;
        }
        TmpInvoice that = (TmpInvoice) obj;
        if (that.getRunningNo() != this.getRunningNo()) {
                return false;
        }
    return true;
    }

}
