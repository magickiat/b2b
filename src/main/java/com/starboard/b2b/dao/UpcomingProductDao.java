package com.starboard.b2b.dao;

import java.util.List;

public interface UpcomingProductDao {
	List<String> find(int offset, int size);
}
