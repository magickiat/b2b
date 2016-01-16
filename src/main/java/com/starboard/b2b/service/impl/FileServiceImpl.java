package com.starboard.b2b.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.starboard.b2b.common.B2BFileType;
import com.starboard.b2b.dao.ProductDao;
import com.starboard.b2b.exception.B2BException;
import com.starboard.b2b.model.Product;
import com.starboard.b2b.service.FileService;
import com.starboard.b2b.service.ProductService;
import com.starboard.b2b.util.ArchiveUtil;

@Service("fileService")
@PropertySource(value = "classpath:application-${spring.profiles.active}.properties")
public class FileServiceImpl implements FileService {
	private static final Logger log = LoggerFactory.getLogger(FileServiceImpl.class);

	@Autowired
	private Environment environment;

	@Autowired
	private ProductDao productDao;

	private String uploadPath;
	private String defaultImageFileType = ".jpg";
	private File tempFolder;

	private HashMap<B2BFileType, String> rootPath = new HashMap<>();

	@PostConstruct
	public void init() {
		uploadPath = environment.getProperty("upload.path");
		if (uploadPath == null) {
			throw new B2BException("Not found upload path");
		}

		rootPath.put(B2BFileType.PRODUCT_IMAGE, uploadPath + File.separator + "product_image" + File.separator + "big" + File.separator);

		// ----- create temp folder -----
		tempFolder = new File(uploadPath, "temp");
		if (!tempFolder.exists() || !tempFolder.isDirectory()) {
			tempFolder.mkdirs();
		}
	}

	@Override
	@Transactional(readOnly = true)
	public byte[] downloadProductImage(long productBrandGroup, String productTypeName) throws Exception {
		Set<String> files = new HashSet<>();
		List<Product> productCodeList = productDao.findByBrandGroupId(productBrandGroup);
		if (productCodeList == null || productCodeList.isEmpty()) {
			return new byte[0];
		} else {
			for (Product product : productCodeList) {
				String filename = String.format("%s%s%s", rootPath.get(B2BFileType.PRODUCT_IMAGE), product.getProductCode(), defaultImageFileType);
				files.add(filename);
			}
		}

		log.info("found : " + files.size());
		ArrayList<String> list = new ArrayList<>(files);
		return ArchiveUtil.zip(list);

	}

	@Override
	public File[] listAll(B2BFileType type) {
		return new File(rootPath.get(type)).listFiles();
	}

	@Override
	public File getProductImage(String productCode) {
		return new File(rootPath.get(B2BFileType.PRODUCT_IMAGE), productCode + defaultImageFileType);
	}

}
