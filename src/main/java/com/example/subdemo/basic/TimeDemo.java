package com.example.subdemo.basic;

import cn.hutool.core.date.LocalDateTimeUtil;
import cn.hutool.json.JSONUtil;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class TimeDemo {

    private String name;

    public String getName() {
        return name;
    }

    public static void main(String[] args) {
//        TimeDemo timeDemo = new TimeDemo();
//        timeDemo.setName("你好");
//        System.out.println(JSONUtil.toJsonStr(timeDemo));
//
//        LocalDate currentDate = LocalDate.now();
//        LocalDate lastMonthDate = currentDate.minusMonths(1);
//
//        LocalDate firstDate = lastMonthDate.with(TemporalAdjusters.firstDayOfMonth());
//        LocalDate lastDate = lastMonthDate.with(TemporalAdjusters.lastDayOfMonth());
//
//        System.out.println(LocalDateTimeUtil.format(firstDate, DateTimeFormatter.ISO_DATE));
//        System.out.println(LocalDateTimeUtil.format(lastDate, DateTimeFormatter.ISO_DATE));
//        System.out.println(firstDate + ":" + lastDate);

//        String emailSuffix="@t.op";
//        System.out.println("jsonb_exists_any(email_suffix, array ['".concat(emailSuffix).concat("'])=true"));

//        LocalDate targetMonth = LocalDateTimeUtil.parseDate("2022-02","yyyy-MM").plusMonths(1).plusDays(6);
//        System.out.println(LocalDate.of(2022,3,8).isBefore(targetMonth));

//        LocalDate targetMonth = LocalDateTimeUtil.parseDate("2022-02","yyyy-MM");
//        System.out.println(targetMonth);

        Object a=null;
        String b= (String) a;
        System.out.println(b);
    }

    public void setName(String name) {
        this.name = name;
    }
}

