package com.starboard.b2b.service.impl;

import com.starboard.b2b.dao.ContentDao;
import com.starboard.b2b.model.Content;
import com.starboard.b2b.service.ContentService;
import com.starboard.b2b.util.UserUtil;
import com.starboard.b2b.web.form.feed.CreateFeedContentForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by Ken on 9/29/2015.
 */
@Service
@Transactional
public class ContentServiceImpl implements ContentService {

    @Autowired
    private ContentDao contentDao;

    @Override
    public List<Content> list() {
        return contentDao.list();
    }

    @Override
    public void save(CreateFeedContentForm feedContentForm) throws Exception {
        Content content = new Content();
        content.setTitle(feedContentForm.getTitle());
        content.setContent(feedContentForm.getContent());
        content.setUserCreate(UserUtil.getCurrentUsername());
        content.setTimeCreate(new Date());
        contentDao.add(content);
    }

}
