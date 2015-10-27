package com.starboard.b2b.service;

import java.util.HashMap;
import java.util.List;

import com.starboard.b2b.common.Page;
import com.starboard.b2b.dto.ProductBuyerGroupDTO;
import com.starboard.b2b.dto.ProductCategoryDTO;
import com.starboard.b2b.dto.ProductDTO;
import com.starboard.b2b.dto.ProductModelDTO;
import com.starboard.b2b.dto.ProductSearchResult;
import com.starboard.b2b.dto.ProductTechnologyDTO;
import com.starboard.b2b.dto.ProductTypeDTO;
import com.starboard.b2b.dto.ProductYearDTO;
import com.starboard.b2b.dto.search.SearchProductModelDTO;
import com.starboard.b2b.web.form.product.SearchProductForm;

public interface ProductService {

	// Query Brands by brandGroupId, if brandGroupId = 0 is query all
	List<ProductTypeDTO> findAllProductType(Long brandGroupId);

	List<ProductCategoryDTO> findAllProductCategory();

	List<ProductModelDTO> findAllProductModel();

	List<ProductYearDTO> findAllProductYear();

	List<ProductTechnologyDTO> findAllProductTechnology();

	List<ProductBuyerGroupDTO> findAllProductBuyerGroup();

	Page<SearchProductModelDTO> searchProduct(SearchProductForm searchProductForm);

	List<ProductSearchResult> findProductModel(String modelId, String withnoseProtection);

	List<ProductSearchResult> findProductModel(String modelId);

	HashMap<String, ProductSearchResult> findProductLength(List<ProductSearchResult> productListNoWithnose);

	HashMap<String, List<ProductSearchResult>> groupProductByTechnology(List<ProductSearchResult> productListNoWithnose);

	void findProductPrice(List<ProductSearchResult> productList, String custInvoiceCode);

	void findProductPriceList(List<SearchProductModelDTO> productList, String custInvoiceCode);

	String findProductUnit(long productId);

	ProductDTO findById(Long productId);

}