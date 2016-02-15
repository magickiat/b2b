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
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.starboard.b2b.bean.ExcelOrderBean;
import com.starboard.b2b.dto.ProductDTO;
import com.starboard.b2b.dto.ProductPriceDTO;
import com.starboard.b2b.exception.B2BException;

/**
 *
 * @author MaGicBank <magicbank@gmail.com>
 */
public class ExcelUtil {

	private static final Logger log = LoggerFactory.getLogger(ExcelUtil.class);

	private static final DataFormatter formatter = new DataFormatter(DateTimeUtil.LOCALE);

	public static List<ExcelOrderBean> parseOrder(byte[] data) throws IOException, EncryptedDocumentException, InvalidFormatException {
		Sheet sheet = WorkbookFactory.create(new ByteArrayInputStream(data)).getSheetAt(0);
		if (sheet == null) {
			throw new B2BException("no sheet present in this workbook");
		}
		Iterator<Row> rows = sheet.iterator();
		List<ExcelOrderBean> list = new ArrayList<>();
		while (rows.hasNext()) {
			Row row = rows.next();
			if (row.getRowNum() < 4) {
				continue;
			}
			//
			Cell productCodeCell = row.getCell(3);
			Cell quantityCell = row.getCell(5);
			Cell remarkCell = row.getCell(6);
			//
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
			String remark = remarkCell == null || remarkCell.getCellType() != Cell.CELL_TYPE_STRING ? "" : remarkCell.getStringCellValue();
			//
			ExcelOrderBean order = new ExcelOrderBean();
			order.setProductCode(productCodeCell.getStringCellValue());
			order.setQuantity(quantity);
			order.setRemark(remark);
			list.add(order);
		}
		if (list.isEmpty()) {
			return null;
		}
		return list;
	}

	public static List<ProductDTO> parseProduct(InputStream inputStream) throws Exception {
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
					Cell cellTypeId = row.getCell(0);
					Cell cellCode = row.getCell(1);
					Cell cellName = row.getCell(2);
					Cell cellBuyerGroupId = row.getCell(3);
					Cell cellModelId = row.getCell(4);
					Cell cellTechnology = row.getCell(5);
					Cell cellSize = row.getCell(6);
					Cell cellActive = row.getCell(7);
					Cell cellYear = row.getCell(8);
					Cell cellVendor = row.getCell(9);

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

					// ----- validate and get value -----
					// --------------------------------------------------
					if (cellTypeId == null) {
//						throw new B2BException("Row " + (i+1) + " product_type_id is required");
						continue;
					} else if (cellTypeId.getCellType() == Cell.CELL_TYPE_STRING) {
						typeId = new BigDecimal(fmt.formatCellValue(cellTypeId)).longValue();
					} else if (cellTypeId.getCellType() == Cell.CELL_TYPE_NUMERIC) {
						typeId = ((Number) cellTypeId.getNumericCellValue()).longValue();
					} else {
						throw new B2BException("Row " + (i+1) + " product_type_id must be Number");
					}

					// --------------------------------------------------
					if (cellCode == null) {
						throw new B2BException("Row " + (i+1) + " product code is required");
					} else{
						code = fmt.formatCellValue(cellCode);
					}

					// --------------------------------------------------
					if (cellName == null) {
						throw new B2BException("Row " + (i+1) + " product name is required");
					} else{
						name = fmt.formatCellValue(cellName);
					}

					// --------------------------------------------------
					if (cellBuyerGroupId == null) {
						throw new B2BException("Row " + (i+1) + " product buyer group is required");
					} else {
						buyerGroupId = fmt.formatCellValue(cellBuyerGroupId);
					}

					// --------------------------------------------------
					if (cellModelId == null) {
						throw new B2BException("Row " + (i+1) + " product model id is required");
					} else {
						modelId = fmt.formatCellValue(cellModelId);
					}

					// --------------------------------------------------
					if(cellTechnology == null){
						throw new B2BException("Row " + (i+1) + " product technology is required");
					}else{
						technology = fmt.formatCellValue(cellTechnology);
					}

					// --------------------------------------------------
					if (cellSize != null) {
						size = fmt.formatCellValue(cellSize);
					}else{
						size = "Undefined";
					}

					// --------------------------------------------------
					if (cellActive != null) {
						if (cellActive.getStringCellValue().trim().equalsIgnoreCase("yes")) {
							active = "1";
						} else {
							active = "0";
						}
					}else{
						active = "1";
					}

					// --------------------------------------------------
					if (cellYear != null) {
						year = fmt.formatCellValue(cellYear);
					}
					
					// --------------------------------------------------
					if(cellVendor != null){
						vendor = fmt.formatCellValue(cellVendor);
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

	public static List<ProductPriceDTO> parseProductPrice(InputStream inputStream) throws Exception {
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
					log.info("row: " + row.getRowNum());

					// ----- skip header -----
					if (row.getRowNum() == 0) {
						continue;
					}

					// ----- get cell value -----
					XSSFCell cellProductCode = row.getCell(0);
					XSSFCell cellPriceGroup = row.getCell(1);
					XSSFCell cellCurrency = row.getCell(2);
					XSSFCell cellAmount = row.getCell(3);
					XSSFCell cellMsrePrice = row.getCell(4);
					XSSFCell cellUnitId = row.getCell(5);

					String productCode = formatter.formatCellValue(cellProductCode);
					String priceGroup = formatter.formatCellValue(cellPriceGroup);
					String currency = formatter.formatCellValue(cellCurrency);
					BigDecimal amount = new BigDecimal(0);
					BigDecimal msrePrice = new BigDecimal(0);
					String unitId = formatter.formatCellValue(cellUnitId);

					// ----- validate and get value -----

					if (StringUtils.isEmpty(productCode)) {
						throw new B2BException("Product code is required");
					}

					if (cellAmount != null && cellAmount.getCellType() == Cell.CELL_TYPE_NUMERIC) {
						amount = new BigDecimal(cellAmount.getNumericCellValue());
					}

					if (cellMsrePrice != null && cellMsrePrice.getCellType() == Cell.CELL_TYPE_NUMERIC) {
						msrePrice = new BigDecimal(cellMsrePrice.getNumericCellValue());
					}

					result.add(new ProductPriceDTO(productCode, priceGroup, currency, amount, unitId, msrePrice));
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
