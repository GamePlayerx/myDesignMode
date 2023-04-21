package com.xcc.designmode.DODE1_工厂模式;

/**
 * fruits实现Food接口
 */
public class fruits implements Food{
    @Override
    public void foods(String foods) {
        System.out.println("吃个----"+foods);
    }
}
