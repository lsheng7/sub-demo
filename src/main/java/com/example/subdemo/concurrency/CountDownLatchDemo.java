package com.example.subdemo.concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch latch = new CountDownLatch(2);

        CompletableFuture.runAsync(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000L);
                    System.out.println(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + " complete task1");
            latch.countDown();
        });

        CompletableFuture.runAsync(() -> {
            for (int i = 10; i < 20; i++) {
                try {
                    Thread.sleep(1000L);
                    System.out.println(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + " complete task2");
            latch.countDown();
        });

        latch.await();
        System.out.println("over");
    }
}
