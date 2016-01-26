package com.starboard.b2b.web.controller.backend;

import com.starboard.b2b.common.Page;
import com.starboard.b2b.dto.EventDTO;
import com.starboard.b2b.service.EventService;
import com.starboard.b2b.web.form.event.EventForm;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

/**
 * Created by User: Thanakit Jumparuang (jthanakit.dev@gmail.com) Date: 1/22/2016 17:45
 */
@Controller
@RequestMapping("/backend/event")
public class BackendEventController {
    private static final Logger LOG = LogManager.getLogger(BackendEventController.class);
    @Autowired
    private EventService eventService;

    @RequestMapping(method = RequestMethod.GET)
    public String feedForm(@RequestParam(value = "page", required = false) Integer page, Model model) {
        model.addAttribute("resultPage", eventService.listCont(page));
        return "pages-back/event/list";
    }

    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String createForm(Model model) {
        model.addAttribute("eventForm", new EventForm());
        return "pages-back/event/create";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String createFormSubmit(@RequestParam(value = "page", required = false) Integer page, @ModelAttribute("feedContentForm") @Valid EventForm eventForm, BindingResult bindingResult,
                                   Model model) throws Exception {
        model.addAttribute("eventForm", eventForm);
        if (bindingResult.hasErrors()) {
            return "pages-back/event/create";
        }
        eventService.save(eventForm);
        model.addAttribute("resultPage", eventService.listCont(page));
        return "pages-back/event/list";
    }

    @RequestMapping(value = "edit/{eventId}", method = RequestMethod.GET)
    public String editForm(Model model, @PathVariable final int eventId, @RequestParam final int currentPage) {
        EventForm eventForm = new EventForm();
        eventForm.setId(eventId);
        eventForm.setPage(currentPage);
        final Page<EventDTO> event = eventService.content(eventId);
        if(event.getResult().isEmpty()){
            model.addAttribute("resultPage", eventService.listCont(currentPage));
            return "pages-back/event/list";
        }else{
            EventDTO eventDTO = event.getResult().get(0);
            eventForm.setTitle(eventDTO.getTitle());
            eventForm.setContent(eventDTO.getContent());
            eventForm.setTimeEvent(eventDTO.getTimeEvent());
            model.addAttribute("eventForm", eventForm);
            return "pages-back/event/edit";
        }
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String editFormSubmit(@ModelAttribute("feedContentForm") @Valid EventForm eventForm, BindingResult bindingResult,
                                 Model model) throws Exception {
        LOG.info("Edit!!! with time "+eventForm.getTimeEvent()+" for event "+eventForm.getTitle());
        eventService.update(eventForm);
        model.addAttribute("eventForm", eventForm);
        model.addAttribute("resultPage", eventService.listCont(eventForm.getPage()));
        return "pages-back/event/list";
    }

    @RequestMapping(value = "delete/{feedId}", method = RequestMethod.GET)
    public String deleteFeed(Model model, @PathVariable final int feedId, @RequestParam final int currentPage) {
        eventService.remove(feedId);
        model.addAttribute("resultPage", eventService.listCont(currentPage));
        return "pages-back/event/list";
    }


}
