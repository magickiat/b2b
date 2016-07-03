package com.starboard.b2b.dao;

import java.util.List;

import com.starboard.b2b.dto.ProductPriceDTO;
import com.starboard.b2b.model.ProductPrice;
import com.starboard.b2b.model.ProductPriceId;
import com.starboard.b2b.model.User;

public interface ProductPriceDao {

	void save(ProductPrice price);

	ProductPriceDTO findProductPrice(String productCode, Long productTypeId, User user);

	ProductPrice findById(ProductPriceId id);

	ProductPriceDTO findProductPriceWithPriceGroup(String productCode, String productBuyerGroupId, String productPreintro);

	List<ProductPriceDTO> list();

}