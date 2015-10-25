package com.starboard.b2b.dao;

import com.starboard.b2b.dto.ProductPriceDTO;

public interface ProductPriceDao {

	ProductPriceDTO findProductPrice(String productCode, String custInvoiceCode);

}