package com.starboard.b2b.service.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;

import com.starboard.b2b.config.WebConfig;
import com.starboard.b2b.dto.PaymentMethodDTO;
import com.starboard.b2b.dto.ShippingTypeDTO;
import com.starboard.b2b.service.OrderService;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = WebConfig.class, loader = AnnotationConfigWebContextLoader.class)
public class OrderServiceImplTest {

	private static final Logger log = LoggerFactory.getLogger(OrderServiceImplTest.class);
	
	@Autowired
	private OrderService orderService;
	
	@Test
	public void testListPaymentMethod() {
		List<PaymentMethodDTO> paymentMethod = orderService.findAllPaymentMethod();
		assertNotNull(paymentMethod);
		log.info("Payment method: " + paymentMethod);
	}
	
	@Test
	public void testListShippingType() {
		List<ShippingTypeDTO> type = orderService.findAllShippingType();
		assertNotNull(type);
		log.info("Shipping type: " + type);
	}

	@Test
	public void testGenOrderRunningNo(){
		long oldId = orderService.getNextRunningNo(2015);
		long newId = orderService.getNextRunningNo(2015);
		log.info("oldId = "+oldId);
		log.info("newId = "+newId);
		assertTrue((newId - oldId) == 1);
	}
}
