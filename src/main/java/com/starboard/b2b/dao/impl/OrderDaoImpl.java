package com.starboard.b2b.dao.impl;

import com.starboard.b2b.dao.OrderDao;
import com.starboard.b2b.dto.InvoiceDTO;
import com.starboard.b2b.dto.SoDTO;
import com.starboard.b2b.dto.search.SearchOrderDTO;
import com.starboard.b2b.dto.search.SearchRequest;
import com.starboard.b2b.dto.search.SearchResult;
import com.starboard.b2b.model.OrdAddress;
import com.starboard.b2b.model.Orders;
import com.starboard.b2b.web.form.order.OrderSummaryForm;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
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
		String searchQuery = "SELECT  new com.starboard.b2b.dto.search.SearchOrderDTO(o.orderId, o.orderCode, c.nameEn, p.productTypeName, o.orderDate, o.expectShipmentDate, os.orderStatusName, o.paymentMethodId, o.shippingId, pt.description, o.remarkCustomer, pt.paymentTermId, o.orderStatus, o.remarkOrders, o.custCode  )"
				+ " FROM Orders o, ProductType p, Cust c, OrderStatus os, PaymentTerm pt "
				+ " WHERE o.brandGroupId = p.productTypeId AND o.custId = c.custId and o.orderStatus = os.orderStatusId and o.paymentTermId = pt.paymentTermId "
				+ " and o.orderId = :orderId ";
		return (SearchOrderDTO) sessionFactory.getCurrentSession().createQuery(searchQuery).setLong("orderId", orderId).uniqueResult();
	}

	@Override
	public SearchOrderDTO findOrderForReport(String orderCode) {
		String searchQuery = "SELECT  new com.starboard.b2b.dto.search.SearchOrderDTO(o.orderId, o.orderCode, c.nameEn, p.productTypeName, o.orderDate, o.expectShipmentDate, os.orderStatusName, o.paymentMethodId, o.shippingId, pt.description, o.remarkCustomer, pt.paymentTermId, o.orderStatus, o.remarkOrders, o.custCode  )"
		+ " FROM Orders o, ProductType p, Cust c, OrderStatus os, PaymentTerm pt "
		+ " WHERE o.brandGroupId = p.productTypeId AND o.custId = c.custId and o.orderStatus = os.orderStatusId  and o.paymentTermId = pt.paymentTermId "
		+ " and o.orderCode = :orderCode ";
		return (SearchOrderDTO) sessionFactory.getCurrentSession().createQuery(searchQuery).setString("orderCode", orderCode).uniqueResult();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public SearchResult<SearchOrderDTO> search(SearchRequest<OrderSummaryForm> searchRequest) {

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
				" o.shippingId, pt.description, o.remarkCustomer, pt.paymentTermId, o.orderStatus, o.remarkOrders, o.custCode ) " +
				"FROM Orders o, ProductType p, Cust c, OrderStatus os, PaymentTerm pt " +
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
				"AND (:custId = 0 OR o.custId = :custId)  and o.paymentTermId = pt.paymentTermId " +
				"ORDER BY o.orderId DESC ";
		final String ordersTotalQuery = "SELECT count(o.orderCode) " +
				"FROM Orders o, ProductType p, Cust c, OrderStatus os, PaymentTerm pt " +
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
				"AND (:custId = 0 OR o.custId = :custId)  and o.paymentTermId = pt.paymentTermId ";
				
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
		//Find Sales Order && Invoice for each order
		for (Object object : searchOrderDTOs) {
			SearchOrderDTO sOrder = (SearchOrderDTO) object;
			//Sales Order
			List<SoDTO> so = sessionFactory.getCurrentSession().createQuery("SELECT new com.starboard.b2b.dto.SoDTO(s) from So s where s.orderId = :orderId")
					.setLong("orderId", sOrder.getOrderId())
					.list();
			if(so != null && !so.isEmpty() ){
				sOrder.setSalesOrders(so);
			}else{
				sOrder.setSalesOrders(new ArrayList<SoDTO>());
			}
			//Invoice
			List<InvoiceDTO> invoice = sessionFactory.getCurrentSession().createQuery("SELECT new com.starboard.b2b.dto.InvoiceDTO(iv) from Invoice iv, So s where  iv.soId = s.soId and s.orderId = :orderId")
					.setLong("orderId", sOrder.getOrderId())
					.list();
			if(invoice != null && !invoice.isEmpty() ){
				sOrder.setInvoices(invoice);
			}else{
				sOrder.setInvoices(new ArrayList<InvoiceDTO>());
			}
		}
		result.setTotal(ordersTotal == null ? 0 : (long) ordersTotal);
		result.setResult(searchOrderDTOs);

		log.info("List size: {}", (searchOrderDTOs != null ? searchOrderDTOs.size() : 0));
		log.info("Total {}", result.getTotal());
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OrdAddress> findOrderAddress(final String orderCode) {
		return sessionFactory.getCurrentSession()
				.createQuery("SELECT o FROM OrdAddress o, Orders r WHERE o.orderId = r.orderId AND r.orderCode = :orderCode")
				.setString("orderCode", orderCode)
				.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SearchOrderDTO> findOrderForReport(Long[] ordersId) {
		String searchQuery = "SELECT  new com.starboard.b2b.dto.search.SearchOrderDTO(o.orderId, o.orderCode, c.nameEn, p.productTypeName, o.orderDate, o.expectShipmentDate, os.orderStatusName, o.paymentMethodId, o.shippingId, pt.description, o.remarkCustomer, pt.paymentTermId, o.orderStatus, o.remarkOrders, o.custCode  )"
				+ " FROM Orders o, ProductType p, Cust c, OrderStatus os, PaymentTerm pt "
				+ " WHERE o.brandGroupId = p.productTypeId AND o.custId = c.custId and o.orderStatus = os.orderStatusId"
				+ " and o.orderId in (:orderId)  and o.paymentTermId = pt.paymentTermId  "
				+ " order by o.orderId";
		return sessionFactory.getCurrentSession().createQuery(searchQuery).setParameterList("orderId", ordersId).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SearchOrderDTO> searchOrderSummaryForReport(OrderSummaryForm form) {

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
				" o.shippingId, pt.description, o.remarkCustomer, pt.paymentTermId, o.orderStatus, o.remarkOrders, o.custCode ) " +
				"FROM Orders o, ProductType p, Cust c, OrderStatus os, PaymentTerm pt " +
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
				"AND (:custId = 0 OR o.custId = :custId)  and o.paymentTermId = pt.paymentTermId " +
				"ORDER BY o.orderDate DESC ";
			
		final String keyword = StringUtils.isEmpty(form.getKeyword()) ? null : "%"+form.getKeyword()+"%";
		final int productTypeId = StringUtils.isEmpty(form.getSelectedBrand()) ? 0 : Integer.parseInt(form.getSelectedBrand());
		final String orderStatusId = StringUtils.isEmpty(form.getSelectedStatus()) ? null : form.getSelectedStatus();
		final String fromDate = StringUtils.isEmpty(form.getDateFrom()) ? null : form.getDateFrom();
		final String toDate = StringUtils.isEmpty(form.getDateTo()) ? null : form.getDateTo();
		final long custId = form.getCustId();
		return sessionFactory.getCurrentSession().createQuery(ordersQuery)
				.setString("keyword", keyword)
				.setInteger("productTypeId", productTypeId)
				.setString("orderStatusId", orderStatusId)
				.setString("fromDate", fromDate)
				.setString("toDate", toDate)
				.setLong("custId", custId)
				.list();
	}
	
	@Override
	public Orders findByOrderCode(String roCode) {
		return (Orders)sessionFactory.getCurrentSession()
				.createCriteria(Orders.class)
				.add(Restrictions.eq("orderCode", roCode))
				.uniqueResult();
	}

    @Override
    public int deleteByOrderCode(String orderCode) {
		return sessionFactory.getCurrentSession()
				.createQuery("delete from Orders o where o.orderCode = :orderCode")
				.setString("orderCode", orderCode)
				.executeUpdate();
    }

	@SuppressWarnings("unchecked")
	@Override
	public List<Orders> list() {
		return sessionFactory.getCurrentSession().createCriteria(Orders.class).list();
	}
}
