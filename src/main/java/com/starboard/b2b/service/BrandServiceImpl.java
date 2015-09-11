package com.starboard.b2b.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.starboard.b2b.dao.BrandDao;
import com.starboard.b2b.model.Brand;

@Service
public class BrandServiceImpl implements BrandService {

	@Autowired
	private BrandDao brandDao;

	@Override
	@Transactional(readOnly = true)
	public List<Brand> list(Integer companyId) {
		return brandDao.list(companyId);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Brand> list() {
		return brandDao.list();
	}

}
