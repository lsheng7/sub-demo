package com.example.subdemo.pattern.oceanus.mediator;

public class Client {

    public static void main(String[] args) {
        Manager manager = new Manager();
        EmployeeA employeeA = new EmployeeA("张三", manager);
        EmployeeB employeeB = new EmployeeB("李四", manager);
        employeeA.sendMsg(employeeA.name, "需要产品文档", employeeB);
    }
}
