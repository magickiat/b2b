package com.starboard.b2b.service;

import java.io.File;

import com.starboard.b2b.common.B2BFileType;
import com.starboard.b2b.dto.ProductTypeDTO;

public interface FileService {

	File[] listAll(B2BFileType type);

	File getProductImage(String productCode);

	byte[] downloadProductImage(long productBrandGroup, String productTypeName) throws Exception;

}