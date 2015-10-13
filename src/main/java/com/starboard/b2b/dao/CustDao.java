package com.starboard.b2b.dao;

import java.util.List;

import com.starboard.b2b.dto.AddressDTO;
import com.starboard.b2b.dto.ProductBrandGroupDTO;
import com.starboard.b2b.dto.search.SearchCustRequest;
import com.starboard.b2b.dto.search.SearchCustResult;
import com.starboard.b2b.model.Cust;

public interface CustDao {
	SearchCustResult listCust(SearchCustRequest req);

	Cust findById(Long custId);

	List<AddressDTO> findAddress(Long custId, Long addressType);

	List<ProductBrandGroupDTO> findProductBrandGroup(Long custId);
}
