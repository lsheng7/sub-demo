package com.example.subdemo.pattern.oceanus.observer;

public class ObserverClient {

    public static void main(String[] args) {

        ObserverSubject observerSubject = new ObserverSubject();
        new ObserverOctalObserver(observerSubject);
        new ObserverBinaryObserver(observerSubject);

        System.out.println("First state change: 15");
        observerSubject.setState(15);
        System.out.println("Second state change: 10");
        observerSubject.setState(10);
    }
}
