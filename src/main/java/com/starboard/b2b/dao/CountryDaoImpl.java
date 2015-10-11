package com.starboard.b2b.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.starboard.b2b.dto.CountryDTO;

@Repository("countryDao")
public class CountryDaoImpl implements CountryDao {
	@Autowired
	private SessionFactory sf;

	@Override
	@SuppressWarnings("unchecked")
	public List<CountryDTO> findAll() {
		return sf.getCurrentSession()
				.createQuery("select new com.starboard.b2b.dto.CountryDTO(c.countryCode, c.countryName) from Country c")
				.list();
	}
}
