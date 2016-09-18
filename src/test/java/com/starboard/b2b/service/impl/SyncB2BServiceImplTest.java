package com.starboard.b2b.service.impl;

import com.starboard.b2b.config.ConfigForTest;
import com.starboard.b2b.config.RootConfig;
import com.starboard.b2b.config.ServiceConfig;
import com.starboard.b2b.dao.ContactDao;
import com.starboard.b2b.dao.ProductDao;
import com.starboard.b2b.dao.TmpContactAXDao;
import com.starboard.b2b.dao.TmpProductDao;
import com.starboard.b2b.model.Contact;
import com.starboard.b2b.model.Product;
import com.starboard.b2b.model.TmpContactFromAx;
import com.starboard.b2b.model.TmpProduct;
import com.starboard.b2b.service.SyncB2BService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.util.List;

import javax.transaction.Transactional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = { ConfigForTest.class, ServiceConfig.class, RootConfig.class })
@Transactional
public class SyncB2BServiceImplTest {

	//private static final Logger log = LoggerFactory.getLogger(SyncB2BServiceImplTest.class);

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
	
	private final long custId = 1011L;
	
	@Test
	public void testSyncContactFromAX() {
		// mock data from ax
		TmpContactFromAx tmpCont1 = new TmpContactFromAx();
		tmpCont1.setContactId(1L);
		tmpCont1.setCustId(custId);
		tmpCont1.setNameEn("mark");
		tmpCont1.setAddress("Address for mark");
		tmpContactAXDao.save(tmpCont1);

		syncB2BService.syncContactFromAX();

		List<Contact> cont1 = contactDao.findByCustId(custId);
		assertNotNull(cont1);
		assertEquals(1, cont1.size());
		assertEquals("mark", cont1.get(0).getNameEn());
	}
	
	@Test
	public void testSyncProductFromAX(){
		
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

	}

	@Test
	public void testSyncOrdersFromAX() throws Exception {

	}

	@Test
	public void testSyncOrderDetailFromAX() throws Exception {

	}

	@Test
	public void testSyncOrderAddressFromAX() throws Exception {

	}

	@Test
	public void testSyncSellOrderFromAX() throws Exception {

	}

}
