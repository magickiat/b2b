package com.starboard.b2b.dao;

import java.util.List;

import com.starboard.b2b.model.ProductType;

public interface ProductTypeDao {

	List<ProductType> findAll();

	List<ProductType> findByProductBrandGroupId(Integer brandGroupId);

}