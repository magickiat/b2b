package com.starboard.b2b.web.controller.frontend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.starboard.b2b.dto.ProductTypeDTO;
import com.starboard.b2b.service.ProductService;

@Controller
@RequestMapping("/frontend/download")
public class FrontDownloadController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping("/index")
	String index(Model model){
		return "pages-front/download/index";
	}
	
	@RequestMapping("/list-brand")
	@ResponseBody List<ProductTypeDTO> listBrand(){
		return productService.listProductBrandGroupForJson();
	}
}
