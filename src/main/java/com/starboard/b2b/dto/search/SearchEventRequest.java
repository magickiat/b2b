package com.starboard.b2b.dto.search;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * Created by User: Thanakit Jumparuang (jthanakit.dev@gmail.com) Date: 1/22/2016 14:02
 */
public class SearchEventRequest extends SearchRequest {
    public SearchEventRequest(Integer page, int size) {
        super(page, size);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
