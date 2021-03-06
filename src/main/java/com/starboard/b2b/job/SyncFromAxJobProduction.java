package com.starboard.b2b.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.starboard.b2b.service.SyncB2BService;

@Component("syncFromAx")
@Profile("prd")
public class SyncFromAxJobProduction {

	private static final Logger log = LoggerFactory.getLogger(SyncFromAxJobProduction.class);

	private SyncB2BService syncB2BService;

	@Scheduled(cron = "0 0 0/6 * * ?")
	public void doIt() throws Exception {
		log.info("Start sync data from AX...");
		syncB2BService.syncAllFromAX();
		log.info("Finished sync data from AX...");
	}

	@Autowired
	public void setSyncB2BService(SyncB2BService syncB2BService) {
		this.syncB2BService = syncB2BService;
	}
}
