package com.example.subdemo.concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import lombok.Data;
import lombok.experimental.Accessors;

public class CountDownLatchReturnDemo {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        CountDownLatch latch = new CountDownLatch(2);
        LatchVo latchVo = new LatchVo();

        task1(latch, latchVo);

        CompletableFuture.runAsync(() -> {
            System.out.println("task3");
        });

        task2(latch, latchVo);

        System.out.println("task4");
        latch.await();
        System.out.println(latchVo);
    }

    public static void task1(CountDownLatch latch, LatchVo latchVo) {

        CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(1_0000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " complete task1");
            latchVo.setName("123");
            latch.countDown();
        });

    }

    public static void task2(CountDownLatch latch, LatchVo latchVo) {

        CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(1_0000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " complete task2");
            latchVo.setCode("2345");
            latch.countDown();
        });
    }

    @Data
    @Accessors(chain = true)
    public static class LatchVo {

        private String name;

        private String code;
    }
}
