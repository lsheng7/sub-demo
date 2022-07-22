package com.example.subdemo.basic;

public enum PersonEnum {

    A {
        @Override
        public String getValue() {
            return "a";
        }
    };

    String value;

    public static void main(String[] args) {
        System.out.println(PersonEnum.A.getValue());
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
