package com.xcc.designmode.no14.Bridge;

/**
 * @Author GamePlayer-Joker
 * @Date 2024/1/2
 */
public class Corp {
    private Product product;

    public Corp(Product product) {
        this.product = product;
    }

    public void makeMoney() {
        this.product.make();
        this.product.sell();
    }
}
