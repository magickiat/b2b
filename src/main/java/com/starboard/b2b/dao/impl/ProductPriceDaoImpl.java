package com.starboard.b2b.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.starboard.b2b.dao.ProductPriceDao;
import com.starboard.b2b.dto.ProductPriceDTO;
import com.starboard.b2b.model.ProductPrice;
import com.starboard.b2b.model.ProductPriceId;
import com.starboard.b2b.model.User;
import com.starboard.b2b.util.CustCodeUtil;

@Repository("productPriceDao")
public class ProductPriceDaoImpl implements ProductPriceDao {

	private static final Logger log = LoggerFactory.getLogger(ProductPriceDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("rawtypes")
	@Override
	public ProductPriceDTO findProductPrice(String productCode, Long productTypeId, User user) {
		log.info("productCode = " + productCode + "\tcustInvoiceCode = " + user.getCustomer().getInvoiceCode() + "\tproductTypeId = " + productTypeId
				+ "\tuser.getCustomer().getCurrency() = " + user.getCustomer().getCurrency());
		String sb = " select new com.starboard.b2b.dto.ProductPriceDTO(p.id.productCode, p.id.productPriceGroupId, p.id.productCurrency, p.amount,p.productUnitId, p.msrePrice)  from ProductPrice p";
		sb += " where p.id.productCode = :productCode";
		sb += " and p.id.productPriceGroupId in ";
		sb += "	(select productBuyerGroupId from CustPriceGroup cpg where cpg.custCode like :custInvoiceCode and cpg.productTypeId = :productTypeId)";
		List prices = sessionFactory.getCurrentSession().createQuery(sb.toString()).setString("productCode", productCode)
				.setString("custInvoiceCode", CustCodeUtil.getCustCodeWithoutCurrency(user.getCustomer().getInvoiceCode()) + "%")
				.setLong("productTypeId", productTypeId).list();
		if (prices != null && !prices.isEmpty()) {
			return (ProductPriceDTO) prices.get(0);
		} else {
			return null;
		}
	}

	@Override
	public ProductPrice findById(ProductPriceId id) {
		return (ProductPrice) sessionFactory.getCurrentSession().get(ProductPrice.class, id);
	}

	@Override
	public void save(ProductPrice price) {
		sessionFactory.getCurrentSession().save(price);
	}

	@Override
	public ProductPriceDTO findProductPriceWithPriceGroup(String productCode, String productBuyerGroupId, String productPreintro) {
		String sql = " select new com.starboard.b2b.dto.ProductPriceDTO(p.id.productCode, p.id.productPriceGroupId, p.id.productCurrency, p.amount,p.productUnitId, p.msrePrice)  from ProductPrice p";
		sql += " where p.id.productCode = :productCode";
		sql += " and p.id.productPriceGroupId = :productBuyerGroupId";
		sql += " order by p.amount ";
		return (ProductPriceDTO) sessionFactory.getCurrentSession().createQuery(sql).setString("productCode", productCode)
				.setString("productBuyerGroupId", productBuyerGroupId).setMaxResults(1).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductPriceDTO> list() {
		String hql = "select new com.starboard.b2b.dto.ProductPriceDTO(p.id.productCode, p.id.productPriceGroupId, p.id.productCurrency, p.amount,p.productUnitId, p.msrePrice)  from ProductPrice p order by p.id.productCode";
		return sessionFactory.getCurrentSession().createQuery(hql).list();
	}

}
