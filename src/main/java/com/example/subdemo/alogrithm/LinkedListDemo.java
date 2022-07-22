package com.example.subdemo.alogrithm;

import cn.hutool.core.util.StrUtil;
import java.util.LinkedList;
import lombok.Data;
import lombok.experimental.Accessors;

public class LinkedListDemo {


    public static void main(String[] args) {

        LinkedList<DataObject> linkedList = new LinkedList<>();

        linkedList.add(new DataObject().setName("a").setAge(1));
        linkedList.add(new DataObject().setName("b").setAge(2));
        linkedList.add(new DataObject().setName("c").setAge(3));
        linkedList.add(new DataObject().setName("d").setAge(4));
        linkedList.add(new DataObject().setName("b").setAge(5));

        DataObject last = linkedList.getLast();
        last.setAge(100);
        DataObject previous;
        int size = linkedList.size() - 1;
        while (true) {
            previous = linkedList.get(--size);
            if (StrUtil.equals(previous.getName(), last.getName())) {
                previous.setAge(100);
                break;
            }
            previous.setAge(100);
        }


//        System.out.println(linkedList.pollFirst());
//        System.out.println(linkedList.pollFirst());
//        System.out.println(linkedList.peekFirst());
        System.out.println("------------------------------------------------------");
        linkedList.stream().forEach(System.out::println);
//        System.out.println("------------------------------------------------------");

    }


    @Data
    @Accessors(chain = true)
    static class DataObject {

        private String name;

        private int age;
    }
}
