package com.starboard.b2b.service;

import java.util.List;
import java.util.Set;

import com.starboard.b2b.common.Page;
import com.starboard.b2b.model.Brand;
import com.starboard.b2b.model.Customer;
import com.starboard.b2b.web.form.brand.BrandForm;
import com.starboard.b2b.web.form.customer.CustomerForm;

public interface CustomerService {
	Customer findById(int id);

	Customer findByName(String name) throws Exception;

	List<Customer> list() throws Exception;

	List<Customer> list(Page page) throws Exception;

	void add(CustomerForm customer) throws Exception;

	void update(CustomerForm customer) throws Exception;

	void addBrand(BrandForm brand) throws Exception;

	Set<Brand> getSelectedBrand(Integer custId) throws Exception;

	List<Integer> getSelectedBrandId(Integer custId) throws Exception;
}
