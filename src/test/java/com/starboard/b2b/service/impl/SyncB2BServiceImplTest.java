package com.starboard.b2b.service.impl;

import static org.junit.Assert.*;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.starboard.b2b.config.ConfigForTest;
import com.starboard.b2b.config.RootConfig;
import com.starboard.b2b.config.ServiceConfig;
import com.starboard.b2b.service.SyncB2BService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = { ConfigForTest.class, ServiceConfig.class, RootConfig.class })
@Transactional
public class SyncB2BServiceImplTest {

	@Autowired
	private SyncB2BService syncB2BService;
	
	@Test
	public void testSyncSellOrderFromAX() {
		assertNotNull(syncB2BService);
	}

//	@Test
//	public void testSyncInvoiceFromAX() {
//		fail("Not yet implemented");
//	}

}
