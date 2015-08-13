package com.starboard.b2b.web.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import com.starboard.b2b.service.ConfigService;

public class InitOnStartupListener implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private ConfigService configService;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		configService.reloadConfig();
	}

}
