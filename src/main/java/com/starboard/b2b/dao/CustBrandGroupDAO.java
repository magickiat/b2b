package com.starboard.b2b.dao;

import java.util.List;

import com.starboard.b2b.dto.CustBrandGroupDTO;
import com.starboard.b2b.model.CustBrandGroup;
import com.starboard.b2b.web.form.brand.BrandForm;

public interface CustBrandGroupDAO {
	List<CustBrandGroup> findByCustId(Long custId);

	List<CustBrandGroupDTO> findProductType(Long custId);

	void addSelectedBrand(BrandForm form, List<Integer> selectedBrand);

}
