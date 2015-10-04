package com.starboard.b2b.web.controller.backend;

import com.starboard.b2b.service.ContentService;
import com.starboard.b2b.web.form.feed.CreateFeedContentForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by Ken on 9/30/2015.
 */
@Controller
@RequestMapping("/backend/feed-contents")
public class BackendFeedContentController {

    @Autowired
    private ContentService contentService;

    @RequestMapping(
            method = RequestMethod.GET
    )
    public String feedForm() {
        return "pages-back/feed/list";
    }

    @RequestMapping(
            value = "create",
            method = RequestMethod.GET
    )
    public String createForm(Model model) {
        model.addAttribute("feedContentForm", new CreateFeedContentForm());
        return "pages-back/feed/create";
    }

    @RequestMapping(
            value = "create",
            method = RequestMethod.POST
    )
    public String createFormSubmit(@ModelAttribute("feedContentForm") @Valid CreateFeedContentForm feedContentForm,
                                   BindingResult bindingResult, Model model) throws Exception {
        model.addAttribute("feedContentForm", feedContentForm);
        if (bindingResult.hasErrors()) {
            return "pages-back/feed/create";
        }
        contentService.save(feedContentForm);
        return "pages-back/feed/list";
    }

}
