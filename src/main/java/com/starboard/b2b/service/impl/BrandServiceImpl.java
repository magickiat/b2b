package com.starboard.b2b.service.impl;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.starboard.b2b.dao.BrandDao;
import com.starboard.b2b.dao.CustBrandGroupDAO;
import com.starboard.b2b.dao.ProductBrandGroupDAO;
import com.starboard.b2b.dto.ProductBrandGroupDTO;
import com.starboard.b2b.model.Brand;
import com.starboard.b2b.model.CustBrandGroup;
import com.starboard.b2b.model.ProductBrandGroup;
import com.starboard.b2b.service.BrandService;

@Service
public class BrandServiceImpl implements BrandService {

	@Autowired
	private BrandDao brandDao;

	@Autowired
	private CustBrandGroupDAO custBrandGroupDAO;
	@Autowired
	private ProductBrandGroupDAO productBrandGroupDAO;

	@Override
	@Transactional(readOnly = true)
	public List<Brand> list(Long companyId) {
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Brand> list() {
		return brandDao.list();
	}

	@Override
	public Set<ProductBrandGroupDTO> getBrandGroupList(Long custId) {
		Set<ProductBrandGroupDTO> result = new TreeSet<>();
		List<CustBrandGroup> custBrandGroupList = custBrandGroupDAO.findByCustId(custId);
		for (CustBrandGroup custBrandGroup : custBrandGroupList) {
			List<ProductBrandGroup> brandList = productBrandGroupDAO
					.findByProductTypeId(custBrandGroup.getId().getBrandGroupId());
			for (ProductBrandGroup brandGroup : brandList) {
				ProductBrandGroupDTO brandGroupDTO = new ProductBrandGroupDTO();
				BeanUtils.copyProperties(brandGroupDTO, brandGroup);
				result.add(brandGroupDTO);
			}
		}
		return null;
	}

}
