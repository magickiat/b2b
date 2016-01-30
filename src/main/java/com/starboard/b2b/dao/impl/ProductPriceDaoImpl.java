package com.starboard.b2b.dao.impl;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.starboard.b2b.dao.ProductPriceDao;
import com.starboard.b2b.dto.ProductPriceDTO;
import com.starboard.b2b.model.ProductPrice;
import com.starboard.b2b.model.ProductPriceId;

@Repository("productPriceDao")
public class ProductPriceDaoImpl implements ProductPriceDao {

	private static final Logger log = LoggerFactory.getLogger(ProductDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public ProductPriceDTO findProductPrice(String productCode, String custInvoiceCode, String preIntro) {
		log.info("productCode = " + productCode + "\tcustInvoiceCode = " + custInvoiceCode);
		StringBuffer sb = new StringBuffer();
		sb.append(
				" select new com.starboard.b2b.dto.ProductPriceDTO(p.id.productCode, p.id.productPriceGroupId, p.id.productCurrency, p.amount,p.productUnitId, p.msrePrice)  from ProductPrice p");
		sb.append(" where p.id.productCode = :productCode");
		sb.append(
				" and p.id.productPriceGroupId in (select distinct productBuyerGroupId from CustPriceGroup cpg where cpg.custCode = :custInvoiceCode)");
		sb.append(" order by p.amount ");
		return (ProductPriceDTO) sessionFactory.getCurrentSession().createQuery(sb.toString()).setString("productCode", productCode)
				.setString("custInvoiceCode", custInvoiceCode).setMaxResults(1).uniqueResult();
	}

	@Override
	public ProductPrice findById(ProductPriceId id) {
		return (ProductPrice) sessionFactory.getCurrentSession().get(ProductPrice.class, id);
	}

	@Override
	public void save(ProductPrice price) {
		sessionFactory.getCurrentSession().save(price);
	}

}
