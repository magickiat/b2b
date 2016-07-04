package com.starboard.b2b.dao;

import java.util.List;

import com.starboard.b2b.dto.SoDTO;
import com.starboard.b2b.model.sync.So;
import com.starboard.b2b.model.sync.SoDetail;

public interface SoDao {

	List<SoDTO> findByOrderId(long orderId);

	So findBySoNo(String soNo);

	void save(So so);

	/**
	 * Find So by so no
	 * 
	 * @param soId
	 *            so id
	 * @return So object
	 */
	So findSoById(final long soId);

	/**
	 * Find So detail by so no
	 * 
	 * @param soId
	 *            so id
	 * @return So detail object
	 */
	List<SoDetail> findSoDetailBySoId(final long soId);

}