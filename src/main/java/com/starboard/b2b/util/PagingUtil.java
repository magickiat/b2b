package com.starboard.b2b.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.starboard.b2b.common.B2BConstant;
import com.starboard.b2b.common.Pagination;
import com.starboard.b2b.service.ConfigService;

@Component
public class PagingUtil {

	@Autowired
	private ConfigService configService;

	public Pagination getDefault() {
		Integer size = configService.getInt(B2BConstant.KEY_PAGE_SIZE);
		if (size == null || size.intValue() <= 0) {
			size = 25;
		}
		return new Pagination(0, size, 0);
	}
}
