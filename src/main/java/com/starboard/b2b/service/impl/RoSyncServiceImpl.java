package com.starboard.b2b.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.starboard.b2b.dao.OrderAddressDao;
import com.starboard.b2b.dao.OrderDao;
import com.starboard.b2b.dao.OrderDetailDao;
import com.starboard.b2b.dao.TmpOrdDetailDao;
import com.starboard.b2b.dao.TmpOrderAddressDao;
import com.starboard.b2b.dao.TmpOrdersDao;
import com.starboard.b2b.model.OrdAddress;
import com.starboard.b2b.model.OrdDetail;
import com.starboard.b2b.model.Orders;
import com.starboard.b2b.model.TmpOrdAddress;
import com.starboard.b2b.model.TmpOrdDetail;
import com.starboard.b2b.model.TmpOrders;
import com.starboard.b2b.service.RoSyncService;

@Service("roSyncService")
public class RoSyncServiceImpl implements RoSyncService {
	
	private static final Logger log = LoggerFactory.getLogger(RoSyncServiceImpl.class);

	@Autowired
	private OrderDao orderDao;

	@Autowired
	private OrderDetailDao orderDetailDao;

	@Autowired
	private OrderAddressDao orderAddressDao;

	@Autowired
	private TmpOrdersDao tmpOrdersDao;

	@Autowired
	private TmpOrdDetailDao tmpOrdDetailDao;

	@Autowired
	private TmpOrderAddressDao tmpOrderAddressDao;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void syncProduct() {
		throw new UnsupportedOperationException("Not implement yet");
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void syncRoFromB2BtoAX(long orderId) throws Exception {
		Orders ord = orderDao.findById(orderId);
		if (ord != null) {

			List<TmpOrders> existTmpOrders = tmpOrdersDao.findByOrderCode(ord.getOrderCode());

			if (existTmpOrders != null && !existTmpOrders.isEmpty() ) {
				log.info("Clear old data with order code: " + ord.getOrderCode());
				for (TmpOrders tmpOrders : existTmpOrders) {
					tmpOrdDetailDao.deleteByOrderId(tmpOrders.getOrderId());
					tmpOrderAddressDao.deleteByOrderId(tmpOrders.getOrderId());
				}
				
				tmpOrdersDao.delete(existTmpOrders);
				
				
			}
			
			// ----- save tmp_orders -----
			TmpOrders tmpOrders = new TmpOrders();
			BeanUtils.copyProperties(ord, tmpOrders);
			tmpOrdersDao.save(tmpOrders);

			// ----- save tmp_ord_details -----
			List<OrdDetail> list = orderDetailDao.findByOrderId(orderId);
			if (list != null && !list.isEmpty()) {
				for (OrdDetail ordDetail : list) {
					TmpOrdDetail tmp = new TmpOrdDetail();
					BeanUtils.copyProperties(ordDetail, tmp);
					tmpOrdDetailDao.save(tmp);
				}
			}

			// ----- save tmp_order_address -----
			List<OrdAddress> addressList = orderAddressDao.findByOrderId(orderId);
			if (addressList != null) {
				for (OrdAddress ordAddress : addressList) {
					TmpOrdAddress addr = new TmpOrdAddress();
					BeanUtils.copyProperties(ordAddress, addr);
					tmpOrderAddressDao.save(addr);
				}
			} else {
				throw new Exception("Not found any Order Address");
			}
		}
	}

}
