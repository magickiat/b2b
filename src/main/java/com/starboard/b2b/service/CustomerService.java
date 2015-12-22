package com.starboard.b2b.service;

import java.util.Date;
import java.util.List;

import com.starboard.b2b.common.Page;
import com.starboard.b2b.common.Pagination;
import com.starboard.b2b.dto.AddressDTO;
import com.starboard.b2b.dto.ContactDTO;
import com.starboard.b2b.dto.CountryDTO;
import com.starboard.b2b.dto.CustBrandGroupDTO;
import com.starboard.b2b.dto.CustDTO;
import com.starboard.b2b.dto.CustomerDTO;
import com.starboard.b2b.dto.MobileTypeDTO;
import com.starboard.b2b.model.ProductType;
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

	List<ProductType> getProductType();
	
	List<CustBrandGroupDTO> getCustBrandGroupById(Long custId);

	List<Integer> getSelectedBrandId(Long custId);

	boolean isExistCustomerCode(String code);

	boolean isExistCustomerName(String name);

	CustDTO findCustById(Long custId);
	
	List<AddressDTO> findAddress(Long custId, Long addressType);
	
	List<AddressDTO> findAddressByCustomerId(Long custId);
	
	List<CountryDTO> listCountry();
	
	void saveAddress(Long addId, Long custId,String address,String regionCountryId,String tel1,String postCode,String fax,String email,String type);
	
	List<ContactDTO> findContactByCustomerId(Long custId);
	
	void saveContact(Long contactId, Long custId, String nameEn, String nameNick, String position, Date birthDate, String address, 
			 String tel, String email, String mobile, String mobileId, String fax, String skype, String facebook, String twitter);
	
	List<MobileTypeDTO> getMobileType();
}
