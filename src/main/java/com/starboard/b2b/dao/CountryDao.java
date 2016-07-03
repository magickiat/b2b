package com.starboard.b2b.dao;

import java.util.List;

import com.starboard.b2b.dto.CountryDTO;

public interface CountryDao {

	List<CountryDTO> findAll();

}