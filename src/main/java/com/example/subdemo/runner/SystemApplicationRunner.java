package com.example.subdemo.runner;

import cn.hutool.crypto.SecureUtil;
import com.example.subdemo.bean.People;
import com.example.subdemo.spring.typefilter.IArea;
import javax.annotation.Resource;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class SystemApplicationRunner implements ApplicationRunner {

    @Resource
    private People people;

    @Resource
    private IArea iArea;

    public static void main(String[] args) {
        System.out.println(SecureUtil.md5("Lv123456"));
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(people);
        System.out.println(SecureUtil.md5("Lv123456"));
        iArea.say();
    }

}
