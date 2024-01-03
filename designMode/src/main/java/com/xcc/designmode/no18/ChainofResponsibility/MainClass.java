package com.xcc.designmode.no18.ChainofResponsibility;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author GamePlayer-Joker
 * @Date 2024/1/3
 */
public class MainClass {
    public static void main(String[] args) {
        // 创建处理器链
        List<HandlerChain> handlers = new ArrayList<>();
        handlers.add(new ConcreteHandlerA());
        handlers.add(new ConcreteHandlerB());
        handlers.add(new ConcreteHandlerC());
        handlers.add(new ConcreteHandlerD());

        // 处理器连接在一起
        for (int i = 0; i < handlers.size() - 1; i++) {
            HandlerChain currentHandler = handlers.get(i);
            HandlerChain nextHandler  = handlers.get(i + 1);
            currentHandler.setNext(nextHandler);
        }

        // 处理请求
        handlers.get(0).doChian();
    }
}
