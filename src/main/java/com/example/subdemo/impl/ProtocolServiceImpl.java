package com.example.subdemo.impl;

import cn.hutool.http.HttpUtil;
import java.util.Arrays;

public class ProtocolServiceImpl {


    public static void main(String[] args) {

        String[] urls = new String[]{
                "http://localhost:9808/engine/project/607cf2353b9d3f4a03971b7b/protocol/export/excel/61a5946b232a2a0de0c62baf?t=57bda571546a42989b1ab3ae2c155c74",
                "http://localhost:9808/engine/project/6197638ad3e3f6253ba35536/protocol/export/excel/61bb3e82232a2a0bc96e9663?t=57bda571546a42989b1ab3ae2c155c74",
                "http://localhost:9808/engine/project/60f0e0a8d3e3f627a0745b59/protocol/export/excel/61a077edd3e3f6452ab51469?t=57bda571546a42989b1ab3ae2c155c74",
                "http://localhost:9808/engine/project/5fe04bce3b9d3f75863d1774/protocol/export/excel/619f9987232a2a3bf0a9981e?t=57bda571546a42989b1ab3ae2c155c74",
                "http://localhost:9808/engine/project/5dafb6c53b9d3f4e3749b83a/protocol/export/excel/5e6b10c8df89a4422c6c6c31?t=57bda571546a42989b1ab3ae2c155c74",
                "http://localhost:9808/engine/project/5c18ad083b9d3f78353fb58d/protocol/export/excel/5c19b4f3df89a46d8a336f72?t=57bda571546a42989b1ab3ae2c155c74",
                "http://localhost:9808/engine/project/5c072cd33b9d3f5b2dcea177/protocol/export/excel/5c0880663b9d3f5b2dcead1d?t=57bda571546a42989b1ab3ae2c155c74",
                "http://localhost:9808/engine/project/5bf4b74edf89a45442c43cf4/protocol/export/excel/5c3c1ceedf89a46ca8637603?t=57bda571546a42989b1ab3ae2c155c74",
                "http://localhost:9808/engine/project/5be288183b9d3f1bbb578710/protocol/export/excel/5c21a2873b9d3f7573ab35b7?t=57bda571546a42989b1ab3ae2c155c74",
                "http://localhost:9808/engine/project/5c36fb3e3b9d3f70560ca5bc/protocol/export/excel/5d1eee5a3b9d3f06cdde1987?t=57bda571546a42989b1ab3ae2c155c74",
        };

        String[] errorUrls = new String[]{
//                "http://localhost:9808/engine/project/5fe04bce3b9d3f75863d1774/protocol/export/excel/619f9987232a2a3bf0a9981e?t=57bda571546a42989b1ab3ae2c155c74"
//                ,
                "http://localhost:9808/engine/project/5be288183b9d3f1bbb578710/protocol/export/excel/5c21a2873b9d3f7573ab35b7?t=57bda571546a42989b1ab3ae2c155c74"
        };

        Arrays.stream(errorUrls).forEach(url -> {
            try {
                Thread.sleep(1_000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            HttpUtil.createGet(url).execute();
        });
    }

}
