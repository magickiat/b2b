package com.starboard.b2b.web.controller;

import com.starboard.b2b.dto.search.SearchOrderDTO;
import com.starboard.b2b.dto.search.SearchOrderDetailDTO;
import com.starboard.b2b.service.CustomerService;
import com.starboard.b2b.service.OrderService;
import com.starboard.b2b.service.ProductService;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/report")
public class ReportController {

	private static final Logger log = LoggerFactory.getLogger(ReportController.class);

	@Autowired
	private OrderService orderService;

	@Autowired
	private CustomerService customerService;

	@Autowired
	private ProductService productService;

	// http://kodejava.org/how-do-i-create-an-excel-document-using-apache-poi/
	// https://poi.apache.org/spreadsheet/quick-guide.html
	@RequestMapping(value = "order/excel", method = RequestMethod.GET)
	String generateOrderExcel(Long orderId, HttpServletRequest request, HttpServletResponse response) throws Exception {
		log.info("Generate excel order report: orderId = " + orderId);
		String filename = "" + orderId;
		HSSFWorkbook workbook = new HSSFWorkbook();
		// ----- Create header row sheet "order" -----
		HSSFSheet sheetOrder = workbook.createSheet("order");
		HSSFRow rowHeadOrder = sheetOrder.createRow(0);
		rowHeadOrder.createCell(0).setCellValue("Request ID");
		rowHeadOrder.createCell(1).setCellValue("Customer");
		rowHeadOrder.createCell(2).setCellValue("Brand");
		rowHeadOrder.createCell(3).setCellValue("Order Date");
		rowHeadOrder.createCell(4).setCellValue("Expected Shipment Date");
		rowHeadOrder.createCell(5).setCellValue("Status");

		if (orderId != null) {
			SearchOrderDTO order = orderService.findOrderForReport(orderId);

			if (order != null) {
				filename = order.getOrderCode();

				// ----- Create order detail row
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YYYY", Locale.US);
				
				HSSFRow orderRow1 = sheetOrder.createRow(1);
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

				// ----- resize column -----
				sheetOrder.autoSizeColumn(0);
				sheetOrder.autoSizeColumn(1);
				sheetOrder.autoSizeColumn(2);
				sheetOrder.autoSizeColumn(3);
				sheetOrder.autoSizeColumn(4);
				sheetOrder.autoSizeColumn(5);

				// ----- Create orderline sheet -----
				HSSFSheet sheetOrderLine = workbook.createSheet("orderline");
				HSSFRow rowHeadOrderLine = sheetOrderLine.createRow(0);
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
						HSSFRow detailRow = sheetOrderLine.createRow(row++);
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
					HSSFRow totalPriceRow = sheetOrderLine.createRow(row);
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

		// Set servlet response excel
		ServletOutputStream os = response.getOutputStream();
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-Disposition", "attachment; filename=\"" + filename + ".xls\"");

		workbook.write(os);
		workbook.close();
		os.flush();

		return null;
	}
	
	@RequestMapping(value = "order/pdf", method = RequestMethod.GET)
	String generateOrderPDF(Long orderId, HttpServletRequest request, HttpServletResponse response) throws Exception {
		InputStream jasperStream = this.getClass().getResourceAsStream("/report/ro.jasper");
	    Map<String,Object> params = new HashMap<>();
	    params.put("orderId", orderId);
	    params.put("showcate", false);
//	    params.put("productCurrency", "");
	    params.put("SUBREPORT_DIR", this.getClass().getResource("/report/").getPath());
	    
	    JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
	    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, new JREmptyDataSource());

	    response.setContentType("application/x-pdf");
	    response.setHeader("Content-disposition", "inline; filename=helloWorldReport.pdf");

	    final OutputStream outStream = response.getOutputStream();
	    JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
	    outStream.flush();
	    outStream.close();
		return null;
	}
}
