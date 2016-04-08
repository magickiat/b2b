package com.starboard.b2b.service;

import java.util.List;

import com.starboard.b2b.dto.ProductBrandGroupDTO;

public interface BrandService {

	List<ProductBrandGroupDTO> getBrandGroupList(Long custId);

	List<ProductBrandGroupDTO> getProductBrandGroup(Long custId);
}