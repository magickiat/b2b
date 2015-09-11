package com.starboard.b2b.dao;

import java.util.List;

import com.starboard.b2b.model.Brand;

public interface BrandDao {

	List<Brand> list(Integer companyId);

	List<Brand> list();

	void addSelectedBrand(Integer custId, List<Integer> selectedBrand);

}