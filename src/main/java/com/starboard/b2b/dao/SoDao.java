package com.starboard.b2b.dao;

import java.util.List;

import com.starboard.b2b.dto.SoDTO;
import com.starboard.b2b.model.sync.So;

public interface SoDao {

	List<SoDTO> findByOrderId(long orderId);

	void save(So so);

}