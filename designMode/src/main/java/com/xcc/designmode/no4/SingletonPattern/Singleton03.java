package com.xcc.designmode.no4.SingletonPattern;

/**
 * @Author GamePlayer-Joker
 * @Date 2023/12/28
 */
public class Singleton03 {
    private static Singleton03 instance;
    private Singleton03() {}

    public static Singleton03 getInstance() {
        if (instance == null) {
            instance = new Singleton03();
        }
        return instance;
    }
}
