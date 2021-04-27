package com.chason.design.factory.demo2;

/**
 * 简单工厂模式
 */
public class CarFactory {

    // 创建对象的动作放在 工厂类中完成
    public static Car getCar () {
        return new Car();
    }


}
