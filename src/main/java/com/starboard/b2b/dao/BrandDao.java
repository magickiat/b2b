package com.starboard.b2b.dao;

import java.util.List;

import com.starboard.b2b.model.Brand;

public interface BrandDao {

	List<Brand> list(Integer companyId);

	List<Brand> list();

	void addSelectedBrand(Long custId, List<Integer> selectedBrand);

        public Brand getBrand(long brandId);
}