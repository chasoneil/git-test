package com.chason.test.proxy.dynamic;

/**
 * 接口的实现类
 * 正式的代码中，这里是业务逻辑的处理类
 */
public class ServiceImpl implements Service {

    @Override
    public void update() {
        System.out.println("do update");
    }

    @Override
    public String select() {
        return "do select";
    }
}
