package com.starboard.b2b.web.controller.backend;

import java.io.ByteArrayOutputStream;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.starboard.b2b.common.Page;
import com.starboard.b2b.dto.ProductBuyerGroupDTO;
import com.starboard.b2b.dto.ProductDTO;
import com.starboard.b2b.dto.ProductPriceDTO;
import com.starboard.b2b.dto.ProductTypeDTO;
import com.starboard.b2b.dto.search.SearchProductModelDTO;
import com.starboard.b2b.exception.B2BException;
import com.starboard.b2b.service.ProductService;
import com.starboard.b2b.util.B2BFileUtil;
import com.starboard.b2b.util.ExcelUtil;
import com.starboard.b2b.web.form.product.SearchProductForm;

@Controller
@RequestMapping("/backend/product")
public class BackendProductController {

	private static final Logger log = LoggerFactory.getLogger(BackendProductController.class);

	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	String index(Model model) {
		return search(new SearchProductForm(), model);
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	String deleteProduct(@ModelAttribute("productId") long productId, Model model) {
		boolean delete = productService.delete(productId);
		if (!delete) {
			model.addAttribute("msg", "Cannot delete");
		}

		return search(new SearchProductForm(), model);
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	String search(@ModelAttribute("searchForm") SearchProductForm searchForm, Model model) {

		List<ProductTypeDTO> productTypes = productService.findAllProductType();
		model.addAttribute("productType", productTypes);

		// when all product type, find with relate product type
		List<ProductBuyerGroupDTO> productBuyerGroups;
		if (StringUtils.isNotEmpty(searchForm.getSelectedBrand())) {
			Long brandId = new Long(searchForm.getSelectedBrand());
			productBuyerGroups = productService.findProductBuyerGroupByBrandId(brandId);
		} else {
			productBuyerGroups = productService.findProductBuyerGroupByProductType(productTypes);
		}

		model.addAttribute("productBuyerGroup", productBuyerGroups);
		model.addAttribute("productModel", productService.findAllProductModel());
		model.addAttribute("productYear", productService.findAllProductYear());
		model.addAttribute("productTechnology", productService.findAllProductTechnology());

		model.addAttribute("searchForm", searchForm);

		Page<SearchProductModelDTO> searchProduct = productService.searchProductBackend(searchForm);
		model.addAttribute("resultPage", searchProduct);
		model.addAttribute("searchForm", searchForm);
		return "pages-back/product/index";
	}

	@RequestMapping(value = "/download", method = RequestMethod.GET)
	String download(HttpServletRequest req, HttpServletResponse response) throws Exception{
		
		String filename = "product.xlsx";
		XSSFWorkbook workbook = B2BFileUtil.createExcelProduct(productService);
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ServletOutputStream os = response.getOutputStream();
		try{
			workbook.write(baos);
			workbook.close();
			
			// Set servlet response excel
			response.setContentLength(baos.size());
			response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
			response.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");
			response.setHeader("Cache-Control", "cache, must-revalidate");
	        response.setHeader("Pragma", "public");
			
			
			baos.writeTo(os);
			
		}catch(Exception e){
			log.error(e.toString(), e);
		} finally {
			os.flush();
			os.close();
			baos.close();
		}

		return null;
	}

	@RequestMapping(value = "/upload", method = RequestMethod.GET)
	String upload() {
		return "pages-back/product/upload/product";
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	String upload(@RequestParam("file") MultipartFile file, Model model) throws Exception {

		if (file.isEmpty()) {
			throw new B2BException("excel product file are not present in this request");
		}

		List<ProductDTO> uploadProducts = ExcelUtil.parseProduct(productService, file.getInputStream());

		if (uploadProducts == null || uploadProducts.isEmpty()) {
			throw new B2BException("Not found a product in this upload file");
		}

		log.info("uploadProducts size: " + uploadProducts.size());

		productService.updateProduct(uploadProducts);

		model.addAttribute("msg", "upload complete");
		return "pages-back/product/upload/product";
	}

	@RequestMapping(value = "/upload/product-price", method = RequestMethod.GET)
	String uploadProductPrice() {
		return "pages-back/product/upload/product-price";
	}

	@RequestMapping(value = "/upload/product-price", method = RequestMethod.POST)
	String uploadProductPrice(@RequestParam("file") MultipartFile file, Model model) throws Exception {

		if (file.isEmpty()) {
			throw new B2BException("excel product file are not present in this request");
		}

		List<ProductPriceDTO> uploadProductPrices = ExcelUtil.parseProductPrice(file.getInputStream());

		if (uploadProductPrices == null || uploadProductPrices.isEmpty()) {
			throw new B2BException("Product Price not found in this upload file");
		}

		log.info("uploadProducts size: " + uploadProductPrices.size());

		productService.updateProductPrice(uploadProductPrices);

		model.addAttribute("msg", "upload complete");
		return "pages-back/product/upload/product-price";
	}

}
