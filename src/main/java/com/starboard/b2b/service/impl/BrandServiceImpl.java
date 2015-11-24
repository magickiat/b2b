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
import com.starboard.b2b.dao.CustDao;
import com.starboard.b2b.dao.ProductBrandGroupDAO;
import com.starboard.b2b.dto.BrandDTO;
import com.starboard.b2b.dto.ProductBrandGroupDTO;
import com.starboard.b2b.exception.B2BException;
import com.starboard.b2b.model.Brand;
import com.starboard.b2b.model.CustBrandGroup;
import com.starboard.b2b.model.ProductBrandGroup;
import com.starboard.b2b.service.BrandService;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import org.apache.commons.beanutils.BeanUtils;

@Service("brandService")
public class BrandServiceImpl implements BrandService {
	private static final Logger log = LoggerFactory.getLogger(BrandServiceImpl.class);

	@Autowired
	private BrandDao brandDao;

	@Autowired
	private CustBrandGroupDAO custBrandGroupDAO;
	@Autowired
	private ProductBrandGroupDAO productBrandGroupDAO;

	@Autowired
	private CustDao custDao;

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
	@Transactional(readOnly = true)
	public List<ProductBrandGroupDTO> getBrandGroupList(Long custId) {
		return custDao.findProductBrandGroup(custId);
	}

    @Override
    @Transactional(readOnly = true)
    public BrandDTO getBrand(long brandId) {
        Brand entity = brandDao.getBrand(brandId);
        if(entity == null) {
            return null;
        }
        try {
            BrandDTO brand = new BrandDTO();
            BeanUtils.copyProperties(brand, entity);
            return brand;
        } catch (IllegalAccessException | InvocationTargetException ex) {
            throw new B2BException(ex);
        }
    }
}
