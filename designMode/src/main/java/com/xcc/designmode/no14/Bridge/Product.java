package com.xcc.designmode.no14.Bridge;

/**
 * @Author GamePlayer-Joker
 * @Date 2024/1/2
 */
public abstract class Product {
    // 不管什么产品，都要生产
    public abstract void make();
    // 不管什么产品，都要销售
    public abstract void sell();
}
