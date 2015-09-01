package com.starboard.b2b.service;

import java.util.List;

import com.starboard.b2b.common.Page;
import com.starboard.b2b.model.Customer;
import com.starboard.b2b.web.form.customer.CustomerForm;

public interface CustomerService {
	Customer findById(int id);

	Customer findByName(String name);

	List<Customer> list();
	
	List<Customer> list(Page page);
	
	void add(CustomerForm customer);
}
