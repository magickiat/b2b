package com.starboard.b2b.service;

import java.util.List;

import com.starboard.b2b.dto.CountryDTO;

public interface CountryService {

	List<CountryDTO> findAll();

}