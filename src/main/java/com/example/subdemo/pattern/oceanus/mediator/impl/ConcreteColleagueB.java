package com.example.subdemo.pattern.oceanus.mediator.impl;

class ConcreteColleagueB extends Colleague {

    public ConcreteColleagueB(Mediator mediator) {
        super(mediator);
    }

    public void operation() {
        getMediator().notify(this);
    }

}
