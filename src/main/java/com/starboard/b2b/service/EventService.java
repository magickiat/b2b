package com.starboard.b2b.service;

import com.starboard.b2b.common.Page;
import com.starboard.b2b.dto.EventDTO;
import com.starboard.b2b.web.form.event.EventForm;

import java.util.List;

/**
 * Created by User: Thanakit Jumparuang (jthanakit.dev@gmail.com) Date: 1/22/2016 17:45
 */
public interface EventService {

    List<EventDTO> list();

    void save(EventForm eventForm) throws Exception;

	Page<EventDTO> listCont(Integer pageIndex);

    Page<EventDTO> content(int eventId);

    void remove(int eventId);

    void update(EventForm eventForm);
}
