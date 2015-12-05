package com.starboard.b2b.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.starboard.b2b.dao.AddrDao;
import com.starboard.b2b.model.Addr;
import com.starboard.b2b.service.AddrService;
import com.starboard.b2b.web.form.address.AddressForm;

@Service("AddrService")
public class AddrServiceImpl implements AddrService {

	private static final Logger log = LoggerFactory.getLogger(AddrServiceImpl.class);

	@Autowired
	private AddrDao addrDao;

	@Override
	@Transactional(readOnly = true)
	public AddressForm findById(long addrId) {
		Addr addr = addrDao.findById(addrId);
		AddressForm addressForm = new AddressForm();
		addressForm.setAddrId(addr.getAddrId());
		addressForm.setAddress(addr.getAddress());
		addressForm.setType(addr.getType());
		addressForm.setRegionCountryId(addr.getRegionCountryId());
		addressForm.setEmail(addr.getEmail());
		addressForm.setFax(addr.getFax());
		addressForm.setPostCode(addr.getPostCode());
		addressForm.setTel1(addr.getTel1());
		return addressForm;
	}

	@Override
	@Transactional(readOnly = true)
	public List<AddressForm> findByCustId(long custId) {
		List<Addr> addrs = addrDao.findByCustId(custId);
		List<AddressForm> addressForms = new ArrayList<>();
		for (Addr addr : addrs) {
			AddressForm addressForm = new AddressForm();
			addressForm.setAddrId(addr.getAddrId());
			addressForm.setAddress(addr.getAddress());
			addressForm.setType(addr.getType());
			addressForm.setRegionCountryId(addr.getRegionCountryId());
			addressForm.setEmail(addr.getEmail());
			addressForm.setFax(addr.getFax());
			addressForm.setPostCode(addr.getPostCode());
			addressForm.setTel1(addr.getTel1());
			addressForms.add(addressForm);
		}
		return addressForms;
	}

	@Override
	@Transactional
	public boolean update(AddressForm addressForm) {
		boolean isSuccess = false;
		Addr addr = addrDao.findById(addressForm.getAddrId());
		addr.setAddrId(addressForm.getAddrId());
		addr.setAddress(addressForm.getAddress());
		addr.setRegionCountryId(addressForm.getRegionCountryId());
		addr.setPostCode(addressForm.getPostCode());
		addr.setTel1(addressForm.getTel1());
		addr.setFax(addressForm.getFax());
		addr.setType(addressForm.getType());
		addr.setEmail(addressForm.getEmail());
		
		try{
			addrDao.update(addr);
			isSuccess = true;
		}catch(Exception e){
			isSuccess = false;
		}
		
		return isSuccess;
	}

}
