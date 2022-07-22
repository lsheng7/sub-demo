package com.example.subdemo.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopClient {

    public static void main(String[] args) {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        MyService stuDao = (MyService) app.getBean("myAop");
        stuDao.method();
    }
}
