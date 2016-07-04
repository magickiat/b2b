package com.starboard.b2b.dao;

import com.starboard.b2b.dto.search.SearchRequest;
import com.starboard.b2b.dto.search.SearchResult;
import com.starboard.b2b.model.Contactus;
import com.starboard.b2b.web.form.SearchContactUsForm;

public interface ContactUsDao {
	SearchResult<Contactus> search(SearchRequest<SearchContactUsForm> req);

	void save(Object contactUs);

	Contactus findById(long id);

	void delete(Contactus contactUs);
}
