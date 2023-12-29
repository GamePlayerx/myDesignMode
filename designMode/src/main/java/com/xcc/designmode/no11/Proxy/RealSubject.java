package com.xcc.designmode.no11.Proxy;

/**
 * @Author GamePlayer-Joker
 * @Date 2023/12/29
 */
public class RealSubject implements Subject{
    @Override
    public void show() {
        System.out.println("原神，启动");
    }
}
