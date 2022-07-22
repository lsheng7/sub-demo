package com.example.subdemo.guava;

import com.github.rholder.retry.Retryer;
import com.github.rholder.retry.RetryerBuilder;
import com.github.rholder.retry.StopStrategies;
import com.github.rholder.retry.WaitStrategies;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class RetryDemo {

    private static final Retryer<Integer> retryer = RetryerBuilder.<Integer>newBuilder()
//            .retryIfException()
            .retryIfResult(rst -> rst == 1)
            .withStopStrategy(StopStrategies.stopAfterAttempt(2))
            .withWaitStrategy(WaitStrategies.fixedWait(3, TimeUnit.SECONDS))
            .build();

    public static void main(String[] args) {
        for (int i = 0; i < 4; i++) {
            new Thread(() -> mockQueryDB(), "Thread-" + i).start();
        }
    }

    public static int mockQueryDB() {
        Callable<Integer> callable = () -> doQuery();
        int result;
        try {
            result = retryer.call(callable);
        } catch (Exception e) {
            result = -1;
        }
        return result;
    }

    private static int doQuery() {
        Random r = new Random(System.currentTimeMillis());
        int num = r.nextInt(5);
        System.out.println(Thread.currentThread().getName() + " query result " + num);

        if (num == 0) {
//            throw new RuntimeException("RuntimeException");
            return -1;
        } else if (num == 1) {
            return 1;
//            System.out.println("DBException");
//            throw new RuntimeException("DBException");
        } else if (num == 2) {
            return 1;
//            System.out.println("IllegalArgumentException");
//            throw new IllegalArgumentException("IllegalArgumentException");
        } else if (num == 3) {
            return 1;
//            System.out.println("NullPointerException");
//            throw new NullPointerException("NullPointerException");
        } else {
            return 1;
//            System.out.println("IndexOutOfBoundsException");
//            throw new IndexOutOfBoundsException("IndexOutOfBoundsException");
        }
    }
}
