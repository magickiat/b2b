package com.starboard.b2b.service.impl;

import com.starboard.b2b.dao.ContentDao;
import com.starboard.b2b.model.Content;
import com.starboard.b2b.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Ken on 9/29/2015.
 */
@Service
public class ContentServiceImpl implements ContentService {

    @Autowired
    private ContentDao contentDao;

    @Override
    public List<Content> list() {
        return contentDao.list();
    }

}
