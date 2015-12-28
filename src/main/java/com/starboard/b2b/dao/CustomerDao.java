package com.starboard.b2b.dao;

import java.util.List;

import com.starboard.b2b.common.Pagination;
import com.starboard.b2b.model.Cust;

public interface CustomerDao extends BaseDao {
	Cust findById(Long id);

	Cust findByName(String name);

	List<Cust> list();

	List<Cust> list(Pagination page);

	void add(Cust customer);

	void update(Cust customer);

}
