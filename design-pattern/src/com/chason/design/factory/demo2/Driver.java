package com.chason.design.factory.demo2;


/**
 * 驾驶员
 */
public class Driver {

    // 开车
    public void drive(){

        // 调用 Car 的 drive
        System.out.println("trying to drive car...");
        Car car = CarFactory.getCar();                  // 使用工厂类创建car对象
        car.drive();

    }

}
