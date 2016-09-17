package com.starboard.b2b.service;

import org.springframework.transaction.annotation.Transactional;

public interface SyncB2BService {

	void syncContactFromAX();

	void syncAddressFromAX();

	void syncProductFromAX();

	void syncOrderFromAX();

    //for Order Detail
    @Transactional(rollbackFor = Exception.class)
    void syncOrderDetailFromAX();

    //for Order Address
    @Transactional(rollbackFor = Exception.class)
    void syncOrderAddressFromAX();

    void syncSellOrderFromAX();

	void syncInvoiceFromAX();

}
