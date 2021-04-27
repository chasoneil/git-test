package com.chason.design.factory.demo3;

public class Demo3Test {

    public static void main(String[] args) {

        // 这里的工厂类已经可以创建不同类型的产品了，根据类型获取我们想要的产品
        Car suv = CarFactory.getCar("suv");
        suv.drive();

    }
}
