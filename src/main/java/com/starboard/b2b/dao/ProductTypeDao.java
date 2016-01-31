package com.starboard.b2b.dao;

import java.util.List;

import com.starboard.b2b.model.ProductType;

public interface ProductTypeDao {

	public List<ProductType> findAll();

	public ProductType findById(Long id);

	public List<ProductType> findByProductBrandGroupId(Long brandGroupId);

	public List<ProductType> findByCustomerAndBrand(Long customerId, Long brandGroupId);
	
	public List<ProductType> listDistinctProductType();
}