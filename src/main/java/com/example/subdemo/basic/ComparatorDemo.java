package com.example.subdemo.basic;

import cn.hutool.core.collection.CollectionUtil;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.ToLongFunction;
import lombok.Data;

public class ComparatorDemo {

    public static void main(String[] args) {
        ToLongFunction<String> toLongFunction = string -> Long.parseLong(string.substring(2));
        Comparator<String> comparingLong = Comparator.comparingLong(toLongFunction);
        List<String> sortList = CollectionUtil.sort(Arrays.asList("a_123", "a_23", "a_323"), comparingLong);
        sortList.forEach(System.out::println);
    }

    @Data
    static class CompareBean {

        private String name;
    }
}
