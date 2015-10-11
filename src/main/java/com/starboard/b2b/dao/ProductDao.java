package com.starboard.b2b.dao;

import java.util.List;

import com.starboard.b2b.dto.ProductSearchResult;
import com.starboard.b2b.dto.search.CommonSearchRequest;
import com.starboard.b2b.dto.search.SearchProductModelDTO;
import com.starboard.b2b.dto.search.SearchResult;
import com.starboard.b2b.model.Product;
import com.starboard.b2b.web.form.product.SearchProductForm;

public interface ProductDao {

	List<Product> list();

	List<Product> list(Integer brandId);

	SearchResult<SearchProductModelDTO> search(CommonSearchRequest<SearchProductForm> req);

	List<ProductSearchResult> findProductModel(String modelId, String withnoseProtection);

	List<ProductSearchResult> findProductModel(String modelId);

}