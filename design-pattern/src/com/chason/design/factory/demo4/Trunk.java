package com.chason.design.factory.demo4;

public class Trunk implements Car {

    @Override
    public void drive() {
        System.out.println("start engine for trunk...");
        System.out.println("go...");
    }
}
