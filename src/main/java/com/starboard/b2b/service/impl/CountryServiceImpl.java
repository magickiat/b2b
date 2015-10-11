package com.starboard.b2b.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.starboard.b2b.dao.CountryDao;
import com.starboard.b2b.dto.CountryDTO;
import com.starboard.b2b.service.CountryService;

@Repository("countryService")
public class CountryServiceImpl implements CountryService {

	@Autowired
	private CountryDao countryDao;

	@Override
	@Transactional(readOnly = true)
	public List<CountryDTO> findAll() {
		return countryDao.findAll();
	}
}
