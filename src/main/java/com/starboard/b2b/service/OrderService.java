package com.starboard.b2b.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.starboard.b2b.dto.ShippingTypeDTO;

public interface OrderService {

	List<ShippingTypeDTO> findAllShippingType();

}