package com.xcc.designmode.no4.SingletonPattern;

/**
 * @Author GamePlayer-Joker
 * @Date 2023/12/28
 */
public class Singleton07 {
    private static class Singleton07Holder {
        private static final Singleton07 INSTANCE =new Singleton07();
    }
    private Singleton07() {}
    public static final Singleton07 getInstance() {
        return Singleton07Holder.INSTANCE;
    }
}
