package com.starboard.b2b.web.controller.backend;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.starboard.b2b.dto.ProductDTO;
import com.starboard.b2b.exception.B2BException;
import com.starboard.b2b.service.ProductService;
import com.starboard.b2b.util.ExcelUtil;

@Controller
@RequestMapping("/backend/product")
public class BackendProductController {
	
	private static final Logger log = LoggerFactory.getLogger(BackendProductController.class);

	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/upload", method = RequestMethod.GET)
	String upload(Model model) {
		return "pages-back/product/upload";
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	String upload(@RequestParam("file") MultipartFile file, Model model) throws Exception {

		if (file.isEmpty()) {
			throw new B2BException("excel product file are not present in this request");
		}

		List<ProductDTO> uploadProducts = ExcelUtil.parseProduct(file.getInputStream());
		
		if (uploadProducts == null || uploadProducts.isEmpty()) {
			throw new B2BException("Product not not found in this upload file");
		}
		
		log.info("uploadProducts size: " + uploadProducts.size());

		productService.updateProduct(uploadProducts);

		model.addAttribute("msg", "upload complete");
		return "pages-back/product/upload";
	}

}
