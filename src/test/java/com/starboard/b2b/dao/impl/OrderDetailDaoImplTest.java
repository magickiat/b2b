package com.starboard.b2b.dao.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.starboard.b2b.config.ConfigForTest;
import com.starboard.b2b.config.RootConfig;
import com.starboard.b2b.config.ServiceConfig;
import com.starboard.b2b.dao.OrderDao;
import com.starboard.b2b.dao.OrderDetailDao;
import com.starboard.b2b.dao.SoDao;
import com.starboard.b2b.dao.SoDetailDao;
import com.starboard.b2b.model.OrdDetail;
import com.starboard.b2b.model.Orders;
import com.starboard.b2b.model.sync.So;
import com.starboard.b2b.model.sync.SoDetail;
import com.starboard.b2b.service.OrderService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = { ConfigForTest.class, ServiceConfig.class, RootConfig.class })
@Transactional
public class OrderDetailDaoImplTest {
	private static final Logger log = LoggerFactory.getLogger(OrderDetailDaoImplTest.class);
	
	//
	// @Autowired
	// private RoSyncService roSyncService;

	@Autowired
	private OrderService orderService;

	@Autowired
	private OrderDetailDao orderDetailDao;

	@Autowired
	private OrderDao orderDao;

	@Autowired
	private SoDetailDao soDetailDao;

	@Autowired
	private SoDao soDao;

	@Test
	public void testDeleteBySoNo() {

		// Create order
		Orders order = new Orders();
		order.setOrderCode(orderService.generateOrderCode());
		orderDao.save(order);

		// Create order detail
		OrdDetail detail1 = new OrdDetail();
		detail1.setOrderId(order.getOrderId());

		OrdDetail detail2 = new OrdDetail();
		detail2.setOrderId(order.getOrderId());

		orderDetailDao.save(detail1);
		orderDetailDao.save(detail2);

		String soNo = "SO-001";
		int deleteBySoNo = orderDetailDao.deleteBySoNo(soNo);
		assertEquals(0, deleteBySoNo);

		// mockup SO has sync
		So so = new So();
		so.setSoId(1);
		so.setOrderId(order.getOrderId());
		so.setSoNo(soNo);
		soDao.save(so);

		SoDetail soDetail1 = new SoDetail();
		soDetail1.setSoProductId(detail1.getOrderDetailId());
		soDetail1.setSoId(so.getSoId());
		soDetail1.setOrderProductId(detail1.getOrderDetailId());
		soDetailDao.save(soDetail1);

		List<OrdDetail> details = orderDetailDao.findByOrderId(order.getOrderId());
		assertNotNull(details);
		assertEquals(2, details.size());

		deleteBySoNo = orderDetailDao.deleteBySoNo(soNo);
		assertEquals(1, deleteBySoNo);

		details = orderDetailDao.findByOrderId(order.getOrderId());
		assertEquals(1, details.size());
	}

	@Test
	public void testDeleteWithoutSoNo() {
		// Create order
		Orders order = new Orders();
		order.setOrderCode(orderService.generateOrderCode());
		orderDao.save(order);

		// Create order detail
		OrdDetail detail1 = new OrdDetail();
		detail1.setOrderId(order.getOrderId());

		OrdDetail detail2 = new OrdDetail();
		detail2.setOrderId(order.getOrderId());

		orderDetailDao.save(detail1);
		orderDetailDao.save(detail2);
		
		log.info("detail1 = " + detail1.getOrderDetailId());
		log.info("detail2 = " + detail2.getOrderDetailId());

		// mockup SO has sync
		So so = new So();
		so.setSoId(1);
		so.setOrderId(order.getOrderId());
		so.setSoNo("S001");
		soDao.save(so);
		

		SoDetail soDetail1 = new SoDetail();
		soDetail1.setSoId(so.getSoId());
		soDetail1.setOrderProductId(detail1.getOrderDetailId());
		soDetailDao.save(soDetail1);
		
		log.info("soDetail1 = " + soDetail1.getSoProductId());
		
		int deleteWithoutSoNo = orderDetailDao.deleteWithoutSoNo(order.getOrderId());
		assertEquals(1, deleteWithoutSoNo);
	}
}
