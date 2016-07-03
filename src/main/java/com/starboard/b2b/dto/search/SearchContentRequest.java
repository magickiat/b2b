package com.starboard.b2b.dto.search;

import org.apache.commons.lang.builder.ToStringBuilder;

public class SearchContentRequest extends SearchRequest {

	public SearchContentRequest(Integer page, int size) {
		super(page, size);
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
