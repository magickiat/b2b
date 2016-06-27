package com.starboard.b2b.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.starboard.b2b.dao.ProductEmailDao;
import com.starboard.b2b.dto.ProductEmailDTO;
import com.starboard.b2b.model.ProductEmail;

@Repository("productEmailDao")
public class ProductEmailDaoImpl implements ProductEmailDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(ProductEmail productEmail) {
		sessionFactory.getCurrentSession().save(productEmail);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductEmailDTO> findAll() {
		return sessionFactory.getCurrentSession()
				.createQuery(
						"select pe.id as id, pe.brandGroupId as brandGroupId, pe.email as email, pe.emailType as emailType from ProductEmail pe order by pe.brandGroupId, pe.email, pe.emailType ")
				.setResultTransformer(Transformers.aliasToBean(ProductEmailDTO.class)).list();
	}

	@Override
	public ProductEmailDTO findByEmail(Long brandGroupId, String email) {
		String hql = "select pe.id as id, pe.brandGroupId as brandGroupId, pe.email as email, pe.emailType as emailType from ProductEmail pe ";
		hql += "where pe.brandGroupId = :brandGroupId and email = :email";
		return (ProductEmailDTO) sessionFactory.getCurrentSession().createQuery(hql).setLong("brandGroupId", brandGroupId).setString("email", email)
				.setResultTransformer(Transformers.aliasToBean(ProductEmailDTO.class)).uniqueResult();
	}

	@Override
	public ProductEmailDTO find(Long brandGroupId, String email, String emailType) {
		String hql = "select pe.id as id, pe.brandGroupId as brandGroupId, pe.email as email, pe.emailType as emailType from ProductEmail pe ";
		hql += "where pe.brandGroupId = :brandGroupId and email = :email and emailType = :emailType";
		return (ProductEmailDTO) sessionFactory.getCurrentSession().createQuery(hql).setLong("brandGroupId", brandGroupId).setString("email", email)
				.setString("emailType", emailType).setResultTransformer(Transformers.aliasToBean(ProductEmailDTO.class)).uniqueResult();
	}

	@Override
	public int deleteById(Long id) {
		String hql = "delete from ProductEmail pe where pe.id = :id";
		return sessionFactory.getCurrentSession().createQuery(hql).setLong("id", id).executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductEmail> findByBrandGroupId(Long brandGroupId) {
		return sessionFactory.getCurrentSession().createCriteria(ProductEmail.class).add(Restrictions.eq("brandGroupId", brandGroupId)).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductEmail> findByBrandGroupId(Long brandGroupId, String emailType) {
		return sessionFactory.getCurrentSession().createCriteria(ProductEmail.class).add(Restrictions.eq("brandGroupId", brandGroupId)).add(Restrictions.eq("emailType", emailType)).list();
	}

}
