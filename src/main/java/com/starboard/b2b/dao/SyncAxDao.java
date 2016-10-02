package com.starboard.b2b.dao;

import com.starboard.b2b.dto.search.SearchRequest;
import com.starboard.b2b.dto.search.SearchSyncRequest;
import com.starboard.b2b.dto.search.SearchSyncResult;
import com.starboard.b2b.model.SyncAx;

public interface SyncAxDao {
	
	void save(SyncAx sync);
	
	SearchSyncResult search(SearchRequest<SearchSyncRequest> req);

}
