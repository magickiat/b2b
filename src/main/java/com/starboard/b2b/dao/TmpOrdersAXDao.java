package com.starboard.b2b.dao;

import com.starboard.b2b.model.TmpOrdersFromAx;

import java.util.List;

public interface TmpOrdersAXDao {
    List<TmpOrdersFromAx> list();

    void removeAll();

    void save(TmpOrdersFromAx tmpOrdersFromAx);
}
