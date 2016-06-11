package com.starboard.b2b.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.starboard.b2b.common.Page;
import com.starboard.b2b.common.Pagination;
import com.starboard.b2b.dao.EventDao;
import com.starboard.b2b.dto.EventDTO;
import com.starboard.b2b.dto.search.SearchEventRequest;
import com.starboard.b2b.dto.search.SearchEventResult;
import com.starboard.b2b.model.Event;
import com.starboard.b2b.service.EventService;
import com.starboard.b2b.util.ApplicationConfig;
import com.starboard.b2b.util.UserUtil;
import com.starboard.b2b.web.form.event.EventForm;

/**
 *
 * Created by User: Thanakit Jumparuang (jthanakit.dev@gmail.com) Date: 1/22/2016 17:45
 */
@Service("eventService")
@Transactional
public class EventServiceImpl implements EventService {
	private static final Logger log = LoggerFactory.getLogger(EventServiceImpl.class);
	private static final int maxContentLength = 1700;

    @Autowired
    private EventDao eventDao;
    @Autowired
	private ApplicationConfig applicationConfig;

    @SuppressWarnings("unchecked")
	@Override
    public List<EventDTO> list() {
        return copyEventToDTO(eventDao.list());
    }

	@Override
	@Transactional(readOnly = true)
	public Page<EventDTO> listCont(Integer pageIndex) {
		log.info("Search event for page index: {}", pageIndex);
		SearchEventRequest req = new SearchEventRequest(pageIndex, applicationConfig.getPageSize());
		log.info(req.toString());
		SearchEventResult searchResult = eventDao.listEvents(req);
		List<EventDTO> result = new ArrayList<>();
		for (Event event : searchResult.getResult()) {
			EventDTO dto = new EventDTO();
			BeanUtils.copyProperties(event, dto, "event");
			if(event.getContent().length() > maxContentLength){
				dto.setContent(event.getContent().substring(0, maxContentLength));
				dto.setMore(true);
			}else{
				dto.setContent(event.getContent());
			}
			result.add(dto);
		}
		Page<EventDTO> page = new Page<>();
		page.setCurrent(req.getPage());
		page.setResult(result);
		page.setPageSize(req.getPageSize());
		page.setTotal(searchResult.getTotal());
		return page;
	}

	@Override
	public Page<EventDTO> content(int feedId) {
		Page<EventDTO> page = new Page<>();
		Event event = eventDao.findById(feedId);
		if(event != null){
			EventDTO eventDTO = new EventDTO();
			List<EventDTO> result = new ArrayList<>();
			BeanUtils.copyProperties(event, eventDTO);
			result.add(eventDTO);
			page.setResult(result);
		}else{
			page.setResult(new ArrayList<EventDTO>());
		}
		return page;
	}

	@Transactional(readOnly = true)
	public List<EventDTO> list(Pagination page) {
		return copyEventToDTO(eventDao.list(page));
	}
	
	private List<EventDTO> copyEventToDTO(List<Event> list) {
		ArrayList<EventDTO> eventDTOs = new ArrayList<>();
		if (list != null && list.size() > 0) {
			for (Event event : list) {
				eventDTOs.add(new EventDTO(event));
			}
		}
		return eventDTOs;
	}

    @Override
    public void save(EventForm eventForm) throws Exception {
        Event event = new Event();
        event.setTitle(eventForm.getTitle());
        event.setContent(eventForm.getContent());
		event.setTimeEvent(eventForm.getTimeEvent());
        event.setUserCreate(UserUtil.getCurrentUsername());
        event.setTimeCreate(new Date());
        eventDao.add(event);
    }

	@Override
	public void remove(final int contentId) {
		eventDao.remove(contentId);
	}

	@Override
	public void update(EventForm eventForm){
		Event event = eventDao.findById(eventForm.getId());
		event.setTitle(eventForm.getTitle());
		event.setContent(eventForm.getContent());
		event.setTimeEvent(eventForm.getTimeEvent());
		event.setUserUpdate(UserUtil.getCurrentUsername());
		event.setTimeUpdate(new Date());
		eventDao.update(event);
	}

}
