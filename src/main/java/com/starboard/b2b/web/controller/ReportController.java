package com.starboard.b2b.web.controller;

import com.starboard.b2b.dto.OrderDTO;
import com.starboard.b2b.dto.OrderStatusDTO;
import com.starboard.b2b.dto.ProductTypeDTO;
import com.starboard.b2b.dto.SoDTO;
import com.starboard.b2b.dto.SoDetailDTO;
import com.starboard.b2b.dto.search.SearchOrderDTO;
import com.starboard.b2b.dto.search.SearchOrderDetailDTO;
import com.starboard.b2b.service.CustomerService;
import com.starboard.b2b.service.OrderService;
import com.starboard.b2b.service.ProductService;
import com.starboard.b2b.web.form.order.OrderSummaryForm;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.internal.SessionImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.sql.Connection;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

	@Autowired
	private SessionFactory sessionFactory;

	// http://kodejava.org/how-do-i-create-an-excel-document-using-apache-poi/
	// https://poi.apache.org/spreadsheet/quick-guide.html
	@RequestMapping(value = "order/excel", method = RequestMethod.GET)
	String generateOrderExcel(@RequestParam("orderId[]") Long[] orderId, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		log.info("Generate excel order report: orderId = " + orderId);
		String filename = "excel_order_list";
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

		if (orderId != null && orderId.length > 0) {
			
			List<SearchOrderDTO> orderList = orderService.findOrderForReport(orderId);
			log.info("order size: " + (orderList == null? 0 : orderList.size()));
			if (orderList != null && orderList.size() > 0) {

				// ----- Create order detail row
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YYYY", Locale.US);
				int orderRow = 1;
				for (SearchOrderDTO order : orderList) {
					HSSFRow orderRow1 = sheetOrder.createRow(orderRow++);
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
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ServletOutputStream os = response.getOutputStream();
		try{
			workbook.write(baos);
			workbook.close();
			
			// Set servlet response excel
			
			response.setContentType("application/vnd.ms-excel");
			response.setHeader("Content-Disposition", "attachment; filename=\"" + filename + ".xls\"");
			response.setContentLength(baos.size());
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
	
	@RequestMapping(value = "ordersummary/excel", method = RequestMethod.GET)
	String generateOrderSummaryExcel(@ModelAttribute OrderSummaryForm form, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		log.info("search condition: " + form.toString());
        setOrderSummarySearchFrom(form, model);
		List<SearchOrderDTO> list = orderService.searchOrderForReport(form);
		if(list != null && list.size() > 0){
			ArrayList<Long> orderId = new ArrayList<>();
			
			for (SearchOrderDTO dto : list) {
				orderId.add(dto.getOrderId());
			}
			
			return generateOrderExcel(orderId.toArray(new Long[orderId.size()]), request, response);
		}

		return null;
	}
	
	 /**
     * Set all required search condition for order summary page
     * @param form Order Summary form
     * @param model Model attributes
     */
    private void setOrderSummarySearchFrom(final OrderSummaryForm form, final Model model){
        final List<ProductTypeDTO> productTypes = productService.findProductTypeByBrandId(form.getBrandId());
        model.addAttribute("productType", productTypes);
        final List<OrderStatusDTO> orderStatus = orderService.findAllOrderStatus();
        model.addAttribute("orderStatus", orderStatus);
    }


	@RequestMapping(value = "order/pdf", method = RequestMethod.GET)
	@Transactional
	String generateOrderPDF(Long orderId, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, Object> params = new HashMap<>();

		Session session = sessionFactory.openSession();

		Connection connection = null;
		Transaction tx = null;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		OutputStream outStream = response.getOutputStream();
		try {
			
			OrderDTO order = orderService.findOrder(orderId);

			connection = ((SessionImpl) session).connection();
			tx = session.beginTransaction();

			params.put("orderId", orderId);
			params.put("showcate", false);
			
			params.put("relativePage", 0);
			
			// params.put("productCurrency", "");
			params.put("SUBREPORT_DIR", this.getClass().getResource("/report/").getPath());

			InputStream jasperStream = this.getClass().getResourceAsStream("/report/ro.jasper");
			JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
			
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, connection);
			JasperExportManager.exportReportToPdfStream(jasperPrint, baos);
			
			response.setContentType("application/x-pdf");
			response.setHeader("Content-disposition", "inline; filename="+order.getOrderCode()+".pdf");
			response.setContentLength(baos.size());
			
			baos.writeTo(outStream);
			
			jasperStream.close();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {

			if (connection != null) {
				connection.close();
			}
			outStream.flush();
			outStream.close();
			baos.close();
		}

		return null;
	}

	@RequestMapping(value = "so/pdf", method = RequestMethod.GET)
	@Transactional
	String generateSOPDF(final Long soId, HttpServletRequest request, HttpServletResponse response) throws Exception {
		final Map<String, Object> params = new HashMap<>();
		final Session session = sessionFactory.openSession();
		log.info("Calling generateSOPDF for so id {}", soId);
		Connection connection = null;
		Transaction tx = null;
		final ByteArrayOutputStream baos = new ByteArrayOutputStream();
		OutputStream outStream = response.getOutputStream();
		try {

			final SoDTO so = orderService.findSO(soId);
			//find so detail before generate jasper report
			final List<SoDetailDTO> soDetail = orderService.findSoDetail(soId);
			if(!soDetail.isEmpty()){
				connection = ((SessionImpl) session).connection();
				tx = session.beginTransaction();
				log.info("Generating pdf by Jasper");
				params.put("soId", soId);
				params.put("showcate", false);
				params.put("relativePage", 0);
				params.put("SUBREPORT_DIR", this.getClass().getResource("/report/").getPath());

				final InputStream jasperStream = this.getClass().getResourceAsStream("/report/so/so.jasper");
				final JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);

				final JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, connection);
				JasperExportManager.exportReportToPdfStream(jasperPrint, baos);

				response.setContentType("application/x-pdf");
				response.setHeader("Content-disposition", "inline; filename="+so.getSoNo()+".pdf");
				response.setContentLength(baos.size());

				baos.writeTo(outStream);

				jasperStream.close();
				tx.commit();
			}
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			log.error("Got problem while exporting sales order pdf with error {}", e.getMessage(), e);
		} finally {

			if (connection != null) {
				connection.close();
			}
			outStream.flush();
			outStream.close();
			baos.close();
		}

		return null;
	}

	@RequestMapping(value = "so/detail/count")
	@ResponseBody
	String countSoDetail(final Long soId) throws Exception {
		return String.valueOf(orderService.findSoDetail(soId).size());
	}
}
