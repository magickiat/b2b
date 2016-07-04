package com.starboard.b2b.dao;

public interface InvoiceDao {

	long findShippedAmount(long orderDetailId);

}