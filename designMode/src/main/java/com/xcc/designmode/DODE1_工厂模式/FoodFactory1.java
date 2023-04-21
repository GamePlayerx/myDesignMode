package com.xcc.designmode.DODE1_工厂模式;

/**
 * 单方法工厂模式
 */
public class FoodFactory1 {
    public Food creatFood(String food1){
        if (food1.equals("水果")) {
            return new fruits();
        } else if (food1.equals("红烧肉")) {
            return new meat();
        } else {
            return null;
        }
    }

}
