package com.starboard.b2b.dao;

import com.starboard.b2b.dto.ProductPriceDTO;
import com.starboard.b2b.model.ProductPrice;
import com.starboard.b2b.model.ProductPriceId;

public interface ProductPriceDao {

	void save(ProductPrice price);

	ProductPriceDTO findProductPrice(String productCode, String custInvoiceCode, String preIntro);

	ProductPrice findById(ProductPriceId id);

}