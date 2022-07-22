package com.example.subdemo.pattern.oceanus.mediator;

abstract class Employee {

    public String name;
    private Department department;

    public Employee(String name, Department department) {
        this.name = name;
        this.department = department;
    }

    public void getMsg(String userName, String msg) {
        System.out.println("【" + this.name + "】收到" + "【" + userName + "】协调任务：[" + msg + "]");
    }

    public void sendMsg(String name, String msg, Employee employee) {
        System.out.println("【" + name + "】发起协调任务：" + msg);
        department.coordinate(name, msg, employee);
    }
}