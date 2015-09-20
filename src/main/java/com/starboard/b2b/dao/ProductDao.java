package com.starboard.b2b.dao;

import java.util.List;

import com.starboard.b2b.common.Page;
import com.starboard.b2b.model.Product;

public interface ProductDao {

	List<Product> list();

	List<Product> list(Integer brandId);

	List<Product> list(Page page);

}