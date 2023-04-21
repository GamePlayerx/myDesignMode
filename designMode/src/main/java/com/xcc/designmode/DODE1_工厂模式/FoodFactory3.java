package com.xcc.designmode.DODE1_工厂模式;

/**
 * 静态工厂模式，无需创建工厂类实例
 */
public class FoodFactory3 {

    public static Food createFruits() {
        return new fruits();
    }

    public static Food creatMeat() {
        return new meat();
    }

}
