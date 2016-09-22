package com.starboard.b2b.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.starboard.b2b.dao.AddrDao;
import com.starboard.b2b.dao.TmpAddrDao;
import com.starboard.b2b.model.Addr;
import com.starboard.b2b.model.TmpAddr;

@Service("SyncAXService")
@Transactional(rollbackFor = Exception.class)
public class SyncAXService {

	private AddrDao addrDao;
	private TmpAddrDao tmpAddrDao;

	public void syncAddr(long custId) {
		// clear old address
		tmpAddrDao.deleteByCustId(custId);
		
		// insert new address
		List<Addr> listAddr = addrDao.findByCustId(custId);
		if(listAddr != null && !listAddr.isEmpty()){
			for (Addr addr : listAddr) {
				TmpAddr tmpAddr = new TmpAddr();
				BeanUtils.copyProperties(addr, tmpAddr);
				tmpAddrDao.save(tmpAddr);
			}
		}
	}

	@Autowired
	public void setAddrDao(AddrDao addrDao) {
		this.addrDao = addrDao;
	}

	@Autowired
	public void setTmpAddrDao(TmpAddrDao tmpAddrDao) {
		this.tmpAddrDao = tmpAddrDao;
	}
}
