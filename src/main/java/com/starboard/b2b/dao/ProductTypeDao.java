package com.starboard.b2b.dao;

import java.util.List;

import com.starboard.b2b.model.ProductType;

public interface ProductTypeDao {

	List<ProductType> findAll();

	List<ProductType> findByProductBrandGroupId(Long brandGroupId);

        List<ProductType> findByIds(List<Long> ids);
}