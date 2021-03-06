package com.starboard.b2b.dao;

import com.starboard.b2b.model.TmpSo;

import java.util.List;

public interface TmpSoDao {

    void save(TmpSo tmpSo);

    TmpSo findBySoId(final long soId);

    void remove(final long soId);

    List<TmpSo> list();

    void removeAll();
}
