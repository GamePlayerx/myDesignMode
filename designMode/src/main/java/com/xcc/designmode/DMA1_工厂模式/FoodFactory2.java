package com.xcc.designmode.DMA1_工厂模式;

/**
 * 多方法工厂模式 == 需要那个，用哪个方法
 */
public class FoodFactory2 {

    public Food createFruits() {
        return new fruits();
    }

    public Food createMeat() {
        return new meat();
    }

}
