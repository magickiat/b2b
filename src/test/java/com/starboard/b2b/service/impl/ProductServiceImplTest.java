package com.starboard.b2b.service.impl;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	private static final Logger log = LoggerFactory.getLogger(ProductServiceImplTest.class);

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

	@Test
	public void testGroupProductByTechnology() {
		final int expectedProductFound = 18;

		List<ProductSearchResult> noWithnoseProducts = productService.findProductModel("20861500",
				WithnoseConstant.NO_WITHNOSE_PROTECTION);
		assertTrue(!noWithnoseProducts.isEmpty());
		assertTrue(noWithnoseProducts.size() == expectedProductFound);

		HashMap<String, List<ProductSearchResult>> byTechnology = productService
				.groupProductByTechnology(noWithnoseProducts);

		assertEquals(4, byTechnology.size());
		assertTrue(byTechnology.containsKey("2PCSADJ"));
		assertTrue(byTechnology.containsKey("3PCSADJ"));
		assertTrue(byTechnology.containsKey("OVAL"));
		assertTrue(byTechnology.containsKey("ROUND"));
		
		
		
		Set<Entry<String, List<ProductSearchResult>>> entrySet = byTechnology.entrySet();

		int found = 0;
		for (Entry<String, List<ProductSearchResult>> entry : entrySet) {
			found += entry.getValue().size();
		}
		assertEquals(expectedProductFound, found);

		HashMap<String, ProductSearchResult> productLength = productService.findProductLength(noWithnoseProducts);
		assertEquals(5, productLength.size());
		assertTrue(productLength.containsKey("S"));
		assertTrue(productLength.containsKey("M"));
		assertTrue(productLength.containsKey("L"));
		assertTrue(productLength.containsKey("XS"));
		assertTrue(productLength.containsKey("XL"));

	}

}