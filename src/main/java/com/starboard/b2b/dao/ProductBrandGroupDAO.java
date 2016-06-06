package com.starboard.b2b.dao;

import java.util.List;

import com.starboard.b2b.dto.ProductTypeDTO;
import com.starboard.b2b.model.ProductBrandGroup;

public interface ProductBrandGroupDAO {
	List<ProductBrandGroup> findByProductTypeId(Long brandGroupId);

	List<ProductTypeDTO> list();
}
