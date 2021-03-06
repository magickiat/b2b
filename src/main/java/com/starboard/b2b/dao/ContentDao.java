package com.starboard.b2b.dao;

import com.starboard.b2b.common.Pagination;
import com.starboard.b2b.dto.search.SearchContentRequest;
import com.starboard.b2b.dto.search.SearchContentResult;
import com.starboard.b2b.model.Content;

import java.util.List;

/**
 * Created by Ken on 9/29/2015.
 */
public interface ContentDao {

    List list();

    void add(Content content);

	List<Content> list(Pagination page);

	SearchContentResult listContent(SearchContentRequest req);

    Content findById(int contentId);

    void remove(int contentId);

    void update(Content content);
}
