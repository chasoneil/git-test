package com.chason.test.mode.observer;

import java.util.LinkedList;
import java.util.List;

/**
 * 观察者模式
 */
abstract class Subject {

    protected List<Observer> observers = new LinkedList<>();

    // 注册
    public boolean registerObserver(Observer observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
            return true;
        }
        return false;
    }

    // 注销
    public boolean removeObserver (Observer observer) {
        if (observers.contains(observer)) {
            observers.remove(observer);
            return true;
        }
        return false;
    }

    // 全局通知
    public abstract void notifyObserver();

}
