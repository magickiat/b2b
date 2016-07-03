package com.starboard.b2b.web.controller.backend;

import com.starboard.b2b.common.Page;
import com.starboard.b2b.dto.ContentDTO;
import com.starboard.b2b.service.ContentService;
import com.starboard.b2b.web.form.feed.CreateFeedContentForm;

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
 * Created by Ken on 9/30/2015.
 */
@Controller
@RequestMapping("/backend/feed-contents")
public class BackendFeedContentController {
    private static final Logger LOG = LogManager.getLogger(BackendFeedContentController.class);
    @Autowired
    private ContentService contentService;

    @RequestMapping(method = RequestMethod.GET)
    public String feedForm(@RequestParam(value = "page", required = false) Integer page, Model model) {
        model.addAttribute("resultPage", contentService.listCont(page));
        return "pages-back/feed/list";
    }

    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String createForm(Model model) {
        model.addAttribute("feedContentForm", new CreateFeedContentForm());
        return "pages-back/feed/create";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String createFormSubmit(@RequestParam(value = "page", required = false) Integer page, @ModelAttribute("feedContentForm") @Valid CreateFeedContentForm feedContentForm, BindingResult bindingResult,
                                   Model model) throws Exception {
        model.addAttribute("feedContentForm", feedContentForm);
        if (bindingResult.hasErrors()) {
            return "pages-back/feed/create";
        }
        contentService.save(feedContentForm);
        model.addAttribute("resultPage", contentService.listCont(page));
        return "pages-back/feed/list";
    }

    @RequestMapping(value = "edit/{feedId}", method = RequestMethod.GET)
    public String editForm(Model model, @PathVariable final int feedId, @RequestParam final int currentPage) {
        CreateFeedContentForm feedContentForm = new CreateFeedContentForm();
        feedContentForm.setId(feedId);
        feedContentForm.setPage(currentPage);
        final Page<ContentDTO> content = contentService.content(feedId);
        if(content.getResult().isEmpty()){
            model.addAttribute("resultPage", contentService.listCont(currentPage));
            return "pages-back/feed/list";
        }else{
            ContentDTO contentDTO = content.getResult().get(0);
            feedContentForm.setTitle(contentDTO.getTitle());
            feedContentForm.setContent(contentDTO.getContent());
            model.addAttribute("feedContentForm", feedContentForm);
            return "pages-back/feed/edit";
        }
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String editFormSubmit(@ModelAttribute("feedContentForm") @Valid CreateFeedContentForm feedContentForm, BindingResult bindingResult,
                                 Model model) throws Exception {
        if (!bindingResult.hasErrors()) {
            contentService.update(feedContentForm);
        }
        model.addAttribute("feedContentForm", feedContentForm);
        model.addAttribute("resultPage", contentService.listCont(feedContentForm.getPage()));
        return "pages-back/feed/list";
    }

    @RequestMapping(value = "delete/{feedId}", method = RequestMethod.GET)
    public String deleteFeed(Model model, @PathVariable final int feedId, @RequestParam final int currentPage) {
        contentService.remove(feedId);
        model.addAttribute("resultPage", contentService.listCont(currentPage));
        return "pages-back/feed/list";
    }


}
