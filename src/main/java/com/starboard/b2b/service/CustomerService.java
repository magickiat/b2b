package com.starboard.b2b.service;

import java.util.List;
import java.util.Set;

import com.starboard.b2b.common.Page;
import com.starboard.b2b.dto.BrandDTO;
import com.starboard.b2b.dto.CustomerDTO;
import com.starboard.b2b.web.form.brand.BrandForm;
import com.starboard.b2b.web.form.customer.CustomerForm;

public interface CustomerService {
	CustomerDTO findById(int id);

	CustomerDTO findByName(String name) throws Exception;

	List<CustomerDTO> list() throws Exception;

	List<CustomerDTO> list(Page page) throws Exception;

	void add(CustomerForm customer) throws Exception;

	void update(CustomerForm customer) throws Exception;

	void addBrand(BrandForm brand) throws Exception;

	Set<BrandDTO> getSelectedBrand(Integer custId) throws Exception;

	List<Integer> getSelectedBrandId(Integer custId) throws Exception;
}
