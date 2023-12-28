package com.xcc.designmode.no1.SimpleFactoryMode;

/**
 * @Author GamePlayer-Joker
 * @Date 2023/12/28
 */
public class MainClass {
    public static void main(String[] args) {
        Fruit apple = FruitFactory.get(Apple.class);
        apple.get();
        Fruit orange = FruitFactory.get(Orange.class);
        orange.get();
    }
}
