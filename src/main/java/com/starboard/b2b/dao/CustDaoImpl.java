package com.starboard.b2b.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.starboard.b2b.dto.AddressDTO;
import com.starboard.b2b.dto.ProductBrandGroupDTO;
import com.starboard.b2b.dto.search.SearchCustRequest;
import com.starboard.b2b.dto.search.SearchCustResult;
import com.starboard.b2b.model.Cust;
import com.starboard.b2b.model.CustPriceGroup;

@Repository("custDao")
public class CustDaoImpl implements CustDao {

	private static final Logger log = LoggerFactory.getLogger(CustDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public SearchCustResult listCust(SearchCustRequest req) {
		log.info("search request: " + req);

		SearchCustResult result = new SearchCustResult();

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Cust.class);
		List list = criteria.setFirstResult(req.getFirstResult()).setMaxResults(req.getPageSize()).list();

		Object totalRecord = sessionFactory.getCurrentSession().createCriteria(Cust.class)
				.setProjection(Projections.rowCount()).uniqueResult();
		result.setResult(list);
		result.setTotal((long) totalRecord);

		log.info("Total " + result.getTotal());
		return result;
	}

	@Override
	public Cust findById(Long custId) {
		return (Cust) sessionFactory.getCurrentSession().get(Cust.class, custId);
	}

	/**
	 * Get a address when have more than one
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<AddressDTO> findAddress(Long custId, Long addressType) {
		StringBuffer sb = new StringBuffer();
		sb.append(
				"select new com.starboard.b2b.dto.AddressDTO(a.addrId,a.custId,a.custCode,a.contactId,a.address,a.subDistrict,a.district,a.province,a.regionCountryId,a.postCode,a.tel1,a.tel2,a.fax,a.email,a.transType,a.transTel,a.type,a.userCreate,a.userUpdate,a.timeCreate,a.timeUpdate) ");
		sb.append(" from Addr a where a.custId = :custId and a.type = :type order by a.addrId asc");

		return (List<AddressDTO>) sessionFactory.getCurrentSession().createQuery(sb.toString())
				.setLong("custId", custId).setLong("type", addressType).list();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductBrandGroupDTO> findProductBrandGroup(Long custId) {
		StringBuffer sb = new StringBuffer();
		sb.append(" select new com.starboard.b2b.dto.ProductBrandGroupDTO(b.id.brandGroupId, b.id.productTypeId)");
		sb.append(" from ProductBrandGroup b");
		sb.append(" where b.id.brandGroupId in");
		sb.append(" (select distinct c.id.brandGroupId from CustBrandGroup c where c.id.custId = :custId)");
		sb.append(" group by b.id.brandGroupId");
		
		return sessionFactory.getCurrentSession().createQuery(sb.toString()).setLong("custId", custId).list();
	}

	@Override
	public List<CustPriceGroup> findCustPriceGroup(String custInvoiceNo) {
		StringBuffer sb = new StringBuffer();
		sb.append("select new com.starboard.b2b.dto.CustPriceGroupDTO");
		return null;
	}

	@Override
	public List<CustPriceGroup> findCustPriceGroup(Long custId) {
		// TODO Auto-generated method stub
		return null;
	}

}
