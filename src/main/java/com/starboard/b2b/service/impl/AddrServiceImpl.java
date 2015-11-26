package com.starboard.b2b.service.impl;

import com.starboard.b2b.dao.AddrDao;
import com.starboard.b2b.model.Addr;
import com.starboard.b2b.service.AddrService;
import com.starboard.b2b.web.form.user.AddressForm;
import com.starboard.b2b.web.form.user.UserForm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("AddrService")
public class AddrServiceImpl implements AddrService {

	private static final Logger log = LoggerFactory.getLogger(AddrServiceImpl.class);

	@Autowired
	private AddrDao addrDao;

	@Override
	@Transactional(readOnly = true)
	public Addr findById(long addrId) {
		return addrDao.findById(addrId);
	}

	@Override
	@Transactional(readOnly = true)
	public List<AddressForm> findByCustId(long custId) {
		List<Addr> addrs = addrDao.findByCustId(custId);
		List<AddressForm> addressForms = new ArrayList<>();
		for (Addr addr : addrs) {
			AddressForm addressForm = new AddressForm();
			addressForm.setId(addr.getAddrId());
			addressForm.setAddress(addr.getAddress());
			addressForm.setAddressType(addr.getType());
			addressForm.setCountry(addr.getRegionCountryId());
			addressForm.setEmail(addr.getEmail());
			addressForm.setFax(addr.getFax());
			addressForm.setPostCode(addr.getPostCode());
			addressForm.setTelephone(addr.getTel1());
			addressForms.add(addressForm);
		}
		return addressForms;
	}

	@Override
	@Transactional
	public void update(UserForm userForm) {
		for(AddressForm addressForm: userForm.getAddresses()){
			Addr addr = new Addr();//addrDao.findById(addressForm.getId());
			addr.setAddrId(addressForm.getId());
			addr.setAddress(addressForm.getAddress());
			addr.setRegionCountryId(addressForm.getCountry());
			addr.setPostCode(addressForm.getPostCode());
			addr.setTel1(addressForm.getTelephone());
			addr.setFax(addressForm.getFax());
			addr.setType(addressForm.getAddressType());
			addr.setEmail(addressForm.getEmail());
			addr.setCustId(userForm.getCustId());
			addrDao.update(addr);
		}		
	}

}
