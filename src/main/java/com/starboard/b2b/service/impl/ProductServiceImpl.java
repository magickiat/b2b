package com.starboard.b2b.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.starboard.b2b.dao.ProductCategoryDao;
import com.starboard.b2b.dao.ProductDao;
import com.starboard.b2b.dao.ProductModelDao;
import com.starboard.b2b.dao.ProductTechnologyDao;
import com.starboard.b2b.dao.ProductTypeDao;
import com.starboard.b2b.dao.ProductYearDao;
import com.starboard.b2b.dto.ProductBuyerGroupDTO;
import com.starboard.b2b.dto.ProductCategoryDTO;
import com.starboard.b2b.dto.ProductModelDTO;
import com.starboard.b2b.dto.ProductTechnologyDTO;
import com.starboard.b2b.dto.ProductTypeDTO;
import com.starboard.b2b.dto.ProductYearDTO;
import com.starboard.b2b.model.ProductCategory;
import com.starboard.b2b.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;

	@Autowired
	private ProductTypeDao productTypeDao;

	@Autowired
	private ProductCategoryDao productCategoryDao;

	@Autowired
	private ProductModelDao productModelDao;

	@Autowired
	private ProductYearDao productYearDao;

	@Autowired
	private ProductTechnologyDao productTechnologyDao;

	@Override
	@Transactional
	public List<ProductCategoryDTO> findAllProductCategory() throws Exception {
		List<ProductCategoryDTO> result = new ArrayList<>();
		List<ProductCategory> list = productCategoryDao.findAll();
		for (ProductCategory data : list) {
			ProductCategoryDTO dto = new ProductCategoryDTO();
			BeanUtils.copyProperties(data, dto);
			result.add(dto);
		}
		return result;
	}

	@Override
	@Transactional
	public List<ProductModelDTO> findAllProductModel() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public List<ProductYearDTO> findAllProductYear() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public List<ProductTechnologyDTO> findAllProductTechnology() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public List<ProductBuyerGroupDTO> findAllProductBuyerGroup() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public List<ProductTypeDTO> findAllProductType(Integer brandGroupId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}