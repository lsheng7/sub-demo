package com.example.subdemo.basic;

public class DefaultMethodImpl implements DefaultMethodInter {

    public static void main(String[] args) {
        DefaultMethodImpl defaultMethod = new DefaultMethodImpl();
        defaultMethod.method();

        final String[] split = "1234".split("");
        for (int index = split.length; index > 0; index--) {
            System.out.println(split[index - 1]);
        }
    }

    @Override
    public void method() {
        System.out.println("default impl");
    }
}
