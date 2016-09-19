package com.starboard.b2b.service;

public interface SyncB2BService {

	void syncContactFromAX();

	void syncAddressFromAX();

	void syncProductFromAX();

    void syncOrdersFromAX();

    void syncOrderDetailFromAX();

    void syncOrderAddressFromAX();

    void syncSellOrderFromAX();

	void syncInvoiceFromAX();

}
