package com.xcc.designmode.no18.ChainofResponsibility;

/**
 * @Author GamePlayer-Joker
 * @Date 2024/1/3
 */
public class ConcreteHandlerC implements HandlerChain{
    private HandlerChain nextHandler;
    @Override
    public void setNext(HandlerChain handler) {
        this.nextHandler = handler;
    }

    @Override
    public void doChian() {
        System.out.println("处理请求C！！");
        this.nextHandler.doChian();
    }
}
