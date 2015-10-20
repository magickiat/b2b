package com.starboard.b2b.util;

import java.util.WeakHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.starboard.b2b.common.B2BConstant;
import com.starboard.b2b.service.ConfigService;

@Component
public class ApplicationConfig {

    @Autowired
    private ConfigService configService;

    WeakHashMap<String, Object> cache = new WeakHashMap<>();

    public int getPageSize() {
        Integer size = (Integer) cache.get(B2BConstant.KEY_PAGE_SIZE);
        if (size == null) {
            size = configService.getInt(B2BConstant.KEY_PAGE_SIZE);
            if (size == null || size == 0) {
                size = 20; // default size
            }
        }
        return size;
    }
}
