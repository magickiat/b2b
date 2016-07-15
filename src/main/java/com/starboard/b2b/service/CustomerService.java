package com.starboard.b2b.service;

import java.util.List;

import com.starboard.b2b.common.Page;
import com.starboard.b2b.dto.AddressDTO;
import com.starboard.b2b.dto.ContactDTO;
import com.starboard.b2b.dto.CountryDTO;
import com.starboard.b2b.dto.CustBrandGroupDTO;
import com.starboard.b2b.dto.CustDTO;
import com.starboard.b2b.dto.CustPriceGroupDTO;
import com.starboard.b2b.dto.MobileTypeDTO;
import com.starboard.b2b.model.ProductType;
import com.starboard.b2b.model.search.SearchUserResponse;
import com.starboard.b2b.web.form.brand.BrandForm;
import com.starboard.b2b.web.form.contact.ContactForm;
import com.starboard.b2b.web.form.customer.CreateCustomerForm;
import com.starboard.b2b.web.form.customer.SearchCustomerForm;

public interface CustomerService {
	CustDTO findById(Long id);

	CustDTO findByName(String name);

	List<CustDTO> list();

	Page<SearchUserResponse> listCust(SearchCustomerForm form);

	void add(CreateCustomerForm customer);

	void update(CustDTO customer);

	void addBrand(BrandForm brand);

	List<ProductType> getProductType();

	List<CustBrandGroupDTO> getCustBrandGroupById(Long custId);

	boolean isExistCustomerCode(String code);

	boolean isExistCustomerName(String name);

	CustDTO findCustById(Long custId);

	List<AddressDTO> findAddress(Long custId, Long addressType);

	List<AddressDTO> findAddressByCustomerId(Long custId);

	List<CountryDTO> listCountry();

	void saveAddress(Long addId, Long custId, String address, String regionCountryId, String tel1, String postCode, String fax, String email,
			String type);

	List<ContactDTO> findContactByCustomerId(Long custId);

	List<MobileTypeDTO> getMobileType();

	CustPriceGroupDTO findCustPriceGroup(String custCode, long productType);

	void saveContact(ContactForm contact);
}
