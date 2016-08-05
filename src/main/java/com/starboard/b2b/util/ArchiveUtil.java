/*
 * +-+ +-+ +-+ +-+ +-+ +-+ +-+ +-+ +-+ +-+ +-+
 * |4| |7| |R| |o| |n| |i| |n| |L| |a| |b| |s|
 * +-+ +-+ +-+ +-+ +-+ +-+ +-+ +-+ +-+ +-+ +-+
 */
package com.starboard.b2b.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.starboard.b2b.exception.B2BException;

/**
 *
 * @author MaGicBank <magicbank@gmail.com>
 */
public class ArchiveUtil {

	public static byte[] zip(List<String> files) throws IOException {
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		try (ZipOutputStream zip = new ZipOutputStream(output)) {
			for (String file : files) {
				File content = new File(file);
				if (!content.exists()) {
					continue;
				}
				if (content.isDirectory()) {
					ZipEntry zipEntry = new ZipEntry(content.getName() + File.separator);
					zipEntry.setSize(0);
					zip.putNextEntry(zipEntry);
				} else {
					zip.putNextEntry(new ZipEntry(content.getName()));
					try (FileInputStream input = new FileInputStream(content)) {
						byte[] data = new byte[input.available()];
						input.read(data);
						zip.write(data);
					}
					zip.closeEntry();
				}
			}
		}
		if (output.size() == 0) {
			throw new B2BException("request file are not ready to download");
		}
		return output.toByteArray();
	}

	public static byte[] zipExcel(Map<String, HSSFWorkbook> excelMap) throws IOException {
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		try (ZipOutputStream zip = new ZipOutputStream(output)) {
			for (Entry<String, HSSFWorkbook> entry : excelMap.entrySet()) {
				zip.putNextEntry(new ZipEntry(entry.getKey() + ".xls"));
				ByteArrayOutputStream bos = new ByteArrayOutputStream();
				entry.getValue().write(bos);
				zip.write(bos.toByteArray());
				zip.closeEntry();
			}
		}
		return output.toByteArray();
	}
}
