package com.starboard.b2b.service.impl;

import static org.junit.Assert.*;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.starboard.b2b.common.B2BConstant;
import com.starboard.b2b.common.SyncConstant;
import com.starboard.b2b.config.ConfigForTest;
import com.starboard.b2b.config.RootConfig;
import com.starboard.b2b.config.ServiceConfig;
import com.starboard.b2b.dao.OrderDao;
import com.starboard.b2b.dao.OrderDetailDao;
import com.starboard.b2b.dao.ProductDao;
import com.starboard.b2b.dao.SoDao;
import com.starboard.b2b.dao.SoDetailDao;
import com.starboard.b2b.dao.TmpSoDao;
import com.starboard.b2b.model.OrdDetail;
import com.starboard.b2b.model.Orders;
import com.starboard.b2b.model.Product;
import com.starboard.b2b.model.sync.So;
import com.starboard.b2b.model.sync.SoDetail;
import com.starboard.b2b.model.sync.TmpSo;
import com.starboard.b2b.service.OrderService;
import com.starboard.b2b.service.SyncB2BService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = { ConfigForTest.class, ServiceConfig.class, RootConfig.class })
@Transactional
public class SyncB2BServiceImplTest {

//	private static final Logger log = LoggerFactory.getLogger(SyncB2BServiceImplTest.class);

	@Autowired
	private SyncB2BService syncB2BService;

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

	@Autowired
	private TmpSoDao tmpSoDao;

	@Autowired
	private ProductDao productDao;

	private String SO_NO = "SO-001";

	@Before
	public void init() {
		Product p1 = new Product();
		p1.setProductCode("P001");

		Product p2 = new Product();
		p2.setProductCode("P002");

		productDao.save(p1);
		productDao.save(p2);

		// Create order
		Orders order = new Orders();
		order.setOrderCode(orderService.generateOrderCode());
		orderDao.save(order);

		// Create order detail
		OrdDetail detail1 = new OrdDetail();
		detail1.setOrderId(order.getOrderId());
		detail1.setProductId(p1.getProductId());

		OrdDetail detail2 = new OrdDetail();
		detail2.setOrderId(order.getOrderId());
		detail2.setProductId(p2.getProductId());

		orderDetailDao.save(detail1);
		orderDetailDao.save(detail2);

		TmpSo so1 = new TmpSo();
		so1.setDtsSystem(B2BConstant.AX_SYSTEM_NAME);
		so1.setImportStatus(Long.valueOf(SyncConstant.WAIT_FOR_SYNC));
		so1.setRoCode(order.getOrderCode());
		so1.setSoNo(SO_NO);
		so1.setItemCode(p1.getProductCode());
		tmpSoDao.save(so1);
	}

	@Test
	public void testSyncSellOrderFromAX() {

		syncB2BService.syncSellOrderFromAX();

		So so = soDao.findBySoNo(SO_NO);
		assertNotNull(so);
		List<SoDetail> soDetails = soDetailDao.findBySoId(so.getSoId());
		assertNotNull(soDetails);
		assertEquals(1, soDetails.size());
//		List<OrdDetail> orderDetails = orderDetailDao.findByOrderId(so.getOrderId());
//		assertNull(orderDetails);

	}

	// @Test
	// public void testSyncInvoiceFromAX() {
	// fail("Not yet implemented");
	// }

}
