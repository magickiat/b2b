package com.starboard.b2b.service;

import java.util.List;

import com.starboard.b2b.dto.ProductBrandGroupDTO;
import com.starboard.b2b.model.Brand;

public interface BrandService {

	List<Brand> list(Long companyId);

	List<Brand> list();

	List<ProductBrandGroupDTO> getBrandGroupList(Long custId);
	
}