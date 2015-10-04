package com.starboard.b2b.dao;

import com.starboard.b2b.common.SearchCustRequest;
import com.starboard.b2b.common.SearchCustResult;
import com.starboard.b2b.model.Cust;

public interface CustDao {
	SearchCustResult listCust(SearchCustRequest req);

	Cust findById(Long custId);
}
