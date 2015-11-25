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
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

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
                zip.putNextEntry(new ZipEntry(content.getName()));
                try (FileInputStream input = new FileInputStream(content)) {
                    byte[] data = new byte[input.available()];
                    input.read(data);
                    zip.write(data);
                }
                zip.closeEntry();
            }
        }
        return output.toByteArray();
    }
}
