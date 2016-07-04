package com.starboard.b2b.service;

import java.util.List;

import com.starboard.b2b.web.form.address.AddressForm;

public interface AddrService {

	AddressForm findById(long addrId);

	List<AddressForm> findByCustId(long custId);
	
	boolean update(AddressForm addressForm);

}
