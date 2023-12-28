package com.xcc.designmode.no1.SimpleFactoryMode;

/**
 * @Author GamePlayer-Joker
 * @Date 2023/12/28
 */
public class FruitFactory {
    /**
     * 自己选择创建谁
     */
    public static Fruit get(Class c) {
        try {
            return (Fruit) c.newInstance();
        } catch (Exception e) {
            throw new RuntimeException("实例化失败！");
        }
    }
}
