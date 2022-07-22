package com.example.subdemo.pattern.adapter.demo2;

// SD卡实现类
public class SDCard implements ISDCard{
    @Override
    public String readSD() {
        String msg = "read sd hello world";

        return msg;
    }

    @Override
    public void writeSD(String msg) {
        System.out.println("write sd " + msg);
    }
}