package com.xcc.designmode.no2.FactorMethodMode;

/**
 * @Author GamePlayer-Joker
 * @Date 2023/12/28
 */
public class MainClass {
    public static void main(String[] args) {
        Factory factory = new FactoryImpl();
        Fruit apple = factory.create(Apple.class);
        apple.get();
        Fruit banana = factory.create(Banana.class);
        banana.get();
        Fruit orange = factory.create(Orange.class);
        orange.get();
    }
}
