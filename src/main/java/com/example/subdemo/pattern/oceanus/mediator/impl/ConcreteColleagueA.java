package com.example.subdemo.pattern.oceanus.mediator.impl;

/**
 * 具体同事类
 */
class ConcreteColleagueA extends Colleague {

    public ConcreteColleagueA(Mediator mediator) {
        super(mediator);
    }

    public void operate() {
        getMediator().notify(this);
    }

}
