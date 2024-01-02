package com.xcc.designmode.no15.Adapter;

/**
 * @Author GamePlayer-Joker
 * @Date 2024/1/2
 */
public class NbLoggerImp implements NbLogger{
    @Override
    public void d(int priority, String message, Object... obj) {
        System.out.println(String.format("牛xlogger记录:%s", message));
    }
}
