package com.starboard.b2b.service;

import com.starboard.b2b.dto.OrderDTO;

public interface EmailService {
	void sendEmailOrderToCustomer(OrderDTO order, String host) throws Exception;

	void sendEmailOrderToStaff(OrderDTO order, String host) throws Exception;

}
