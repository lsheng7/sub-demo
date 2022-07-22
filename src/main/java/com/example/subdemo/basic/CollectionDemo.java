package com.example.subdemo.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***
 * true
 * [a]
 * true
 * []
 * false
 * [a, b]
 * true
 * []
 *
 * @author lvsheng
 * @version 1.0.0
 * @date 2022/03/11 16:31
 */
public class CollectionDemo {

    public static void main(String[] args) {

        List<String> strList = new ArrayList<>();
        strList.add("a");
        strList.add("b");

        //保留a
        System.out.println(strList.retainAll(Arrays.asList("a")));
        System.out.println(strList);
        //移除a
        System.out.println(strList.removeAll(Arrays.asList("a")));
        System.out.println(strList);

        strList.add("a");
        strList.add("b");
//        Exception in thread "main" java.lang.NullPointerException
//        at java.util.Objects.requireNonNull(Objects.java:203)
//        at java.util.ArrayList.removeAll(ArrayList.java:695)
//        at com.example.subdemo.basic.CollectionDemo.main(CollectionDemo.java:24)

//        System.out.println(strList.removeAll(null));
        System.out.println(strList.removeAll(new ArrayList<>()));
        System.out.println(strList);
        System.out.println(strList.retainAll(new ArrayList<>()));
        System.out.println(strList);
    }
}
