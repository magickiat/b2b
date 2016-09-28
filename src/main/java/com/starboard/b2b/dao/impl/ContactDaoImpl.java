package com.starboard.b2b.dao.impl;

import com.starboard.b2b.dao.ContactDao;
import com.starboard.b2b.model.Contact;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository("contactDao")
public class ContactDaoImpl implements ContactDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Long maxId() {
		/*Object max =  sessionFactory.getCurrentSession().createSQLQuery("select max(contact_id) from contact").uniqueResult();
		Long lmax = (Long)max;*/
		return ((BigInteger) sessionFactory.getCurrentSession().createSQLQuery("SELECT MAX(contact_id) FROM contact").uniqueResult()).longValue();
	}

	@Override
	public Contact findById(Long contactId) {
		return (Contact) sessionFactory.getCurrentSession().get(Contact.class, contactId);
	}

	@Override
	public void save(Contact obj) {
		 sessionFactory.getCurrentSession().save(obj);
	}

	@Override
	public void removeByCustId(long custId) {
		final String hql = "DELETE FROM Contact c WHERE c.custId = :custId";
		sessionFactory.getCurrentSession().createQuery(hql).setLong("custId", custId).executeUpdate();
	}

    @Override
    public void removeByCustIds(List<Long> custIds) {
		final String hql = "DELETE FROM Contact c WHERE c.custId in (:custIds)";
		sessionFactory.getCurrentSession().createQuery(hql).setParameterList("custIds", custIds).executeUpdate();
    }

    @SuppressWarnings("unchecked")
	@Override
	public List<Contact> findByCustId(long custId) {
		return sessionFactory.getCurrentSession().createCriteria(Contact.class).add(Restrictions.eq("custId", custId)).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Contact> list() {
		return sessionFactory.getCurrentSession().createCriteria(Contact.class).list();
	}
}
