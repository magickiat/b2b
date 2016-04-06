package com.starboard.b2b.util;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.starboard.b2b.config.RootConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = { RootConfig.class })
public class ApplicationConfigTest {

	@Autowired
	private ApplicationConfig applicationConfig;

	@Test
	public void testGetPageSize() {
		assertEquals(12, applicationConfig.getPageSize());
	}

	@Test
	public void testEnableSendMail() {
		assertFalse(applicationConfig.getEnabledSendMail());
	}

	@Test
	public void testDefultOrderStatusNew() {
		assertEquals("10", applicationConfig.getOrderStatusNew());
	}

	@Test
	public void testDefaultTermId() {
		assertEquals("3070AP", applicationConfig.getNewOrderPaymentTermId());
	}

	@Test
	public void testDefaultProductCurrency(){
		assertEquals("TBA", applicationConfig.getDefaultProductCurrency());
	}
	
	@Test
	public void testDefaultCurrencyForOrder(){
		assertEquals("EUR", applicationConfig.getDefaultCurrencyForOrder());
	}
	
	@Test
	public void testDefaultProductUnit(){
		assertEquals("PCS", applicationConfig.getDefaultProductUnit());
	}
	
	@Test
	public void testDefaultProductBuyerGroup(){
		assertEquals("GROUP1", applicationConfig.getDefaultProductBuyerGroup());
	}
	
	@Test
	public void testEmailSales(){
		assertEquals(1, applicationConfig.getMailApprover().length);
	}
	
	@Test
	public void testDefaultProductLength(){
		assertEquals("Undefined", applicationConfig.getDefaultProductLength());
	}
}
