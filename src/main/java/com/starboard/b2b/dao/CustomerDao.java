package com.starboard.b2b.dao;

import java.util.List;

import com.starboard.b2b.common.Page;
import com.starboard.b2b.model.Customer;

public interface CustomerDao {
	Customer findById(int id);

	Customer findByName(String name);

	List<Customer> list();
	
	List<Customer> list(Page page);
	
	void add(Customer customer);
	
	void update(Customer customer);

}
