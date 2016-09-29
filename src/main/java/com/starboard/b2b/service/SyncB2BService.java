package com.starboard.b2b.service;

import org.springframework.transaction.annotation.Transactional;

public interface SyncB2BService {

	void syncContactFromAX();

	void syncAddressFromAX();

	void syncProductFromAX();

    void syncOrdersFromAX();

    void syncOrderDetailFromAX();

    void syncOrderAddressFromAX();

    void syncSellOrderFromAX();

    //For Sale Order
    @Transactional(rollbackFor = Exception.class)
    void syncSellOrderDetailFromAX();

    void syncInvoiceFromAX();

}
