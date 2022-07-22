package com.example.subdemo.pattern.adapter.demo2;

// 客户端
public class Client {
    public static void main(String[] args) {
        Compter compter = new Compter();
        SDCard sdCard = new SDCard();
        System.out.println("插入SD卡");
        System.out.println(compter.readSD(sdCard));
        compter.writeSD(sdCard);

        System.out.println("插入FT卡转换器");
        FTAdapterSD ftAdapterSD = new FTAdapterSD();
        System.out.println(compter.readSD(ftAdapterSD));
        compter.writeSD(ftAdapterSD);
    }
}