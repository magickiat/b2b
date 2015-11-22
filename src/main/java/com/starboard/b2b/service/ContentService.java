package com.starboard.b2b.service;

import com.starboard.b2b.common.Page;
import com.starboard.b2b.dto.ContentDTO;
import com.starboard.b2b.model.Content;
import com.starboard.b2b.web.form.feed.CreateFeedContentForm;

import java.util.List;

/**
 * Created by Ken on 9/29/2015.
 */
public interface ContentService {

    List<ContentDTO> list();

    void save(CreateFeedContentForm feedContentForm) throws Exception;

	Page<ContentDTO> listCont(Integer pageIndex);

}
