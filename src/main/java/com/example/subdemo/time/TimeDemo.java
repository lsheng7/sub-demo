package com.example.subdemo.time;

import cn.hutool.core.date.LocalDateTimeUtil;
import java.time.LocalDate;

public class TimeDemo {

    public static void main(String[] args) {
        final LocalDate localDate = LocalDateTimeUtil.parseDate("2022-05", "yyyy-MM").plusMonths(1).plusDays(7);
        System.out.println(localDate);
        System.out.println(LocalDate.now().isAfter(localDate));
    }
}
