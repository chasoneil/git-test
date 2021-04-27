package com.chason.design.factory.demo1;

/**
 * 驾驶员
 */
public class Driver {

    // 开车
    public void drive(){

        // 调用 Car 的 drive
        System.out.println("trying to drive car...");
        Car car = new Car();                            // 业务类中嵌入了对象的创建 耦合性非常大
        car.drive();

    }

}
