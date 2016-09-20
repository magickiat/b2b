package com.starboard.b2b.service.impl;

import com.starboard.b2b.config.ConfigForTest;
import com.starboard.b2b.config.RootConfig;
import com.starboard.b2b.config.ServiceConfig;
import com.starboard.b2b.dao.AddrDao;
import com.starboard.b2b.dao.ContactDao;
import com.starboard.b2b.dao.OrderAddressDao;
import com.starboard.b2b.dao.OrderDao;
import com.starboard.b2b.dao.OrderDetailDao;
import com.starboard.b2b.dao.ProductDao;
import com.starboard.b2b.dao.SoDao;
import com.starboard.b2b.dao.TmpAddrAXDao;
import com.starboard.b2b.dao.TmpContactAXDao;
import com.starboard.b2b.dao.TmpOrdAddressAXDao;
import com.starboard.b2b.dao.TmpOrdDetailAXDao;
import com.starboard.b2b.dao.TmpOrdersAXDao;
import com.starboard.b2b.dao.TmpProductDao;
import com.starboard.b2b.dao.TmpSoDao;
import com.starboard.b2b.model.Addr;
import com.starboard.b2b.model.Contact;
import com.starboard.b2b.model.OrdAddress;
import com.starboard.b2b.model.OrdDetail;
import com.starboard.b2b.model.Orders;
import com.starboard.b2b.model.Product;
import com.starboard.b2b.model.TmpAddrFromAx;
import com.starboard.b2b.model.TmpContactFromAx;
import com.starboard.b2b.model.TmpOrdAddressFromAx;
import com.starboard.b2b.model.TmpOrdDetailFromAx;
import com.starboard.b2b.model.TmpOrdersFromAx;
import com.starboard.b2b.model.TmpProduct;
import com.starboard.b2b.model.TmpSo;
import com.starboard.b2b.model.sync.So;
import com.starboard.b2b.service.SyncB2BService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.math.BigDecimal;
import java.util.List;

import javax.transaction.Transactional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = { ConfigForTest.class, ServiceConfig.class, RootConfig.class })
@Transactional
public class SyncB2BServiceImplTest {

	private static final Logger log = LoggerFactory.getLogger(SyncB2BServiceImplTest.class);
	private static final String ORD_CODE_1 = "code1";
	private static final String ORD_CODE_2 = "code2";
	private static final String ORD_CODE_3 = "code3";
	private static final long ORDER_ID_1 = 11L;
	private static final long ORDER_ID_2 = 12L;
	private static final long ORDER_ID_3 = 13L;

	@Autowired
	private SyncB2BService syncB2BService;

	@Autowired
	private ContactDao contactDao;

	@Autowired
	private TmpContactAXDao tmpContactAXDao;

	@Autowired
	private TmpProductDao tmpProductDao;

	@Autowired
	private ProductDao productDao;

	@Autowired
	private TmpAddrAXDao tmpAddrAXDao;

	@Autowired
	private AddrDao addrDao;

	@Autowired
	private TmpOrdersAXDao tmpOrdersAXDao;

	@Autowired
	private OrderDao orderDao;

	@Autowired
	private TmpOrdDetailAXDao tmpOrdDetailAXDao;

	@Autowired
	private OrderDetailDao orderDetailDao;

	@Autowired
	private TmpOrdAddressAXDao tmpOrdAddressAXDao;

	@Autowired
	private OrderAddressDao orderAddressDao;

	@Autowired
	private TmpSoDao tmpSoDao;

	@Autowired
	private SoDao soDao;

	private final long custId = 1011L;
	private final long custId2 = 1012L;
	private final long custId3 = 1013L;
	private final long custId4 = 1014L;

	@Test
	public void testSyncContactFromAX() {
		// mock data from ax
		TmpContactFromAx tmpCont1 = new TmpContactFromAx();
		tmpCont1.setContactId(1L);
		tmpCont1.setCustId(custId);
		tmpCont1.setNameEn("mark");
		tmpCont1.setAddress("Address for mark");
		tmpContactAXDao.save(tmpCont1);

		// mock data from ax
		TmpContactFromAx tmpCont2 = new TmpContactFromAx();
		tmpCont2.setContactId(2L);
		tmpCont2.setCustId(custId);
		tmpCont2.setNameEn("mark xxxxx");
		tmpCont2.setAddress("Address for mark xxxxx");
		tmpContactAXDao.save(tmpCont2);

		syncB2BService.syncContactFromAX();

		List<Contact> cont1 = contactDao.findByCustId(custId);
		assertNotNull(cont1);
		assertEquals(2, cont1.size());
		assertEquals("mark", cont1.get(0).getNameEn());
	}

	@Test
	public void testSyncProductFromAX() {

		// mock exist product
		Product p1 = new Product();
		p1.setProductId(1L);
		p1.setProductCode("P001");
		p1.setProductNameEn("XXX");
		productDao.save(p1);

		// mock data from ax
		TmpProduct tmpProduct = new TmpProduct();
		tmpProduct.setProductId(1L);
		tmpProduct.setProductCode("P001");
		tmpProduct.setProductNameEn("Product 1");
		tmpProductDao.save(tmpProduct);

		TmpProduct tmpProduct2 = new TmpProduct();
		tmpProduct2.setProductId(2L);
		tmpProduct2.setProductCode("P002");
		tmpProduct2.setProductNameEn("Product 2");
		tmpProductDao.save(tmpProduct2);

		syncB2BService.syncProductFromAX();

		List<Product> list = productDao.list();
		assertNotNull(list);
		assertEquals(2, list.size());

		Product product = productDao.findByProductCode("P001");
		assertNotNull(product);
		assertEquals("Product 1", product.getProductNameEn());

		Product product2 = productDao.findByProductCode("P002");
		assertNotNull(product2);
		assertEquals("Product 2", product2.getProductNameEn());

	}

	@Test
	public void testSyncAddressFromAX() throws Exception {
		// Mock data
		Addr addr1 = new Addr();
		addr1.setAddrId(101L);
		addr1.setAddress("Address 1 Cust 1");
		addr1.setProvince(1L);
		addr1.setPostCode("P1");
		addr1.setCustId(custId);
		addrDao.save(addr1);

		Addr addr2 = new Addr();
		addr2.setAddrId(102L);
		addr2.setAddress("Address 2 Cust 1");
		addr2.setProvince(2L);
		addr2.setPostCode("P2");
		addr2.setCustId(custId);
		addrDao.save(addr2);

		Addr addr3 = new Addr();
		addr3.setAddrId(103L);
		addr3.setAddress("Address 1 Cust 2");
		addr3.setProvince(3L);
		addr3.setPostCode("P3");
		addr3.setCustId(custId2);
		addrDao.save(addr3);

		TmpAddrFromAx addr1Ax = new TmpAddrFromAx();
		addr1Ax.setAddrId(104L);
		addr1Ax.setAddress("Address Cust 1 AX");
		addr1Ax.setProvince(ORDER_ID_1);
		addr1Ax.setPostCode("P1AX");
		addr1Ax.setCustId(custId);
		tmpAddrAXDao.save(addr1Ax);

		TmpAddrFromAx addr3Ax = new TmpAddrFromAx();
        addr3Ax.setAddrId(106L);
        addr3Ax.setAddress("Address Cust 4 AX");
        addr3Ax.setProvince(ORDER_ID_1);
        addr3Ax.setPostCode("P4AX");
        addr3Ax.setCustId(custId);
		tmpAddrAXDao.save(addr3Ax);

		TmpAddrFromAx addr2Ax = new TmpAddrFromAx();
		addr2Ax.setAddrId(105L);
		addr2Ax.setAddress("Address Cust 3 AX");
		addr2Ax.setProvince(ORDER_ID_2);
		addr2Ax.setPostCode("P3AX");
		addr2Ax.setCustId(custId3);
		tmpAddrAXDao.save(addr2Ax);

		// Sync it
		syncB2BService.syncAddressFromAX();

		// Assert
		final List<Addr> addrCust1 = addrDao.findByCustId(custId);
		assertNotNull(addrCust1);
		assertEquals(2, addrCust1.size());
		assertEquals(104L, addrCust1.get(0).getAddrId());
		assertEquals("Address Cust 1 AX", addrCust1.get(0).getAddress());

		final List<Addr> addrCust2 = addrDao.findByCustId(custId2);
		assertNotNull(addrCust2);
		assertEquals(3, addrCust2.size());
		assertEquals(103L, addrCust2.get(0).getAddrId());
		assertEquals("Address 1 Cust 2", addrCust2.get(0).getAddress());

		final List<Addr> addrCust3 = addrDao.findByCustId(custId3);
		assertNotNull(addrCust3);
		assertEquals(1, addrCust3.size());
		assertEquals(105L, addrCust3.get(0).getAddrId());
		assertEquals("Address Cust 3 AX", addrCust3.get(0).getAddress());
	}

	@Test
	public void testSyncOrdersFromAX() throws Exception {
		// Mock data
		Orders orders1 = new Orders();
		orders1.setCustId(custId);
		orders1.setOrderCode(ORD_CODE_1);
		orderDao.save(orders1);

		Orders orders2 = new Orders();
		orders2.setCustId(custId2);
		orders2.setOrderCode(ORD_CODE_2);
		orderDao.save(orders2);

		TmpOrdersFromAx orders1Ax = new TmpOrdersFromAx();
		orders1Ax.setOrderId(ORDER_ID_1);
		orders1Ax.setCustId(custId3);
		orders1Ax.setOrderCode(ORD_CODE_1);
		tmpOrdersAXDao.save(orders1Ax);

		TmpOrdersFromAx orders2Ax = new TmpOrdersFromAx();
		orders2Ax.setOrderId(ORDER_ID_2);
		orders2Ax.setCustId(custId4);
		orders2Ax.setOrderCode(ORD_CODE_3);
		tmpOrdersAXDao.save(orders2Ax);

		// Sync it
		syncB2BService.syncOrdersFromAX();

		// Assert
		final Orders ordersCode1 = orderDao.findByOrderCode(ORD_CODE_1);
		assertEquals(custId3, ordersCode1.getCustId().longValue());

		final Orders ordersCode2 = orderDao.findByOrderCode(ORD_CODE_2);
		assertEquals(custId2, ordersCode2.getCustId().longValue());

		final Orders ordersCode3 = orderDao.findByOrderCode(ORD_CODE_3);
		assertEquals(custId4, ordersCode3.getCustId().longValue());
	}

	@Test
	public void testSyncOrderDetailFromAX() throws Exception {
		// Mock data
		Orders orders1 = new Orders();
		orders1.setOrderId(ORDER_ID_1);
		orders1.setCustId(custId);
		orders1.setOrderCode(ORD_CODE_1);
		orderDao.save(orders1);

		Orders orders2 = new Orders();
		orders2.setOrderId(ORDER_ID_2);
		orders2.setCustId(custId2);
		orders2.setOrderCode(ORD_CODE_2);
		orderDao.save(orders2);

		OrdDetail ordDetail1 = new OrdDetail();
		ordDetail1.setOrderId(orders1.getOrderId());
		ordDetail1.setPrice(BigDecimal.TEN);
		orderDetailDao.save(ordDetail1);

		OrdDetail ordDetail2 = new OrdDetail();
		ordDetail2.setOrderId(orders1.getOrderId());
		ordDetail2.setPrice(BigDecimal.ONE);
		orderDetailDao.save(ordDetail2);

		OrdDetail ordDetail3 = new OrdDetail();
		ordDetail3.setOrderId(orders2.getOrderId());
		ordDetail3.setPrice(BigDecimal.ZERO);
		orderDetailDao.save(ordDetail3);

		TmpOrdDetailFromAx ordDetailFromAx = new TmpOrdDetailFromAx();
		ordDetailFromAx.setOrderId(orders1.getOrderId());
		ordDetailFromAx.setOrderCode(orders1.getOrderCode());
		ordDetailFromAx.setPrice(BigDecimal.valueOf(100));
		tmpOrdDetailAXDao.save(ordDetailFromAx);

		// Sync it
		syncB2BService.syncOrderDetailFromAX();

		// Assert
		final List<OrdDetail> detailOrder1 = orderDetailDao.findByOrderId(orders1.getOrderId());
		assertNotNull(detailOrder1);
		assertEquals(1, detailOrder1.size());
		assertEquals(BigDecimal.valueOf(100), detailOrder1.get(0).getPrice());

		final List<OrdDetail> detailOrder2 = orderDetailDao.findByOrderId(orders2.getOrderId());
		assertNotNull(detailOrder2);
		assertEquals(1, detailOrder2.size());
		assertEquals(BigDecimal.ZERO, detailOrder2.get(0).getPrice());
	}

	@Test
	public void testSyncOrderAddressFromAX() throws Exception {
		// Mock data
		// Mock data
		Orders orders1 = new Orders();
		orders1.setOrderId(ORDER_ID_1);
		orders1.setCustId(custId);
		orders1.setOrderCode(ORD_CODE_1);
		orderDao.save(orders1);

		Orders orders2 = new Orders();
		orders2.setOrderId(ORDER_ID_2);
		orders2.setCustId(custId2);
		orders2.setOrderCode(ORD_CODE_2);
		orderDao.save(orders2);

		OrdAddress ordAddress1 = new OrdAddress();
		ordAddress1.setOrderId(orders1.getOrderId());
		ordAddress1.setOrderAddr("Order 1 Address 1");
		orderAddressDao.save(ordAddress1);

		OrdAddress ordAddress2 = new OrdAddress();
		ordAddress2.setOrderId(orders1.getOrderId());
		ordAddress2.setOrderAddr("Order 1 Address 2");
		orderAddressDao.save(ordAddress2);

		OrdAddress ordAddress3 = new OrdAddress();
		ordAddress3.setOrderId(orders2.getOrderId());
		ordAddress3.setOrderAddr("Order 2 Address 1");
		orderAddressDao.save(ordAddress3);

		TmpOrdAddressFromAx ordAddressFromAx = new TmpOrdAddressFromAx();
		ordAddressFromAx.setOrderAddressId(1L);
		ordAddressFromAx.setOrderId(orders1.getOrderId());
		ordAddressFromAx.setOrderCode(orders1.getOrderCode());
		ordAddressFromAx.setOrderAddr("Order 1 Address AX");
		tmpOrdAddressAXDao.save(ordAddressFromAx);

		TmpOrdAddressFromAx ordAddressFromAx2 = new TmpOrdAddressFromAx();
		ordAddressFromAx2.setOrderAddressId(2L);
		ordAddressFromAx2.setOrderId(orders1.getOrderId());
		ordAddressFromAx2.setOrderCode(orders1.getOrderCode());
		ordAddressFromAx2.setOrderAddr("Order 1 Address 2 AX");
		tmpOrdAddressAXDao.save(ordAddressFromAx2);

		// Sync it
		syncB2BService.syncOrderAddressFromAX();

		// Assert
		final List<OrdAddress> addressOrder1 = orderAddressDao.findByOrderId(orders1.getOrderId());
		assertNotNull(addressOrder1);
		assertEquals(2, addressOrder1.size());
		assertEquals("Order 1 Address AX", addressOrder1.get(0).getOrderAddr());

		final List<OrdAddress> addressOrder2 = orderAddressDao.findByOrderId(orders2.getOrderId());
		assertNotNull(addressOrder2);
		assertEquals(1, addressOrder2.size());
		assertEquals("Order 2 Address 1", addressOrder2.get(0).getOrderAddr());
	}

	@Test
	public void testSyncSellOrderFromAX() throws Exception {
		// Mock data
		So so1 = new So();
		so1.setSoNo("SoNo1");
		so1.setOrderId(ORDER_ID_1);
		so1.setUserCreate("admin");
		soDao.save(so1);

		So so2 = new So();
		so2.setSoNo("SoNo2");
		so2.setOrderId(ORDER_ID_2);
		so2.setUserCreate("admin");
		soDao.save(so2);

		TmpSo tmpSo1 = new TmpSo();
		tmpSo1.setSoNo("SoNo1");
		tmpSo1.setOrderId(ORDER_ID_2);
		tmpSo1.setUserCreate("admin");
		tmpSoDao.save(tmpSo1);

		TmpSo tmpSo2 = new TmpSo();
		tmpSo2.setSoNo("SoNo3");
		tmpSo2.setOrderId(ORDER_ID_3);
		tmpSo2.setUserCreate("admin");
		tmpSoDao.save(tmpSo2);

		// Sync it
		syncB2BService.syncSellOrderFromAX();

		// Assert
		final So soNo1 = soDao.findBySoNo("SoNo1");
		assertEquals(ORDER_ID_2, soNo1.getOrderId());

		final So soNo2 = soDao.findBySoNo("SoNo2");
		assertEquals(ORDER_ID_2, soNo2.getOrderId());

		final So soNo3 = soDao.findBySoNo("SoNo3");
		assertEquals(ORDER_ID_3, soNo3.getOrderId());
	}

}
