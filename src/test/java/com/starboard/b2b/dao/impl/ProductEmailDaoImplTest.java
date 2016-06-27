package com.starboard.b2b.dao.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.starboard.b2b.config.ConfigForTest;
import com.starboard.b2b.config.EmailType;
import com.starboard.b2b.dao.ProductEmailDao;
import com.starboard.b2b.dao.ProductTypeDao;
import com.starboard.b2b.dto.ProductEmailDTO;
import com.starboard.b2b.model.ProductEmail;
import com.starboard.b2b.model.ProductType;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = { ConfigForTest.class })
@Transactional
public class ProductEmailDaoImplTest {

	@Autowired
	private ProductTypeDao productTypeDao;

	@Autowired
	private ProductEmailDao productEmailDao;

	@Test
	public void testFindByBrandGroupId() {
		ProductEmail e1 = new ProductEmail();
		e1.setBrandGroupId(1L);
		e1.setEmail("asdf");
		e1.setEmailType(EmailType.CC);
		productEmailDao.save(e1);

		List<ProductEmail> pe = productEmailDao.findByBrandGroupId(1L);
		assertNotNull(pe);
		assertEquals(1, pe.size());

		ProductEmail dto = pe.get(0);
		assertNotNull(dto);
		assertEquals("asdf", dto.getEmail());
	}

	@Test
	public void testFindAll() {
		ProductType pt = new ProductType();
		pt.setProductTypeId(1);
		pt.setProductTypeName("pt");
		productTypeDao.save(pt);

		ProductEmail e2 = new ProductEmail();
		e2.setBrandGroupId(1L);
		e2.setEmail("222");
		e2.setEmailType(EmailType.CC);
		productEmailDao.save(e2);

		
		ProductEmail e1 = new ProductEmail();
		e1.setBrandGroupId(1L);
		e1.setEmail("111");
		e1.setEmailType(EmailType.CC);
		productEmailDao.save(e1);

		List<ProductEmailDTO> list = productEmailDao.findAll();
		assertNotNull(list);
		assertEquals(2, list.size());
		ProductEmailDTO dto1 = list.get(0);
		ProductEmailDTO dto2 = list.get(1);
		assertEquals("111", dto1.getEmail());
		assertEquals("222", dto2.getEmail());
	}
}
