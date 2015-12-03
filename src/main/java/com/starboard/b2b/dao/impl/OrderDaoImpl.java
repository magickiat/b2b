package com.starboard.b2b.dao.impl;

import com.starboard.b2b.dao.OrderDao;
import com.starboard.b2b.dto.search.CommonSearchRequest;
import com.starboard.b2b.dto.search.SearchOrderDTO;
import com.starboard.b2b.dto.search.SearchResult;
import com.starboard.b2b.model.OrdAddress;
import com.starboard.b2b.model.Orders;
import com.starboard.b2b.web.form.product.OrderSummaryForm;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;

@Repository("orderDao")
public class OrderDaoImpl implements OrderDao {

	private static final Logger log = LoggerFactory.getLogger(OrderDaoImpl.class);

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
		String searchQuery = "SELECT  new com.starboard.b2b.dto.search.SearchOrderDTO(o.orderId, o.orderCode, c.nameEn, p.productTypeName, o.orderDate, o.expectShipmentDate, os.orderStatusName, o.paymentMethodId, o.shippingId )"
				+ " FROM Orders o, ProductType p, Cust c, OrderStatus os "
				+ " WHERE o.brandGroupId = p.productTypeId AND o.custId = c.custId and o.orderStatus = os.orderStatusId"
				+ " and o.orderId = :orderId ";
		return (SearchOrderDTO) sessionFactory.getCurrentSession().createQuery(searchQuery).setLong("orderId", orderId).uniqueResult();
	}

	@Override
	public SearchOrderDTO findOrderForReport(String orderCode) {
		String searchQuery = "SELECT  new com.starboard.b2b.dto.search.SearchOrderDTO(o.orderId, o.orderCode, c.nameEn, p.productTypeName, o.orderDate, o.expectShipmentDate, os.orderStatusName, o.paymentMethodId, o.shippingId )"
		+ " FROM Orders o, ProductType p, Cust c, OrderStatus os "
		+ " WHERE o.brandGroupId = p.productTypeId AND o.custId = c.custId and o.orderStatus = os.orderStatusId"
		+ " and o.orderCode = :orderCode ";
		return (SearchOrderDTO) sessionFactory.getCurrentSession().createQuery(searchQuery).setString("orderCode", orderCode).uniqueResult();
	}

	@Override
	public SearchResult<SearchOrderDTO> search(CommonSearchRequest<OrderSummaryForm> searchRequest) {

		final String ordersQuery = "SELECT " +
				" new com.starboard.b2b.dto.search.SearchOrderDTO( " +
				" o.orderId, " +
				" o.orderCode, " +
				" c.nameEn, " +
				" p.productTypeName, " +
				" o.orderDate, " +
				" o.expectShipmentDate, " +
				" os.orderStatusName, " +
				" o.paymentMethodId, " +
				" o.shippingId) " +
				"FROM Orders o, ProductType p, Cust c, OrderStatus os " +
				"WHERE o.brandGroupId = p.productTypeId " +
				"AND o.custId = c.custId " +
				"AND o.orderStatus = os.orderStatusId " +
				"AND (:keyword IS NULL OR (" +
				"	o.orderCode LIKE :keyword" +
				"	OR c.nameEn LIKE :keyword" +
				"	OR p.productTypeName LIKE :keyword" +
				"	OR os.orderStatusName LIKE :keyword" +
				"))" +
				"AND (:productTypeId = 0 OR p.productTypeId = :productTypeId) " +
				"AND (:orderStatusId IS NULL OR os.orderStatusId = :orderStatusId) " +
				"AND ((:fromDate IS NULL OR :toDate IS NULL) OR ( DATE(o.orderDate) BETWEEN :fromDate AND :toDate)) " +
				"AND (:custId = 0 OR o.custId = :custId) " +
				"ORDER BY o.orderDate DESC ";
		final String ordersTotalQuery = "SELECT count(o.orderCode) " +
				"FROM Orders o, ProductType p, Cust c, OrderStatus os " +
				"WHERE o.brandGroupId = p.productTypeId " +
				"AND o.custId = c.custId " +
				"AND o.orderStatus = os.orderStatusId " +
				"AND (:keyword IS NULL OR (" +
				"	o.orderCode LIKE :keyword" +
				"	OR c.nameEn LIKE :keyword" +
				"	OR p.productTypeName LIKE :keyword" +
				"	OR os.orderStatusName LIKE :keyword" +
				"))" +
				"AND (:productTypeId = 0 OR p.productTypeId = :productTypeId) " +
				"AND (:orderStatusId IS NULL OR os.orderStatusId = :orderStatusId) " +
				"AND ((:fromDate IS NULL OR :toDate IS NULL) OR ( DATE(o.orderDate) BETWEEN :fromDate AND :toDate)) " +
				"AND (:custId = 0 OR o.custId = :custId) ";
				
		final String keyword = StringUtils.isEmpty(searchRequest.getCondition().getKeyword()) ? null : "%"+searchRequest.getCondition().getKeyword()+"%";
		final int productTypeId = StringUtils.isEmpty(searchRequest.getCondition().getSelectedBrand()) ? 0 : Integer.parseInt(searchRequest.getCondition().getSelectedBrand());
		final String orderStatusId = StringUtils.isEmpty(searchRequest.getCondition().getSelectedStatus()) ? null : searchRequest.getCondition().getSelectedStatus();
		final String fromDate = StringUtils.isEmpty(searchRequest.getCondition().getDateFrom()) ? null : searchRequest.getCondition().getDateFrom();
		final String toDate = StringUtils.isEmpty(searchRequest.getCondition().getDateTo()) ? null : searchRequest.getCondition().getDateTo();
		final long custId = searchRequest.getCondition().getCustId();
		final List searchOrderDTOs = sessionFactory.getCurrentSession().createQuery(ordersQuery)
				.setString("keyword", keyword)
				.setInteger("productTypeId", productTypeId)
				.setString("orderStatusId", orderStatusId)
				.setString("fromDate", fromDate)
				.setString("toDate", toDate)
				.setLong("custId", custId)
				.setFirstResult(searchRequest.getFirstResult()).setMaxResults(searchRequest.getPageSize())
				.list();
		log.info("Search order with parameter:\n\t{}\n\t{}\n\t{}\n\t{}\n\t{}", searchRequest.getCondition().getSelectedBrand()
		,searchRequest.getCondition().getSelectedStatus()
		,searchRequest.getCondition().getDateFrom()
		,searchRequest.getCondition().getDateTo()
		,searchRequest.getCondition().getKeyword());
		final Object ordersTotal = sessionFactory.getCurrentSession().createQuery(ordersTotalQuery)
				.setString("keyword", keyword)
				.setInteger("productTypeId", productTypeId)
				.setString("orderStatusId", orderStatusId)
				.setString("fromDate", fromDate)
				.setString("toDate", toDate)
				.setLong("custId", custId)
				.uniqueResult();
		final SearchResult<SearchOrderDTO> result = new SearchResult<>();
		result.setTotal(ordersTotal == null ? 0 : (long) ordersTotal);
		result.setResult(searchOrderDTOs);

		log.info("List size: {}", (searchOrderDTOs != null ? searchOrderDTOs.size() : 0));
		log.info("Total {}", result.getTotal());
		return result;
	}

	@Override
	public List<OrdAddress> findOrderAddress(final String orderCode) {
		return sessionFactory.getCurrentSession()
				.createQuery("SELECT o FROM OrdAddress o, Orders r WHERE o.orderId = r.orderId AND r.orderCode = :orderCode")
				.setString("orderCode", orderCode)
				.list();
	}
}
