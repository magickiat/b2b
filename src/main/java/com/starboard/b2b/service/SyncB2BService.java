package com.starboard.b2b.service;

public interface SyncB2BService {

    void syncAllFromAX();

	void syncContactFromAX();

	void syncAddressFromAX();

	void syncProductFromAX();

    void syncOrdersFromAX();

    void syncOrderDetailFromAX();

    void syncOrderAddressFromAX();

    void syncSellOrderFromAX();

    void syncSellOrderDetailFromAX();

    //void syncInvoiceFromAX();

}
