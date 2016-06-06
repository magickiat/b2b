package com.starboard.b2b.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.starboard.b2b.common.B2BConstant;
import com.starboard.b2b.common.Page;
import com.starboard.b2b.dao.OrderDao;
import com.starboard.b2b.dao.ProductBrandGroupDAO;
import com.starboard.b2b.dao.ProductBuyerGroupDao;
import com.starboard.b2b.dao.ProductCategoryDao;
import com.starboard.b2b.dao.ProductDao;
import com.starboard.b2b.dao.ProductModelDao;
import com.starboard.b2b.dao.ProductPriceDao;
import com.starboard.b2b.dao.ProductPriceGroupDao;
import com.starboard.b2b.dao.ProductTechnologyDao;
import com.starboard.b2b.dao.ProductTypeDao;
import com.starboard.b2b.dao.ProductYearDao;
import com.starboard.b2b.dao.UserDao;
import com.starboard.b2b.dto.ProductBuyerGroupDTO;
import com.starboard.b2b.dto.ProductCategoryDTO;
import com.starboard.b2b.dto.ProductDTO;
import com.starboard.b2b.dto.ProductModelDTO;
import com.starboard.b2b.dto.ProductPriceDTO;
import com.starboard.b2b.dto.ProductPriceGroupDTO;
import com.starboard.b2b.dto.ProductSearchResult;
import com.starboard.b2b.dto.ProductTechnologyDTO;
import com.starboard.b2b.dto.ProductTypeDTO;
import com.starboard.b2b.dto.ProductYearDTO;
import com.starboard.b2b.dto.search.SearchOrderDetailDTO;
import com.starboard.b2b.dto.search.SearchProductModelDTO;
import com.starboard.b2b.dto.search.SearchRequest;
import com.starboard.b2b.dto.search.SearchResult;
import com.starboard.b2b.model.Orders;
import com.starboard.b2b.model.Product;
import com.starboard.b2b.model.ProductBuyerGroup;
import com.starboard.b2b.model.ProductCategory;
import com.starboard.b2b.model.ProductModel;
import com.starboard.b2b.model.ProductPrice;
import com.starboard.b2b.model.ProductPriceId;
import com.starboard.b2b.model.ProductTechnology;
import com.starboard.b2b.model.ProductType;
import com.starboard.b2b.model.ProductYear;
import com.starboard.b2b.model.User;
import com.starboard.b2b.service.ProductService;
import com.starboard.b2b.util.ApplicationConfig;
import com.starboard.b2b.util.DateTimeUtil;
import com.starboard.b2b.util.ProductUtils;
import com.starboard.b2b.util.UserUtil;
import com.starboard.b2b.web.form.product.SearchProductForm;

@Service("productService")
@PropertySource(value = "classpath:application-${spring.profiles.active}.properties")
public class ProductServiceImpl implements ProductService {

	private static final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);

	@Value("${upload.path}")
	private String uploadPath;

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
	
	@Autowired
	private ProductBrandGroupDAO productBrandGroupDAO;

	@Autowired
	private ProductPriceDao productPriceDao;

	@Autowired
	private ProductPriceGroupDao productPriceGroupDao;

	@Autowired
	private UserDao userDao;

	@Autowired
	private OrderDao orderDao;

	@Override
	@Transactional(readOnly = true)
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
	@Transactional(readOnly = true)
	public List<ProductModelDTO> findAllProductModel() {
		return productModelDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
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
	@Transactional(readOnly = true)
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
	@Transactional(readOnly = true)
	public List<ProductBuyerGroupDTO> findProductBuyerGroupByBrandId(Long brandId) {
		List<ProductBuyerGroupDTO> result = new ArrayList<>();

		List<ProductBuyerGroup> list = null;
		if (brandId == null) {
			list = productBuyerGroupDao.findAll();
		} else {
			list = productBuyerGroupDao.findByBrandId(brandId);
		}
		for (ProductBuyerGroup productBuyerGroup : list) {
			ProductBuyerGroupDTO dto = new ProductBuyerGroupDTO();
			BeanUtils.copyProperties(productBuyerGroup, dto);
			result.add(dto);
		}

		return result;
	}

	@Override
	@Transactional(readOnly = true)
	public List<ProductTypeDTO> findProductTypeByBrandId(Long brandGroupId) {
		log.info("findAllProductType brandGroupId: " + brandGroupId);

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

	@Override()
	@Transactional(readOnly = true)
	public Page<SearchProductModelDTO> searchProduct(SearchProductForm form, Long custId) {
		log.info("form: " + form);
		SearchRequest<SearchProductForm> req = new SearchRequest<>(form.getPage(), applicationConfig.getPageSize());
		req.setCondition(form);

		// Find product model
		SearchResult<SearchProductModelDTO> result = productDao.searchProductForFrontend(req, custId);

		List<SearchProductModelDTO> resultList = result.getResult();
		log.info("resultList size: " + (resultList == null ? 0 : resultList.size()));

		// create result page object
		Page<SearchProductModelDTO> page = new Page<>();
		page.setCurrent(form.getPage());
		log.info("current page: " + page.getCurrent());
		page.setPageSize(req.getPageSize());
		page.setTotal(result.getTotal());
		page.setResult(result.getResult());
		return page;
	}

	@Override
	@Transactional(readOnly = true)
	public List<ProductSearchResult> findProductModel(String modelId, String withnoseProtection) {
		List<ProductSearchResult> result = productDao.findProductModel(modelId, withnoseProtection);

		// Set null when not found img in upload path (When img is null, show
		// default in view)
		for (ProductSearchResult product : result) {
			String imgPath = product.getProduct().getProductPictureBig();
			if (imgPath == null) {
				continue;
			}

			if (imgPath.startsWith("/upload/")) {
				imgPath = imgPath.substring(7);
			}

			// log.info("imgPath = " + imgPath);
			File img = new File(uploadPath, imgPath);
			if (!img.exists()) {
				product.getProduct().setProductPictureBig(null);
			}
		}
		return result;
	}

	@Override
	@Transactional(readOnly = true)
	public ProductModelDTO findProductModel(String modelId) {
		ProductModelDTO dto = null;
		ProductModel productModel = productModelDao.findProductModel(modelId);
		if (productModel != null) {
			dto = new ProductModelDTO();
			BeanUtils.copyProperties(productModel, dto);
		}
		return dto;
	}

	@Override
	@Transactional(readOnly = true)
	public HashMap<String, ProductSearchResult> findProductLength(List<ProductSearchResult> productList) {
		HashMap<String, ProductSearchResult> lengthGroup = new HashMap<>();

		for (ProductSearchResult productSearchResult : productList) {
			String productLength = productSearchResult.getProduct().getProductLength();
			lengthGroup.put(productLength, productSearchResult);
		}

		return lengthGroup;
	}

	@Override
	@Transactional(readOnly = true)
	public HashMap<String, List<ProductSearchResult>> groupProductByTechnology(List<ProductSearchResult> products) {

		HashMap<String, List<ProductSearchResult>> technologies = new HashMap<>();
		if (products != null && !products.isEmpty()) {
			for (ProductSearchResult product : products) {
				List<ProductSearchResult> listProductTech = technologies.get(product.getProduct().getProductTechnologyId());
				if (listProductTech == null) {
					listProductTech = new ArrayList<>();
					technologies.put(product.getProduct().getProductTechnologyId(), listProductTech);
				}
				listProductTech.add(product);
			}
		}
		return technologies;
	}

	@Override
	@Transactional(readOnly = true)
	public void findProductPrice(List<ProductSearchResult> productList, Long productTypeId) {
		log.info("findProductPrice:");
		User currentUser = UserUtil.getCurrentUser();
		for (ProductSearchResult result : productList) {
			ProductPriceDTO price = productPriceDao.findProductPrice(result.getProduct().getProductCode(), productTypeId, currentUser);
			result.setPrice(price);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public void findProductPriceList(List<SearchProductModelDTO> productList, Long productTypeId) {
		log.info("findProductPrice:");
		User currentUser = UserUtil.getCurrentUser();
		for (SearchProductModelDTO result : productList) {
			ProductPriceDTO price = productPriceDao.findProductPrice(result.getProductCode(), productTypeId, currentUser);
			log.info("prict: " + price);
			if (price != null) {
				result.setProductPrice(price.getAmount());
				result.setProductCurrency(price.getProductCurrency());
				result.setProductUnitId(price.getProductUnitId());
			} else {
				result.setProductPrice(null);
				result.setProductCurrency(null);
				result.setProductUnitId(null);
			}
		}
	}

	@Override
	@Transactional(readOnly = true)
	public String findProductUnit(long productId) {
		Product dto = productDao.findById(productId);
		if (dto != null) {
			return dto.getProductUnitId();
		}
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public ProductDTO findById(Long productId) {
		Product product = productDao.findById(productId);
		ProductDTO dto = new ProductDTO();
		if (product != null) {
			BeanUtils.copyProperties(product, dto);
		}
		return dto;
	}

	@Override
	@Transactional(readOnly = true)
	public ProductDTO findByProductCode(String productCode) {
		Product product = productDao.findByProductCode(productCode);
		ProductDTO dto = new ProductDTO();
		if (product != null) {
			BeanUtils.copyProperties(product, dto);
		}
		return dto;
	}

	@Override
	@Transactional(readOnly = true)
	public List<ProductBuyerGroupDTO> findProductBuyerGroupByProductType(List<ProductTypeDTO> productType) {
		List<ProductBuyerGroupDTO> result = new ArrayList<>();

		List<ProductBuyerGroup> list = null;
		if (productType == null || productType.isEmpty()) {
			list = productBuyerGroupDao.findAll();
		} else {
			ArrayList<Long> productTypeList = new ArrayList<>();
			for (ProductTypeDTO productTypeDTO : productType) {
				productTypeList.add(productTypeDTO.getProductTypeId());
			}
			list = productBuyerGroupDao.findByProductType(productTypeList);
		}
		for (ProductBuyerGroup productBuyerGroup : list) {
			ProductBuyerGroupDTO dto = new ProductBuyerGroupDTO();
			BeanUtils.copyProperties(productBuyerGroup, dto);
			result.add(dto);
		}

		return result;
	}

	@Override
	@Transactional(readOnly = true)
	public List<ProductSearchResult> findProductPrice(Map<Long, ProductDTO> cart, Long productTypeId) {
		ArrayList<ProductSearchResult> result = new ArrayList<>();
		Set<Long> keySet = cart.keySet();

		for (Long key : keySet) {
			ProductDTO productInCart = cart.get(key);
			ProductSearchResult product = new ProductSearchResult(productInCart);
			ProductPriceDTO price = productPriceDao.findProductPrice(productInCart.getProductCode(), productTypeId, UserUtil.getCurrentUser());
			product.setPrice(price);
			if (price != null) {
				productInCart.setProductPrice(price.getAmount());
			}
			result.add(product);
		}
		result.trimToSize();
		return result;
	}

	@Override
	@Transactional(readOnly = true)
	public ProductTypeDTO getProductType(Long brandGroupId) {
		ProductType type = productTypeDao.findById(brandGroupId);
		if (type == null) {
			return null;
		}
		ProductTypeDTO dto = new ProductTypeDTO();
		BeanUtils.copyProperties(type, dto);
		return dto;
	}

	@Override
	@Transactional(readOnly = true)
	public List<ProductTypeDTO> getProductTypes(Long customerId, Long brandGroupId) {
		log.info("getProductTypes\tcustomerId = " + customerId + "\tbrandGroupId = " + brandGroupId);
		List<ProductType> types = productTypeDao.findByCustomerAndBrand(customerId, brandGroupId);
		if (types == null || types.isEmpty()) {
			return null;
		}
		List<ProductTypeDTO> list = getProductTypeDTO(types);
		return list;
	}

	public List<ProductTypeDTO> getProductTypeDTO(List<ProductType> types) {
		List<ProductTypeDTO> list = new ArrayList<>();
		for (ProductType type : types) {
			ProductTypeDTO dto = new ProductTypeDTO();
			BeanUtils.copyProperties(type, dto);
			list.add(dto);
		}
		return list;
	}

	@Override
	@Transactional(readOnly = true)
	public List<ProductPriceGroupDTO> listProductPriceGroup() {
		return productPriceGroupDao.list();
	}

	@Override
	@Transactional(readOnly = true)
	public List<ProductTypeDTO> findAllProductType() {
		List<ProductType> types = productTypeDao.findAll();
		log.info("found " + (types == null ? 0 : types.size()));
		List<ProductTypeDTO> list = getProductTypeDTO(types);
		return list;
	}

	@Override
	@Transactional(readOnly = true)
	public List<ProductTypeDTO> listProductBrandGroupForJson() {
		ArrayList<ProductTypeDTO> result = new ArrayList<>();
		List<ProductType> list = productTypeDao.listDistinctProductType();

		if (list == null || list.isEmpty()) {
			return result;
		} else {
			for (ProductType data : list) {
				ProductTypeDTO dto = new ProductTypeDTO();
				BeanUtils.copyProperties(data, dto);
				result.add(dto);
			}

			return result;
		}

	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void updateProduct(List<ProductDTO> products) {
		if (products != null && !products.isEmpty()) {

			for (ProductDTO importProduct : products) {
				if (StringUtils.isNotEmpty(importProduct.getProductCode())) {
					log.info("find by product code: " + importProduct.getProductCode());
					Product product = productDao.findByProductCode(importProduct.getProductCode());
					boolean isNull = product == null;
					log.info("found: " + !isNull);
					if (isNull) {
						product = new Product();
						BeanUtils.copyProperties(importProduct, product);
						product.setTimeCreate(DateTimeUtil.getCurrentDate());
						product.setUserCreate(B2BConstant.B2B_SYSTEM_NAME);
					} else {
						product.setProductTypeId(importProduct.getProductTypeId());
						product.setProductNameEn(importProduct.getProductNameEn());
						product.setProductTechnologyId(importProduct.getProductTechnologyId());
						product.setProductLength(importProduct.getProductLength());
						product.setIsActive(importProduct.getIsActive());

						product.setTimeUpdate(DateTimeUtil.getCurrentDate());
						product.setUserUpdate(B2BConstant.B2B_SYSTEM_NAME);
					}

					// Set default to active if value is empty
					if (StringUtils.isEmpty(importProduct.getIsActive())) {
						product.setIsActive(B2BConstant.PRODUCT_FLAG_ACTIVE);
					}

					// ----- Transform data -----
					// withnose protector
					String flagWithNoseProduct = B2BConstant.NO_WITHNOSE_PROTECTION;
					if (ProductUtils.isWithnoseProduct(product.getProductNameEn())) {
						flagWithNoseProduct = B2BConstant.WITHNOSE_PROTECTION;
					}
					
					product.setProductPreintro(flagWithNoseProduct);
					product.setProductModelId(importProduct.getProductModelId().trim());
					product.setProductBuyerGroupId(importProduct.getProductBuyerGroupId().trim());
					product.setProductYearId(importProduct.getProductYearId());
					product.setStatusFlag(importProduct.getStatusFlag());
					
					

					if (isNull) {
						log.info("save " + product.getProductCode());
						productDao.save(product);
					}
				}
			}
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Page<SearchProductModelDTO> searchProductBackend(SearchProductForm form) {
		log.info("form: " + form);
		SearchRequest<SearchProductForm> req = new SearchRequest<>(form.getPage(), applicationConfig.getPageSize());
		req.setCondition(form);

		// Find product model
		SearchResult<SearchProductModelDTO> result = productDao.searchProductForBackend(req);

		// Validate has image exist
		List<SearchProductModelDTO> resultList = result.getResult();
		log.info("resultList size: " + (resultList == null ? 0 : resultList.size()));

		// create result page object
		Page<SearchProductModelDTO> page = new Page<>();
		page.setCurrent(form.getPage());
		log.info("current page: " + page.getCurrent());
		page.setPageSize(req.getPageSize());
		page.setTotal(result.getTotal());
		page.setResult(result.getResult());
		return page;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void updateProductPrice(List<ProductPriceDTO> productPrices) {
		if (productPrices != null && !productPrices.isEmpty()) {
			for (ProductPriceDTO dto : productPrices) {
				boolean isNew = false;
				ProductPriceId id = new ProductPriceId();
				id.setProductCode(dto.getProductCode());
				id.setProductCurrency(dto.getProductCurrency());
				id.setProductPriceGroupId(dto.getProductPriceGroupId());

				ProductPrice price = productPriceDao.findById(id);
				if (price == null) {
					isNew = true;
					price = new ProductPrice();
					price.setId(id);
					price.setTimeCreate(DateTimeUtil.getCurrentDate());
					price.setUserCreate(B2BConstant.B2B_SYSTEM_NAME);
				} else {
					price.setTimeUpdate(DateTimeUtil.getCurrentDate());
					price.setUserUpdate(B2BConstant.B2B_SYSTEM_NAME);
				}

				price.setAmount(dto.getAmount());
				price.setMsrePrice(dto.getMsrePrice());
				price.setProductUnitId(dto.getProductUnitId());

				if (isNew) {
					productPriceDao.save(price);
				}
			}
		}
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean delete(long productId) {
		return productDao.delete(productId);
	}

	@Override
	@Transactional(readOnly = true)
	public void findOrderPriceList(List<SearchOrderDetailDTO> orderDetails, Long orderId) {
		if (orderDetails != null && !orderDetails.isEmpty()) {
			Orders ord = orderDao.findById(orderId);
			User orderUser = userDao.findByUsername(ord.getUserCreate());

			for (SearchOrderDetailDTO result : orderDetails) {
				Product product = productDao.findById(result.getProductId());
				if (product == null) {
					continue;
				}

				ProductPriceDTO price = productPriceDao.findProductPrice(result.getProductCode(), ord.getBrandGroupId(), orderUser);
				log.info("prict: " + price);
				if (price != null) {
					result.setUnitPrice(price.getAmount());
					result.setProductCurrency(price.getProductCurrency());
					result.setProductUnitId(price.getProductUnitId());
				} else {
					result.setUnitPrice(null);
					result.setProductCurrency(null);
					result.setProductUnitId(null);
				}
			}
		} else {
			log.warn("orderDetails is empty!");
		}
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void createNewModel(String modelId) {
		productModelDao.save(new ProductModel(modelId, modelId, "Created when not found model id", B2BConstant.B2B_SYSTEM_NAME, null,
				DateTimeUtil.getCurrentDate(), null, "default", B2BConstant.B2B_SYSTEM_NAME, B2BConstant.B2B_SYSTEM_NAME));
	}

	@Override
	@Transactional(readOnly = true)
	public List<Product> findProductByBrandId(Long brandGroupId) {
		return productDao.findByBrandGroupId(brandGroupId);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ProductTypeDTO> getProductTypes(Long customerId) {
		List<ProductTypeDTO> result = new ArrayList<>();
		List<ProductType> productTypeList = productTypeDao.findByCustomer(customerId);

		if (productTypeList != null && productTypeList.size() > 0) {
			for (ProductType productType : productTypeList) {
				ProductTypeDTO dto = new ProductTypeDTO();
				BeanUtils.copyProperties(productType, dto);
				result.add(dto);
			}
		}

		return result;
	}

	@Override
	@Transactional(readOnly = true)
	public List<SearchProductModelDTO> searchProductForReport(SearchProductForm form, Long custId) {
		SearchRequest<SearchProductForm> req = new SearchRequest<>(0, B2BConstant.SEARCH_ALL);
		req.setCondition(form);

		SearchResult<SearchProductModelDTO> result = productDao.searchProductForFrontend(req, custId);

		return result.getResult();

	}

	@Override
	@Transactional(readOnly = true)
	public List<SearchProductModelDTO> findAllProduct() {
		return productDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Product> findProductByProductTypeId(Long productTypeId) {
		return productDao.findByProductTypeId(productTypeId);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ProductPriceDTO> findAllProductPrice() {
		return productPriceDao.list();
	}

	@Override
	public List<ProductTypeDTO> listProductBrandGroup() {
		return productBrandGroupDAO.list();
	}

}
