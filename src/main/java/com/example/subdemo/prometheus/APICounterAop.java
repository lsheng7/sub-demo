package com.example.subdemo.prometheus;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class APICounterAop {

    ThreadLocal<Long> startTime = new ThreadLocal<>();

    @Resource
    private MeterRegistry registry;

    private Counter counter;

    @Pointcut("execution(public * com.example.demo.*.*.*(..))")
    public void pointCut() {
    }

    @PostConstruct
    private void init() {
        counter = registry.counter("requests_total", "status", "success");
    }

    @Before("pointCut()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        System.out.println("do before");
        counter.increment(); //请求计数
    }

    @AfterReturning(returning = "returnVal", pointcut = "pointCut()")
    public void doAfterReturning(Object returnVal) {
        System.out.println("do after");
    }
}