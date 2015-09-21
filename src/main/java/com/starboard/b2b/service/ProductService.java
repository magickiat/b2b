package com.starboard.b2b.service;

import java.util.List;

import com.starboard.b2b.dto.ProductBuyerGroupDTO;
import com.starboard.b2b.dto.ProductCategoryDTO;
import com.starboard.b2b.dto.ProductModelDTO;
import com.starboard.b2b.dto.ProductTechnologyDTO;
import com.starboard.b2b.dto.ProductTypeDTO;
import com.starboard.b2b.dto.ProductYearDTO;

public interface ProductService {

	// Query Brands by brandGroupId, if brandGroupId = 0 is query all
	List<ProductTypeDTO> findAllProductType(Integer brandGroupId) throws Exception;

	List<ProductCategoryDTO> findAllProductCategory() throws Exception;

	List<ProductModelDTO> findAllProductModel() throws Exception;

	List<ProductYearDTO> findAllProductYear() throws Exception;

	List<ProductTechnologyDTO> findAllProductTechnology() throws Exception;

	List<ProductBuyerGroupDTO> findAllProductBuyerGroup() throws Exception;
}