package com.starboard.b2b.dao;

import java.util.List;

import com.starboard.b2b.dto.SoDTO;
import com.starboard.b2b.model.SoDetail;

public interface SoDao {

	List<SoDTO> findByOrderId(long orderId);

	List<SoDetail> findByOrderDetailId(long orderDetailId);

}