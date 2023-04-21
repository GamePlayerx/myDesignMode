package com.xcc.designmode.DODE1_工厂模式;

/**
 * meat实现Food接口
 */
public class meat implements Food{
    @Override
    public void foods(String foods) {
        System.out.println("来个===="+foods);
    }
}
