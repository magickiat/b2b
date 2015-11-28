package com.starboard.b2b.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.starboard.b2b.dao.OrderDetailDao;
import com.starboard.b2b.dto.search.SearchOrderDetailDTO;
import com.starboard.b2b.model.OrdDetail;

@Repository("orderDetailDao")
public class OrderDetailDaoImpl implements OrderDetailDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Serializable save(OrdDetail detail) {
		return sessionFactory.getCurrentSession().save(detail);
	}

	@Override
	public List<SearchOrderDetailDTO> searchOrderDetail(Long orderId) {
		StringBuffer sb = new StringBuffer();
		sb.append(" select new com.starboard.b2b.dto.search.SearchOrderDetailDTO(p.productCode, p.productNameEn, od.amount, 0L, od.amount, od.productUnitId, od.price)");
		sb.append(" FROM    OrdDetail od,    Product p ");
		sb.append(" WHERE od.productId = p.productId");
		sb.append(" and od.orderId = :orderId");
		
		return sessionFactory.getCurrentSession().createQuery(sb.toString()).setLong("orderId", orderId).list();
	}

	@Override
	public List<String> findAllOrderCurrency(Long orderId) {
		StringBuffer sb = new StringBuffer();
		sb.append("select new java.lang.String(od.productCurrency)");
		sb.append(" from OrdDetail od");
		sb.append(" where od.orderId = :orderId");
		sb.append(" order by od.productCurrency asc");
		return sessionFactory.getCurrentSession().createQuery(sb.toString()).setLong("orderId", orderId).list();
	}
	
 
}
