package com.starboard.b2b.dao;

import java.util.List;

import com.starboard.b2b.dto.ProductEmailDTO;
import com.starboard.b2b.model.ProductEmail;

public interface ProductEmailDao {

	void save(ProductEmail productEmail);

	List<ProductEmailDTO> findByProductTypeId(Long productTypeId);
	
	List<ProductEmailDTO> findAll();

	ProductEmailDTO findByEmail(Long productTypeId, String email);

	ProductEmailDTO find(Long productTypeId, String email, String emailType);

	int deleteById(Long id);

	List<ProductEmail> findByBrandGroupId(Long brandGroupId);

	List<ProductEmail> findByBrandGroupId(Long brandGroupId, String emailType);
}