package com.xcc.designmode.no18.ChainofResponsibility;

/**
 * @Author GamePlayer-Joker
 * @Date 2024/1/3
 */
public interface HandlerChain {
    void setNext(HandlerChain handler);
    void doChian();
}
