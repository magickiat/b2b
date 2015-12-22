package com.starboard.b2b.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.starboard.b2b.dao.BrandDao;
import com.starboard.b2b.model.Brand;
import com.starboard.b2b.model.CustBrandGroup;
import com.starboard.b2b.model.CustBrandGroupId;
import com.starboard.b2b.web.form.brand.BrandForm;

@Repository("brandDao")
public class BrandDaoImpl implements BrandDao {
	private static final Logger log = LoggerFactory.getLogger(BrandDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@SuppressWarnings("unchecked")
	public List<Brand> list(Integer companyId) {
		return sessionFactory.getCurrentSession().createCriteria(Brand.class).add(Restrictions.eq("company", companyId))
				.list();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Brand> list() {
		return sessionFactory.getCurrentSession().createCriteria(Brand.class).list();
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

    @Override
    public Brand getBrand(long brandId) {
        return Brand.class.cast(sessionFactory.getCurrentSession().get(Brand.class, Long.valueOf(brandId).intValue()));
    }
}
