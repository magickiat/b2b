package com.starboard.b2b.dao;

import com.starboard.b2b.dto.ProductSearchResult;
import com.starboard.b2b.dto.search.SearchProductModelDTO;
import com.starboard.b2b.dto.search.SearchRequest;
import com.starboard.b2b.dto.search.SearchResult;
import com.starboard.b2b.model.TmpProduct;
import com.starboard.b2b.web.form.product.SearchProductForm;

import java.util.List;

public interface TmpProductDao {

	List<TmpProduct> list();

	SearchResult<SearchProductModelDTO> searchProductForBackend(SearchRequest<SearchProductForm> req);

	SearchResult<SearchProductModelDTO> searchProductForFrontend(SearchRequest<SearchProductForm> req, Long custId);

	List<ProductSearchResult> findProductModel(String modelId, String withnoseProtection);

	List<ProductSearchResult> findProductModel(String modelId);

	TmpProduct findById(long productId);

	TmpProduct findByProductCode(String productCode);

	List<TmpProduct> findByBrandGroupId(long brandGroupId);

	void save(TmpProduct product);

	void merge(TmpProduct product);

	boolean delete(long productId);

	List<SearchProductModelDTO> findAll();

	List<TmpProduct> findByProductTypeId(Long productTypeId);
}
