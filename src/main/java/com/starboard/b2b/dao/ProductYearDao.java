package com.starboard.b2b.dao;

import java.util.List;

import com.starboard.b2b.model.ProductYear;

public interface ProductYearDao {

	List<ProductYear> findAll();

	ProductYear findByYear(String year);

}