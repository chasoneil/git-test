package com.chason.design.factory.demo3;

public class SUV implements Car {

    @Override
    public void drive() {
        System.out.println("start engine for SUV...");
        System.out.println("go...");
    }
}
