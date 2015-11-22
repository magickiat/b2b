package com.starboard.b2b.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.starboard.b2b.dao.OrderDao;
import com.starboard.b2b.dto.search.SearchOrderDTO;
import com.starboard.b2b.model.Orders;

@Repository("orderDao")
public class OrderDaoImpl implements OrderDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public long save(Orders order) {
		return (Long) sessionFactory.getCurrentSession().save(order);
	}

	@Override
	public Orders findById(Long orderId) {
		return (Orders) sessionFactory.getCurrentSession().get(Orders.class, orderId);
	}

	@Override
	public SearchOrderDTO findOrderForReport(Long orderId) {
		StringBuffer sb = new StringBuffer();
		sb.append(
				" SELECT  new com.starboard.b2b.dto.search.SearchOrderDTO(   o.orderCode,    c.nameEn,    p.productTypeName,    o.orderDate,    o.expectShipmentDate,    os.orderStatusName, o.paymentMethodId, o.shippingId )");
		sb.append(" FROM    Orders o,    ProductType p,    Cust c,    OrderStatus os");
		sb.append(" WHERE    o.brandGroupId = p.productTypeId        AND o.custId = c.custId        and o.orderStatus = os.orderStatusId");
		sb.append(" and o.orderId = :orderId ");
		return (SearchOrderDTO) sessionFactory.getCurrentSession().createQuery(sb.toString()).setLong("orderId", orderId).uniqueResult();
	}
}
