package com.starboard.b2b.util;

import java.util.HashMap;
import java.util.List;

import com.starboard.b2b.dto.ProductBrandGroupDTO;
import com.starboard.b2b.service.BrandService;

public class CartHelper {

	private BrandService brandService;

	public HashMap<Long, Long> getBrandGroup() {

		HashMap<Long, Long> groups = new HashMap<>();
		List<ProductBrandGroupDTO> brandGroupList = brandService.getBrandGroupList(UserUtil.getCurrentUser().getCustomer().getCustId());
		for (ProductBrandGroupDTO group : brandGroupList) {
			Long brandGroup = groups.get(group.getProductTypeId());
			if (brandGroup == null) {
				groups.put(group.getProductTypeId(), group.getBrandGroupId());
			}
		}

		return groups;
	}

	public void setBrandService(BrandService brandService) {
		this.brandService = brandService;
	}
}
