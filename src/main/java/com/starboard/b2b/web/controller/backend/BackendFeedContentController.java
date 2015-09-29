package com.starboard.b2b.web.controller.backend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Ken on 9/30/2015.
 */
@Controller
@RequestMapping("/backend/feed-contents")
public class BackendFeedContentController {

    @RequestMapping(
            method = RequestMethod.GET
    )
    public String feedForm() {
        return "pages-back/feed/form";
    }

}
