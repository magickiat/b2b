package com.starboard.b2b.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	private static final Logger log = LoggerFactory.getLogger(BrandServiceImpl.class);

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
	public List<ProductBrandGroupDTO> getBrandGroupList(Long custId) {
		List<ProductBrandGroupDTO> result = new ArrayList<>();
		List<CustBrandGroup> custBrandGroupList = custBrandGroupDAO.findByCustId(custId);
		log.info("custBrandGroupList size: " + (custBrandGroupList == null ? 0 : custBrandGroupList.size()));
		for (CustBrandGroup custBrandGroup : custBrandGroupList) {
			List<ProductBrandGroup> brandList = productBrandGroupDAO
					.findByProductTypeId(custBrandGroup.getId().getBrandGroupId());
			log.info("brandList size: " + (brandList == null ? 0 : brandList.size()));

			for (ProductBrandGroup brandGroup : brandList) {
				ProductBrandGroupDTO brandGroupDTO = new ProductBrandGroupDTO();
				brandGroupDTO.setBrandGroupId(brandGroup.getId().getBrandGroupId());
				brandGroupDTO.setProductTypeId(brandGroup.getId().getProductTypeId());
				result.add(brandGroupDTO);
			}
		}
		return result;
	}

}
