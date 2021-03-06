package com.starboard.b2b.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.starboard.b2b.common.Page;
import com.starboard.b2b.common.Pagination;
import com.starboard.b2b.dao.AddrDao;
import com.starboard.b2b.dao.ContactDao;
import com.starboard.b2b.dao.CountryDao;
import com.starboard.b2b.dao.CustBrandGroupDAO;
import com.starboard.b2b.dao.CustDao;
import com.starboard.b2b.dao.CustPriceGroupDao;
import com.starboard.b2b.dao.CustomerDao;
import com.starboard.b2b.dao.MobileTypeDao;
import com.starboard.b2b.dao.ProductTypeDao;
import com.starboard.b2b.dto.AddressDTO;
import com.starboard.b2b.dto.ContactDTO;
import com.starboard.b2b.dto.CountryDTO;
import com.starboard.b2b.dto.CustBrandGroupDTO;
import com.starboard.b2b.dto.CustDTO;
import com.starboard.b2b.dto.CustPriceGroupDTO;
import com.starboard.b2b.dto.MobileTypeDTO;
import com.starboard.b2b.dto.search.SearchCustResult;
import com.starboard.b2b.dto.search.SearchRequest;
import com.starboard.b2b.exception.B2BException;
import com.starboard.b2b.model.Addr;
import com.starboard.b2b.model.Contact;
import com.starboard.b2b.model.Cust;
import com.starboard.b2b.model.CustPriceGroup;
import com.starboard.b2b.model.ProductType;
import com.starboard.b2b.model.search.SearchUserResponse;
import com.starboard.b2b.service.CustomerService;
import com.starboard.b2b.util.ApplicationConfig;
import com.starboard.b2b.util.CustCodeUtil;
import com.starboard.b2b.util.DateTimeUtil;
import com.starboard.b2b.util.UserUtil;
import com.starboard.b2b.web.form.brand.BrandForm;
import com.starboard.b2b.web.form.contact.ContactForm;
import com.starboard.b2b.web.form.customer.CreateCustomerForm;
import com.starboard.b2b.web.form.customer.SearchCustomerForm;

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
	private CountryDao countryDao;

	@Autowired
	private AddrDao addrDao;

	@Autowired
	private ContactDao contactDao;

	@Autowired
	private CustBrandGroupDAO custBrandGroupDAO;

	@Autowired
	private ProductTypeDao productTypeDao;

	@Autowired
	private MobileTypeDao mobileTypeDao;

	@Autowired
	private CustPriceGroupDao custPriceGroupDao;

	@Transactional(readOnly = true)
	public CustDTO findById(Long id) {
		Cust customer = customerDao.findById(id);
		CustDTO cust = new CustDTO();
		if (customer != null) {
			BeanUtils.copyProperties(cust, customer);
		}

		return cust;
	}

	@Transactional(readOnly = true)
	public CustDTO findByName(String name) {
		Cust customer = customerDao.findByName(name);
		CustDTO cust = new CustDTO();
		if (customer != null) {
			BeanUtils.copyProperties(cust, customer);
		}

		return cust;
	}

	@Transactional(readOnly = true)
	public List<CustDTO> list() {
		return copyCustomerToDTO(customerDao.list());
	}

	@Transactional(readOnly = true)
	public List<CustDTO> list(Pagination page) {
		return copyCustomerToDTO(customerDao.list(page));
	}

	@Transactional(rollbackFor = Exception.class)
	public void add(CreateCustomerForm form) {
		Cust customer = new Cust();
		customer.setCustCode(form.getCode());
		customer.setNameEn(form.getName());
		customer.setUserCreate(UserUtil.getCurrentUsername());
		customer.setTimeCreate(new Date());
		customerDao.add(customer);
	}

	@Transactional(rollbackFor = Exception.class)
	public void update(CustDTO customerForm) {
		Cust customer = customerDao.findById(customerForm.getCustId());
		log.info("Found " + customer);
		customer.setCustCode(customerForm.getCustCode());
		customer.setNameEn(customerForm.getNameEn());
		customer.setTimeUpdate(DateTimeUtil.getCurrentDate());
		customer.setUserUpdate(UserUtil.getCurrentUser().getName());
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void addBrand(BrandForm form) {
		custBrandGroupDAO.addSelectedBrand(form, form.getSelectedBrand());
	}

	@Override
	@Transactional(readOnly = true)
	public List<ProductType> getProductType() {
		List<ProductType> listProduct = productTypeDao.findAll();
		return listProduct;
	}

	@Override
	@Transactional(readOnly = true)
	public List<CustBrandGroupDTO> getCustBrandGroupById(Long custId) {
		List<CustBrandGroupDTO> listCustBrandGroup = custBrandGroupDAO.findProductType(custId);
		return listCustBrandGroup;
	}

	private List<CustDTO> copyCustomerToDTO(List<Cust> list) {
		ArrayList<CustDTO> custList = new ArrayList<>();
		if (list != null && list.size() > 0) {
			for (Cust customer : list) {
				CustDTO cust = new CustDTO();
				BeanUtils.copyProperties(cust, customer);
				custList.add(cust);
			}
		}
		return custList;
	}

	@Override
	@Transactional(readOnly = true)
	public boolean isExistCustomerCode(String code) {
		log.info("isExistCustomerCode");
		return customerDao.exist("custCode", code);
	}

	@Override
	@Transactional(readOnly = true)
	public boolean isExistCustomerName(String name) {
		return customerDao.exist("name", name);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<SearchUserResponse> listCust(SearchCustomerForm form) {

		// ----- set request ------
		SearchRequest<SearchCustomerForm> req = new SearchRequest<>(form.getPage(), applicationConfig.getPageSize());
		req.setCondition(form);
		SearchCustResult searchResult = custDao.listCust(req);

		// ----- prepare result page -----
		Page<SearchUserResponse> page = new Page<>();
		page.setCurrent(req.getPage());
		page.setResult(searchResult.getResult());
		page.setPageSize(req.getPageSize());
		page.setTotal(searchResult.getTotal());

		return page;
	}

	@Override
	@Transactional(readOnly = true)
	public CustDTO findCustById(Long custId) {
		log.info("findCustById " + custId);

		Cust cust = custDao.findById(custId);
		if (cust == null) {
			throw new B2BException("Cannot found customer id " + custId);
		}
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
	@Transactional(rollbackFor = Exception.class)
	public void saveAddress(Long addId, Long custId, String address, String regionCountryId, String tel1, String postCode, String fax, String email,
			String type) {
		if (addId == null || addId == 0) {
			addId = addrDao.maxId();
			if (addId == null) {
				addId = 0L;
			}
			addId = addId + 1;
			addrDao.save(createAddress(addId, custId, address, regionCountryId, tel1, postCode, fax, email, type));
		} else {
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

	public Addr createAddress(Long addrId, Long custId, String address, String regionCountryId, String tel1, String postCode, String fax,
			String email, String type) {
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
	@Transactional(rollbackFor = Exception.class)
	public void saveContact(ContactForm contactInfo) {
		if (contactInfo.getContactId() == null || contactInfo.getContactId() == 0) {
			contactDao.save(createContact(contactInfo));
		} else {
			Contact contact = contactDao.findById(contactInfo.getContactId());
			contact.setContactId(contactInfo.getContactId());
			contact.setCustId(contactInfo.getCustId());
			contact.setNameEn(contactInfo.getNameEn());
			contact.setNameNick(contactInfo.getNameNick());
			contact.setPosition(contactInfo.getPosition());
			contact.setBirthDate(contactInfo.getBirthDate());
			contact.setAddress(contactInfo.getAddress());
			contact.setEmail(contactInfo.getEmail());
			contact.setTel(contactInfo.getTel());
			contact.setMobile(contactInfo.getMobile());
			contact.setMobileId(contactInfo.getMobileId());
			contact.setFax(contactInfo.getFax());
			contact.setSkype(contactInfo.getSkype());
			contact.setFacebook(contactInfo.getFacebook());
			contact.setTwitter(contactInfo.getTwitter());
		}

	}

	public Contact createContact(ContactForm contactInfo) {
		Contact contact = new Contact();
		contact.setCustId(contactInfo.getCustId());
		contact.setNameEn(contactInfo.getNameEn());
		contact.setNameNick(contactInfo.getNameNick());
		contact.setPosition(contactInfo.getPosition());
		contact.setBirthDate(contactInfo.getBirthDate());
		contact.setAddress(contactInfo.getAddress());
		contact.setEmail(contactInfo.getEmail());
		contact.setTel(contactInfo.getTel());
		contact.setMobile(contactInfo.getMobile());
		contact.setMobileId(contactInfo.getMobileId());
		contact.setFax(contactInfo.getFax());
		contact.setSkype(contactInfo.getSkype());
		contact.setFacebook(contactInfo.getFacebook());
		contact.setTwitter(contactInfo.getTwitter());
		return contact;
	}

	@Override
	@Transactional(readOnly = true)
	public List<MobileTypeDTO> getMobileType() {
		return mobileTypeDao.findAll();
	}

	@Override
	public CustPriceGroupDTO findCustPriceGroup(String custCode, long productType) {
		String custCodeWithoutCurrency = CustCodeUtil.getCustCodeWithoutCurrency(custCode);
		log.info("Use customer code = " + custCodeWithoutCurrency);
		CustPriceGroup priceGroup = custPriceGroupDao.findByCustCode(custCodeWithoutCurrency, productType);
		CustPriceGroupDTO dto = new CustPriceGroupDTO();
		if(priceGroup != null){
			BeanUtils.copyProperties(priceGroup, dto);
		}
		return dto;
	}
}
