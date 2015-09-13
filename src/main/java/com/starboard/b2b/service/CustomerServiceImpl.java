package com.starboard.b2b.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.starboard.b2b.common.Page;
import com.starboard.b2b.dao.BrandDao;
import com.starboard.b2b.dao.CustomerDao;
import com.starboard.b2b.dto.BrandDTO;
import com.starboard.b2b.dto.CustomerDTO;
import com.starboard.b2b.model.Brand;
import com.starboard.b2b.model.Customer;
import com.starboard.b2b.util.DateTimeUtil;
import com.starboard.b2b.util.UserUtil;
import com.starboard.b2b.web.form.brand.BrandForm;
import com.starboard.b2b.web.form.customer.CustomerForm;

@Service
public class CustomerServiceImpl implements CustomerService {
//	private static final Logger log = LoggerFactory.getLogger(CustomerServiceImpl.class);
	@Autowired
	private CustomerDao customerDao;

	@Autowired
	private BrandDao brandDao;

	@Transactional(readOnly = true)
	public CustomerDTO findById(int id) {
		return new CustomerDTO(customerDao.findById(id));
	}

	@Transactional(readOnly = true)
	public CustomerDTO findByName(String name) {
		return new CustomerDTO(customerDao.findByName(name));
	}

	@Transactional(readOnly = true)
	public List<CustomerDTO> list() {
		return copyCustomerToDTO(customerDao.list());
	}

	@Transactional(readOnly = true)
	public List<CustomerDTO> list(Page page) {
		return copyCustomerToDTO(customerDao.list(page));
	}

	@Transactional
	public void add(CustomerForm form) throws Exception {
		Customer customer = new Customer();
		customer.setCode(form.getCode());
		customer.setName(form.getName());
		customer.setCreatedBy(UserUtil.getCurrentUsername());
		customer.setCreatedDate(new Date());
		customerDao.add(customer);
	}

	@Transactional
	public void update(CustomerForm customerForm) throws Exception {
		Customer customer = customerDao.findById(customerForm.getId());
		customer.setCode(customerForm.getCode());
		customer.setName(customerForm.getName());
		customer.setUpdatedDate(DateTimeUtil.getCurrentDate());
		customer.setUpdatedBy(UserUtil.getCurrentUser().getName());
	}

	@Override
	@Transactional
	public void addBrand(BrandForm form) throws Exception {
		Customer customer = customerDao.findById(form.getCustId());
		if (form.getSelectedBrand() == null || form.getSelectedBrand().size() == 0) {
			customer.setBrands(null);
		} else {
			brandDao.addSelectedBrand(form.getCustId(), form.getSelectedBrand());
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<Integer> getSelectedBrandId(Integer custId) throws Exception {
		ArrayList<Integer> brandList = new ArrayList<>();
		Customer customer = customerDao.findById(custId);
		Iterator<Brand> iterator = customer.getBrands().iterator();
		while (iterator.hasNext()) {
			Brand brand = (Brand) iterator.next();
			brandList.add(brand.getId());
		}
		return brandList;
	}

	@Override
	@Transactional(readOnly = true)
	public Set<BrandDTO> getSelectedBrand(Integer custId) throws Exception {
		Customer customer = customerDao.findById(custId);
		if (customer != null) {
			return copyBrandToDTO(customer.getBrands());
		}
		return null;
	}

	private Set<BrandDTO> copyBrandToDTO(Set<Brand> brands) {
		Set<BrandDTO> list = new HashSet<>();
		for (Brand brand : brands) {
			list.add(new BrandDTO(brand));
		}

		return list;
	}

	private List<CustomerDTO> copyCustomerToDTO(List<Customer> list) {
		ArrayList<CustomerDTO> custList = new ArrayList<>();
		for (Customer customer : list) {
			custList.add(new CustomerDTO(customer));
		}
		return custList;
	}
}
