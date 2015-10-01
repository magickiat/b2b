package com.starboard.b2b.dao;

import java.util.List;

import com.starboard.b2b.common.Pagination;
import com.starboard.b2b.model.Customer;

public interface CustomerDao extends BaseDao {
	Customer findById(Long id);

	Customer findByName(String name);

	List<Customer> list();

	List<Customer> list(Pagination page);

	void add(Customer customer);

	void update(Customer customer);

}
