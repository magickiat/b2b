package com.starboard.b2b.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.starboard.b2b.dao.OrderDao;
import com.starboard.b2b.dao.OrderDetailDao;
import com.starboard.b2b.dao.SoDao;
import com.starboard.b2b.dao.SoDetailDao;
import com.starboard.b2b.dao.TmpSoDao;
import com.starboard.b2b.model.sync.TmpSo;
import com.starboard.b2b.service.SyncB2BService;

@Service("syncB2BService")
public class SyncB2BServiceImpl implements SyncB2BService {

	private static final Logger log = LoggerFactory.getLogger(SyncB2BServiceImpl.class);

	private OrderDao orderDao;
	private OrderDetailDao orderDetailDao;
	private SoDao soDao;
	private SoDetailDao soDetailDao;
	private TmpSoDao tmpSoDao;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void syncSellOrderFromAX() {
		log.info("Sync sell order from AX");

		// ----- find SO from AX -----
		List<TmpSo> tmpSoList = tmpSoDao.findSoForImport();
		if (tmpSoList == null || tmpSoList.isEmpty()) {
			log.info("Not found any record for sync");
			return;
		}

		// ==========
		// sync step
		// ==========
		for (TmpSo tmpSo : tmpSoList) {
			// ------ Step 1: Clear order detail by Sell Order number -----
			orderDetailDao.deleteBySoNo(tmpSo.getSoNo());
		}

	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void syncInvoiceFromAX() {
		log.info("sync invoice from AX");
	}

	@Autowired
	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	@Autowired
	public void setOrderDetailDao(OrderDetailDao orderDetailDao) {
		this.orderDetailDao = orderDetailDao;
	}

	@Autowired
	public void setSoDao(SoDao soDao) {
		this.soDao = soDao;
	}

	@Autowired
	public void setSoDetailDao(SoDetailDao soDetailDao) {
		this.soDetailDao = soDetailDao;
	}

	@Autowired
	public void setTmpSoDao(TmpSoDao tmpSoDao) {
		this.tmpSoDao = tmpSoDao;
	}
}
