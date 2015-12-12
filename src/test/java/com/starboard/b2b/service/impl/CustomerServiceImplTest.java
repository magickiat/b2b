package com.starboard.b2b.service.impl;

import com.starboard.b2b.common.AddressConstant;
import com.starboard.b2b.config.WebConfig;
import com.starboard.b2b.dao.CustDao;
import com.starboard.b2b.dto.AddressDTO;
import com.starboard.b2b.model.Cust;
import com.starboard.b2b.service.CustomerService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = WebConfig.class, loader = AnnotationConfigWebContextLoader.class)
public class CustomerServiceImplTest {
	
	private static final Logger log = LoggerFactory.getLogger(CustomerServiceImplTest.class);
	

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private CustDao custDao;

	@Test
	@Transactional
	public void testFindAddress() {
		Cust customer = custDao.findById(new Long(1001));
		assertNotNull(customer);
		
		List<AddressDTO> addressess = customerService.findAddress(customer.getCustId(), AddressConstant.ORDER_DISPATCH_TO);
		assertNotNull(addressess);
		assertFalse(addressess.isEmpty());
		assertEquals(2, addressess.size());
		for (AddressDTO addressDTO : addressess) {
			log.info("Address = " + addressDTO.toString());
		}
	}

}
