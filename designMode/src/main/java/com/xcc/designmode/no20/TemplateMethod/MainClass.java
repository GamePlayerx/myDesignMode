package com.xcc.designmode.no20.TemplateMethod;

/**
 * @Author GamePlayer-Joker
 * @Date 2024/1/4
 */
public class MainClass {
    public static void main(String[] args) {
        MakeCar bus = new MakeBus();
        bus.make();
        System.out.println("-------------------");
        MakeCar jeep = new MakeJeep();
        jeep.make();
        System.out.println("-------------------");
        MakeGame game = new MakeWorld();
        game.make();
    }
}
