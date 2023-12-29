package com.xcc.designmode.no7.Decorator;

/**
 * @Author GamePlayer-Joker
 * @Date 2023/12/29
 */
public class XiaoMiCar implements Car{
    @Override
    public void show() {
        this.run();
        this.fly();
    }

    @Override
    public void run() {
        System.out.println("Are you ok!");
    }

    public void fly() {
        System.out.println("屌爆了");
    }
}
