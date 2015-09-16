package com.starboard.b2b.service;

import java.util.List;

import com.starboard.b2b.common.Page;
import com.starboard.b2b.dto.ProductDTO;

public interface ProductService {

	List<ProductDTO> list(Integer brandId) throws Exception;

	List<ProductDTO> list(Integer brandId, Page page) throws Exception;

}