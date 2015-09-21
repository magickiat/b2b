package com.starboard.b2b.dao;

import java.util.List;

import com.starboard.b2b.model.ProductCategory;

public interface ProductCategoryDao {

	List<ProductCategory> findAll();

}