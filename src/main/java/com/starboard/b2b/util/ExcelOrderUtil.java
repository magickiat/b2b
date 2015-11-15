/*
 * +-+ +-+ +-+ +-+ +-+ +-+ +-+ +-+ +-+ +-+ +-+
 * |4| |7| |R| |o| |n| |i| |n| |L| |a| |b| |s|
 * +-+ +-+ +-+ +-+ +-+ +-+ +-+ +-+ +-+ +-+ +-+
 */
package com.starboard.b2b.util;

import com.starboard.b2b.bean.ExcelOrderBean;
import com.starboard.b2b.exception.B2BException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 *
 * @author MaGicBank <magicbank@gmail.com>
 */
public class ExcelOrderUtil {

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
            Cell productCode = row.getCell(3);
            Cell quantity = row.getCell(5);
            Cell remark = row.getCell(6);
            //
            if (productCode == null) {
                continue;
            }
            if (quantity == null) {
                continue;
            }
            int qty = Double.valueOf(quantity.getNumericCellValue()).intValue();
            if (qty == 0) {
                continue;
            }
            //
            ExcelOrderBean order = new ExcelOrderBean();
            order.setProductCode(productCode.getStringCellValue());
            order.setQuantity(qty);
            order.setRemark(remark == null ? "" : remark.getStringCellValue());
            list.add(order);
        }
        if (list.isEmpty()) {
            return null;
        }
        return list;
    }
}
