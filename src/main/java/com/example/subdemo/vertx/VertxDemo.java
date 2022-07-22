package com.example.subdemo.vertx;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Context;
import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;

public class VertxDemo {

    public static void main(String[] args) {
        //创建一个vertx实例
        VertxOptions vo = new VertxOptions();
        vo.setEventLoopPoolSize(1);
        Vertx vertx = Vertx.vertx(vo);
        vertx.deployVerticle(new FirstVersicle());
    }

    static class FirstVersicle extends AbstractVerticle {

        public void start() {

            vertx.createHttpServer().requestHandler(req -> {
                System.out.println(Thread.currentThread());
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                req.response()
                        .putHeader("content-type", "text/plain")
                        .end("Hello World!");
                this.deploymentID();
                Context c = vertx.getOrCreateContext();
            }).listen(8080);
        }
    }
}
