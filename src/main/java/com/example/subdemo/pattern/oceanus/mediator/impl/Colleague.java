package com.example.subdemo.pattern.oceanus.mediator.impl;

/**
 * 抽象同事类
 */
abstract class Colleague {

    /* 持有调停者对象 */
    private Mediator mediator;

    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }

    public Mediator getMediator() {
        return mediator;
    }

}
