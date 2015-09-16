package com.starboard.b2b.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.starboard.b2b.common.Page;
import com.starboard.b2b.dao.ProductDao;
import com.starboard.b2b.dto.ProductDTO;

public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;

	@Override
	public List<ProductDTO> list(Integer brandId) throws Exception {
		ArrayList<ProductDTO> products = new ArrayList<>();
		return products;
	}

	@Override
	public List<ProductDTO> list(Integer brandId, Page page) throws Exception {
		ArrayList<ProductDTO> products = new ArrayList<>();

		return products;
	}
}
