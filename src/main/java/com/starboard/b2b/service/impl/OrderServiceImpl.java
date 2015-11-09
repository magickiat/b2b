package com.starboard.b2b.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.starboard.b2b.dao.ShippingTypeDao;
import com.starboard.b2b.dto.ShippingTypeDTO;
import com.starboard.b2b.service.OrderService;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

	@Autowired
	private ShippingTypeDao shippingTypeDao;

	@Override
	@Transactional(readOnly = true)
	public List<ShippingTypeDTO> findAllShippingType() {
		return shippingTypeDao.findAll();
	}
}
