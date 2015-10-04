package com.starboard.b2b.service;

import java.util.List;
import java.util.Set;

import com.starboard.b2b.common.Page;
import com.starboard.b2b.common.Pagination;
import com.starboard.b2b.dto.BrandDTO;
import com.starboard.b2b.dto.CustDTO;
import com.starboard.b2b.dto.CustomerDTO;
import com.starboard.b2b.web.form.brand.BrandForm;
import com.starboard.b2b.web.form.customer.CreateCustomerForm;
import com.starboard.b2b.web.form.customer.CustomerForm;

public interface CustomerService {
	CustomerDTO findById(Long id);

	CustomerDTO findByName(String name) throws Exception;

	List<CustomerDTO> list() throws Exception;

	Page<CustDTO> listCust(Integer page);

	List<CustomerDTO> list(Pagination page) throws Exception;

	void add(CreateCustomerForm customer) throws Exception;

	void update(CustomerForm customer) throws Exception;

	void addBrand(BrandForm brand) throws Exception;

	Set<BrandDTO> getSelectedBrand(Long custId) throws Exception;

	List<Integer> getSelectedBrandId(Long custId) throws Exception;

	boolean isExistCustomerCode(String code);

	boolean isExistCustomerName(String name);

	CustDTO findCustById(Long custId);
}
