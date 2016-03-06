package com.starboard.b2b.dao;

import java.util.List;

import com.starboard.b2b.dto.ProductModelDTO;
import com.starboard.b2b.model.ProductModel;

public interface ProductModelDao {

	List<ProductModelDTO> findAll();

	void save(ProductModel productModel);

	ProductModel findProductModel(String modelId);

}