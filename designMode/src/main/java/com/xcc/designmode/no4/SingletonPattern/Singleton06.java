package com.xcc.designmode.no4.SingletonPattern;

/**
 * @Author GamePlayer-Joker
 * @Date 2023/12/28
 */
public class Singleton06 {
    private volatile static Singleton06 singleton06;
    private Singleton06() {}
    public static Singleton06 getSingleton06() {
        if (singleton06 == null) {
            synchronized (Singleton06.class) {
                if (singleton06 == null) {
                    singleton06 = new Singleton06();
                }
            }
        }
        return singleton06;
    }
}
