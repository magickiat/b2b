package com.starboard.b2b.service;

public interface RoSyncService {

	void syncProduct();

	void syncRoFromB2BtoAX(long orderId) throws Exception;

}