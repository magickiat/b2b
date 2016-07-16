package com.starboard.b2b.dao.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.hibernate.type.LongType;
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
import com.starboard.b2b.model.search.SearchUserResponse;
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

		String nativeSql = "";
		nativeSql += "SELECT  ";
		nativeSql += "c.cust_id as custId, c.cust_code as custCode, c.name_en as companyName, ct.name_en as contractName, ctr.country_name as countryName, a.tel_1 as tel, a.email, a.address ";
		nativeSql += "FROM cust c ";
		nativeSql += "LEFT JOIN addr a ON c.cust_id = a.cust_id ";
		nativeSql += "LEFT JOIN country ctr ON a.region_country_id = ctr.country_code ";
		nativeSql += "LEFT JOIN contact ct ON c.cust_id = ct.cust_id ";
		nativeSql += "LEFT JOIN cust_brand_group cg ON c.cust_id = cg.cust_id ";

		if (req != null && req.getCondition() != null) {
			String where = " where a.type = " + AddressConstant.USER_INVOICE_TO;
			if (StringUtils.isNotEmpty(req.getCondition().getKeyword())) {
				where += " and ( c.name_en like '%" + req.getCondition().getKeyword() + "%' ";
				where += "  		or ctr.country_name like  '%" + req.getCondition().getKeyword() + "%' ";
				where += "  		or a.email like  '%" + req.getCondition().getKeyword() + "%' ";
				where += "  		or a.address like  '%" + req.getCondition().getKeyword() + "%') ";
			}

			if (StringUtils.isNotEmpty(req.getCondition().getSelectedCountry())) {
				where += " and a.region_country_id = '" + req.getCondition().getSelectedCountry() + "' ";
			}

			if (req.getCondition().getSelectedBrand() != null) {
				where += " and cg.brand_group_id in ( ";
				where += " select product_type_id from product_brand_group pg where pg.brand_group_id = " + req.getCondition().getSelectedBrand();
				where += ") ";
			}

			if (StringUtils.isNotEmpty(where)) {
				nativeSql += where;
			}
		}

		nativeSql += " GROUP BY c.name_en ";

		List list = sessionFactory.getCurrentSession().createSQLQuery(nativeSql).addScalar("custId", LongType.INSTANCE).addScalar("custCode")
				.addScalar("companyName").addScalar("contractName").addScalar("countryName").addScalar("tel").addScalar("email").addScalar("address")
				.setResultTransformer(Transformers.aliasToBean(SearchUserResponse.class)).setFirstResult(req.getFirstResult())
				.setMaxResults(req.getPageSize()).list();

		// ----- Find total -----
		Object totalRecord = sessionFactory.getCurrentSession().createSQLQuery("select count(*) as total from (" + nativeSql + ") tmp")
				.addScalar("total", LongType.INSTANCE).uniqueResult();

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
