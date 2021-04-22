package com.chason.test.proxy.staticproxy;

/**
 * 测试类
 * 静态代理是一种设计模式，存在一个分歧就是代理类需要实现业务接口吗?
 */
public class ProxyTest {

    public static void main(String[] args) {

        Service service = new ServiceImpl();
        ServiceProxy proxy = new ServiceProxy(service);
        System.out.println(proxy.update());

    }

}
