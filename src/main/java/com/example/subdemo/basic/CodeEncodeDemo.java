package com.example.subdemo.basic;

import com.google.common.base.Charsets;
import java.io.UnsupportedEncodingException;

public class CodeEncodeDemo {

    public static void main(String[] args) throws UnsupportedEncodingException {

//        byte[] bytes = "哈根".getBytes(Charsets.UTF_8);
//        for (byte b : bytes) {
//            System.out.println(String.format("%02X ", b));
//        }
//
//        System.out.println(new String(bytes,"GBK"));

        byte[] bytes = "中国".getBytes(Charsets.ISO_8859_1);
        for (byte b : bytes) {
            System.out.println(String.format("%02X ", b));
        }

        System.out.println(new String(bytes,"GBK"));
    }
}
