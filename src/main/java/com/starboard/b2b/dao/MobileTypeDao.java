package com.starboard.b2b.dao;

import java.util.List;

import com.starboard.b2b.dto.MobileTypeDTO;

public interface MobileTypeDao {
	
	List<MobileTypeDTO> findAll();
	
}
