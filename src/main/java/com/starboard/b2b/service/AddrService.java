package com.starboard.b2b.service;

import java.util.List;

import com.starboard.b2b.model.Addr;
import com.starboard.b2b.web.form.user.AddressForm;
import com.starboard.b2b.web.form.user.UserForm;

public interface AddrService {

	Addr findById(long addrId);

	List<AddressForm> findByCustId(long custId);
	
	void update(UserForm userForm);

}
