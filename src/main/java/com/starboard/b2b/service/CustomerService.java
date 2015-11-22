package com.starboard.b2b.service;

import java.util.List;
import java.util.Set;

import com.starboard.b2b.common.Page;
import com.starboard.b2b.common.Pagination;
import com.starboard.b2b.dto.AddressDTO;
import com.starboard.b2b.dto.BrandDTO;
import com.starboard.b2b.dto.CountryDTO;
import com.starboard.b2b.dto.CustDTO;
import com.starboard.b2b.dto.CustomerDTO;
import com.starboard.b2b.web.form.brand.BrandForm;
import com.starboard.b2b.web.form.customer.CreateCustomerForm;
import com.starboard.b2b.web.form.customer.CustomerForm;

public interface CustomerService {
	CustomerDTO findById(Long id);

	CustomerDTO findByName(String name);

	List<CustomerDTO> list();

	Page<CustDTO> listCust(Integer page);

	List<CustomerDTO> list(Pagination page);

	void add(CreateCustomerForm customer);

	void update(CustomerForm customer);

	void addBrand(BrandForm brand);

	Set<BrandDTO> getSelectedBrand(Long custId);

	List<Integer> getSelectedBrandId(Long custId);

	boolean isExistCustomerCode(String code);

	boolean isExistCustomerName(String name);

	CustDTO findCustById(Long custId);
	
	List<AddressDTO> findAddress(Long custId, Long addressType);
	
	List<AddressDTO> findAddressByCustomerId(Long custId);
	
	List<CountryDTO> listCountry();
	
	void saveAddress(Long addId, Long custId,String address,String regionCountryId,String tel1,String postCode,String fax,String email,String type);
}
