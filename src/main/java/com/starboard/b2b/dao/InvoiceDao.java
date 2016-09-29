package com.starboard.b2b.dao;

import com.starboard.b2b.model.Invoice;
import com.starboard.b2b.model.InvoiceDetail;

import java.util.List;

public interface InvoiceDao {

	long findShippedAmount(long orderDetailId);


    Invoice findInvoiceById(long invoiceId);

    @SuppressWarnings("unchecked")
    List<InvoiceDetail> findInvoiceDetailByInvoiceId(long invoiceId);
}
