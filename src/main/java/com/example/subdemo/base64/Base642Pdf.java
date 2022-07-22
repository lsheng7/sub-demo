package com.example.subdemo.base64;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import org.bouncycastle.util.encoders.Base64;

public class Base642Pdf {

    public static void main(String[] args) throws UnsupportedEncodingException {

        File file = new File("base64.txt");
        try (final FileInputStream fileInputStream = new FileInputStream(file); final FileOutputStream fileOutputStream = new FileOutputStream(
                "developer-ca.pdf")) {
            final byte[] data = new byte[fileInputStream.available()];
            final int length = fileInputStream.read(data);
            System.out.println("data.size=" + data.length);
            System.out.println("length=" + length);
            final byte[] bytes = Base64.decode(data);
            fileOutputStream.write(bytes);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
