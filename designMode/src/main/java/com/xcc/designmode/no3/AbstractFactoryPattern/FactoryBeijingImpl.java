package com.xcc.designmode.no3.AbstractFactoryPattern;

/**
 * @Author GamePlayer-Joker
 * @Date 2023/12/28
 */
public class FactoryBeijingImpl implements Factory{
    @Override
    public Fruit created(Class s) {
        System.out.println("北京工厂！");
        try {
            return (Fruit) s.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
