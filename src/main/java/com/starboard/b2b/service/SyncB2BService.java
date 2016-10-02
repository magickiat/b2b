package com.starboard.b2b.service;

import com.starboard.b2b.common.Page;
import com.starboard.b2b.dto.search.SearchSyncRequest;
import com.starboard.b2b.dto.search.SyncAxDto;

public interface SyncB2BService {

	void syncAllFromAX() throws Exception;

	void syncContactFromAX();

	void syncAddressFromAX();

	void syncProductFromAX();

	void syncOrdersFromAX();

	void syncOrderDetailFromAX();

	void syncOrderAddressFromAX();

	void syncSellOrderFromAX();

	void syncSellOrderDetailFromAX();

	Page<SyncAxDto> search(SearchSyncRequest req);

	// void syncInvoiceFromAX();

}
