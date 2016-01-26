/*
 * +-+ +-+ +-+ +-+ +-+ +-+ +-+ +-+ +-+ +-+ +-+
 * |4| |7| |R| |o| |n| |i| |n| |L| |a| |b| |s|
 * +-+ +-+ +-+ +-+ +-+ +-+ +-+ +-+ +-+ +-+ +-+
 */
package com.starboard.b2b.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.starboard.b2b.bean.ExcelOrderBean;
import com.starboard.b2b.dto.ProductDTO;
import com.starboard.b2b.exception.B2BException;

/**
 *
 * @author MaGicBank <magicbank@gmail.com>
 */
public class ExcelUtil {

	private static final Logger log = LoggerFactory.getLogger(ExcelUtil.class);

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
		ArrayList<ProductDTO> result = new ArrayList<>();
		XSSFWorkbook workbook = null;
		XSSFSheet sheet = null;

		try {
			workbook = new XSSFWorkbook(inputStream);
			sheet = workbook.getSheetAt(0);

			if (sheet == null) {
				throw new B2BException("no sheet present in this workbook");
			}

			Iterator<Row> iterator = sheet.iterator();
			while (iterator.hasNext()) {
				Row row = (Row) iterator.next();
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

				Long typeId = null;
				String code = "";
				String name = "";
				String buyerGroupId = "";
				String modelId = "";
				String technology = "undefined";
				String size = "";
				String active = "0";

				// ----- validate and get value -----
				if (cellTypeId == null) {
					throw new B2BException("product_type_id is required");
				} else if (cellTypeId.getCellType() == Cell.CELL_TYPE_NUMERIC) {
					typeId = (long) cellTypeId.getNumericCellValue();
				} else if (cellTypeId.getCellType() == Cell.CELL_TYPE_STRING) {
					typeId = Long.parseLong(cellTypeId.getStringCellValue());
				} else {
					throw new B2BException("product_type_id must be Text or Number");
				}

				if (cellCode == null) {
					throw new B2BException("product_code is required");
				} else if (cellCode.getCellType() == Cell.CELL_TYPE_STRING) {
					code = StringUtil.removeSpecialChar(cellCode.getStringCellValue().trim());
				} else {
					throw new B2BException("product_code must be text");
				}

				if (cellName == null) {
					throw new B2BException("product_name is required");
				} else if (cellName.getCellType() == Cell.CELL_TYPE_STRING) {
					name = cellName.getStringCellValue().trim();
				} else {
					throw new B2BException("product_name must be text");
				}

				if (cellBuyerGroupId == null) {
					throw new B2BException("product_buyer_group_id is required");
				} else if (cellBuyerGroupId.getCellType() == Cell.CELL_TYPE_STRING) {
					buyerGroupId = StringUtil.removeSpecialChar(cellBuyerGroupId.getStringCellValue().trim());
				} else {
					throw new B2BException("product_buyer_group_id must be text");
				}

				if (cellModelId == null) {
					throw new B2BException("product_model_id is required");
				} else if (cellModelId.getCellType() == Cell.CELL_TYPE_STRING) {
					modelId = cellModelId.getStringCellValue().trim();
				} else {
					throw new B2BException("product_model_id must be text");
				}

				if (cellTechnology != null && cellTechnology.getCellType() == Cell.CELL_TYPE_STRING) {
					technology = StringUtil.removeSpecialChar(cellTechnology.getStringCellValue().trim());
				} else {
					throw new B2BException("technology must be text");
				}

				if (cellSize != null && cellSize.getCellType() == Cell.CELL_TYPE_STRING) {
					size = cellSize.getStringCellValue();
				} else {
					throw new B2BException("size must be text");
				}

				log.info("cell active = " + cellActive.getStringCellValue());
				if (cellActive != null) {
					if (cellActive.getStringCellValue().trim().equalsIgnoreCase("yes")) {
						active = "1";
					}else{
						active = "0";
					}

				}

				ProductDTO product = new ProductDTO();
				product.setProductTypeId(typeId);
				product.setProductCode(code);
				product.setProductNameEn(name);
				product.setProductBuyerGroupId(buyerGroupId);
				product.setProductModelId(modelId);
				product.setProductTechnologyId(technology);
				product.setProductLength(size);
				product.setIsActive(active);

				log.info("productType = " + product.getProductTypeId() + "\t technology = " + product.getProductTechnologyId());
				result.add(product);
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
