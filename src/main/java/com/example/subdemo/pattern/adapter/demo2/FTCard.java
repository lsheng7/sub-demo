package com.example.subdemo.pattern.adapter.demo2;

// FT卡实现类
public class FTCard implements IFTCard {

    @Override
    public String readFT() {
        String msg = "read ft hello world";
        return msg;
    }

    @Override
    public void writeFT(String msg) {
        System.out.println("write ft " + msg);
    }
}