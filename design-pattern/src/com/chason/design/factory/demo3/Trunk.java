package com.chason.design.factory.demo3;

public class Trunk implements Car {

    @Override
    public void drive() {
        System.out.println("start engine for Trunk...");
        System.out.println("go...");
    }
}
