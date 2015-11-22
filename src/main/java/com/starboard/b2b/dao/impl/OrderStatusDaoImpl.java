package com.starboard.b2b.dao.impl;

import com.starboard.b2b.dao.OrderStatusDao;
import com.starboard.b2b.model.OrderStatus;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User: Thanakit Jumparuang (jthanakit.dev@gmail.com) Date: 11/21/2015 Time: 08:55
 */
@Repository("orderStatusDao")
public class OrderStatusDaoImpl implements OrderStatusDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<OrderStatus> findAll() {
        final List<OrderStatus> orderStatuses = new ArrayList<>();
        for(Object returnObject : sessionFactory.getCurrentSession().createQuery("SELECT o FROM OrderStatus o").list()){
            orderStatuses.add((OrderStatus) returnObject);
        }
        return orderStatuses;
    }
}
