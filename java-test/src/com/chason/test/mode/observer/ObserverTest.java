package com.chason.test.mode.observer;

/**
 * 测试类
 */
public class ObserverTest {

    public static void main(String[] args) {

        Observer observer1 = new ConcreteObserver1();
        Observer observer2 = new ConcreteObserver2();

        Subject subject = new ConcreteSubject();
        // 执行注册
        subject.registerObserver(observer1);
        subject.registerObserver(observer2);

        subject.notifyObserver();

    }

}
