package com.starboard.b2b.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
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

import com.starboard.b2b.common.B2BConstant;
import com.starboard.b2b.config.SecurityConfig;
import com.starboard.b2b.config.WebConfig;
import com.starboard.b2b.dto.ProductSearchResult;
import com.starboard.b2b.dto.ProductTypeDTO;
import com.starboard.b2b.service.ProductService;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SecurityConfig.class, WebConfig.class}, loader = AnnotationConfigWebContextLoader.class)
public class ProductServiceImplTest {

	private static final Logger log = LoggerFactory.getLogger(ProductServiceImplTest.class);

	@Autowired
	private ProductService productService;

	@Test
	public void testFindProductModelStringString() {
		List<ProductSearchResult> noWithnoseProducts = productService.findProductModel("ALLSTAR", B2BConstant.NO_WITHNOSE_PROTECTION);
		assertTrue(!noWithnoseProducts.isEmpty());
		assertTrue(noWithnoseProducts.size() == 15);

		// Check not Withnose Board
		String productBuyerGroupId = noWithnoseProducts.get(0).getProduct().getProductBuyerGroupId();
		assertNotNull(productBuyerGroupId);
		assertFalse("WB".equals(productBuyerGroupId));

		List<ProductSearchResult> withnoseProducts = productService.findProductModel("ALLSTAR", B2BConstant.WITHNOSE_PROTECTION);
		assertTrue(withnoseProducts.isEmpty());
	}

	@Test
	public void testGroupProductByTechnology() {
		final int expectedProductFound = 18;

		List<ProductSearchResult> noWithnoseProducts = productService.findProductModel("20861500", B2BConstant.NO_WITHNOSE_PROTECTION);
		assertTrue(!noWithnoseProducts.isEmpty());
		assertTrue(noWithnoseProducts.size() == expectedProductFound);

		HashMap<String, List<ProductSearchResult>> byTechnology = productService.groupProductByTechnology(noWithnoseProducts);

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

	@Test
	public void testGetProductTypes() {
		final long customerId = 1001L;
		final long brandGroupId = 10L;
		List<ProductTypeDTO> types = productService.getProductTypes(customerId, brandGroupId);
		for (ProductTypeDTO type : types) {
			System.out.println(type.getProductTypeName());
		}
	}
	
	@Test
	public void testDownloadProductImage(){
		
	}
}
