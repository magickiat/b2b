package com.starboard.b2b.dao;

import java.util.List;

import com.starboard.b2b.dto.ProductModelDTO;

public interface ProductModelDao {

	List<ProductModelDTO> findAll();

}