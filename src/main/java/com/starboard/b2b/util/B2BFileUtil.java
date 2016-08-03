package com.starboard.b2b.util;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import com.starboard.b2b.common.B2BConstant;
import com.starboard.b2b.dto.B2BFile;
import com.starboard.b2b.dto.ProductPriceDTO;
import com.starboard.b2b.dto.ProductTypeDTO;
import com.starboard.b2b.dto.search.SearchOrderDTO;
import com.starboard.b2b.dto.search.SearchOrderDetailDTO;
import com.starboard.b2b.dto.search.SearchProductModelDTO;
import com.starboard.b2b.exception.B2BException;
import com.starboard.b2b.model.Product;
import com.starboard.b2b.service.OrderService;
import com.starboard.b2b.service.ProductService;

public class B2BFileUtil {

	private static final Logger log = LoggerFactory.getLogger(B2BFileUtil.class);

	public static List<B2BFile> list(String rootFolder, String path) {
		log.info("root: " + rootFolder);
		log.info("path: " + path);

		ArrayList<B2BFile> files = new ArrayList<>();

		File folder = new File(rootFolder);
		if (StringUtils.isNotEmpty(path)) {
			folder = new File(rootFolder, path);
		}
		if (folder.isFile()) {
			return files;
		}

		File[] listFiles = folder.listFiles(new FilenameFilter() {

			@Override
			public boolean accept(File dir, String name) {
				if (name.equalsIgnoreCase(".DS_Store") || name.contains(".db")) {
					return false;
				}
				return true;
			}
		});

		if (listFiles != null && listFiles.length > 0) {
			// ----- Sort -----
			Arrays.sort(listFiles);

			for (File file : listFiles) {
				B2BFile f = new B2BFile();
				f.setName(file.getName());
				f.setNameWithPath(file.getAbsolutePath().substring(rootFolder.length()));
				f.setFullPath(file.getAbsolutePath());
				f.setFolder(file.isDirectory());
				// f.setContentType(contentType); // Find content type before
				// set
				files.add(f);
			}
		}

		return files;
	}

	public static boolean isImage(String contentType) {
		return contentType.startsWith("image/");
	}

	public static void saveFileToLocalDisk(String root, String folder, MultipartFile uploadFile) throws IOException {
		File parent = new File(root, folder);
		if (!parent.exists() || !parent.isDirectory()) {
			parent.mkdirs();
		}

		if (parent.exists() && parent.isDirectory()) {
			File dest = new File(parent.getAbsolutePath(), uploadFile.getOriginalFilename());
			FileUtils.writeByteArrayToFile(dest, uploadFile.getBytes(), false);
		}
	}

	public static int delete(String root, String[] files) {
		int deleted = 0;

		if (files != null && files.length > 0) {
			for (String filename : files) {
				File file = new File(root, filename);
				if (file.exists() && file.delete()) {
					deleted++;
				}
			}
		}

		return deleted;
	}

	public static byte[] createExcelTemplateForOrder(ApplicationConfig config, Long brandGroupId, ProductService productService) throws IOException {
		log.info("Brand Group ID: " + brandGroupId);

		List<ProductTypeDTO> brands = productService.getProductTypes(UserUtil.getCurrentUser().getCustomer().getCustId(), brandGroupId);

		if (brands.size() == 0) {
			throw new B2BException("Not found any brand");
		}

		HashMap<String, HSSFWorkbook> excelMap = new HashMap<>();

		for (ProductTypeDTO brand : brands) {
			log.info("Brand: " + brand.getProductTypeName());
			HSSFWorkbook workbook = new HSSFWorkbook();
			HSSFSheet sheetProduct = workbook.createSheet("Products");
			HSSFRow rowHeader = sheetProduct.createRow(0);

			rowHeader.createCell(0).setCellValue("Description");
			rowHeader.createCell(1).setCellValue("Product Code");
			rowHeader.createCell(2).setCellValue("Unit");
			rowHeader.createCell(3).setCellValue("Qty");

			List<Product> products = productService.findProductByProductTypeId(brand.getProductTypeId());

			int countRow = 1;
			if (products.size() > 0) {
				for (int i = 0; i < products.size(); i++) {
					Product product = products.get(i);
					if(B2BConstant.PRODUCT_FLAG_ACTIVE.equals(product.getIsActive())){
						HSSFRow productRow = sheetProduct.createRow(countRow++);
						productRow.createCell(0).setCellValue(StringUtils.defaultIfEmpty(product.getProductNameEn(), ""));
						productRow.createCell(1).setCellValue(StringUtils.defaultIfEmpty(product.getProductCode(), ""));
						productRow.createCell(2).setCellValue(StringUtils.defaultIfEmpty(product.getProductUnitId(), config.getDefaultProductUnit()));
						productRow.createCell(3).setCellValue("");
					}
					
				}
			}

			sheetProduct.autoSizeColumn(0);
			sheetProduct.autoSizeColumn(1);
			sheetProduct.autoSizeColumn(2);
			sheetProduct.autoSizeColumn(3);

			excelMap.put(StringUtil.removeSpecialChar(brand.getProductTypeName().replaceAll(" ", "_")), workbook);
		}

		return ArchiveUtil.zipExcel(excelMap);
	}

	public static XSSFWorkbook createExcelProduct(ProductService productService) {
		XSSFWorkbook workbook = new XSSFWorkbook();
		// ----- Create header row sheet -----
		int headerIndex = 0;
		XSSFSheet productSheet = workbook.createSheet("product");
		XSSFRow rowHead = productSheet.createRow(headerIndex);
		rowHead.createCell(headerIndex++).setCellValue("product_type_id");
		rowHead.createCell(headerIndex++).setCellValue("product_code");
		rowHead.createCell(headerIndex++).setCellValue("product_name");
		rowHead.createCell(headerIndex++).setCellValue("product_buyer_group_id");
		rowHead.createCell(headerIndex++).setCellValue("product_model_id");
		rowHead.createCell(headerIndex++).setCellValue("product_technology_id");
		rowHead.createCell(headerIndex++).setCellValue("size");
		rowHead.createCell(headerIndex++).setCellValue("active");
		rowHead.createCell(headerIndex++).setCellValue("PRIMARYVENDORID");
		rowHead.createCell(headerIndex++).setCellValue("category");
		rowHead.createCell(headerIndex++).setCellValue("excel_sheet");

		List<SearchProductModelDTO> searchProduct = productService.findAllProduct();
		if (searchProduct != null && !searchProduct.isEmpty()) {
			int row = 1;
			for (SearchProductModelDTO product : searchProduct) {
				int detailIndex = 0;
				XSSFRow detailRow = productSheet.createRow(row++);
				detailRow.createCell(detailIndex++).setCellValue(product.getProductTypeId());
				detailRow.createCell(detailIndex++).setCellValue(product.getProductCode());
				detailRow.createCell(detailIndex++).setCellValue(product.getProductNameEn());
				detailRow.createCell(detailIndex++).setCellValue(product.getProductBuyerGroupId());
				detailRow.createCell(detailIndex++).setCellValue(Long.valueOf(product.getYear()));
				detailRow.createCell(detailIndex++).setCellValue(product.getProductTechnologyId());
				detailRow.createCell(detailIndex++).setCellValue(product.getProductLength());
				detailRow.createCell(detailIndex++).setCellValue(Long.parseLong(product.getStatusFlag()));
				detailRow.createCell(detailIndex++).setCellValue(product.getVendor());
				detailRow.createCell(detailIndex++).setCellValue(product.getProductModelId());
				detailRow.createCell(detailIndex++).setCellValue("");
			}
		}

		// ----- resize column -----
		for(int i = 0; i < headerIndex; i++){
			productSheet.autoSizeColumn(i);
		}

		return workbook;
	}

	public static XSSFWorkbook createExcelOrder(Long[] orderId, OrderService orderService) {
		XSSFWorkbook workbook = new XSSFWorkbook();
		// ----- Create header row sheet "order" -----
		XSSFSheet sheetOrder = workbook.createSheet("order");
		XSSFRow rowHeadOrder = sheetOrder.createRow(0);
		rowHeadOrder.createCell(0).setCellValue("Request ID");
		rowHeadOrder.createCell(1).setCellValue("Customer");
		rowHeadOrder.createCell(2).setCellValue("Brand");
		rowHeadOrder.createCell(3).setCellValue("Order Date");
		rowHeadOrder.createCell(4).setCellValue("Expected Shipment Date");
		rowHeadOrder.createCell(5).setCellValue("Status");

		if (orderId != null && orderId.length > 0) {

			List<SearchOrderDTO> orderList = orderService.findOrderForReport(orderId);
			log.info("order size: " + (orderList == null ? 0 : orderList.size()));
			if (orderList != null && orderList.size() > 0) {

				// ----- Create order detail row
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YYYY", Locale.US);
				int orderRow = 1;
				for (SearchOrderDTO order : orderList) {
					XSSFRow orderRow1 = sheetOrder.createRow(orderRow++);
					orderRow1.createCell(0).setCellValue(StringUtils.isEmpty(order.getOrderCode()) ? "" : order.getOrderCode());
					orderRow1.createCell(1).setCellValue(StringUtils.isEmpty(order.getCustomerName()) ? "" : order.getCustomerName());
					orderRow1.createCell(2).setCellValue(StringUtils.isEmpty(order.getProductTypeName()) ? "" : order.getProductTypeName());
					if (order.getOrderDate() == null) {
						orderRow1.createCell(3).setCellValue("");
					} else {
						orderRow1.createCell(3).setCellValue(sdf.format(order.getOrderDate()));
					}
					if (order.getExpectShipmentDate() == null) {
						orderRow1.createCell(4).setCellValue("");
					} else {
						orderRow1.createCell(4).setCellValue(sdf.format(order.getExpectShipmentDate()));
					}

					orderRow1.createCell(5).setCellValue(StringUtils.isEmpty(order.getOrderStatus()) ? "" : order.getOrderStatus());

				}

				// ----- resize column -----
				sheetOrder.autoSizeColumn(0);
				sheetOrder.autoSizeColumn(1);
				sheetOrder.autoSizeColumn(2);
				sheetOrder.autoSizeColumn(3);
				sheetOrder.autoSizeColumn(4);
				sheetOrder.autoSizeColumn(5);

				// ----- Create orderline sheet -----
				XSSFSheet sheetOrderLine = workbook.createSheet("orderline");
				XSSFRow rowHeadOrderLine = sheetOrderLine.createRow(0);
				rowHeadOrderLine.createCell(0).setCellValue("Product Code");
				rowHeadOrderLine.createCell(1).setCellValue("Description");
				rowHeadOrderLine.createCell(2).setCellValue("Shiped");
				rowHeadOrderLine.createCell(3).setCellValue("Pending");
				rowHeadOrderLine.createCell(4).setCellValue("UOM");
				rowHeadOrderLine.createCell(5).setCellValue("Unit Price");
				rowHeadOrderLine.createCell(6).setCellValue("Amount");

				List<SearchOrderDetailDTO> orderDetails = orderService.searchOrderDetail(orderId);
				if (orderDetails != null && !orderDetails.isEmpty()) {
					int row = 1;
					DecimalFormat df = new DecimalFormat("#,##0.00");
					BigDecimal totalPrice = new BigDecimal(0);
					for (SearchOrderDetailDTO detail : orderDetails) {
						XSSFRow detailRow = sheetOrderLine.createRow(row++);
						detailRow.createCell(0).setCellValue(StringUtils.isEmpty(detail.getProductCode()) ? "" : detail.getProductCode());
						detailRow.createCell(1).setCellValue(StringUtils.isEmpty(detail.getProductName()) ? "" : detail.getProductName());
						detailRow.createCell(2).setCellValue(detail.getShiped());
						detailRow.createCell(3).setCellValue(detail.getPending());
						detailRow.createCell(4).setCellValue(StringUtils.isEmpty(detail.getProductUnit()) ? "" : detail.getProductUnit());
						detailRow.createCell(5).setCellValue(0.00);
						detailRow.createCell(6).setCellValue(0.00);
						if (detail.getUnitPrice() != null) {
							detailRow.createCell(5).setCellValue(df.format(detail.getUnitPrice()));
							BigDecimal amount = detail.getUnitPrice().multiply(BigDecimal.valueOf(detail.getAmount()));
							detailRow.createCell(6).setCellValue(df.format(amount));
							totalPrice = totalPrice.add(amount);
						}
					}
					XSSFRow totalPriceRow = sheetOrderLine.createRow(row);
					totalPriceRow.createCell(6).setCellValue(df.format(totalPrice));

					sheetOrderLine.autoSizeColumn(0);
					sheetOrderLine.autoSizeColumn(1);
					sheetOrderLine.autoSizeColumn(2);
					sheetOrderLine.autoSizeColumn(3);
					sheetOrderLine.autoSizeColumn(4);
					sheetOrderLine.autoSizeColumn(5);
					sheetOrderLine.autoSizeColumn(6);
				}

			} else {
				log.info("Not found order");
			}

		} else {
			log.warn("Required orderId");
		}
		return workbook;
	}

	public static XSSFWorkbook createExcelProductPrice(ProductService productService) {
		XSSFWorkbook workbook = new XSSFWorkbook();
		// ----- Create header row -----
		int headerIndex = 0;
		XSSFSheet sheetOrder = workbook.createSheet("price");
		XSSFRow rowHeadOrder = sheetOrder.createRow(headerIndex);
		rowHeadOrder.createCell(headerIndex++).setCellValue("product_code");
		rowHeadOrder.createCell(headerIndex++).setCellValue("product_price_group_id");
		rowHeadOrder.createCell(headerIndex++).setCellValue("product_currency");
		rowHeadOrder.createCell(headerIndex++).setCellValue("amount");
		rowHeadOrder.createCell(headerIndex++).setCellValue("msre_price");
		rowHeadOrder.createCell(headerIndex++).setCellValue("product_unit_id");
		rowHeadOrder.createCell(headerIndex++).setCellValue("so_category");

		List<ProductPriceDTO> productPrices = productService.findAllProductPrice();
		log.info("order size: " + (productPrices == null ? 0 : productPrices.size()));

		CellStyle cellStyle = workbook.createCellStyle();
		cellStyle.setDataFormat(workbook.getCreationHelper().createDataFormat().getFormat("#.00"));
		if (productPrices != null && productPrices.size() > 0) {

			// ----- Create order detail row
			int orderRow = 1;
			for (ProductPriceDTO productPrice : productPrices) {
				int detailIndex = 0;
				XSSFRow priceRow = sheetOrder.createRow(orderRow++);
				priceRow.createCell(detailIndex++).setCellValue(StringUtils.isEmpty(productPrice.getProductCode()) ? "" : productPrice.getProductCode());
				priceRow.createCell(detailIndex++).setCellValue(StringUtils.isEmpty(productPrice.getProductPriceGroupId()) ? "" : productPrice.getProductPriceGroupId());
				priceRow.createCell(detailIndex++).setCellValue(StringUtils.isEmpty(productPrice.getProductCurrency()) ? "" : productPrice.getProductCurrency());
				
				XSSFCell cellAmount = priceRow.createCell(detailIndex++);
				cellAmount.setCellStyle(cellStyle);
				if(productPrice.getAmount() != null){
					cellAmount.setCellValue(productPrice.getAmount().doubleValue());
				}
				
				XSSFCell cellMsre = priceRow.createCell(detailIndex++);
				cellMsre.setCellStyle(cellStyle);
				if(productPrice.getMsrePrice() != null){
					cellMsre.setCellValue(productPrice.getMsrePrice().doubleValue());
				}
				priceRow.createCell(detailIndex++).setCellValue(StringUtils.isEmpty(productPrice.getProductUnitId()) ? "" : productPrice.getProductUnitId());
				priceRow.createCell(detailIndex++).setCellValue(productPrice.getSoCategory());
			}

			// ----- resize column -----
			for(int i = 0; i< headerIndex; i++){
				sheetOrder.autoSizeColumn(i);
			}
			
		} else {
			log.warn("Not found any product_price");
		}

		return workbook;
	}
}
