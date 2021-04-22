package com.chason.test.proxy.dynamic;

/**
 * 动态代理测试类
 */
public class DynamicTest {

    public static void main(String[] args) {
        Service service = new ServiceImpl();

        DynamicInvokeHandler handler = new DynamicInvokeHandler(service);   // 传入target 获取handler对象， 目的是为了获取目标target的代理
        /*
         * Q1: 为什么要进行强制类型转化?
         * A1: 因为不进行强制类型转化，你就没法调用target(service)中的方法，因为我们的本质目的还是执行target中的方法
         * Q2: 为什么可以进行强制类型转化?
         * A2: 源码分析
         *
         */
        Service serviceProxy = (Service) handler.getTargetProxy();      // 重点: 获取代理

        serviceProxy.update();                                          // 使用代理调用目标方法执行
        System.out.println(serviceProxy.select());
    }
}
