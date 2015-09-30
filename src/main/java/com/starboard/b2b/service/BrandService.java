package com.starboard.b2b.service;

import java.util.List;
import java.util.Set;

import com.starboard.b2b.dto.ProductBrandGroupDTO;
import com.starboard.b2b.model.Brand;

public interface BrandService {

	List<Brand> list(Long companyId);

	List<Brand> list();

	Set<ProductBrandGroupDTO> getBrandGroupList(Long custId);
	
}