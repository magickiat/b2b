package com.starboard.b2b.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.starboard.b2b.dao.TmpAddrDao;
import com.starboard.b2b.model.TmpAddr;

@Repository("tmpAddrDao")
public class TmpAddrDaoImpl implements TmpAddrDao {

//	@Autowired
//	private SessionFactory sessionFactory;

	@Override
	public TmpAddr findById(long addrId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Object obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Long maxId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TmpAddr> findByCustId(long custId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(TmpAddr addr) {
		// TODO Auto-generated method stub
		
	}

	
}
