package com.starboard.b2b.dao.impl;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.starboard.b2b.dao.OrderDetailDao;
import com.starboard.b2b.dto.search.SearchOrderDetailDTO;
import com.starboard.b2b.dto.search.SearchOrderDetailReportResult;
import com.starboard.b2b.model.OrdDetail;
import org.hibernate.Query;

@Repository("orderDetailDao")
public class OrderDetailDaoImpl implements OrderDetailDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Serializable save(OrdDetail detail) {
        return sessionFactory.getCurrentSession().save(detail);
    }

    @Override
    public int purge(Long orderId) {
        Query query = sessionFactory.getCurrentSession().createQuery("DELETE FROM OrdDetail o WHERE o.orderId = :orderId");
        query.setLong("orderId", orderId);
        return query.executeUpdate();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<SearchOrderDetailDTO> searchOrderDetail(Long orderId) {
        StringBuilder sb = new StringBuilder();
        sb.append("select new com.starboard.b2b.dto.search.SearchOrderDetailDTO(o.orderDetailId, p.productId, p.productCode, p.productNameEn, o.amount, 0L, o.amount, o.productUnitId, o.productCurrency, o.price, o.productBuyerGroupId) ");
        sb.append("FROM OrdDetail o, Product p ");
        sb.append("WHERE o.productId = p.productId ");
        sb.append("and o.orderId = :orderId ");
        sb.append("ORDER BY p.productCode");
        return sessionFactory.getCurrentSession().createQuery(sb.toString()).setLong("orderId", orderId).list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<SearchOrderDetailDTO> searchOrderDetail(String orderCode) {
        String searchOrderDetail = "select new com.starboard.b2b.dto.search.SearchOrderDetailDTO(d.orderDetailId, p.productId, p.productCode, p.productNameEn, d.amount, 0L, d.amount, d.productUnitId, d.productCurrency, d.price, d.productBuyerGroupId) "
                + "FROM OrdDetail d, Orders o, Product p "
                + "WHERE d.productId = p.productId and d.orderId = o.id and o.orderCode = :orderCode "
                + "ORDER BY p.productCode ";

        return sessionFactory.getCurrentSession().createQuery(searchOrderDetail).setString("orderCode", orderCode).list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<String> findAllOrderCurrency(Long orderId) {
        StringBuilder sb = new StringBuilder();
        sb.append("select new java.lang.String(od.productCurrency)");
        sb.append(" from OrdDetail od");
        sb.append(" where od.orderId = :orderId");
        sb.append(" order by od.productCurrency asc");
        return sessionFactory.getCurrentSession().createQuery(sb.toString()).setLong("orderId", orderId).list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<SearchOrderDetailDTO> searchOrderDetail(Long[] ordersId) {
        StringBuilder sb = new StringBuilder();
        sb.append(
                " select new com.starboard.b2b.dto.search.SearchOrderDetailDTO(od.orderDetailId, p.productCode, p.productNameEn, od.amount, 0L, od.amount, od.productUnitId, od.price, od.productBuyerGroupId)");
        sb.append(" FROM    OrdDetail od,    Product p ");
        sb.append(" WHERE od.productId = p.productId");
        sb.append(" and od.orderId in ( :orderId) ");
        sb.append(" order by od.orderId, p.productCode");

        return sessionFactory.getCurrentSession().createQuery(sb.toString()).setParameterList("orderId", ordersId).list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<OrdDetail> findByOrderId(long orderId) {
        return sessionFactory.getCurrentSession().createCriteria(OrdDetail.class).add(Restrictions.eq("orderId", orderId)).list();
    }

    @SuppressWarnings("rawtypes")
    @Override
    public List<SearchOrderDetailReportResult> findOrderDetailByOrderId(long orderId) {
        String stringQuery = "SELECT ord_detail.order_detail_id "; // 0
        stringQuery += "		, orders.order_id "; // 1
        stringQuery += "		, orders.order_code "; // 2
        stringQuery += "		, product.product_id "; // 3
        stringQuery += "		, product.product_code "; // 4
        stringQuery += "		, product.product_name_en "; // 5
        stringQuery += "		, cust.cust_code "; // 6
        stringQuery += "		, cust.name_en "; // 7
        stringQuery += "		, ord_detail.amount ";// 8
        stringQuery += "		, ord_detail.status ";// 9
        stringQuery += "		, ord_detail.price ";// 10
        stringQuery += "		, ord_detail.product_unit_id ";// 11
        stringQuery += "		, ord_detail.product_buyer_group_id ";// 12
        stringQuery += "		, ord_detail.product_currency ";// 13
        stringQuery += "		, orders.payment_term_id ";// 14
        stringQuery += "		, ord_detail.user_create ";// 15
        stringQuery += "		, ord_detail.user_update ";// 16
        stringQuery += "		, ord_detail.time_create ";// 17
        stringQuery += "		, ord_detail.time_update ";// 18
        stringQuery += "    	, product_category.product_category_id ";// 19
        stringQuery += "		, product_so_category.so_category ";// 20
        stringQuery += "		, product_so_category.sale_order_cat ";// 21
        stringQuery += "		, product_so_category.site ";// 22
        stringQuery += "		, product_so_category.warehouse ";// 23
        stringQuery += "FROM 	ord_detail ";
        stringQuery += "		LEFT JOIN orders ON ";
        stringQuery += "			ord_detail.order_id = orders.order_id ";
        stringQuery += "		LEFT JOIN product ON ";
        stringQuery += "			ord_detail.product_id = product.product_id ";
        stringQuery += "		LEFT JOIN cust ON ";
        stringQuery += "			orders.cust_id = cust.cust_id ";
        stringQuery += "		LEFT JOIN product_category ON ";
        stringQuery += "			product.product_category_id = product_category.product_category_id ";
        stringQuery += "		LEFT JOIN product_so_category ON ";
        stringQuery += "			product.so_category = product_so_category.so_category ";
        stringQuery += "WHERE orders.order_id = :orderId ";
        stringQuery += "ORDER BY order_detail_id ";

        List results = sessionFactory.getCurrentSession().createSQLQuery(stringQuery).setLong("orderId", orderId).list();

        ArrayList<SearchOrderDetailReportResult> orderDetails = new ArrayList<>();
        for (Iterator iter = results.iterator(); iter.hasNext();) {
            Object[] objects = (Object[]) iter.next();
            SearchOrderDetailReportResult detail = new SearchOrderDetailReportResult();
            detail.setOrderDetailId(((BigInteger) objects[0]).longValue());

            if (objects[1] != null) {
                detail.setOrderId(((BigInteger) objects[1]).longValue());
            }
            detail.setOrderCode((String) objects[2]);

            if (objects[3] != null) {
                detail.setProductId(((BigInteger) objects[3]).longValue());
            }
            detail.setProductCode((String) objects[4]);
            detail.setProductNameEn((String) objects[5]);
            detail.setCustCode((String) objects[6]);
            detail.setNameEn((String) objects[7]);

            if (objects[8] != null) {
                detail.setAmount(((BigInteger) objects[8]).longValue());
            }

            if (objects[9] != null) {
                detail.setStatus(((BigInteger) objects[9]).longValue());
            }
            detail.setPrice((BigDecimal) objects[10]);
            detail.setProductUnitId((String) objects[11]);
            detail.setProductBuyerGroupId((String) objects[12]);
            detail.setProductCurrency((String) objects[13]);
            detail.setPaymentTermId((String) objects[14]);
            detail.setUserCreate((String) objects[15]);
            detail.setUserUpdate((String) objects[16]);
            detail.setTimeCreate((Date) objects[17]);
            detail.setTimeUpdate((Date) objects[18]);
            detail.setProductCategoryId((String) objects[19]);
            detail.setSoCategory((String) objects[20]);
            detail.setSaleOrderCat((String) objects[21]);
            detail.setSite((String) objects[22]);
            detail.setWarehouse((String) objects[23]);

            orderDetails.add(detail);
        }

        orderDetails.trimToSize();
        return orderDetails;
    }
}
