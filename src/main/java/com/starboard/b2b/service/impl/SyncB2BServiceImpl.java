package com.starboard.b2b.service.impl;

import com.starboard.b2b.dao.OrderDao;
import com.starboard.b2b.dao.OrderDetailDao;
import com.starboard.b2b.dao.ProductDao;
import com.starboard.b2b.dao.SoDao;
import com.starboard.b2b.dao.SoDetailDao;
import com.starboard.b2b.dao.TmpSoDao;
import com.starboard.b2b.dao.TmpSoDetailDao;
import com.starboard.b2b.service.SyncB2BService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("syncB2BService")
public class SyncB2BServiceImpl implements SyncB2BService {

	private static final Logger log = LoggerFactory.getLogger(SyncB2BServiceImpl.class);

	private OrderDao orderDao;
	private OrderDetailDao orderDetailDao;
	private SoDao soDao;
	private SoDetailDao soDetailDao;
	private TmpSoDao tmpSoDao;
    private TmpSoDetailDao tmpSoDetailDao;
	private ProductDao productDao;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void syncContactFromAX() {
        log.info("Sync Contact from AX");
        //Step 1: Get data from AX
        //Step 2: Insert / Update into sync table
        //Step 3: Remove table from AX
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void syncAddressFromAX() {
        log.info("Sync Adddress from AX");
        //Step 1: Get data from AX
        //Step 2: Insert / Update into sync table
        //Step 3: Remove table from AX
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void syncProductFromAX() {
        log.info("Sync Product from AX");
        //Step 1: Get data from AX
        //Step 2: Insert / Update into sync table
        //Step 3: Remove table from AX
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void syncOrderFromAX() {
        log.info("Sync Order from AX");
        //Step 1: Get data from AX
        //Step 2: Insert / Update into sync table
        //Step 3: Remove table from AX
	}

	//for Address

	//for Product

	//for Order

	//for Order Detail

	//for Order Address

	//for Sale Order

	//for Sale Order Detail

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void syncSellOrderFromAX() {
		log.info("Sync sell order from AX");
		//Step 1: Get data from AX
		//Step 2: Insert / Update into sync table
		//Step 3: Remove table from AX
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

	@Autowired
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
}
