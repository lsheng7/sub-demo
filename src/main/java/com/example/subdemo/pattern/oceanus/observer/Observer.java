package com.example.subdemo.pattern.oceanus.observer;

public abstract class Observer {

    protected ObserverSubject observerSubject;

    public abstract void update();
}