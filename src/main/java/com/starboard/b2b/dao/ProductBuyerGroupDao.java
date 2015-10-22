package com.starboard.b2b.dao;

import java.util.List;

import com.starboard.b2b.dto.ProductBuyerGroupDTO;
import com.starboard.b2b.model.ProductBuyerGroup;

public interface ProductBuyerGroupDao {
	List<ProductBuyerGroup> findAll();
}
