package com.starboard.b2b.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.starboard.b2b.common.Page;
import com.starboard.b2b.dao.BrandDao;
import com.starboard.b2b.dao.CustomerDao;
import com.starboard.b2b.model.Brand;
import com.starboard.b2b.model.Customer;
import com.starboard.b2b.web.form.brand.BrandForm;
import com.starboard.b2b.web.form.customer.CustomerForm;

@Service
public class CustomerServiceImpl implements CustomerService {
	private static final Logger log = LoggerFactory.getLogger(CustomerServiceImpl.class);
	@Autowired
	private CustomerDao customerDao;

	@Autowired
	private BrandDao brandDao;

	@Transactional(readOnly = true)
	public Customer findById(int id) {
		return customerDao.findById(id);
	}

	@Transactional(readOnly = true)
	public Customer findByName(String name) {
		return customerDao.findByName(name);
	}

	@Transactional(readOnly = true)
	public List<Customer> list() {
		return customerDao.list();
	}

	@Transactional(readOnly = true)
	public List<Customer> list(Page page) {
		return customerDao.list(page);
	}

	@Transactional
	public void add(CustomerForm customerForm) {
		if (findByName(customerForm.getName()) == null) {
			Customer customer = new Customer();
			try {
				BeanUtils.copyProperties(customer, customerForm);
				customer.setCreatedDate(new Date());
				customerDao.add(customer);
			} catch (IllegalAccessException | InvocationTargetException e) {
				log.error("Couldn't copy property to bean", e);
			}

		}

	}

	@Transactional
	public void update(CustomerForm customerForm) throws Exception {
		Customer customer = findById(customerForm.getId());
		if (customer == null) {
			throw new Exception("Not found customer id = " + customerForm.getId());
		}
		customer.setCode(customerForm.getCode());
		customer.setName(customerForm.getName());
		customer.setUpdatedDate(new Date());
	}

	@Override
	@Transactional
	public void addBrand(BrandForm form) throws Exception {
		Customer customer = findById(form.getCustId());
		if (customer == null) {
			throw new Exception("Not found customer id = " + form.getCustId());
		}
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
		Customer customer = findById(custId);
		if (customer != null) {
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
	public Set<Brand> getSelectedBrand(Integer custId) throws Exception {
		 Customer customer = customerDao.findById(custId);
		 if(customer != null){
			 return customer.getBrands();
		 }
		 return null;
	}

}
