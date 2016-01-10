package com.starboard.b2b.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;

import com.starboard.b2b.config.WebConfig;
import com.starboard.b2b.dto.search.SearchRequest;
import com.starboard.b2b.dto.search.SearchProductModelDTO;
import com.starboard.b2b.dto.search.SearchResult;
import com.starboard.b2b.web.form.product.SearchProductForm;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = WebConfig.class, loader = AnnotationConfigWebContextLoader.class)
public class ProductDaoImplTest {

	@Autowired
	private ProductDao productDao;

	@Test
	public void testDefaultSearch() {
		SearchProductForm form = new SearchProductForm();
		form.setShowType("image");
		form.setPage(1);
		form.setBrandId(10);

		SearchRequest<SearchProductForm> req = new SearchRequest<>(form.getPage(), 12);
		req.setCondition(form);

		SearchResult<SearchProductModelDTO> search = productDao.search(req);
		assertNotNull(search.getResult());
		assertTrue(search.getResult().size() == 12);

		
	}

	
	@Test
	public void testSelectedBrandSearch() {
		SearchProductForm form = new SearchProductForm();
		form.setShowType("image");
		form.setPage(1);
		form.setBrandId(10);
		form.setSelectedBrand("10");
		
		SearchRequest<SearchProductForm> req = new SearchRequest<>(form.getPage(), 12);
		req.setCondition(form);
		
		SearchResult<SearchProductModelDTO> search = productDao.search(req);
		
		assertNotNull(search.getResult());
		assertTrue(search.getResult().size() == 12);
	}
	
	@Test
	public void testKeywordSearch() {
		SearchProductForm form = new SearchProductForm();
		form.setShowType("image");
		form.setPage(1);
		form.setBrandId(10);

		form.setKeyword("all star");
		SearchRequest<SearchProductForm> req = new SearchRequest<>(form.getPage(), 12);
		req.setCondition(form);
		
		SearchResult<SearchProductModelDTO> search = productDao.search(req);
		
		assertNotNull(search.getResult());
		assertTrue(search.getResult().size() == 1);
	}
}
