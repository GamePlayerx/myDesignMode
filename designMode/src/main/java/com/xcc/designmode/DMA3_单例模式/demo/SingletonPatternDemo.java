package com.xcc.designmode.DMA3_单例模式.demo;

/**
 * 单例模式（Singleton Pattern）是 Java 中最简单的设计模式之一。
 * 这种类型的设计模式属于创建型模式，它提供了一种创建对象的最佳方式。
 *
 * 这种模式涉及到一个单一的类，该类负责创建自己的对象，同时确保只有单个对象被创建。
 * 这个类提供了一种访问其唯一的对象的方式，可以直接访问，不需要实例化该类的对象。
 *
 * getInstance() 方法中需要使用同步锁 synchronized (Singleton.class)
 * 防止多线程同时进入造成 instance 被多次实例化。
 */
public class SingletonPatternDemo {

    public static void main(String[] args) {
        // 获取唯一可用的对象
        SingleObject object = SingleObject.getInstance();

        // 显示消息
        object.showMessage();
    }
}
