package com.starboard.b2b.service.impl;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.internal.SessionImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.starboard.b2b.exception.B2BException;
import com.starboard.b2b.service.ReportService;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

@Service("reportService")
public class ReportServiceImpl implements ReportService {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public byte[] generateRoPDF(long orderId) {
		Map<String, Object> params = new HashMap<>();

		Session session = sessionFactory.openSession();

		Connection connection = null;
		Transaction tx = null;
		try {

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

			jasperStream.close();
			tx.commit();

			return exportReportToPdf;
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			throw new B2BException(e);
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
				}
			}
		}
	}

}
