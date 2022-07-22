package com.example.subdemo.base64;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.apache.tomcat.util.codec.binary.Base64;

public class Pdf2Base64 {

    public static void main(String[] args) throws UnsupportedEncodingException {
        byte[] bytes = null;
        String pdfPath = "C:\\Users\\sheng.lv\\Downloads\\developer-switch.pdf";
        try (InputStream in = new FileInputStream(pdfPath)) {
            bytes = new byte[in.available()];
            in.read(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(Base64.encodeBase64String(bytes));
        System.out.println(URLEncoder.encode("吕升", "UTF-8"));
    }
}
