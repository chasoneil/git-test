package com.chason.design.factory.demo4;

public class Demo4Test {

    public static void main(String[] args) {

        /*
         * 针对多个产品线 需要创建多个工厂类 每个工厂分别可以创建不同的
         *
         */
        BaseFactory baseFactory = new CarFactory();
        Car suv = (Car) baseFactory.createProduct("suv");
        suv.drive();

        baseFactory = new PersonFactory();
        Teacher teacher = (Teacher) baseFactory.createProduct("teacher");
        teacher.introduce();
    }

}
