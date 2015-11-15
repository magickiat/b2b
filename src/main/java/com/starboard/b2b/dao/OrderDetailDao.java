package com.starboard.b2b.dao;

import java.io.Serializable;

import com.starboard.b2b.model.OrdDetail;

public interface OrderDetailDao {

	Serializable save(OrdDetail detail);

}