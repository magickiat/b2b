package com.starboard.b2b.dao;

import java.util.List;

import com.starboard.b2b.dto.ProductSearchResult;
import com.starboard.b2b.dto.search.SearchProductModelDTO;
import com.starboard.b2b.dto.search.SearchRequest;
import com.starboard.b2b.dto.search.SearchResult;
import com.starboard.b2b.model.Product;
import com.starboard.b2b.web.form.product.SearchProductForm;

public interface ProductDao {

	List<Product> list();

	SearchResult<SearchProductModelDTO> searchProductForBackend(SearchRequest<SearchProductForm> req);

	SearchResult<SearchProductModelDTO> searchProductForFrontend(SearchRequest<SearchProductForm> req, Long custId);

	List<ProductSearchResult> findProductModel(String modelId, String withnoseProtection);

	List<ProductSearchResult> findProductModel(String modelId);

	Product findById(long productId);

	Product findByProductCode(String productCode);

	List<Product> findByBrandGroupId(long brandGroupId);

	void save(Product product);

	void merge(Product product);

	boolean delete(long productId);

	List<SearchProductModelDTO> findAll();

	List<Product> findByProductTypeId(Long productTypeId);
}
