package com.starboard.b2b.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.starboard.b2b.common.Page;
import com.starboard.b2b.dao.ProductBuyerGroupDao;
import com.starboard.b2b.dao.ProductCategoryDao;
import com.starboard.b2b.dao.ProductDao;
import com.starboard.b2b.dao.ProductModelDao;
import com.starboard.b2b.dao.ProductTechnologyDao;
import com.starboard.b2b.dao.ProductTypeDao;
import com.starboard.b2b.dao.ProductYearDao;
import com.starboard.b2b.dto.ProductBuyerGroupDTO;
import com.starboard.b2b.dto.ProductCategoryDTO;
import com.starboard.b2b.dto.ProductDTO;
import com.starboard.b2b.dto.ProductModelDTO;
import com.starboard.b2b.dto.ProductTechnologyDTO;
import com.starboard.b2b.dto.ProductTypeDTO;
import com.starboard.b2b.dto.ProductYearDTO;
import com.starboard.b2b.dto.search.CommonSearchRequest;
import com.starboard.b2b.dto.search.SearchProductModelDTO;
import com.starboard.b2b.dto.search.SearchResult;
import com.starboard.b2b.model.Product;
import com.starboard.b2b.model.ProductBuyerGroup;
import com.starboard.b2b.model.ProductCategory;
import com.starboard.b2b.model.ProductModel;
import com.starboard.b2b.model.ProductTechnology;
import com.starboard.b2b.model.ProductType;
import com.starboard.b2b.model.ProductYear;
import com.starboard.b2b.service.ProductService;
import com.starboard.b2b.util.ApplicationConfig;
import com.starboard.b2b.web.form.product.SearchProductForm;

@Service
public class ProductServiceImpl implements ProductService {

	private static final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);

	@Autowired
	private ApplicationConfig applicationConfig;

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

	@Autowired
	private ProductBuyerGroupDao productBuyerGroupDao;

	@Override
	@Transactional
	public List<ProductCategoryDTO> findAllProductCategory() {
		ArrayList<ProductCategoryDTO> result = new ArrayList<>();
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
	public List<ProductModelDTO> findAllProductModel() {
		List<ProductModelDTO> result = new ArrayList<>();
		List<ProductModel> productModels = productModelDao.findAll();
		for (ProductModel productModel : productModels) {
			ProductModelDTO dto = new ProductModelDTO();
			BeanUtils.copyProperties(productModel, dto);
			result.add(dto);
		}
		return result;
	}

	@Override
	@Transactional
	public List<ProductYearDTO> findAllProductYear() {
		List<ProductYearDTO> result = new ArrayList<>();
		List<ProductYear> productYears = productYearDao.findAll();
		for (ProductYear productYear : productYears) {
			ProductYearDTO dto = new ProductYearDTO();
			BeanUtils.copyProperties(productYear, dto);
			result.add(dto);
		}
		return result;
	}

	@Override
	@Transactional
	public List<ProductTechnologyDTO> findAllProductTechnology() {
		List<ProductTechnologyDTO> result = new ArrayList<>();
		List<ProductTechnology> technologies = productTechnologyDao.findAll();
		for (ProductTechnology productTechnology : technologies) {
			ProductTechnologyDTO dto = new ProductTechnologyDTO();
			BeanUtils.copyProperties(productTechnology, dto);
			result.add(dto);
		}
		return result;
	}

	@Override
	@Transactional
	public List<ProductBuyerGroupDTO> findAllProductBuyerGroup() {
		List<ProductBuyerGroupDTO> result = new ArrayList<>();

		List<ProductBuyerGroup> list = productBuyerGroupDao.findAll();
		for (ProductBuyerGroup productBuyerGroup : list) {
			ProductBuyerGroupDTO dto = new ProductBuyerGroupDTO();
			BeanUtils.copyProperties(productBuyerGroup, dto);
			result.add(dto);
		}

		return result;
	}

	@Override
	@Transactional
	public List<ProductTypeDTO> findAllProductType(Long brandGroupId) {
		List<ProductTypeDTO> result = new ArrayList<>();

		List<ProductType> productTypeList = null;
		if (brandGroupId == null || brandGroupId == 0) {
			productTypeList = productTypeDao.findAll();
		} else {
			productTypeList = productTypeDao.findByProductBrandGroupId(brandGroupId);
		}

		log.info("productTypeList size: " + (productTypeList == null ? 0 : productTypeList.size()));
		if (productTypeList != null & productTypeList.size() > 0) {
			for (ProductType productType : productTypeList) {
				ProductTypeDTO dto = new ProductTypeDTO();
				BeanUtils.copyProperties(productType, dto);
				result.add(dto);
			}
		}

		return result;
	}

	@Override
	public Page<SearchProductModelDTO> searchProduct(SearchProductForm form) {
		log.info("form: " + form);
		CommonSearchRequest<SearchProductForm> req = new CommonSearchRequest<>(form.getPage(),
				applicationConfig.getPageSize());
		req.setCondition(form);

		SearchResult<SearchProductModelDTO> result = productDao.search(req);

		// create result page object
		Page<SearchProductModelDTO> page = new Page<>();
		page.setCurrent(req.getPage());
		page.setPageSize(req.getPageSize());
		page.setTotal(result.getTotal());
		page.setResult(result.getResult());
		return page;
	}
}
