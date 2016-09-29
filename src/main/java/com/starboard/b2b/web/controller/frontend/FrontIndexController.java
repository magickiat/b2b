package com.starboard.b2b.web.controller.frontend;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.starboard.b2b.common.B2BConstant;
import com.starboard.b2b.common.Page;
import com.starboard.b2b.dto.B2BFile;
import com.starboard.b2b.dto.ContentDTO;
import com.starboard.b2b.dto.EventCalendarDTO;
import com.starboard.b2b.dto.EventDTO;
import com.starboard.b2b.service.ContentService;
import com.starboard.b2b.service.EventService;
import com.starboard.b2b.util.B2BFileUtil;
import com.starboard.b2b.web.controller.backend.AdminController;

import org.apache.commons.lang.StringEscapeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

@Controller
public class FrontIndexController {

	private static Gson gson = new GsonBuilder().disableHtmlEscaping().create();
	private static final Logger log = LoggerFactory.getLogger(FrontIndexController.class);

	@Autowired
	private Environment env;

	@Autowired
	private ContentService contentService;
	@Autowired
	private EventService eventService;
	
	@RequestMapping("/frontend")
	String index(@RequestParam(value = "page", required = false) Integer page, Model model) {
		model.addAttribute("resultPage", contentService.listCont(page));
		return "pages-front/home";
	}

	@RequestMapping("/news")
	String news(@RequestParam int feedId, @RequestParam(defaultValue = "front") String side, Model model){
		Page<ContentDTO> pageContent = contentService.content(feedId);
		model.addAttribute("resultPage", pageContent);
		model.addAttribute("side", side);
		return "news";
	}

	@RequestMapping("/event")
	String event(@RequestParam int eventId, @RequestParam(defaultValue = "front") String side, Model model){
		Page<EventDTO> pageEvent = eventService.content(eventId);
		model.addAttribute("resultPage", pageEvent);
		model.addAttribute("side", side);
		return "event";
	}

	@RequestMapping("/event/list")
	@ResponseBody
	String events(@RequestParam(value = "page", required = false) Integer page, HttpServletRequest request){
		Page<EventDTO> events = eventService.listCont(page);
		EventCalendarDTO eventCalendar = new EventCalendarDTO();
		List<EventCalendarDTO.Event> eventCals = new ArrayList<>();
		for(EventDTO event : events.getResult()){
			EventCalendarDTO.Event eventCal = new EventCalendarDTO.Event();
			eventCal.setDate(event.getTimeEvent().getTime());
			eventCal.setType("order");
			eventCal.setTitle(event.getTitle());
			eventCal.setDescription(StringEscapeUtils.unescapeHtml(event.getContent()));
			eventCal.setUrl("http://"+request.getHeader("host")+request.getContextPath()+"/event?eventId="+event.getId()+"&side=front");
			eventCals.add(eventCal);
		}
		eventCalendar.setEvents(eventCals);
		return gson.toJson(eventCalendar.getEvents());
	}
	
	@RequestMapping(value = "/frontend/image/background")
	@ResponseBody
	String background() {
		Map<String, List<String>> response = new HashMap<String, List<String>>();
		List<String> file_list = new ArrayList<String>();
		String rootPath = env.getProperty("upload.path");
		log.info("path: " + B2BConstant.TEMPLATE_IMAGE_FOLDER + "/" + B2BConstant.TEMPLATE_IMAGE_FRONT_END);
		log.info("current : " + B2BConstant.TEMPLATE_IMAGE_FRONT_END);
		List<B2BFile> listFile = B2BFileUtil.list(rootPath, B2BConstant.TEMPLATE_IMAGE_FOLDER + "/" + B2BConstant.TEMPLATE_IMAGE_FRONT_END);
		for (B2BFile b2bFile : listFile) {
			if (b2bFile.getNameWithPath().length() > 0) {
				file_list.add(b2bFile.getNameWithPath());
			}
		}
		response.put("data", file_list);
		return gson.toJson(response);
	}
}
