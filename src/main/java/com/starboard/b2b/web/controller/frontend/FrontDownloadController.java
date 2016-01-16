package com.starboard.b2b.web.controller.frontend;

import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.starboard.b2b.dto.ProductTypeDTO;
import com.starboard.b2b.service.FileService;
import com.starboard.b2b.service.ProductService;

@Controller
@RequestMapping("/frontend/download")
public class FrontDownloadController {

	private static final Logger log = LoggerFactory.getLogger(FrontDownloadController.class);

	@Autowired
	private ProductService productService;

	@Autowired
	private FileService fileService;

	@RequestMapping("/index")
	String index(Model model) {
		return "pages-front/download/index";
	}

	@RequestMapping("/list-brand")
	@ResponseBody
	List<ProductTypeDTO> listBrand() {
		return productService.listProductBrandGroupForJson();
	}

	@RequestMapping(value = "/product-image/{productBrandGroup}")
	String downloadImage(@PathVariable long productBrandGroup, HttpServletRequest request, HttpServletResponse response) throws Exception {
		byte[] zipImage = new byte[0];
		String filename = "not_found_brand";
		ProductTypeDTO productType = productService.getProductType(productBrandGroup);
		if (productType != null) {
			zipImage = fileService.downloadProductImage(productBrandGroup, productType.getProductTypeName());
			filename = productType.getProductTypeName();
		} else {
			return "/pages-front/download/not_found";
		}

		log.info("product: " + filename);
		log.info("zip size: " + zipImage);
		if(zipImage.length == 0){
			return "/pages-front/download/not_found";
		}

		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", String.format("attachment; filename=%s.zip", filename));
		try (OutputStream output = response.getOutputStream()) {
			output.write(zipImage);
		}

		return null;
	}
}
