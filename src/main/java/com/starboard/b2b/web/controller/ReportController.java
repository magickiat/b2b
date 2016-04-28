package com.starboard.b2b.web.controller;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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

import com.starboard.b2b.dto.OrderDTO;
import com.starboard.b2b.dto.OrderStatusDTO;
import com.starboard.b2b.dto.ProductTypeDTO;
import com.starboard.b2b.dto.SoDTO;
import com.starboard.b2b.dto.SoDetailDTO;
import com.starboard.b2b.dto.search.SearchOrderDTO;
import com.starboard.b2b.service.OrderService;
import com.starboard.b2b.service.ProductService;
import com.starboard.b2b.util.B2BFileUtil;
import com.starboard.b2b.web.form.order.OrderSummaryForm;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

@Controller
@RequestMapping("/report")
public class ReportController {

	private static final Logger log = LoggerFactory.getLogger(ReportController.class);

	@Autowired
	private OrderService orderService;

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
		XSSFWorkbook workbook = B2BFileUtil.createExcelOrder(orderId, orderService);

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ServletOutputStream os = response.getOutputStream();
		try {
			workbook.write(baos);
			workbook.close();

			// Set servlet response excel
			response.setContentLength(baos.size());
			response.setContentType("pplication/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
			response.setHeader("Content-Disposition", "attachment; filename=\"" + filename + ".xlsx\"");
			response.setHeader("Cache-Control", "cache, must-revalidate");
			response.setHeader("Pragma", "public");

			baos.writeTo(os);

		} catch (Exception e) {
			log.error(e.toString(), e);
		} finally {
			os.flush();
			os.close();
			baos.close();
		}

		return null;
	}

	@RequestMapping(value = "ordersummary/excel", method = RequestMethod.GET)
	String generateOrderSummaryExcel(@ModelAttribute("form") OrderSummaryForm form, Model model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		log.info("search condition: " + form.toString());
		setOrderSummarySearchFrom(form, model);
		List<SearchOrderDTO> list = orderService.searchOrderForReport(form);
		if (list != null && list.size() > 0) {
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
	 * 
	 * @param form
	 *            Order Summary form
	 * @param model
	 *            Model attributes
	 */
	private void setOrderSummarySearchFrom(final OrderSummaryForm form, final Model model) {
		final List<ProductTypeDTO> productTypes = productService.findProductTypeByBrandId(form.getBrandId());
		model.addAttribute("productType", productTypes);
		final List<OrderStatusDTO> orderStatus = orderService.findAllOrderStatus();
		model.addAttribute("orderStatus", orderStatus);
	}

	@RequestMapping(value = "order/pdf", method = RequestMethod.GET)
	@Transactional(readOnly = true)
	String generateOrderPDF(Long orderId, HttpServletRequest request, HttpServletResponse response) throws Exception {
		log.info("orderId = " + orderId);
		Map<String, Object> params = new HashMap<>();

		Session session = sessionFactory.openSession();

		Connection connection = null;
		Transaction tx = null;
		OutputStream outStream = response.getOutputStream();
		try {

			OrderDTO order = orderService.findOrder(orderId);

			connection = ((SessionImpl) session).connection();
			tx = session.beginTransaction();

			params.put("orderId", orderId);
			params.put("showcate", false);
			params.put("relativePage", 0);
			params.put("SUBREPORT_DIR", this.getClass().getResource("/report/").getPath());

			InputStream jasperStream = this.getClass().getResourceAsStream("/report/ro.jasper");
			JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);

			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, connection);
			byte[] exportReportToPdf = JasperExportManager.exportReportToPdf(jasperPrint);
			log.info("byte size = " + exportReportToPdf.length);

			response.setContentType("application/pdf");
			response.setHeader("Content-Disposition", "attachment; filename=" + order.getOrderCode() + ".pdf");
			response.setHeader("Cache-Control", "cache, must-revalidate");
			response.setHeader("Pragma", "public");
			response.setContentLength(exportReportToPdf.length);

			outStream.write(exportReportToPdf);

			jasperStream.close();
			tx.commit();
		} catch (Exception e) {
			log.error(e.toString(), e);
			if (tx != null) {
				tx.rollback();
			}
		} finally {

			if (connection != null) {
				connection.close();
			}

			// baos.close();
		}

		return null;
	}

	@RequestMapping(value = "so/pdf", method = RequestMethod.GET)
	@Transactional(readOnly = true)
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
			// find so detail before generate jasper report
			final List<SoDetailDTO> soDetail = orderService.findSoDetail(soId);
			if (!soDetail.isEmpty()) {
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

				response.setContentLength(baos.size());
				response.setContentType("application/x-pdf");
				response.setHeader("Content-Disposition", "inline; filename=" + so.getSoNo() + ".pdf");
				response.setHeader("Cache-Control", "cache, must-revalidate");
				response.setHeader("Pragma", "public");

				baos.writeTo(outStream);

				jasperStream.close();
				tx.commit();
			}
		} catch (Exception e) {
			log.error(e.toString(), e);
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

	@RequestMapping(value = "print/pdf")
	String viewPdf(@RequestParam("orderId") Long orderId, HttpServletRequest request, HttpServletResponse response) throws Exception {
		log.info("orderId = " + orderId);
		Map<String, Object> params = new HashMap<>();

		Session session = sessionFactory.openSession();

		Connection connection = null;
		Transaction tx = null;
		OutputStream outStream = response.getOutputStream();
		try {

			OrderDTO order = orderService.findOrder(orderId);

			connection = ((SessionImpl) session).connection();
			tx = session.beginTransaction();

			params.put("orderId", orderId);
			params.put("showcate", false);
			params.put("relativePage", 0);
			params.put("SUBREPORT_DIR", this.getClass().getResource("/report/").getPath());

			InputStream jasperStream = this.getClass().getResourceAsStream("/report/ro.jasper");
			JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);

			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, connection);
			byte[] exportReportToPdf = JasperExportManager.exportReportToPdf(jasperPrint);
			log.info("byte size = " + exportReportToPdf.length);

			response.setContentType("application/pdf");
			response.setHeader("Content-Disposition", "inline; filename=" + order.getOrderCode() + ".pdf");
			response.setHeader("Cache-Control", "cache, must-revalidate");
			response.setHeader("Pragma", "public");
			response.setContentLength(exportReportToPdf.length);

			outStream.write(exportReportToPdf);

			jasperStream.close();
			tx.commit();
		} catch (Exception e) {
			log.error(e.toString(), e);
			if (tx != null) {
				tx.rollback();
			}
		} finally {

			if (connection != null) {
				connection.close();
			}

			// baos.close();
		}

		return null;
	}
}
