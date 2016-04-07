package com.starboard.b2b.util;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.starboard.b2b.config.RootConfig;
import com.starboard.b2b.dto.ProductDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = { RootConfig.class })
public class OrderHelperTest {

	private ApplicationConfig applicationConfig;
	private OrderHelper helper;

	@Before
	public void init() {
		helper = new OrderHelper();
		helper.setConfig(applicationConfig);
	}

	@Test
	public void testNull() {
		HashMap<String, List<ProductDTO>> products = helper.groupProductByCurrency(null);
		assertTrue(products.isEmpty());
	}

	@Test
	public void testMultipleCurrency() {
		Long brandGroup1 = 1L;
		ProductDTO p1 = new ProductDTO();
		p1.setProductCode("p1");
		p1.setProductTypeId(brandGroup1);
		p1.setProductCurrency("USD");

		ProductDTO p2 = new ProductDTO();
		p2.setProductCode("p2");
		p2.setProductTypeId(brandGroup1);
		p2.setProductCurrency("EUR");

		Map<Long, ProductDTO> cart = new HashMap<>();
		cart.put(1L, p1);
		cart.put(2L, p2);

		HashMap<String, List<ProductDTO>> productGroup = helper.groupProductByCurrency(cart);
		assertFalse(productGroup.isEmpty());
		assertTrue(productGroup.size() == 2);

	}

	@Test
	public void testMultipleCurrencyWithTBA() {
		Long brandGroup1 = 1L;
		ProductDTO p1 = new ProductDTO();
		p1.setProductCode("p1");
		p1.setProductTypeId(brandGroup1);
		p1.setProductCurrency("USD");

		ProductDTO p2 = new ProductDTO();
		p2.setProductCode("p2");
		p2.setProductTypeId(brandGroup1);
		p2.setProductCurrency("EUR");

		ProductDTO p3 = new ProductDTO();
		p3.setProductCode("p3");
		p3.setProductTypeId(brandGroup1);
		p3.setProductCurrency(null);

		Map<Long, ProductDTO> cart = new HashMap<>();
		cart.put(1L, p1);
		cart.put(2L, p2);
		cart.put(3L, p3);

		HashMap<String, List<ProductDTO>> productGroup = helper.groupProductByCurrency(cart);
		assertFalse(productGroup.isEmpty());
		assertTrue(productGroup.size() == 2);
		
		Set<Entry<String,List<ProductDTO>>> entrySet = productGroup.entrySet();
		for (Entry<String, List<ProductDTO>> entry : entrySet) {
			String key = entry.getKey();
			List<ProductDTO> value = entry.getValue();
			for (ProductDTO product : value) {
				assertEquals(key, product.getProductCurrency());
			}
		}

	}

	public ApplicationConfig getApplicationConfig() {
		return applicationConfig;
	}

	@Autowired
	public void setApplicationConfig(ApplicationConfig applicationConfig) {
		this.applicationConfig = applicationConfig;
	}

}
