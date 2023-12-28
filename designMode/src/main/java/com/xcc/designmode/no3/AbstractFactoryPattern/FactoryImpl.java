package com.xcc.designmode.no3.AbstractFactoryPattern;

/**
 * @Author GamePlayer-Joker
 * @Date 2023/12/28
 */
public class FactoryImpl implements Factory{
    @Override
    public Fruit created(Class s) {
        try {
            return (Fruit) s.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
