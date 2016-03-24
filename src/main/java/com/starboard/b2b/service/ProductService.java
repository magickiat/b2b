package com.starboard.b2b.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.starboard.b2b.common.Page;
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
import com.starboard.b2b.model.Product;
import com.starboard.b2b.web.form.product.SearchProductForm;

public interface ProductService {

	List<ProductTypeDTO> findAllProductType();

	// Query Brands by brandGroupId, if brandGroupId = 0 is query all
	List<ProductTypeDTO> findProductTypeByBrandId(Long brandGroupId);

	List<ProductCategoryDTO> findAllProductCategory();

	List<ProductModelDTO> findAllProductModel();

	List<ProductYearDTO> findAllProductYear();

	List<ProductTechnologyDTO> findAllProductTechnology();

	List<ProductBuyerGroupDTO> findProductBuyerGroupByBrandId(Long selectedBrandId);

	List<ProductBuyerGroupDTO> findProductBuyerGroupByProductType(List<ProductTypeDTO> productType);

	Page<SearchProductModelDTO> searchProduct(SearchProductForm searchProductForm, Long custId);

	Page<SearchProductModelDTO> searchProductBackend(SearchProductForm searchProductForm);

	List<ProductSearchResult> findProductModel(String modelId, String withnoseProtection);

	ProductModelDTO findProductModel(String modelId);

	HashMap<String, ProductSearchResult> findProductLength(List<ProductSearchResult> productListNoWithnose);

	HashMap<String, List<ProductSearchResult>> groupProductByTechnology(List<ProductSearchResult> productList);

	void findProductPrice(List<ProductSearchResult> productList, Long productTypeId);

	void findProductPriceList(List<SearchProductModelDTO> productList, Long productTypeId);

	String findProductUnit(long productId);

	ProductDTO findById(Long productId);

	ProductDTO findByProductCode(String productCode);

	List<ProductSearchResult> findProductPrice(Map<Long, ProductDTO> cart, Long productTypeId);

	ProductTypeDTO getProductType(Long brandGroupId);

	List<ProductTypeDTO> getProductTypes(Long customerId, Long brandGroupId);

	List<ProductTypeDTO> getProductTypes(Long customerId);

	List<ProductPriceGroupDTO> listProductPriceGroup();

	List<ProductTypeDTO> listProductBrandGroupForJson();

	void updateProduct(List<ProductDTO> products);

	void updateProductPrice(List<ProductPriceDTO> productPrices);

	boolean delete(long productId);

	void findOrderPriceList(List<SearchOrderDetailDTO> orderDetails, Long orderId);

	void createNewModel(String modelId);

	List<Product> findProductByBrandId(Long brandGroupId);

	List<SearchProductModelDTO> searchProductForReport(SearchProductForm form, Long custId);

	List<SearchProductModelDTO> findAllProduct();

}
