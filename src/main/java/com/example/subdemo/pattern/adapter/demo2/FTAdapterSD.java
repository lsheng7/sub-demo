package com.example.subdemo.pattern.adapter.demo2;

// 适配器类，继承FT卡实现类，实现SD卡接口，重写SD卡方法
public class FTAdapterSD extends FTCard implements ISDCard {

    @Override
    public String readSD() {
        System.out.println("适配FT卡读数据");
        return readFT();
    }

    @Override
    public void writeSD(String msg) {
        System.out.println("适配FT卡写数据");
        writeFT(msg);
    }
}