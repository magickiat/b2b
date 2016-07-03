package com.starboard.b2b.service;

import java.util.Map;

import com.starboard.b2b.dto.OrderDTO;
import com.starboard.b2b.dto.SearchProductEmailDTO;

public interface EmailService {
	void sendEmailOrderToCustomer(OrderDTO order, String host) throws Exception;

	void sendEmailOrderToStaff(OrderDTO order, String host) throws Exception;

	Map<Long, SearchProductEmailDTO> listProductEmail();

	void save(Long productTypeId, String email, String type);
	
	int deleteByEmailId(Long id);
}
