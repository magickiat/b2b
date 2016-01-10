package com.starboard.b2b.service.impl;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.starboard.b2b.common.Page;
import com.starboard.b2b.dao.ContactUsDao;
import com.starboard.b2b.dto.ContactUsDTO;
import com.starboard.b2b.dto.search.SearchRequest;
import com.starboard.b2b.dto.search.SearchResult;
import com.starboard.b2b.model.Contactus;
import com.starboard.b2b.service.ContactUsService;
import com.starboard.b2b.util.ApplicationConfig;
import com.starboard.b2b.util.DateTimeUtil;
import com.starboard.b2b.util.UserUtil;
import com.starboard.b2b.web.form.CreateContactUsForm;
import com.starboard.b2b.web.form.SearchContactUsForm;

@Service("contactUsService")
public class ContactUsServiceImpl implements ContactUsService {

	private static final Logger log = LoggerFactory.getLogger(ContactUsServiceImpl.class);

	@Autowired
	private ApplicationConfig applicationConfig;

	@Autowired
	private ContactUsDao contactUsDao;

	@Override
	@Transactional
	public Page<ContactUsDTO> search(SearchContactUsForm form) {
		// ----- set request ------
		SearchRequest<SearchContactUsForm> req = new SearchRequest<>(form.getPage(), applicationConfig.getPageSize());
		req.setCondition(form);
		SearchResult<Contactus> searchResult = contactUsDao.search(req);

		// ----- transform dto -----
		ArrayList<ContactUsDTO> result = new ArrayList<>();
		if (searchResult != null && searchResult.getResult() != null) {
			for (Contactus model : searchResult.getResult()) {
				ContactUsDTO dto = new ContactUsDTO();
				BeanUtils.copyProperties(model, dto);
				result.add(dto);
			}
		}

		// ----- prepare result page -----
		Page<ContactUsDTO> page = new Page<>();
		page.setCurrent(req.getPage());
		page.setResult(result);
		page.setPageSize(req.getPageSize());
		page.setTotal(searchResult.getTotal());

		log.info("result size: " + (result == null ? 0 : result.size()));
		return page;
	}

	@Override
	@Transactional
	public void save(CreateContactUsForm form) {
		Contactus contactUs = new Contactus();
		contactUs.setContactTitle(form.getTitle());
		contactUs.setContactName(form.getName());
		contactUs.setContactEmail(form.getEmail());
		contactUs.setContactDetail(form.getDetail());
		contactUs.setContactTel(form.getTel());
		contactUs.setTimeCreate(DateTimeUtil.getCurrentDate());
		contactUs.setUserCreate(UserUtil.getCurrentUsername());

		contactUsDao.save(contactUs);
	}

	@Override
	@Transactional
	public void delete(long id) {
		Contactus contactUs = contactUsDao.findById(id);
		if(contactUs != null && contactUs.getContactId() != null){
			contactUsDao.delete(contactUs);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public boolean existContact(long id) {
		return contactUsDao.findById(id) != null;
	}

}
