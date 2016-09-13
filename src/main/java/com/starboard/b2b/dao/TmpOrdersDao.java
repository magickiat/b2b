package com.starboard.b2b.dao;

import com.starboard.b2b.model.TmpOrders;

public interface TmpOrdersDao {

    TmpOrders findBySoId(final long soId);

    void remove(final long soId);

	void save(TmpOrders tmpOrders);
}
