package com.starboard.b2b.dao;

import java.util.List;

import com.starboard.b2b.dto.ShippingTypeDTO;

public interface ShippingTypeDao {

	List<ShippingTypeDTO> findAll();

}