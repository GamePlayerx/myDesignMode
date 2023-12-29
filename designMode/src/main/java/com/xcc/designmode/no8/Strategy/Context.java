package com.xcc.designmode.no8.Strategy;

/**
 * @Author GamePlayer-Joker
 * @Date 2023/12/29
 */
public class Context {
    private Strategy strategy;
    public Context(Strategy strategy) {
        this.strategy = strategy;
    }
    public void encrypt() {
        this.strategy.encrypt();
    }
}
