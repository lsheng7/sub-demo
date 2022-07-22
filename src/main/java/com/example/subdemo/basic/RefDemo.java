package com.example.subdemo.basic;

import lombok.Data;
import lombok.experimental.Accessors;

public class RefDemo {

    public static void main(String[] args) {

        Ref ref = new Ref();
        ref.setSubRef(new SubRef().setName("a"));

        SubRef subRef=ref.getSubRef();

        SubRef subRef1=subRef;

        ref.setSubRef(ref.getSubRef().setName("c"));
        System.out.println(ref);
    }

    @Data
    @Accessors(chain = true)
    static class Ref {

        private SubRef subRef;
    }

    @Data
    @Accessors(chain = true)
    static class SubRef {

        private String name;
    }
}
