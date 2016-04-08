package com.starboard.b2b.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.starboard.b2b.config.ConfigForTest;
import com.starboard.b2b.dto.search.SearchProductModelDTO;
import com.starboard.b2b.dto.search.SearchRequest;
import com.starboard.b2b.dto.search.SearchResult;
import com.starboard.b2b.model.Product;
import com.starboard.b2b.web.form.product.SearchProductForm;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = { ConfigForTest.class })
@Transactional
public class ProductDaoImplTest {

	private static final Logger log = LoggerFactory.getLogger(ProductDaoImplTest.class);

	@Autowired
	private ProductDao productDao;

	private long custId = 1001;
	
	@Test
	public void test() {
		final String code = "asdf";
		Product product = new Product();
		product.setProductCode(code);
		productDao.save(product);

		List<Product> products = productDao.list();
		assertNotNull(products);
		log.info("Product size: " + products.size());
		assertFalse(products.isEmpty());
		assertTrue(code.equals(products.get(0).getProductCode()));
	}

	@Test
	public void testDefaultSearch() {

		Product product1 = new Product();
		product1.setProductCode("001");
		product1.setProductTypeId(10L);
		productDao.save(product1);
		
		Product product2 = new Product();
		product2.setProductCode("002");
		product2.setProductTypeId(50L);
		productDao.save(product2);
		
		List<Product> products = productDao.list();
		assertNotNull(products);
		log.info("Product size: " + products.size());
		assertEquals(2, products.size());

		SearchProductForm form = new SearchProductForm();
		form.setShowType("image");
		form.setPage(1);
		form.setBrandId(10);

		SearchRequest<SearchProductForm> req = new SearchRequest<>(form.getPage(), 12);
		req.setCondition(form);

		SearchResult<SearchProductModelDTO> search = productDao.searchProductForFrontend(req, custId);
		assertNotNull(search.getResult());
//		assertTrue(search.getResult().size() == 1);

	}

	// @Test
	public void testSelectedBrandSearch() {
		SearchProductForm form = new SearchProductForm();
		form.setShowType("image");
		form.setPage(1);
		form.setBrandId(10);
		form.setSelectedBrand("10");

		SearchRequest<SearchProductForm> req = new SearchRequest<>(form.getPage(), 12);
		req.setCondition(form);

		SearchResult<SearchProductModelDTO> search = productDao.searchProductForFrontend(req, custId);

		assertNotNull(search.getResult());
		assertTrue(search.getResult().size() == 12);
	}

	// @Test
	public void testKeywordSearch() {
		SearchProductForm form = new SearchProductForm();
		form.setShowType("image");
		form.setPage(1);
		form.setBrandId(10);

		form.setKeyword("all star");
		SearchRequest<SearchProductForm> req = new SearchRequest<>(form.getPage(), 12);
		req.setCondition(form);

		SearchResult<SearchProductModelDTO> search = productDao.searchProductForFrontend(req, custId);

		assertNotNull(search.getResult());
		assertTrue(search.getResult().size() == 1);
	}
}
