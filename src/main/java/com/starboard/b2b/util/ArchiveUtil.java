/*
 * +-+ +-+ +-+ +-+ +-+ +-+ +-+ +-+ +-+ +-+ +-+
 * |4| |7| |R| |o| |n| |i| |n| |L| |a| |b| |s|
 * +-+ +-+ +-+ +-+ +-+ +-+ +-+ +-+ +-+ +-+ +-+
 */
package com.starboard.b2b.util;

import com.starboard.b2b.exception.B2BException;
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
                if (!content.exists()) {
                    continue;
                }
                zip.putNextEntry(new ZipEntry(content.getName()));
                try (FileInputStream input = new FileInputStream(content)) {
                    byte[] data = new byte[input.available()];
                    input.read(data);
                    zip.write(data);
                }
                zip.closeEntry();
            }
        }
        if (output.size() == 0) {
            throw new B2BException("request file are not ready to download");
        }
        return output.toByteArray();
    }
}
