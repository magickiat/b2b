package com.starboard.b2b.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.imgscalr.Scalr;

public class ImageUtil {

//    public static boolean isExistProductImage(String uploadFolder, String image) {
//        File file = new File(uploadFolder + "/", child);
//    }
    public static byte[] createImageThumbnail(byte[] original, int width, int height) throws IOException {
        ByteArrayInputStream source = new ByteArrayInputStream(original);
        ByteArrayOutputStream target = new ByteArrayOutputStream();
        try {
            ImageIO.write(
                    Scalr.resize(
                            ImageIO.read(source),
                            Scalr.Method.BALANCED,
                            Scalr.Mode.AUTOMATIC,
                            width,
                            height,
                            Scalr.OP_ANTIALIAS),
                    "PNG",
                    target);
            return target.toByteArray();
        } finally {
            source.close();
            target.close();
        }
    }
}
