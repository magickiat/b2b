package com.starboard.b2b.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.starboard.b2b.dao.AddrDao;
import com.starboard.b2b.model.Addr;
import com.starboard.b2b.service.AddrService;

@Service("AddrService")
public class AddrServiceImpl implements AddrService {

	private static final Logger log = LoggerFactory.getLogger(AddrServiceImpl.class);

	@Autowired
	private AddrDao addrDao;

	@Override
	@Transactional(readOnly = true)
	public Addr findById(long addrId) {
		return addrDao.findById(addrId);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Addr> findByCustId(long custId) {
		return addrDao.findByCustId(custId);
	}

}
