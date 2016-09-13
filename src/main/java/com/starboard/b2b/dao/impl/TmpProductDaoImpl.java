package com.starboard.b2b.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.starboard.b2b.dao.TmpProductDao;
import com.starboard.b2b.dto.ProductSearchResult;
import com.starboard.b2b.dto.search.SearchProductModelDTO;
import com.starboard.b2b.dto.search.SearchRequest;
import com.starboard.b2b.dto.search.SearchResult;
import com.starboard.b2b.model.TmpProduct;
import com.starboard.b2b.web.form.product.SearchProductForm;

@Repository("tmpProductDao")
public class TmpProductDaoImpl implements TmpProductDao {

	@Override
	public List<TmpProduct> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SearchResult<SearchProductModelDTO> searchProductForBackend(SearchRequest<SearchProductForm> req) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SearchResult<SearchProductModelDTO> searchProductForFrontend(SearchRequest<SearchProductForm> req, Long custId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductSearchResult> findProductModel(String modelId, String withnoseProtection) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductSearchResult> findProductModel(String modelId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TmpProduct findById(long productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TmpProduct findByProductCode(String productCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TmpProduct> findByBrandGroupId(long brandGroupId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(TmpProduct product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void merge(TmpProduct product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean delete(long productId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<SearchProductModelDTO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TmpProduct> findByProductTypeId(Long productTypeId) {
		// TODO Auto-generated method stub
		return null;
	}

}
