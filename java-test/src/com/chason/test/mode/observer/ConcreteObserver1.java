package com.chason.test.mode.observer;

public class ConcreteObserver1 implements Observer {

    @Override
    public void response() {
        System.out.println("observer1 receive notice and give response.");
    }
}
