package com.starboard.b2b.dao;

import java.util.List;

import com.starboard.b2b.model.ProductModel;

public interface ProductModelDao {

	List<ProductModel> findAll();

}