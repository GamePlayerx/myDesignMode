package com.xcc.designmode.no4.SingletonPattern;

/**
 * @Author GamePlayer-Joker
 * @Date 2023/12/28
 */
public class Singleton05 {
    private static Singleton05 instance = new Singleton05();
    private Singleton05() {}
    public static Singleton05 getInstance() {
        return instance;
    }
}
