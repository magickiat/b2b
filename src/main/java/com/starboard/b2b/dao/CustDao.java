package com.starboard.b2b.dao;

import com.starboard.b2b.common.SearchCustRequest;
import com.starboard.b2b.common.SearchCustResult;

public interface CustDao {
	SearchCustResult listCust(SearchCustRequest req);
}
