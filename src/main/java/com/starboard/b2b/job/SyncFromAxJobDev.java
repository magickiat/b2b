package com.starboard.b2b.job;

import com.starboard.b2b.service.SyncB2BService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component("syncFromAx")
@Profile("dev")
public class SyncFromAxJobDev {

	private static final Logger log = LoggerFactory.getLogger(SyncFromAxJobDev.class);

	@Autowired
	private SyncB2BService syncB2BService;

	@Scheduled(cron = "0 0/5 * * * ?")
	public void doIt() throws Exception {
		log.info("Start sync data from AX...");
		syncB2BService.syncAllFromAX();
	}

}
