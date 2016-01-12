package com.starboard.b2b.dao;

import com.starboard.b2b.model.Brand;
import com.starboard.b2b.web.form.brand.BrandForm;

import java.util.List;

public interface BrandDao {

	List<Brand> list(Integer companyId);

	List<Brand> list();

	void addSelectedBrand(BrandForm form, List<Integer> selectedBrand);

	public Brand getBrand(long brandId);
}
