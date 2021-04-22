package com.chason.test.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 创建动态代理的处理器
 * 该类可以根据传入的对象(接口) 创建他对应的代理
 * invoke方法可以通过反射调用对应的方法
 */
public class DynamicInvokeHandler implements InvocationHandler {

    // 传入的对象的实现类 我们称其为target
    private Object target;

    public DynamicInvokeHandler (Object target) {
        this.target = target;
    }

    /*
     * 该方法用于创建传入的目标的代理
     * 最终的返回值是Object类型的变量，需要强制转换成对应的target类型
     */
    public Object getTargetProxy() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("before do something.");
        Object result = method.invoke(target, args);
        System.out.println("after do something.");


        return result;
    }


}
