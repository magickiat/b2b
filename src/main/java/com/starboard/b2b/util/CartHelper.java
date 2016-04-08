package com.starboard.b2b.util;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.starboard.b2b.dto.ProductBrandGroupDTO;
import com.starboard.b2b.service.BrandService;

public class CartHelper {

	private static final Logger log = LoggerFactory.getLogger(CartHelper.class);

	private BrandService brandService;

	public HashMap<Long, Long> getBrandGroup() {

		HashMap<Long, Long> groups = new HashMap<>();
		List<ProductBrandGroupDTO> brandGroupList = brandService.getProductBrandGroup(UserUtil.getCurrentUser().getCustomer().getCustId());
		for (ProductBrandGroupDTO group : brandGroupList) {
			Long brandGroup = groups.get(group.getProductTypeId());
			if (brandGroup == null) {
				log.info(String.format("%d == %d", group.getProductTypeId(), group.getBrandGroupId()));
				groups.put(group.getProductTypeId(), group.getBrandGroupId());
			}
		}

		return groups;
	}

	public void setBrandService(BrandService brandService) {
		this.brandService = brandService;
	}
}
