package com.example.subdemo.basic;

import java.util.ArrayList;

public class IteratorDemo {

    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        for (String a : list) {
            System.out.println(a);
        }
    }
}
