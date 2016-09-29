package com.starboard.b2b.dao;

import com.starboard.b2b.model.TmpOrdDetailFromAx;

import java.util.List;

public interface TmpOrdDetailAXDao {

    List<TmpOrdDetailFromAx> list();

    void removeAll();

    void save(TmpOrdDetailFromAx ordAddressFromAx);

    List<String> findOrderCodes();
}
