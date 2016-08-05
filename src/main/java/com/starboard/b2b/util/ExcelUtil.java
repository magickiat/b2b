/*
 * +-+ +-+ +-+ +-+ +-+ +-+ +-+ +-+ +-+ +-+ +-+
 * |4| |7| |R| |o| |n| |i| |n| |L| |a| |b| |s|
 * +-+ +-+ +-+ +-+ +-+ +-+ +-+ +-+ +-+ +-+ +-+
 */
package com.starboard.b2b.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.starboard.b2b.bean.ExcelOrderBean;
import com.starboard.b2b.common.B2BConstant;
import com.starboard.b2b.dto.ProductDTO;
import com.starboard.b2b.dto.ProductModelDTO;
import com.starboard.b2b.dto.ProductPriceDTO;
import com.starboard.b2b.exception.B2BException;
import com.starboard.b2b.service.ProductService;

/**
 *
 * @author MaGicBank <magicbank@gmail.com>
 */
public class ExcelUtil {

	private static final Logger log = LoggerFactory.getLogger(ExcelUtil.class);

	private static final DataFormatter formatter = new DataFormatter(DateTimeUtil.LOCALE);

	public static List<ExcelOrderBean> parseOrder(byte[] data) throws IOException, EncryptedDocumentException, InvalidFormatException {
		List<ExcelOrderBean> list = new ArrayList<>();

		Workbook workbook = WorkbookFactory.create(new ByteArrayInputStream(data));
		int numOfSheets = workbook.getNumberOfSheets();
		if (numOfSheets > 0) {
			for (int i = 0; i < numOfSheets; i++) {
				Sheet sheet = workbook.getSheetAt(i);
				Iterator<Row> rows = sheet.iterator();

				rows.next();// skip header
				while (rows.hasNext()) {
					Row row = rows.next();

					Cell productCodeCell = row.getCell(1);
					Cell quantityCell = row.getCell(3);

					if (productCodeCell == null || productCodeCell.getCellType() != Cell.CELL_TYPE_STRING) {
						continue;
					}
					if (quantityCell == null || quantityCell.getCellType() != Cell.CELL_TYPE_NUMERIC) {
						continue;
					}
					int quantity = Double.valueOf(quantityCell.getNumericCellValue()).intValue();
					if (quantity == 0) {
						continue;
					}

					ExcelOrderBean order = new ExcelOrderBean();
					order.setProductCode(productCodeCell.getStringCellValue());
					order.setQuantity(quantity);
					list.add(order);
				}
			}

		}

		if (list.isEmpty()) {
			return null;
		}
		return list;
	}

	public static List<ProductDTO> parseProduct(ProductService productService, InputStream inputStream) throws Exception {
		ArrayList<ProductDTO> result = null;
		XSSFWorkbook workbook = null;
		XSSFSheet sheet = null;

		try {
			workbook = new XSSFWorkbook(inputStream);
			sheet = workbook.getSheetAt(0);

			if (sheet == null) {
				throw new B2BException("no sheet present in this workbook");
			}

			int numberOfRows = sheet.getPhysicalNumberOfRows();
			result = new ArrayList<>(numberOfRows);

			if (numberOfRows > 1) {
				final DataFormatter fmt = new DataFormatter();
				for (int i = 0; i < numberOfRows; i++) {
					XSSFRow row = sheet.getRow(i);

					if (row == null) {
						continue;
					}
					log.info("row: " + row.getRowNum());
					if (row.getRowNum() == 0) {
						continue;
					}
					// ----- get cell value -----
					int rowIndex = 0;
					Cell cellTypeId = row.getCell(rowIndex++);
					Cell cellCode = row.getCell(rowIndex++);
					Cell cellName = row.getCell(rowIndex++);
					Cell cellBuyerGroupId = row.getCell(rowIndex++);
					Cell cellYear = row.getCell(rowIndex++); // 20160216 - Model
																// = Year
					Cell cellTechnology = row.getCell(rowIndex++);
					Cell cellSize = row.getCell(rowIndex++);
					Cell cellActive = row.getCell(rowIndex++);
					Cell cellVendor = row.getCell(rowIndex++);
					Cell cellModelId = row.getCell(rowIndex++); // 20160216 -
																// Category =
																// Model
					Cell cellExcelSheet = row.getCell(rowIndex++); // for create
																	// sheet

					Long typeId = null;
					String code = "";
					String name = "";
					String buyerGroupId = "";
					String modelId = "";
					String technology = "undefined";
					String size = "";
					String active = "0";
					String year = "";
					String vendor = null;
					String statusFlag = null;
					String excelSheet = "Undefined";

					// ----- validate and get value -----
					// --------------------------------------------------
					if (cellTypeId == null) {
						// throw new B2BException("Row " + (i+1) + "
						// product_type_id is required");
						continue;
					} else if (cellTypeId.getCellType() == Cell.CELL_TYPE_STRING) {
						typeId = new BigDecimal(fmt.formatCellValue(cellTypeId)).longValue();
					} else if (cellTypeId.getCellType() == Cell.CELL_TYPE_NUMERIC) {
						typeId = ((Number) cellTypeId.getNumericCellValue()).longValue();
					} else {
						throw new B2BException("Row " + (i + 1) + " product_type_id must be Number");
					}

					// --------------------------------------------------
					if (cellCode == null) {
						throw new B2BException("Row " + (i + 1) + " product code is required");
					} else {
						code = fmt.formatCellValue(cellCode);
					}

					// --------------------------------------------------
					if (cellName == null) {
						throw new B2BException("Row " + (i + 1) + " product name is required");
					} else {
						name = fmt.formatCellValue(cellName);
					}

					// --------------------------------------------------
					if (cellBuyerGroupId == null) {
						throw new B2BException("Row " + (i + 1) + " product buyer group is required");
					} else {
						buyerGroupId = fmt.formatCellValue(cellBuyerGroupId);
					}

					// --------------------------------------------------
					if (cellModelId != null) {
						modelId = fmt.formatCellValue(cellModelId);
					} else {
						modelId = B2BConstant.UNDEFINED;
					}

					// --------------------------------------------------
					if (cellTechnology == null) {
						throw new B2BException("Row " + (i + 1) + " product technology is required");
					} else {
						technology = fmt.formatCellValue(cellTechnology);
					}

					// --------------------------------------------------
					if (cellSize != null) {
						size = fmt.formatCellValue(cellSize);
					} else {
						size = B2BConstant.UNDEFINED;
					}

					// --------------------------------------------------
					if (cellActive != null) {
						// active = "" + cellActive.getNumericCellValue();
						statusFlag = "" + (int) cellActive.getNumericCellValue();
						log.info("status flag = '" + statusFlag + "'");
						if (isActive(cellActive)) {
							active = "1";
						}
					} else {
						active = "1";
					}

					// --------------------------------------------------
					if (cellYear != null) {
						year = fmt.formatCellValue(cellYear);
					}

					// --------------------------------------------------
					if (cellVendor != null) {
						vendor = fmt.formatCellValue(cellVendor);
					}

					if (cellExcelSheet != null) {
						String tmpSheet = fmt.formatCellValue(cellExcelSheet);
						if (StringUtils.isNotEmpty(tmpSheet)) {
							excelSheet = tmpSheet;
						}
					}

					// ----- 2016/02/16 ----- insert product_model when not
					// found
					ProductModelDTO productModel = productService.findProductModel(modelId);
					if (productModel == null) {
						productService.createNewModel(modelId);
					}

					ProductDTO product = new ProductDTO();
					product.setProductTypeId(typeId);
					product.setProductCode(StringUtils.trim(code));
					product.setProductNameEn(StringUtils.trim(name));
					product.setProductBuyerGroupId(StringUtils.trim(buyerGroupId));
					product.setProductModelId(StringUtils.trim(modelId));
					product.setProductTechnologyId(StringUtils.trim(technology));
					product.setProductLength(StringUtils.trim(size));
					product.setIsActive(active);
					product.setProductYearId(StringUtils.trim(year));
					product.setVendor(StringUtils.trim(vendor));
					product.setStatusFlag(statusFlag);
					product.setExcelSheet(excelSheet);

					log.info("productType = " + product.getProductTypeId() + "\tproductCode = " + product.getProductCode());
					result.add(product);
				}
			} else {
				throw new B2BException("Excel has only header row");
			}
		} finally {
			if (workbook != null) {
				workbook.close();
			}
		}

		result.trimToSize();
		return result;
	}

	private static boolean isActive(Cell cellActive) {
		return cellActive.getNumericCellValue() == 1 || cellActive.getNumericCellValue() == 3;
	}

	public static List<ProductPriceDTO> parseProductPrice(InputStream inputStream) throws Exception {
		log.info("parsing Product Price");
		ArrayList<ProductPriceDTO> result = null;
		XSSFWorkbook workbook = null;
		XSSFSheet sheet = null;

		try {
			workbook = new XSSFWorkbook(inputStream);
			sheet = workbook.getSheetAt(0);

			if (sheet == null) {
				throw new B2BException("no sheet present in this workbook");
			}

			int numberOfRows = sheet.getPhysicalNumberOfRows();
			result = new ArrayList<>(numberOfRows);

			if (numberOfRows > 1) {

				for (int i = 0; i < numberOfRows; i++) {
					XSSFRow row = sheet.getRow(i);
					if (row == null) {
						continue;
					}
					log.debug("row: " + row.getRowNum());

					// ----- skip header -----
					if (row.getRowNum() == 0) {
						continue;
					}

					// ----- get cell value -----
					int columnIndex = 0;
					XSSFCell cellProductCode = row.getCell(columnIndex++);
					XSSFCell cellPriceGroup = row.getCell(columnIndex++);
					XSSFCell cellCurrency = row.getCell(columnIndex++);
					XSSFCell cellAmount = row.getCell(columnIndex++);
					XSSFCell cellMsrePrice = row.getCell(columnIndex++);
					XSSFCell cellUnitId = row.getCell(columnIndex++);
					XSSFCell cellSOCategory = row.getCell(columnIndex++);// so_category

					String productCode = formatter.formatCellValue(cellProductCode);
					String priceGroup = formatter.formatCellValue(cellPriceGroup);
					String currency = formatter.formatCellValue(cellCurrency);
					BigDecimal amount = null;
					BigDecimal msrePrice = null;
					String unitId = formatter.formatCellValue(cellUnitId);
					String soCategory = formatter.formatCellValue(cellSOCategory);

					// ----- validate and get value -----

					if (StringUtils.isEmpty(productCode)) {
						throw new B2BException("Product code is required");
					}

					// when price is string like 'TBA = to be anouce' it can
					// skip because when not found product price
					// it show TBA by default
					if (cellAmount != null && cellAmount.getCellType() == Cell.CELL_TYPE_NUMERIC) {
						amount = new BigDecimal(cellAmount.getNumericCellValue());
						log.debug(amount.toPlainString());
						amount = amount.setScale(2, BigDecimal.ROUND_DOWN);
					}

					if (cellMsrePrice != null && cellMsrePrice.getCellType() == Cell.CELL_TYPE_NUMERIC) {
						msrePrice = new BigDecimal(cellMsrePrice.getNumericCellValue());
						log.debug(msrePrice.toPlainString());
						msrePrice = msrePrice.setScale(2, BigDecimal.ROUND_DOWN);
					}

					if (StringUtils.isNotEmpty(soCategory) && soCategory.contains(",")) {
						soCategory = soCategory.split(",")[0].trim();
					}

					result.add(new ProductPriceDTO(productCode, priceGroup, currency, amount, unitId, msrePrice, soCategory));
				}
			} else {
				throw new B2BException("Excel has only header row");
			}

		} finally {
			if (workbook != null) {
				workbook.close();
			}
		}

		result.trimToSize();
		return result;
	}
}
