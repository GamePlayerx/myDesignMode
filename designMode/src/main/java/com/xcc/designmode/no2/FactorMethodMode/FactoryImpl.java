package com.xcc.designmode.no2.FactorMethodMode;

/**
 * @Author GamePlayer-Joker
 * @Date 2023/12/28
 */
public class FactoryImpl implements Factory{
    @Override
    public Fruit create(Class s) {
        try {
            return (Fruit) s.newInstance();
        } catch (Exception e) {
            throw new RuntimeException("实例化失败！");
        }
    }
}
