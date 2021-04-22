package com.chason.test.mode.observer;

/**
 * 具体的主题实现类
 * 作用 ???
 */
public class ConcreteSubject extends Subject {

    @Override
    public void notifyObserver() {
        System.out.println("starting observing...");

        // 从父类中获取已经注册过的观察者 逐一通知
        for (Observer observer : super.observers) {
            observer.response();
        }
    }

}
