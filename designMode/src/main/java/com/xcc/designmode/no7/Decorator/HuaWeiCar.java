package com.xcc.designmode.no7.Decorator;

/**
 * @Author GamePlayer-Joker
 * @Date 2023/12/29
 */
public class HuaWeiCar implements Car{
    @Override
    public void show() {
        this.huawei();
        this.run();
    }

    @Override
    public void run() {
        System.out.println("一直领先！");
    }

    public void huawei() {
        System.out.println("遥遥领先！");
    }
}
