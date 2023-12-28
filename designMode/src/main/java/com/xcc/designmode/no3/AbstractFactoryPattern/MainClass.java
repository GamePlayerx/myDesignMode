package com.xcc.designmode.no3.AbstractFactoryPattern;

/**
 * @Author GamePlayer-Joker
 * @Date 2023/12/28
 */
public class MainClass {
    public static void main(String[] args) {
        Factory shanghaiFactory = new FactoryShanghaiImpl();
        Factory beijingFactory = new FactoryBeijingImpl();

        Fruit apple = shanghaiFactory.created(Apple.class);
        apple.get();

        Fruit banana = beijingFactory.created(Banana.class);
        banana.get();
    }
}
