package com.chason.design.factory.demo4;

public class SUV implements Car {

    @Override
    public void drive() {
        System.out.println("start engine for Suv...");
        System.out.println("go...");
    }
}
