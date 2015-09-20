package com.starboard.b2b.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.starboard.b2b.common.Page;
import com.starboard.b2b.dao.ProductDao;
import com.starboard.b2b.dto.ProductDTO;
import com.starboard.b2b.model.product.Product;
import com.starboard.b2b.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;

	@Override
	@Transactional(readOnly = true)
	public List<ProductDTO> list(Integer brandId) throws Exception {
		ArrayList<ProductDTO> products = new ArrayList<>();
		List<Product> list = productDao.list(brandId);
		for (Product product : list) {
//			products.add(new ProductDTO(product));
		}
		return products;
	}

	@Override
	@Transactional(readOnly = true)
	public List<ProductDTO> list(Integer brandId, Page page) throws Exception {
		ArrayList<ProductDTO> products = new ArrayList<>();

		return products;
	}
}
