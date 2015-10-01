package com.starboard.b2b.service;

import com.starboard.b2b.model.Content;
import com.starboard.b2b.web.form.feed.CreateFeedContentForm;

import java.util.List;

/**
 * Created by Ken on 9/29/2015.
 */
public interface ContentService {

    List<Content> list();

    void save(CreateFeedContentForm feedContentForm) throws Exception;

}
