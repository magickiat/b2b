/*
 * +-+ +-+ +-+ +-+ +-+ +-+ +-+ +-+ +-+ +-+ +-+
 * |4| |7| |R| |o| |n| |i| |n| |L| |a| |b| |s|
 * +-+ +-+ +-+ +-+ +-+ +-+ +-+ +-+ +-+ +-+ +-+
 */
package com.starboard.b2b.util;

import com.starboard.b2b.bean.ExcelOrderBean;
import static com.starboard.b2b.util.ExcelUtil.parseOrder;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Test;

/**
 *
 * @author MaGicBank <magicbank@gmail.com>
 */
public class ExcelOrderUtilTest {

    @Test
    public void testParseOrder() throws IOException, EncryptedDocumentException, InvalidFormatException {
        try (FileInputStream input = new FileInputStream(new File("./file/order.xls"))) {
            byte[] data = new byte[input.available()];
            input.read(data);
            List<ExcelOrderBean> orders = parseOrder(data);
            for (ExcelOrderBean order : orders) {
                System.out.println(order.getProductCode() + " | " + order.getQuantity() + " | " + order.getRemark());
            }
        }
    }
}
