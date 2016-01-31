package com.starboard.b2b.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.starboard.b2b.dao.CustDao;
import com.starboard.b2b.dto.ProductBrandGroupDTO;
import com.starboard.b2b.service.BrandService;

@Service("brandService")
public class BrandServiceImpl implements BrandService {
	private static final Logger log = LoggerFactory.getLogger(BrandServiceImpl.class);

	@Autowired
	private CustDao custDao;

	@Override
	@Transactional(readOnly = true)
	public List<ProductBrandGroupDTO> getBrandGroupList(Long custId) {
		log.debug("getBrandGroupList --> custId: " + custId);
		return custDao.findProductBrandGroup(custId);
	}

}
