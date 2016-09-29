package com.starboard.b2b.dao;

import com.starboard.b2b.model.TmpAddrFromAx;

import java.util.List;

public interface TmpAddrAXDao {

    List<TmpAddrFromAx> list();

    void removeAll();

    void save(TmpAddrFromAx tmpAddrFromAx);

    List<Long> findCustIds();
}
