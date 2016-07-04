package com.starboard.b2b.dao;

import com.starboard.b2b.common.Pagination;
import com.starboard.b2b.dto.search.SearchEventRequest;
import com.starboard.b2b.dto.search.SearchEventResult;
import com.starboard.b2b.model.Event;

import java.util.List;

/**
 * Created by User: Thanakit Jumparuang (jthanakit.dev@gmail.com) Date: 1/21/2016 13:02
 */
public interface EventDao {

    List list();

    void add(Event content);

	List<Event> list(Pagination page);

	SearchEventResult listEvents(SearchEventRequest req);

    Event findById(int eventId);

    void remove(int eventId);

    void update(Event event);
}
