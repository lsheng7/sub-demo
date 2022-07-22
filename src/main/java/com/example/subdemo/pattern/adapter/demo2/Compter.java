package com.example.subdemo.pattern.adapter.demo2;

// 电脑类，只支持读写SD卡中内容
public class Compter {

    public String readSD(ISDCard sdCard){
        if(sdCard == null) {
            throw new NullPointerException("sd card is not null");
        }
        return sdCard.readSD();
    }

    public void writeSD(ISDCard sdCard) {
        sdCard.writeSD("hello world");
    }
}