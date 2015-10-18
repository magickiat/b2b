package com.starboard.b2b.dao;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.starboard.b2b.dto.ProductPriceDTO;
import com.starboard.b2b.model.ProductPrice;

@Repository("productPriceDao")
public class ProductPriceDaoImpl implements ProductPriceDao {

	private static final Logger log = LoggerFactory.getLogger(ProductDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@SuppressWarnings("rawtypes")
	public ProductPriceDTO findProductPrice(String productCode, String productBuyerGroupId, String currency) {
		StringBuffer sb = new StringBuffer();
		sb.append(
				" select new com.starboard.b2b.dto.ProductPriceDTO(p.id.productCode, p.id.productPriceGroupId, p.id.productCurrency, p.amount,p.productUnitId, p.msrePrice)  from ProductPrice p");
		sb.append(" where p.id.productCode = :productCode");
		sb.append(" and p.id.productPriceGroupId = :productPriceGroupId");
		sb.append(" and p.id.productCurrency = :productCurrency");

		ProductPriceDTO result = null;
		List list = sessionFactory.getCurrentSession().createQuery(sb.toString())
				.setString("productCode", productCode)
				.setString("productPriceGroupId", productBuyerGroupId)
				.setString("productCurrency", currency).list();
		if (list != null && list.size() > 0) {
			result = (ProductPriceDTO) list.get(0);
		}
		return result;
	}
}
