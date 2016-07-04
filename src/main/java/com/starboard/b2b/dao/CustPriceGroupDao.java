package com.starboard.b2b.dao;

import com.starboard.b2b.model.CustPriceGroup;

public interface CustPriceGroupDao {

	CustPriceGroup findByCustCode(String custCode, long productType);

}