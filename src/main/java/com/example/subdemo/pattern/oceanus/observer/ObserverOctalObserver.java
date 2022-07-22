package com.example.subdemo.pattern.oceanus.observer;

public class ObserverOctalObserver extends Observer {

    public ObserverOctalObserver(ObserverSubject subject) {
        this.observerSubject = subject;
        this.observerSubject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Octal String: " + Integer.toOctalString(observerSubject.getState()));
    }
}