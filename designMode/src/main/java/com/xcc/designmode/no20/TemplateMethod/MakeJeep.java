package com.xcc.designmode.no20.TemplateMethod;

/**
 * @Author GamePlayer-Joker
 * @Date 2024/1/4
 */
public class MakeJeep extends MakeCar{
    @Override
    public void makeHead() {
        System.out.println("Jeep：组装车头！");
    }

    @Override
    public void makeBody() {
        System.out.println("Jeep：组装车身！");
    }

    @Override
    public void makeTail() {
        System.out.println("Jeep：组装车尾！");
    }
}
