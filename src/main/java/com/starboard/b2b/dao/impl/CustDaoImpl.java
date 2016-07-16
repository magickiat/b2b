package com.starboard.b2b.dao.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.starboard.b2b.common.AddressConstant;
import com.starboard.b2b.dao.CustDao;
import com.starboard.b2b.dto.AddressDTO;
import com.starboard.b2b.dto.ContactDTO;
import com.starboard.b2b.dto.ProductBrandGroupDTO;
import com.starboard.b2b.dto.search.SearchCustResult;
import com.starboard.b2b.dto.search.SearchRequest;
import com.starboard.b2b.model.Cust;
import com.starboard.b2b.web.form.customer.SearchCustomerForm;

@Repository("custDao")
public class CustDaoImpl implements CustDao {

	private static final Logger log = LoggerFactory.getLogger(CustDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public SearchCustResult listCust(SearchRequest<SearchCustomerForm> req) {
		log.info("search request: " + req);

		//TODO join Contact, brand group
		String queryString = "select new com.starboard.b2b.model.search.SearchUserResponse(c, a) "
				+ " from Cust c, Addr a where c.custId = a.custId and a.type = " + AddressConstant.USER_INVOICE_TO;
		
		String queryStringTotal = "select count(distinct c.nameEn) "
				+ " from Cust c, Addr a where c.custId = a.custId and a.type = " + AddressConstant.USER_INVOICE_TO;
		
		// ----- Set criteria
		String where = "";
		if (req != null && req.getCondition() != null) {
			if (StringUtils.isNotEmpty(req.getCondition().getKeyword())) {
				where += " and c.custCode like :keyword or c.nameEn like :keyword ";
			}
			
			if(req.getCondition().getSelectedCountry() != null){
				where += " and a.regionCountryId = :country";
			}
		}

		queryString += where;
		queryStringTotal += where;

		queryString += " group by c.nameEn order by c.custCode";

		Query query = sessionFactory.getCurrentSession().createQuery(queryString);
		Query queryTotal = sessionFactory.getCurrentSession().createQuery(queryStringTotal);

		if (StringUtils.isNotEmpty(where)) {
			if (StringUtils.isNotEmpty(req.getCondition().getKeyword())) {
				query.setString("keyword", "%" + req.getCondition().getKeyword() + "%");
				queryTotal.setString("keyword", "%" + req.getCondition().getKeyword() + "%");
			}
			
			if(req.getCondition().getSelectedCountry() != null){
				query.setString("country", req.getCondition().getSelectedCountry());
				queryTotal.setString("country", req.getCondition().getSelectedCountry());
			}
			
			
		}
		List list = query.setFirstResult(req.getFirstResult()).setMaxResults(req.getPageSize()).list();

		// ----- Find total -----
		Object totalRecord = queryTotal.uniqueResult();

		// ----- Set result -----
		SearchCustResult result = new SearchCustResult();
		result.setResult(list);
		result.setTotal((long) totalRecord);

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
		sb.append(" select new com.starboard.b2b.dto.AddressDTO(a.addrId,a.custId,a.custCode,a.contactId, ");
		sb.append(" a.address,a.subDistrict,a.district,a.province,a.regionCountryId,a.postCode,");
		sb.append(" a.tel1,a.tel2,a.fax,a.email,a.transType,a.transTel,a.type,a.userCreate,a.userUpdate,a.timeCreate,a.timeUpdate) ");
		sb.append(" from Addr a where a.custId = :custId and a.type = :type order by a.addrId asc");

		return (List<AddressDTO>) sessionFactory.getCurrentSession().createQuery(sb.toString()).setLong("custId", custId).setLong("type", addressType)
				.list();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductBrandGroupDTO> findProductBrandGroup(Long custId) {
		StringBuffer sb = new StringBuffer();
		sb.append(" select new com.starboard.b2b.dto.ProductBrandGroupDTO(b.id.brandGroupId, b.id.productTypeId)");
		sb.append(" from ProductBrandGroup b");
		sb.append(" where b.id.productTypeId in");
		sb.append(" (select distinct c.id.brandGroupId from CustBrandGroup c where c.id.custId = :custId)");
		sb.append(" group by b.id.brandGroupId");

		return sessionFactory.getCurrentSession().createQuery(sb.toString()).setLong("custId", custId).list();
	}

	/**
	 * Get a address when have more than one
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<AddressDTO> findAddressByCustomerId(Long custId) {
		StringBuffer sb = new StringBuffer();
		sb.append(" select new com.starboard.b2b.dto.AddressDTO(a.addrId,a.custId,a.custCode,a.contactId, ");
		sb.append(" a.address,a.subDistrict,a.district,a.province,a.regionCountryId,a.postCode,a.tel1,a.tel2,a.fax, ");
		sb.append(" a.email,a.transType,a.transTel,a.type,a.userCreate,a.userUpdate,a.timeCreate,a.timeUpdate)");
		sb.append(" from Addr a where a.custId = :custId order by a.type asc");

		return (List<AddressDTO>) sessionFactory.getCurrentSession().createQuery(sb.toString()).setLong("custId", custId).list();

	}

	/**
	 * Get a address when have more than one
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<ContactDTO> findContactByCustomerId(Long custId) {
		StringBuffer sb = new StringBuffer();
		sb.append(" select new com.starboard.b2b.dto.ContactDTO(c.contactId, c.custId, c.nameTh, c.nameTitle, c.nameEn, ");
		sb.append(" c.nameNick, c.position, c.birthDate, c.address, c.email, c.tel, c.mobile, c.fax, c.skype, c.facebook, c.twitter, ");
		sb.append(" c.markUp, c.salesId, c.mobileId, c.imgPath, c.userCreate,	 c.userUpdate, c.timeCreate, c.timeUpdate, c.signaturePath)");
		sb.append(" from Contact c where c.custId = :custId order by c.contactId asc");

		return (List<ContactDTO>) sessionFactory.getCurrentSession().createQuery(sb.toString()).setLong("custId", custId).list();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductBrandGroupDTO> findProductType(Long custId) {
		StringBuffer sb = new StringBuffer();
		sb.append(" select new com.starboard.b2b.dto.ProductBrandGroupDTO(pg.id.brandGroupId, cg.id.brandGroupId)");
		sb.append(" from CustBrandGroup cg, ProductBrandGroup pg");
		sb.append(" where cg.id.brandGroupId = pg.id.productTypeId");
		sb.append(" and cg.id.custId = :custId");

		return sessionFactory.getCurrentSession().createQuery(sb.toString()).setLong("custId", custId).list();
	}

}
