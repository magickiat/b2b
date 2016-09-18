package com.starboard.b2b.dao;

import com.starboard.b2b.model.TmpProduct;

import java.util.List;

public interface TmpProductDao {

	List<TmpProduct> list();

	void removeAll();

	void save(TmpProduct tmpProduct);
}
