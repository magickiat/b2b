package com.starboard.b2b.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Profile("dev")
public class SyncFromAxJobDev {

	private static final Logger log = LoggerFactory.getLogger(SyncFromAxJobDev.class);

	@Scheduled(cron = "0/5 * * * * ?")
	public void doIt() {
		log.info("Hello world");
	}
}
