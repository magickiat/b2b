package com.starboard.b2b.service;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.starboard.b2b.common.Page;
import com.starboard.b2b.dao.CustomerDao;
import com.starboard.b2b.model.Customer;
import com.starboard.b2b.web.form.customer.CustomerForm;

@Service
public class CustomerServiceImpl implements CustomerService{
	private static final Logger log = LoggerFactory.getLogger(CustomerServiceImpl.class);
	@Autowired
	private CustomerDao customerDao;
	
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
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

}
