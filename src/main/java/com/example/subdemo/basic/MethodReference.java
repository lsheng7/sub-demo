package com.example.subdemo.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MethodReference {

    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("a", "e", "c", "c", "d");
        stringList.forEach(System.out::println);
        System.out.println("-------------------------------------");
        //1)实例名::实例方法名:
        //1. "c"::contains
        //2. PrintStream out::println
        stringList.stream().map("c"::contains).forEach(System.out::println);
        System.out.println("-------------------------------------");
        //2)类名::静态方法名
        //MethodReference::toASCII
        stringList.stream().map(MethodReference::toASCII).forEach(System.out::println);
        System.out.println("-------------------------------------");
        //3)类名::实例方法名
        //这个例子相当于stream中每个element对象调用toUpperCase
        stringList.stream().map(String::toUpperCase).forEach(System.out::println);
        System.out.println("-------------------------------------");
        //这个例子相当于stream第1个element是调用compareTo方法对象,第2个element是compareTo参数
//        Collections.sort(stringList);
//        Arrays.asList("a00");//java.util.Arrays.ArrayList非java.util.ArrayList
        stringList.sort(String::compareTo);
        stringList.forEach(System.out::println);
        System.out.println("-------------------------------------");
        //4)类名::new 构造函数引用 用于替换Supplier 如下面的ArrayList::new
        stringList = stringList.stream().map(String::toUpperCase).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        stringList.forEach(System.out::println);

    }

    public static int toASCII(String string) {
        return string.toCharArray()[0];
    }
}
