package com.starboard.b2b.dao.impl;

import com.starboard.b2b.dao.OrderDetailDao;
import com.starboard.b2b.dto.search.SearchOrderDetailDTO;
import com.starboard.b2b.model.OrdDetail;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

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
	public List<SearchOrderDetailDTO> searchOrderDetail(String orderCode) {
		String searchOrderDetail = " select new com.starboard.b2b.dto.search.SearchOrderDetailDTO(p.productCode, p.productNameEn, od.amount, 0L, od.amount, od.productUnitId, od.price)"
		+ " FROM    OrdDetail od, Orders r, Product p "
		+ " WHERE od.productId = p.productId"
		+ " and od.orderId = r.id"
		+ " and r.orderCode = :orderCode";

		return sessionFactory.getCurrentSession().createQuery(searchOrderDetail).setString("orderCode", orderCode).list();
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
