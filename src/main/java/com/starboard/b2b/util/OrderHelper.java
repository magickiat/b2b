package com.starboard.b2b.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.starboard.b2b.dto.ProductDTO;
import com.starboard.b2b.exception.B2BException;

public class OrderHelper {

	private static final Logger log = LoggerFactory.getLogger(OrderHelper.class);

	private ApplicationConfig config;

	public HashMap<String, List<ProductDTO>> groupProductByCurrency(Map<Long, ProductDTO> cart) {
		if(config == null){
			throw new B2BException("Config is required");
		}
		
		HashMap<String, List<ProductDTO>> productGroup = new HashMap<>();

		if (cart != null && !cart.isEmpty()) {
			Iterator<Entry<Long, ProductDTO>> iterator = cart.entrySet().iterator();
			while (iterator.hasNext()) {
				Entry<Long, ProductDTO> item = iterator.next();
				ProductDTO product = item.getValue();

				if (StringUtils.isEmpty(product.getProductCurrency())) {
					product.setProductCurrency(config.getDefaultCurrencyForOrder());
				}

				String currency = product.getProductCurrency().toUpperCase();
				log.info("Product: " + product.getProductCode() + "Currency: " + currency);

				List<ProductDTO> productList = productGroup.get(currency);
				if (productList == null) {
					productList = new ArrayList<>();
					productGroup.put(currency, productList);
				}

				productList.add(product);
			}

		}
		return productGroup;
	}

	public void setConfig(ApplicationConfig config) {
		this.config = config;
	}
}
