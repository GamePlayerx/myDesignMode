package com.xcc.designmode.no15.Adapter;

/**
 * @Author GamePlayer-Joker
 * @Date 2024/1/2
 */
public class Adapter extends Current{
    public void use18V() {
        System.out.println("使用适配器");
        this.use220V();
    }
}
