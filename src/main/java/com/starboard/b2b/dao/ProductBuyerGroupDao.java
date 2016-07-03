package com.starboard.b2b.dao;

import java.util.List;

import com.starboard.b2b.model.ProductBuyerGroup;

public interface ProductBuyerGroupDao {
	List<ProductBuyerGroup> findAll();

	List<ProductBuyerGroup> findByBrandId(Long brandId);

	List<ProductBuyerGroup> findByProductType(List<Long> productType);
}
