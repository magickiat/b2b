package com.starboard.b2b.service;

import java.util.List;

import com.starboard.b2b.model.Brand;

public interface BrandService {

	List<Brand> list(Integer companyId);

	List<Brand> list();
	
}