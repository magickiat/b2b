package com.starboard.b2b.dao.impl;

import org.hibernate.LockMode;
import org.hibernate.LockOptions;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.starboard.b2b.dao.OrdersIdRunningDao;
import com.starboard.b2b.model.OrdersIdRunning;

@Repository("ordersIdRunningDao")
public class OrdersIdRunningDaoImpl implements OrdersIdRunningDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public long generateRunning(int year) {
		Session session = sessionFactory.getCurrentSession();
		OrdersIdRunning runningNo = (OrdersIdRunning) session.get(OrdersIdRunning.class, year, new LockOptions(LockMode.PESSIMISTIC_WRITE));
		if (runningNo == null) {
			runningNo = new OrdersIdRunning(year, 0);
			session.save(runningNo);
		}

		runningNo.setRunningNo(runningNo.getRunningNo() + 1);

		return runningNo.getRunningNo();
	}
}
