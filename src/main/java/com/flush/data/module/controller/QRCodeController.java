package com.flush.data.module.controller;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;

/**
 * 利用zxing开源工具生成二维码QRCode
 *
 *  链接：http://www.cnblogs.com/hongten/archive/2012/10/26/java_qrcode.html
 *
 *  所依赖jar包：zxing-2.1\core\core.jar  、  zxing-2.1\javase\javase.jar
 *
 * @date 2021-02-26
 * @author zyw
 *
 */
public class QRCodeController {
    private static final int BLACK = 0xff000000;
    private static final int WHITE = 0xFFFFFFFF;

    /**
     * @param args
     */
    public static void main(String[] args) {
        QRCodeController test = new QRCodeController();
        File file = new File("E://test.png");
        /**
         * 在com.google.zxing.MultiFormatWriter类中，定义了一些我们不知道的码,二维码只是其中的一种<br>
         * public BitMatrix encode(String contents,
         BarcodeFormat format,
         int width, int height,
         Map<EncodeHintType,?> hints) throws WriterException {
         Writer writer;
         switch (format) {
         case EAN_8:
         writer = new EAN8Writer();
         break;
         case EAN_13:
         writer = new EAN13Writer();
         break;
         case UPC_A:
         writer = new UPCAWriter();
         break;
         case QR_CODE:  //这里是二维码
         writer = new QRCodeWriter();
         break;
         case CODE_39:
         writer = new Code39Writer();
         break;
         case CODE_128:  //这个可以生成
         writer = new Code128Writer();
         break;
         case ITF:
         writer = new ITFWriter();
         break;
         case PDF_417:  //这个可以生成
         writer = new PDF417Writer();
         break;
         case CODABAR:
         writer = new CodaBarWriter();
         break;
         default:
         throw new IllegalArgumentException("No encoder available for format " + format);
         }
         return writer.encode(contents, format, width, height, hints);
         }
         */

        //JS-CNNS-2021-001\r\n固态硬盘一个\r\n021-02-26
        StringBuilder content = new StringBuilder();
        content.append("JS-CNNS-2021-001\r\n");
        content.append("固态硬盘一个\r\n");
        content.append("2021-02-26\r\n");

        test.encode(content.toString(), file, BarcodeFormat.QR_CODE, 200, 200, null);
//        test.encode("helloworld,I'm Hongten.welcome to my zone:http://www.cnblogs.com/hongten", file, BarcodeFormat.QR_CODE, 200, 200, null);
        test.decode(file);
    }

    /**
     * 生成QRCode二维码<br>
     * 在编码时需要将com.google.zxing.qrcode.encoder.Encoder.java中的<br>
     *  static final String DEFAULT_BYTE_MODE_ENCODING = "ISO8859-1";<br>
     *  修改为UTF-8，否则中文编译后解析不了<br>
     */
    public void encode(String contents, File file, BarcodeFormat format, int width, int height, Map<EncodeHintType, ?> hints) {
        try {
            //消除乱码
            contents = new String(contents.getBytes("UTF-8"), "ISO-8859-1");
            BitMatrix bitMatrix = new MultiFormatWriter().encode(contents, format, width, height);
            writeToFile(bitMatrix, "png", file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 生成二维码图片<br>
     *
     * @param matrix
     * @param format
     *            图片格式
     * @param file
     *            生成二维码图片位置
     * @throws IOException
     */
    public static void writeToFile(BitMatrix matrix, String format, File file) throws IOException {
        BufferedImage image = toBufferedImage(matrix);
        ImageIO.write(image, format, file);
    }

    /**
     * 生成二维码内容<br>
     *
     * @param matrix
     * @return
     */
    public static BufferedImage toBufferedImage(BitMatrix matrix) {
        int width = matrix.getWidth();
        int height = matrix.getHeight();
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                image.setRGB(x, y, matrix.get(x, y) == true ? BLACK : WHITE);
            }
        }
        return image;
    }

    /**
     * 解析QRCode二维码
     */
    @SuppressWarnings("unchecked")
    public void decode(File file) {
        try {
            BufferedImage image;
            try {
                image = ImageIO.read(file);
                if (image == null) {
                    System.out.println("Could not decode image");
                }
                LuminanceSource source = new BufferedImageLuminanceSource(image);
                BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
                Result result;
                @SuppressWarnings("rawtypes")
                Hashtable hints = new Hashtable();
                //解码设置编码方式为：utf-8
                hints.put(DecodeHintType.CHARACTER_SET, "utf-8");
                result = new MultiFormatReader().decode(bitmap, hints);
                String resultStr = result.getText();
                System.out.println("解析后内容：" + resultStr);
            } catch (IOException ioe) {
                System.out.println(ioe.toString());
            } catch (ReaderException re) {
                System.out.println(re.toString());
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }
}