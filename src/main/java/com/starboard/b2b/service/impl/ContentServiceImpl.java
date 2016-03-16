package com.starboard.b2b.service.impl;

import com.starboard.b2b.common.Page;
import com.starboard.b2b.common.Pagination;
import com.starboard.b2b.dao.ContentDao;
import com.starboard.b2b.dto.ContentDTO;
import com.starboard.b2b.dto.search.SearchContentRequest;
import com.starboard.b2b.dto.search.SearchContentResult;
import com.starboard.b2b.model.Content;
import com.starboard.b2b.service.ContentService;
import com.starboard.b2b.util.ApplicationConfig;
import com.starboard.b2b.util.UserUtil;
import com.starboard.b2b.web.form.feed.CreateFeedContentForm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Ken on 9/29/2015.
 */
@Service("contentService")
public class ContentServiceImpl implements ContentService {
	private static final Logger log = LoggerFactory.getLogger(ContentServiceImpl.class);
	private static final int maxContentLength = 1700;

    @Autowired
    private ContentDao contentDao;
    @Autowired
	private ApplicationConfig applicationConfig;

    @SuppressWarnings("unchecked")
	@Override
    @Transactional(readOnly = true)
    public List<ContentDTO> list() {
        return copyContentToDTO(contentDao.list());
    }
    
	@Override
	@Transactional(readOnly = true)
	public Page<ContentDTO> listCont(Integer pageIndex) {
		log.info("Search content for page index: {}", pageIndex);
		SearchContentRequest req = new SearchContentRequest(pageIndex, applicationConfig.getPageSize());
		log.info(req.toString());
		SearchContentResult searchResult = contentDao.listContent(req);
		List<ContentDTO> result = new ArrayList<>();
		for (Content cont : searchResult.getResult()) {
			ContentDTO dto = new ContentDTO();
			BeanUtils.copyProperties(cont, dto, "content");
			if(cont.getContent().length() > maxContentLength){
				dto.setContent(cont.getContent().substring(0, maxContentLength));
				dto.setMore(true);
			}else{
				dto.setContent(cont.getContent());
			}
			result.add(dto);
		}
		Page<ContentDTO> page = new Page<>();
		page.setCurrent(req.getPage());
		page.setResult(result);
		page.setPageSize(req.getPageSize());
		page.setTotal(searchResult.getTotal());
		return page;
	}

	@Override
	@Transactional(readOnly = true)
	public Page<ContentDTO> content(int feedId) {
		Page<ContentDTO> page = new Page<>();
		Content content = contentDao.findById(feedId);
		if(content != null){
			ContentDTO contentDTO = new ContentDTO();
			List<ContentDTO> result = new ArrayList<>();
			BeanUtils.copyProperties(content, contentDTO);
			result.add(contentDTO);
			page.setResult(result);
		}else{
			page.setResult(new ArrayList<ContentDTO>());
		}
		return page;
	}

	@Transactional(readOnly = true)
	public List<ContentDTO> list(Pagination page) {
		return copyContentToDTO(contentDao.list(page));
	}
	
	private List<ContentDTO> copyContentToDTO(List<Content> list) {
		ArrayList<ContentDTO> contList = new ArrayList<>();
		if (list != null && list.size() > 0) {
			for (Content content : list) {
				contList.add(new ContentDTO(content));
			}
		}
		return contList;
	}

    @Override
    @Transactional
    public void save(CreateFeedContentForm feedContentForm) throws Exception {
        Content content = new Content();
        content.setTitle(feedContentForm.getTitle());
        content.setContent(feedContentForm.getContent());
        content.setUserCreate(UserUtil.getCurrentUsername());
        content.setTimeCreate(new Date());
        contentDao.add(content);
    }

	@Override
	@Transactional
	public void remove(final int contentId) {
		contentDao.remove(contentId);
	}

	@Override
	@Transactional
	public void update(CreateFeedContentForm feedContentForm){
		Content content = contentDao.findById(feedContentForm.getId());
		content.setTitle(feedContentForm.getTitle());
		content.setContent(feedContentForm.getContent());
		content.setUserUpdate(UserUtil.getCurrentUsername());
		content.setTimeUpdate(new Date());
		contentDao.update(content);
	}

}
