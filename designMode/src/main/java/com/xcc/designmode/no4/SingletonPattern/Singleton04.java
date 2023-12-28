package com.xcc.designmode.no4.SingletonPattern;

/**
 * @Author GamePlayer-Joker
 * @Date 2023/12/28
 */
public class Singleton04 {
    private static Singleton04 instance;
    private Singleton04() {}

    public static synchronized Singleton04 getInstance() {
        if (instance == null) {
            instance = new Singleton04();
        }
        return instance;
    }
}
