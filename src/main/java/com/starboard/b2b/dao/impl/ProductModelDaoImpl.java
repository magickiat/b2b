package com.starboard.b2b.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.starboard.b2b.dao.ProductModelDao;
import com.starboard.b2b.dto.ProductModelDTO;

@Repository("productModelDao")
public class ProductModelDaoImpl implements ProductModelDao {

	@Autowired
	private SessionFactory sf;

	@Override
	@SuppressWarnings("unchecked")
	public List<ProductModelDTO> findAll() {
		StringBuffer sb = new StringBuffer();
		sb.append(
				" select new com.starboard.b2b.dto.ProductModelDTO(p.productModelId,p.productModelName,p.description,p.image,p.headerText1,p.headerText2) ");
		sb.append(" from ProductModel p order by p.productModelId ");
		return sf.getCurrentSession().createQuery(sb.toString()).list();
	}
}
