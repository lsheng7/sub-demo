package com.example.subdemo.pattern.oceanus.mediator;

class Manager implements Department {

    @Override
    public void coordinate(String userName, String msg, Employee employee) {
        System.out.println("经理接收【" + userName + "】的协调任务：" + msg);
        System.out.println("经理转发【" + userName + "】协调任务,@【" + employee.name + "】");
        employee.getMsg(userName, msg);
    }
}