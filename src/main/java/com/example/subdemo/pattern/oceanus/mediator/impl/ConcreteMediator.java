package com.example.subdemo.pattern.oceanus.mediator.impl;

/**
 * 具体调停者类
 */
class ConcreteMediator implements Mediator {

    private ConcreteColleagueA colleagueA;

    private ConcreteColleagueB colleagueB;

    public void setColleagueA(ConcreteColleagueA colleagueA) {
        this.colleagueA = colleagueA;
    }

    public void setColleagueB(ConcreteColleagueB colleagueB) {
        this.colleagueB = colleagueB;
    }

    @Override
    public void notify(Colleague colleague) {
        System.out.println("协调通知消息");
    }

}
