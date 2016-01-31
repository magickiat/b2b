package com.starboard.b2b.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.starboard.b2b.dao.CustBrandGroupDAO;
import com.starboard.b2b.dto.CustBrandGroupDTO;
import com.starboard.b2b.model.CustBrandGroup;
import com.starboard.b2b.model.CustBrandGroupId;
import com.starboard.b2b.web.form.brand.BrandForm;

@Repository("custBrandGroupDAO")
public class CustBrandGroupDAOImpl implements CustBrandGroupDAO {
	private static final Logger log = LoggerFactory.getLogger(CustBrandGroupDAOImpl.class);
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<CustBrandGroup> findByCustId(Long custId) {
		log.info("findByCustId: " + custId);
		return sessionFactory.getCurrentSession().createCriteria(CustBrandGroup.class)
				.add(Restrictions.eq("id.custId", custId)).addOrder(Order.asc("id.custId")).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<CustBrandGroupDTO> findProductType(Long custId) {
		String searchOrderDetail = " select new com.starboard.b2b.dto.CustBrandGroupDTO(cg.id.custId, cg.id.brandGroupId, p.productTypeId, p.productTypeName, p.productTypeDescription, cg.userCreate, cg.userUpdate)"
				+ " FROM    CustBrandGroup cg, ProductType p "
				+ " WHERE cg.id.brandGroupId = p.productTypeId"
				+ " and cg.id.custId = :custId";

				return sessionFactory.getCurrentSession().createQuery(searchOrderDetail).setLong("custId", custId).list();
	}
	

	@Override
	public void addSelectedBrand(BrandForm form, List<Integer> selectedBrand) {
		/*CustBrandGroup custBrand = new CustBrandGroup();
		CustBrandGroupId id = new CustBrandGroupId();
		id.setCustId(form.getCustId());
		custBrand.setId(id);
		sessionFactory.getCurrentSession().delete(custBrand);
		sessionFactory.getCurrentSession().flush();*/
		
		Session session = sessionFactory.getCurrentSession();
		// ----- delete old data -----
		int deleted = session.createQuery("delete from CustBrandGroup g where g.id.custId = :custId").setLong("custId", form.getCustId()).executeUpdate();
		log.info("Deleted {} rows", deleted);
		
		
		for (Integer brandId : selectedBrand) {
			CustBrandGroup custBrandInsert = new CustBrandGroup();
			CustBrandGroupId idInsert = new CustBrandGroupId();
			idInsert.setCustId(form.getCustId());
			idInsert.setBrandGroupId(brandId);
			custBrandInsert.setId(idInsert);
			custBrandInsert.setUserCreate(form.getUserCreate());
			custBrandInsert.setUserUpdate(form.getUserUpdate());
			custBrandInsert.setTimeCreate(new Date());
			custBrandInsert.setTimeUpdate(new Date());
			session.save(custBrandInsert);
		}
	}

}
