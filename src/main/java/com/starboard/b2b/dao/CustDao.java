package com.starboard.b2b.dao;

import java.util.List;

import com.starboard.b2b.dto.AddressDTO;
import com.starboard.b2b.dto.ContactDTO;
import com.starboard.b2b.dto.ProductBrandGroupDTO;
import com.starboard.b2b.dto.search.SearchRequest;
import com.starboard.b2b.dto.search.SearchCustResult;
import com.starboard.b2b.model.Cust;
import com.starboard.b2b.model.CustPriceGroup;
import com.starboard.b2b.web.form.customer.SearchCustomerForm;

public interface CustDao {
	SearchCustResult listCust(SearchRequest<SearchCustomerForm> req);

	Cust findById(Long custId);

	List<AddressDTO> findAddress(Long custId, Long addressType);

	List<ProductBrandGroupDTO> findProductBrandGroup(Long custId);

	List<CustPriceGroup> findCustPriceGroup(String custInvoiceNo);

	List<CustPriceGroup> findCustPriceGroup(Long custId);
	
	List<AddressDTO> findAddressByCustomerId(Long custId);
	
	List<ContactDTO> findContactByCustomerId(Long custId);
}
