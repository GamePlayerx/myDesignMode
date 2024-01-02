package com.xcc.designmode.no15.Adapter;

/**
 * @Author GamePlayer-Joker
 * @Date 2024/1/2
 */
public class Adapter2 {
    private Current current;
    public Adapter2(Current current) {
        this.current = current;
    }

    public void use18V() {
        System.out.println("使用适配器！");
        this.current.use220V();
    }
}
