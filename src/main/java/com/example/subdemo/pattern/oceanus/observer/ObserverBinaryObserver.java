package com.example.subdemo.pattern.oceanus.observer;


public class ObserverBinaryObserver extends Observer {

    public ObserverBinaryObserver(ObserverSubject observerSubject) {
        this.observerSubject = observerSubject;
        this.observerSubject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Binary String: " + Integer.toBinaryString(observerSubject.getState()));
    }

}