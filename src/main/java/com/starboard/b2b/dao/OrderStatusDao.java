package com.starboard.b2b.dao;

import com.starboard.b2b.model.OrderStatus;

import java.util.List;

/**
 * Created by User: Thanakit Jumparuang (jthanakit.dev@gmail.com) Date: 11/21/2015 Time: 08:52
 */
public interface OrderStatusDao {
    List<OrderStatus> findAll();
}
