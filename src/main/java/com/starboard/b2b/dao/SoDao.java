package com.starboard.b2b.dao;

import java.util.List;

import com.starboard.b2b.dto.SoDTO;

public interface SoDao {

	List<SoDTO> findByOrderId(long orderId);

}