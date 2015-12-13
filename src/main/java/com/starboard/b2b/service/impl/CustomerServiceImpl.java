package com.starboard.b2b.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.starboard.b2b.common.Page;
import com.starboard.b2b.common.Pagination;
import com.starboard.b2b.dao.AddrDao;
import com.starboard.b2b.dao.BrandDao;
import com.starboard.b2b.dao.ContactDao;
import com.starboard.b2b.dao.CountryDao;
import com.starboard.b2b.dao.CustDao;
import com.starboard.b2b.dao.CustomerDao;
import com.starboard.b2b.dto.AddressDTO;
import com.starboard.b2b.dto.BrandDTO;
import com.starboard.b2b.dto.ContactDTO;
import com.starboard.b2b.dto.CountryDTO;
import com.starboard.b2b.dto.CustDTO;
import com.starboard.b2b.dto.CustomerDTO;
import com.starboard.b2b.dto.search.SearchCustRequest;
import com.starboard.b2b.dto.search.SearchCustResult;
import com.starboard.b2b.model.Addr;
import com.starboard.b2b.model.Brand;
import com.starboard.b2b.model.Contact;
import com.starboard.b2b.model.Cust;
import com.starboard.b2b.model.Customer;
import com.starboard.b2b.service.CustomerService;
import com.starboard.b2b.util.ApplicationConfig;
import com.starboard.b2b.util.DateTimeUtil;
import com.starboard.b2b.util.UserUtil;
import com.starboard.b2b.web.form.brand.BrandForm;
import com.starboard.b2b.web.form.customer.CreateCustomerForm;
import com.starboard.b2b.web.form.customer.CustomerForm;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {
	private static final Logger log = LoggerFactory.getLogger(CustomerServiceImpl.class);
	@Autowired
	private CustomerDao customerDao;

	@Autowired
	private ApplicationConfig applicationConfig;

	@Autowired
	private CustDao custDao;

	@Autowired
	private BrandDao brandDao;
	
	@Autowired
	private CountryDao countryDao;
	
	@Autowired
	private AddrDao addrDao;
	
	@Autowired
	private ContactDao contactDao;

	@Transactional(readOnly = true)
	public CustomerDTO findById(Long id) {
		Customer customer = customerDao.findById(id);
		return customer == null ? null : new CustomerDTO(customer);
	}

	@Transactional(readOnly = true)
	public CustomerDTO findByName(String name) {
		Customer customer = customerDao.findByName(name);
		return customer == null ? null : new CustomerDTO(customer);
	}

	@Transactional(readOnly = true)
	public List<CustomerDTO> list() {
		return copyCustomerToDTO(customerDao.list());
	}

	@Transactional(readOnly = true)
	public List<CustomerDTO> list(Pagination page) {
		return copyCustomerToDTO(customerDao.list(page));
	}

	@Transactional
	public void add(CreateCustomerForm form) {
		Customer customer = new Customer();
		customer.setCode(form.getCode());
		customer.setName(form.getName());
		customer.setUserCreate(UserUtil.getCurrentUsername());
		customer.setTimeCreate(new Date());
		customerDao.add(customer);
	}

	@Transactional
	public void update(CustomerForm customerForm) {
		Customer customer = customerDao.findById(customerForm.getCustId());
		customer.setCode(customerForm.getCode());
		customer.setName(customerForm.getName());
		customer.setTimeUpdate(DateTimeUtil.getCurrentDate());
		customer.setUserUpdate(UserUtil.getCurrentUser().getName());
	}

	@Override
	@Transactional
	public void addBrand(BrandForm form) {
		Customer customer = customerDao.findById(form.getCustId());
		if (form.getSelectedBrand() == null || form.getSelectedBrand().size() == 0) {
			customer.setBrands(null);
		} else {
			brandDao.addSelectedBrand(form.getCustId(), form.getSelectedBrand());
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<Integer> getSelectedBrandId(Long custId) {
		ArrayList<Integer> brandList = new ArrayList<>();
		Customer customer = customerDao.findById(custId);
		if (customer != null && customer.getBrands() != null) {
			Iterator<Brand> iterator = customer.getBrands().iterator();
			while (iterator.hasNext()) {
				Brand brand = (Brand) iterator.next();
				brandList.add(brand.getId());
			}
		}
		return brandList;
	}

	@Override
	@Transactional(readOnly = true)
	public Set<BrandDTO> getSelectedBrand(Long custId) {
		Customer customer = customerDao.findById(custId);
		if (customer != null) {
			return copyBrandToDTO(customer.getBrands());
		} else {
			return null;
		}

	}

	private Set<BrandDTO> copyBrandToDTO(Set<Brand> brands) {
		Set<BrandDTO> list = new HashSet<>();
		if (brands != null && brands.size() > 0) {
			for (Brand brand : brands) {
				list.add(new BrandDTO(brand));
			}
		}
		return list;
	}

	private List<CustomerDTO> copyCustomerToDTO(List<Customer> list) {
		ArrayList<CustomerDTO> custList = new ArrayList<>();
		if (list != null && list.size() > 0) {
			for (Customer customer : list) {
				custList.add(new CustomerDTO(customer));
			}
		}
		return custList;
	}

	@Override
	@Transactional(readOnly = true)
	public boolean isExistCustomerCode(String code) {
		log.info("isExistCustomerCode");
		return customerDao.exist("code", code);
	}

	@Override
	@Transactional(readOnly = true)
	public boolean isExistCustomerName(String name) {
		return customerDao.exist("name", name);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<CustDTO> listCust(Integer pageIndex) {
		SearchCustRequest req = new SearchCustRequest(pageIndex, applicationConfig.getPageSize());
		log.info(req.toString());
		SearchCustResult searchResult = custDao.listCust(req);
		List<CustDTO> result = new ArrayList<>();
		for (Cust cust : searchResult.getResult()) {
			CustDTO dto = new CustDTO();
			BeanUtils.copyProperties(cust, dto);
			result.add(dto);
		}
		Page<CustDTO> page = new Page<>();
		page.setCurrent(req.getPage());
		page.setResult(result);
		page.setPageSize(req.getPageSize());
		page.setTotal(searchResult.getTotal());
		return page;
	}

	@Override
	@Transactional(readOnly = true)
	public CustDTO findCustById(Long custId) {
		Cust cust = custDao.findById(custId);
		CustDTO dto = new CustDTO();
		BeanUtils.copyProperties(cust, dto);
		return dto;
	}

	@Override
	@Transactional(readOnly = true)
	public List<AddressDTO> findAddress(Long custId, Long addressType) {
		return custDao.findAddress(custId, addressType);
	}

	@Override
	@Transactional(readOnly = true)
	public List<AddressDTO> findAddressByCustomerId(Long custId) {
		return custDao.findAddressByCustomerId(custId);
	}

	@Override
	@Transactional(readOnly = true)
	public List<CountryDTO> listCountry() {
		return countryDao.findAll();
	}
	
	@Override
	@Transactional
	public void saveAddress(Long addId,Long custId,String address,String regionCountryId,String tel1,String postCode,String fax,String email,String type) {
		if(addId==null || addId==0){
			addId = addrDao.maxId();
			if(addId == null){
				addId = 0L;
			}
			addId = addId+1;
			addrDao.save(createAddress(addId, custId, address, regionCountryId, tel1, postCode, fax, email, type));
		}else{
			Addr addr = addrDao.findById(addId);
			addr.setCustId(custId);
			addr.setAddress(address);
			addr.setRegionCountryId(regionCountryId);
			addr.setTel1(tel1);
			addr.setPostCode(postCode);
			addr.setFax(fax);
			addr.setEmail(email);
			addr.setType(type);
		}
		
	}
	
	public Addr createAddress(Long addrId,Long custId,String address,String regionCountryId,String tel1,String postCode,String fax,String email,String type) {
		Addr addr = new Addr();
		addr.setAddrId(addrId);
		addr.setCustId(custId);
		addr.setAddress(address);
		addr.setRegionCountryId(regionCountryId);
		addr.setTel1(tel1);
		addr.setPostCode(postCode);
		addr.setFax(fax);
		addr.setEmail(email);
		addr.setType(type);
		return addr;
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<ContactDTO> findContactByCustomerId(Long custId) {
		return custDao.findContactByCustomerId(custId);
	}

	@Override
	@Transactional
	public void saveContact(Long contactId, Long custId, String nameEn, String nameNick, String position, Date birthDate, String address, String tel,
			String email, String mobileId, String fax, String skype, String facebook, String twitter) {
		if(contactId==null || contactId==0){
			//contactId = contactDao.maxId();
			/*if(contactId == null){
				contactId = 0L;
			}*/
			//contactId = contactId+1;
			contactDao.save(createContact(contactId, custId, nameEn, nameNick, position, birthDate, address, tel, email, mobileId, fax, skype, facebook, twitter));
		}else{
			Contact contact = contactDao.findById(contactId);
			contact.setContactId(contactId);
			contact.setCustId(custId);
			contact.setNameEn(nameEn);
			contact.setNameNick(nameNick);
			contact.setPosition(position);
			contact.setBirthDate(birthDate);
			contact.setAddress(address);
			contact.setEmail(email);
			contact.setTel(tel);
			contact.setEmail(email);
			contact.setMobileId(mobileId);
			contact.setFax(fax);
			contact.setSkype(skype);
			contact.setFacebook(facebook);
			contact.setTwitter(twitter);
		}
		
	}
	public Contact createContact(Long contactId, Long custId, String nameEn, String nameNick, String position, Date birthDate, String address, String tel,
			String email, String mobileId, String fax, String skype, String facebook, String twitter) {
		Contact contact = new Contact();
		contact.setContactId(contactId);
		contact.setCustId(custId);
		contact.setNameEn(nameEn);
		contact.setNameNick(nameNick);
		contact.setPosition(position);
		contact.setBirthDate(birthDate);
		contact.setAddress(address);
		contact.setEmail(email);
		contact.setTel(tel);
		contact.setEmail(email);
		contact.setMobileId(mobileId);
		contact.setFax(fax);
		contact.setSkype(skype);
		contact.setFacebook(facebook);
		contact.setTwitter(twitter);
		return contact;
	}
}
