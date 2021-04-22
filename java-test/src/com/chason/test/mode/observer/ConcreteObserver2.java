package com.chason.test.mode.observer;

public class ConcreteObserver2 implements Observer {

    @Override
    public void response() {
        System.out.println("observer2 receive notice and give response.");
    }
}
