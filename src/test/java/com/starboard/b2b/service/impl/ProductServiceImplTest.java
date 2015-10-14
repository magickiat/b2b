package com.starboard.b2b.service.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;

import com.starboard.b2b.common.WithnoseConstant;
import com.starboard.b2b.config.WebConfig;
import com.starboard.b2b.dto.ProductSearchResult;
import com.starboard.b2b.service.ProductService;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = WebConfig.class, loader = AnnotationConfigWebContextLoader.class)
public class ProductServiceImplTest {

	@Autowired
	private ProductService productService;

	@Test
	public void testFindProductModelStringString() {
		List<ProductSearchResult> noWithnoseProducts = productService.findProductModel("ALLSTAR",
				WithnoseConstant.NO_WITHNOSE_PROTECTION);
		assertTrue(!noWithnoseProducts.isEmpty());
		assertTrue(noWithnoseProducts.size() == 15);
		
		// Check not Withnose Board
		String productBuyerGroupId = noWithnoseProducts.get(0).getProduct().getProductBuyerGroupId();
		assertNotNull(productBuyerGroupId);
		assertFalse("WB".equals(productBuyerGroupId));
		
		List<ProductSearchResult> withnoseProducts = productService.findProductModel("ALLSTAR",
				WithnoseConstant.WITHNOSE_PROTECTION);
		assertTrue(withnoseProducts.isEmpty());
	}

}
