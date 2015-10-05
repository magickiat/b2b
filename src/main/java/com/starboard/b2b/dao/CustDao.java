package com.starboard.b2b.dao;

import com.starboard.b2b.dto.search.SearchCustRequest;
import com.starboard.b2b.dto.search.SearchCustResult;
import com.starboard.b2b.model.Cust;

public interface CustDao {
	SearchCustResult listCust(SearchCustRequest req);

	Cust findById(Long custId);
}
